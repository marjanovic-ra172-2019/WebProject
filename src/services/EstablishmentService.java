package services;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
	
	
	@POST
	@Path("/addest")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean addEstablishment(SportsEstablishment establishment) {
		EstablishmentDAO dao = (EstablishmentDAO) ctx.getAttribute("establishmentDAO");
		return dao.add(establishment);
	}	
	
	@GET
	@Path("{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public SportsEstablishment GetByName(@PathParam("name") String name) {
		EstablishmentDAO dao = (EstablishmentDAO) ctx.getAttribute("establishmentDAO");
		return dao.GetByName(name);
	}
	
	@GET
	@Path("name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<SportsEstablishment> searchEstablishmentsForName(@PathParam("name") String name) {
		EstablishmentDAO dao = (EstablishmentDAO) ctx.getAttribute("establishmentDAO");
		return dao.searchNames(name);
	}
	
	@GET
	@Path("type/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<SportsEstablishment> searchEstablishmentsForType(@PathParam("type") String type) {
		EstablishmentDAO dao = (EstablishmentDAO) ctx.getAttribute("establishmentDAO");
		return dao.searchType(type);
	}
	
	
	@GET
	@Path("address/{address}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<SportsEstablishment> searchEstablishmentsForAddress(@PathParam("address") String address) {
		EstablishmentDAO dao = (EstablishmentDAO) ctx.getAttribute("establishmentDAO");
		return dao.searchAddress(address);
	}
	
	@GET
	@Path("grade/{grade}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<SportsEstablishment> searchEstablishmentsForGrade(@PathParam("grade") String grade) {
		EstablishmentDAO dao = (EstablishmentDAO) ctx.getAttribute("establishmentDAO");
		return dao.searchGrade(grade);
	}
	
	@GET
	@Path("open/")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<SportsEstablishment> searchOpen() {
		EstablishmentDAO dao = (EstablishmentDAO) ctx.getAttribute("establishmentDAO");
		return dao.searchOpen();
	}
	
	@GET
	@Path("sort/{field}&{direction}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<SportsEstablishment> sortEstablishments(@PathParam("field") String field,@PathParam("direction") String direction) {
		EstablishmentDAO dao = (EstablishmentDAO) ctx.getAttribute("establishmentDAO");
		return dao.sort(field,direction);
	}
}
