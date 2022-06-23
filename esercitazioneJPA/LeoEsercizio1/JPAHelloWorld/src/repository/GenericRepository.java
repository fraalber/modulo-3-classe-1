package repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;

public class GenericRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager manager;

	public GenericRepository(EntityManager ent) {
		this.manager = ent;
	}
	
	public <T> T findById(int id, Class<T> entityClass) {
		EntityTransaction transaction = null;

		T entity = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			
			entity = manager.getReference(entityClass, id);

			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		}
		return entity;
	}

	public <T> void insert(T entity) {
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			manager.persist(entity);

			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		}
	}

	public <T> List<T> retrieveAll(Class<T> entityClass) {

		EntityTransaction transaction = null;

		List<T> list = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			CriteriaQuery<T> c = manager.getCriteriaBuilder().createQuery(entityClass);
			c.select(c.from(entityClass));
			list = manager.createQuery(c).getResultList();

			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		}
		return list;
	}

	public <T> void remove(T entity) {

		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			 manager.remove(entity);

			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		}
		
	}

}
