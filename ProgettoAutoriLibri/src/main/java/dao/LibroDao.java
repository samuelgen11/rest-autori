package dao;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Libro;

@Model
public class LibroDao {

	@PersistenceContext(unitName = "persistenceUnit1")
	private EntityManager em;

	public Libro get(int id) {
		return em.find(Libro.class, id);
	}

	public List<Libro> getAll() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllBooks", Libro.class).getResultList();
	}

	public void save(Libro l) {
		// TODO Auto-generated method stub

	}

	public void update(Libro l, String[] params) {
		// TODO Auto-generated method stub

	}

	public void delete(Libro l) {
		// TODO Auto-generated method stub

	}

}
