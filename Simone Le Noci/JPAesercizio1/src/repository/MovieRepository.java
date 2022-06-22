package repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.esercizio1.jpa.ActorEntity;
import com.esercizio1.jpa.MovieEntity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class MovieRepository {

	// @PersistenceContext
		// private EntityManager entityManager;

		// Create an EntityManagerFactory when you start the application.
		private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
				.createEntityManagerFactory("JavaHelps");

		/**
		 * Create a new Movie.
		 * 
		 * @param name
		 * @param age
		 */
		// @Transactional
		public static void create(MovieEntity movie) {
			// Create an EntityManager
			EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
			EntityTransaction transaction = null;

			try {
				// Get a transaction
				transaction = manager.getTransaction();
				// Begin the transaction
				transaction.begin();

				// Save the movie object
				manager.persist(movie);

				// Commit the transaction
				transaction.commit();
			} catch (Exception ex) {
				// If there are any exceptions, roll back the changes
				if (transaction != null) {
					transaction.rollback();
				}
				// Print the Exception
				ex.printStackTrace();
			} finally {
				// Close the EntityManager
				manager.close();
			}
		}
		
		/**
		 * Read Genres by ID.
		 * 
		 * @return a List of Movies
		 */
		public static List<MovieEntity> readById(int id) {

			List<MovieEntity> genres = null;

			// Create an EntityManager
			EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
			EntityTransaction transaction = null;

			try {
				// Get a transaction
				transaction = manager.getTransaction();
				// Begin the transaction
				transaction.begin();

				// Get a List of Movies
				genres = manager.createQuery("SELECT g FROM MovieEntity g WHERE movie_id = " + id, MovieEntity.class).getResultList();

				// Commit the transaction
				transaction.commit();
			} catch (Exception ex) {
				// If there are any exceptions, roll back the changes
				if (transaction != null) {
					transaction.rollback();
				}
				// Print the Exception
				ex.printStackTrace();
			} finally {
				// Close the EntityManager
				manager.close();
			}
			return genres;
		}

		/**
		 * Read Movies by Title.
		 * 
		 * @return a List of Genres
		 */
		public static List<MovieEntity> readByTitle(String title) {

			List<MovieEntity> genres = null;

			// Create an EntityManager
			EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
			EntityTransaction transaction = null;

			try {
				// Get a transaction
				transaction = manager.getTransaction();
				// Begin the transaction
				transaction.begin();

				// Get a List of Movies
				genres = manager.createQuery("SELECT m FROM MovieEntity m WHERE title = '" + title + "'", MovieEntity.class).getResultList();

				// Commit the transaction
				transaction.commit();
			} catch (Exception ex) {
				// If there are any exceptions, roll back the changes
				if (transaction != null) {
					transaction.rollback();
				}
				// Print the Exception
				ex.printStackTrace();
			} finally {
				// Close the EntityManager
				manager.close();
			}
			return genres;
		}
		
		/**
		 * Read All Movies.
		 * 
		 * @return a List of Genres
		 */
		public static List<MovieEntity> readAll() {

			List<MovieEntity> genres = null;

			// Create an EntityManager
			EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
			EntityTransaction transaction = null;

			try {
				// Get a transaction
				transaction = manager.getTransaction();
				// Begin the transaction
				transaction.begin();

				// Get a List of Movies
				genres = manager.createQuery("SELECT m FROM MovieEntity m", MovieEntity.class).getResultList();

				// Commit the transaction
				transaction.commit();
			} catch (Exception ex) {
				// If there are any exceptions, roll back the changes
				if (transaction != null) {
					transaction.rollback();
				}
				// Print the Exception
				ex.printStackTrace();
			} finally {
				// Close the EntityManager
				manager.close();
			}
			return genres;
		}
		
		/**
		 * Read All Movies with Actors.
		 * 
		 * @return a List of Genres
		 */
		public static List<MovieEntity> readMovieActors() {

			List<MovieEntity> genres = null;

			// Create an EntityManager
			EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
			EntityTransaction transaction = null;

			try {
				// Get a transaction
				transaction = manager.getTransaction();
				// Begin the transaction
				transaction.begin();

				// Get a List of Movies
				genres = manager.createQuery("SELECT m FROM MovieEntity m LEFT JOIN actor_to_movies a a ON m.movie_id = a.movie_id", MovieEntity.class).getResultList();

				// Commit the transaction
				transaction.commit();
			} catch (Exception ex) {
				// If there are any exceptions, roll back the changes
				if (transaction != null) {
					transaction.rollback();
				}
				// Print the Exception
				ex.printStackTrace();
			} finally {
				// Close the EntityManager
				manager.close();
			}
			return genres;
		}
    
}