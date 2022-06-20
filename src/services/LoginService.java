package services;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Model.SportsEstablishment;
import Model.User;
import dao.EstablishmentDAO;
import dao.UserDao;

@Path("")

public class LoginService {
	@Context
	ServletContext ctx;
	
	public LoginService() {
		
	}
	
	@PostConstruct
	// ctx polje je null u konstruktoru, mora se pozvati nakon konstruktora (@PostConstruct anotacija)
	public void init() {
		// Ovaj objekat se instancira vi�e puta u toku rada aplikacije
		// Inicijalizacija treba da se obavi samo jednom
		if (ctx.getAttribute("userDAO") == null) {
	    	String contextPath = ctx.getRealPath("");
			ctx.setAttribute("userDAO", new UserDao(contextPath));
		}
	}
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User> users() {
		UserDao userDao = (UserDao) ctx.getAttribute("userDAO");
		return userDao.findAll();
	}
	@GET
	@Path("/username/{username}")
	public Boolean searchForUsername(@PathParam("username") String username) {
		UserDao userDao = (UserDao) ctx.getAttribute("userDAO");
		return userDao.searchForUsername(username);
	}
	
	@POST
	@Path("/addition")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean getProducts(User user) {
		UserDao userDao = (UserDao) ctx.getAttribute("userDAO");
		return userDao.add(user);
	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean login(User user) {
		UserDao userDao = (UserDao) ctx.getAttribute("userDAO");
		User loggedUser = userDao.find(user.getUsername(), user.getPassword());
		if (loggedUser == null) {
			return false;
		}
		return true;
	}
}
