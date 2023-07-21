package fr.maboite.correction.rest.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/articles")
public class MonDeuxiemeRestController {
	
	@GET
	public String maDeuxiemeeMethode() { // URL que traite cette méthode : 
		// URL application + URL de la classe + URL de la méthode
		System.out.println("maDeuxièmeMethode est appelée");
		return "ok";
	}

}
