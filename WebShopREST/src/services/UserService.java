package services;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.User;
import dao.UserDAO;
import dao.UserDAOJson;

@Path("/users")
public class UserService {
	
	@Context
	ServletContext ctx;
	
	public UserService() {
	}
	
	@PostConstruct
	// ctx polje je null u konstruktoru, mora se pozvati nakon konstruktora (@PostConstruct anotacija)
	public void init() {
		// Ovaj objekat se instancira više puta u toku rada aplikacije
		// Inicijalizacija treba da se obavi samo jednom
		if (ctx.getAttribute("userDAO") == null) {
	    	String contextPath = ctx.getRealPath("");
			ctx.setAttribute("userDAO", new UserDAOJson(contextPath));
		}
	}
	
	@GET
	@Path("/allUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User> getUsers() {
		UserDAOJson dao = (UserDAOJson) ctx.getAttribute("userDAO");
		return dao.findAll();
	}
	
	@GET
	@Path("/getLogged")
	@Produces(MediaType.APPLICATION_JSON)
	public User getLogged (User user, @Context HttpServletRequest req) {
		return (User) req.getSession().getAttribute("loggedUser");
	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User login(User user, @Context HttpServletRequest request) {
		UserDAOJson dao = (UserDAOJson) ctx.getAttribute("userDAO");
		
		User us = dao.checkLogin(user.getUsername(), user.getPassword());
		
		if(us!=null) {
			request.getSession().setAttribute("loggedUser", us);
			System.out.println(us);
			return us;
		}
		return null;
	}
	
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUsers(User user) {
		UserDAO dao = (UserDAO) ctx.getAttribute("userDAO");
		return dao.save(user);
	}
	
	@POST
	@Path("/registration")
	@Produces(MediaType.APPLICATION_JSON)
	public User register(User user) {
		UserDAOJson dao = (UserDAOJson) ctx.getAttribute("userDAO");
		return dao.saveUser(user);
	}
	
	@POST
	@Path("/logout")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response logout(@Context HttpServletRequest req) {
		
		req.getSession().invalidate();
		System.out.println("Korisnik uspesno izlogovan!");
		
		return Response.ok().build();
	}
}
