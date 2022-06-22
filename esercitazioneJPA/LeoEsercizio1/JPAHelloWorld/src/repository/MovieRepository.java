package repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.classe1.jpa.Movie;

public class MovieRepository implements Serializable {


	private static final long serialVersionUID = 1L;
	private EntityManager manager;
	
	public MovieRepository(EntityManager manager) {
		super();
		this.manager = manager;
	}
	
	
	public List<Movie> retrieveByTitle(String title) {

		EntityTransaction transaction = null;

		List<Movie> list = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			list = manager.createQuery("FROM Movie WHERE title = '"+title+"'", Movie.class).getResultList();

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
	
	public List<Movie> leftJoinWithActor() {

		EntityTransaction transaction = null;

		List<Movie> list = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			//Query sbagliata
			list = manager.createQuery("SELECT M FROM Actor AC LEFT JOIN AC.Movies M", Movie.class).getResultList();

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
