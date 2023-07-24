package fr.maboite.correction.rest.controller;

import fr.maboite.correction.rest.pojo.ArticlePojo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/articles")
@Produces(MediaType.APPLICATION_JSON)
public class MonDeuxiemeRestController {

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public ArticlePojo getArticles(@PathParam("id") Integer id) {
        System.out.println("La méthode getArticles est appelée avec l'id: " + id);
        ArticlePojo article = new ArticlePojo();
        article.setId(id);
        article.setName("Article " + id);
        article.setDescription("L'article " + id + " est valide");
        return article;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllArticles() {
        ArticlePojo article = new ArticlePojo();
        article.setId(1);
        article.setName("Article 1");
        article.setDescription("Ceci est l'article 1");

        return article.toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public ArticlePojo postArticles(ArticlePojo article) {
        if (article.getId() > 0) {
            return article;
        }
        article.setId(5);
        return article;
    }
    
    @GET
    @Path("/Response/{id}")
    public Response getResponseArticles(@PathParam("id") Integer id) {
        if (id < 0) {
        	return Response.status(Response.Status.NOT_FOUND)
        			.header("mon header","c'est négatif")
        			.build();
        }
        ArticlePojo article = new ArticlePojo();

        article.setId(id);
        article.setName("Article " + id);
        article.setDescription("Cet Id" + id + " est valide");
        return Response.ok(article).build();
        		
    }
 
}
