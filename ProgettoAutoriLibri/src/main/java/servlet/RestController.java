package servlet;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dao.AutoriDao;

import dao.LibroDao;
import model.Autore;
import model.Libro;

@Stateless

@Path("rest")
public class RestController {

	@Inject
	private AutoriDao autoriDao;

	@Inject
	private LibroDao libroDao;

	// --- http://localhost:8080/progettoejb/api/rest/all ---
	// http protocollo
	// 127.0.0.1 : dove risiede il mio server
	// 8080 porta default di esposizione protocollo application server
	// progettoEjb = nome progetto definito in maven
	// api = servlet
	// rest = ejb contenitore di servizi esposti
	// all = il nome del metodo

	@GET
	@Produces(MediaType.APPLICATION_JSON) // formato di dato
	@Path("{id}") // variabile {}
	public Autore getById(@PathParam("id") String id) {
		return autoriDao.get(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON) // formato di dato
	@Path("allAuthors") // variabile {}
	public List<Autore> getEvryone() {
		return autoriDao.getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON) // formato di dato
	@Path("allBooks") // variabile {}
	public List<Libro> getEvryBook() {
		return libroDao.getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON) // formato di dato
	@Path("insertAutore")
	public String insertAutore(@QueryParam("id") String id,@QueryParam("nome") String nome, @QueryParam("cognome") String cognome,
			@QueryParam("età") String eta)  {
		autoriDao.save(id, nome, cognome, Integer.parseInt(eta) );
		return "Insert finished with success!";
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
	@Path("insert")
	public Autore insertAutore(Autore nuovoAutore ) {
		autoriDao.save(nuovoAutore);
		return nuovoAutore;
	}
}
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Path("insertCMT")
//	public void containedPadrone(Padrone padrone, Cane cane) 
//			throws 
//			IllegalStateException, SecurityException, 
//			SystemException, RollbackException, 
//			HeuristicMixedException, HeuristicRollbackException 
//	{
//		padroneDaoMod.save(padrone, cane);
//
//	}


