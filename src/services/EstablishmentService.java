package services;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import dao.EstablishmentDAO;
import Model.SportsEstablishment;

@Path("/establishments")
public class EstablishmentService {
	
	@Context
	ServletContext ctx;
	
	public EstablishmentService() {
	}
	
	@PostConstruct
	public void init() {
		// Ovaj objekat se instancira vi�e puta u toku rada aplikacije
		// Inicijalizacija treba da se obavi samo jednom
		if (ctx.getAttribute("establishmentDAO") == null) {
	    	String contextPath = ctx.getRealPath("");
			ctx.setAttribute("establishmentDAO", new EstablishmentDAO(contextPath));
		}
		
	}
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<SportsEstablishment> getEstablishment() {
		EstablishmentDAO dao = (EstablishmentDAO) ctx.getAttribute("establishmentDAO");
		return dao.findAll();
	}
	
}
