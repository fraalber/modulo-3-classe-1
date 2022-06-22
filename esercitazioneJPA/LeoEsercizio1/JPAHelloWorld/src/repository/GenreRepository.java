package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;

import com.classe1.jpa.Genre;

public class GenreRepository{
	
	private EntityManager entityManager;
	
	public GenreRepository(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public List<Genre> retrieveAll() {

		EntityTransaction transaction = null;

		List<Genre> list = null;

		try {
			// Get a transaction
			transaction = entityManager.getTransaction();
			// Begin the transaction
			transaction.begin();

			CriteriaQuery<Genre> c = entityManager.getCriteriaBuilder().createQuery(Genre.class);
			c.select(c.from(Genre.class));
			list = entityManager.createQuery(c).getResultList();

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
	
	public List<Genre> retrieveByName(String name) {

		EntityTransaction transaction = null;

		List<Genre> list = null;

		try {
			// Get a transaction
			transaction = entityManager.getTransaction();
			// Begin the transaction
			transaction.begin();

			list = entityManager.createQuery("FROM Genre WHERE name = '"+name+"'", Genre.class).getResultList();

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

}
