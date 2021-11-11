package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Autore;

@Stateless
public class AutoriDao {

	@PersistenceContext(unitName = "persistenceUnit1") // tipo 'inject'
	private EntityManager em;

	public Autore get(String id) {
		return em.find(Autore.class, id);
	}

//	@Override
	public List<Autore> getAll() {
		return em.createNamedQuery("findAllAuthors", Autore.class).getResultList();
	}

	public void save(String id, String n, String c, Integer e) {
		Autore autoreEsistente = em.find(Autore.class, id);
		if (autoreEsistente != null) {
			autoreEsistente.setNome(n);
			autoreEsistente.setCognome(c);
			autoreEsistente.setEta(e);
			em.merge(autoreEsistente);
		} else {
			Autore autoreToSave = new Autore();
			autoreToSave.setNome(n);
			autoreToSave.setCognome(c);
			autoreToSave.setEta(e);
			autoreToSave.setId(id);
			em.persist(autoreToSave);
		}
	}

//	@Override
	public void save(Autore autore) {
		Autore autoreEsistente = em.find(Autore.class, autore.getId());
		if (autoreEsistente != null) {
			autoreEsistente.setNome(autore.getNome());
			autoreEsistente.setCognome(autore.getCognome());
			autoreEsistente.setEta(autore.getEta());
			em.merge(autoreEsistente);
		} else {
			em.persist(autore);
		}

	}

//	@Override
	public void update(Autore t) {//
		em.merge(t);
	}

//	@Override
	public void delete(Autore t) {
		em.remove(t);
	}
}
