package dao;



import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import model.Autore;
import model.Libro;



@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class GenericDao {
	
	@PersistenceContext(unitName = "persistenceUnit1") // tipo 'inject'
	private EntityManager em;
	
	@Resource
	UserTransaction uTransaction;
	
	public void save(Autore autore,Libro libro) 
			throws 
				IllegalStateException, SecurityException,
				SystemException, RollbackException,
				HeuristicMixedException, HeuristicRollbackException 		
	{
			try {
				uTransaction.begin();
				
				em.persist(autore);
				em.persist(libro);
				
				uTransaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
				uTransaction.rollback();
			}
	}
		 
	
}