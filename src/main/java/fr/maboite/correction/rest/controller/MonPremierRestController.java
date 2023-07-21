package fr.maboite.correction.rest.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/voitures")
public class MonPremierRestController {
	
	@GET
	public String maPremiereMethode() { // URL que traite cette méthode : 
		// URL application + URL de la classe + URL de la méthode
		System.out.println("maPremiereMethode est appelée");
		return "ok";
	}

}
