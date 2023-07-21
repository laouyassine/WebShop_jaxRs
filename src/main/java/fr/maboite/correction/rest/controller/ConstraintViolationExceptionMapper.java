package fr.maboite.correction.rest.controller;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/**
 * Mappe les exceptions de type ConstraintViolationException
 * pour en faire des réponses HTTP correctes
 */
@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(final ConstraintViolationException exception) {
		return Response.status(Response.Status.BAD_REQUEST)
				.entity(prepareMessage(exception)).type("text/plain")
				.build();
	}

	private String prepareMessage(ConstraintViolationException exception) {
		StringBuilder msg = new StringBuilder();
		for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
			msg.append(cv.getPropertyPath() + " with value " + cv.getInvalidValue() + " " + cv.getMessage() + "\n");
		}
		return msg.toString();
	}
}