package main;

import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;

import com.esercizio1.jpa.ActorEntity;
import com.esercizio1.jpa.GenreEntity;
import com.esercizio1.jpa.MovieEntity;

import repository.ActorRepository;
import repository.MovieRepository;

public class Main {

	// @PersistenceContext
	// private EntityManager entityManager;

	// Create an EntityManagerFactory when you start the application.
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("JavaHelps");

	public static void main(String[] args) {

		// Create three Genres
		create("Thriller");
		create("Horror");
		create("Adventure");

		// Delete the Thriller from database
		delete(1);

		System.out.println("** STAMPA 1 - TUTTA LA TABELLA GENRE **");
		// Print all the Genres
		List<GenreEntity> genres = readAll();
		if (genres != null) {
			for (GenreEntity gen : genres) {
				System.out.println(gen);
			}
		}
		
		System.out.println("\n** STAMPA 2 - GENERE PER NOME **");
		// Print all the Genres by name
		List<GenreEntity> genres2 = readByName("Horror");
		if (genres2 != null) {
			for (GenreEntity gen : genres2) {
				System.out.println(gen);
			}
		}
		
		System.out.println("\n** STAMPA 3 - GENERE PER ID **");
		// Print all the Genres by name
		List<GenreEntity> genres3 = readById(2);
		if (genres3 != null) {
			for (GenreEntity gen : genres3) {
				System.out.println(gen);
			}
		}
		
		// Punto 4 - INIZIO
		
		ActorEntity actor1 = new ActorEntity();
		actor1.setName("Simone");
		actor1.setLast_name("Le Noci");
		actor1.setYear_of_birth(2001);
		
		ActorRepository actrep = new ActorRepository();
		
		actrep.create(actor1);
		
		System.out.println(actrep.readById(1));
		System.out.println(actrep.readByYear(2000));
		
		// Punto 4 - FINE
		
		// Punto 5 - INIZIO
		
		
		
		// Punto 5 - FINE
		
		// NEVER FORGET TO CLOSE THE ENTITY_MANAGER_FACTORY
		ENTITY_MANAGER_FACTORY.close();
	}

	/**
	 * Create a new Genre.
	 * 
	 * @param name
	 * @param age
	 */
	// @Transactional
	public static void create(String name) {
		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Create a new Genre object
			GenreEntity gen = new GenreEntity();
			gen.setName(name);

			// Save the genre object
			manager.persist(gen);

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
	 * Delete the existing Genres.
	 * 
	 * @param id
	 */
	public static void delete(int id) {
		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Get the Genre object
			GenreEntity gen = manager.find(GenreEntity.class, id);

			// Delete the genre
			manager.remove(gen);

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
	 * Read Genres by name.
	 * 
	 * @return a List of Genres
	 */
	public static List<GenreEntity> readByName(String name) {

		List<GenreEntity> genres = null;

		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Get a List of Genres
			genres = manager.createQuery("SELECT g FROM GenreEntity g WHERE name = '" + name + "'", GenreEntity.class).getResultList();

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
	 * Read Genres by ID.
	 * 
	 * @return a List of Genres
	 */
	public static List<GenreEntity> readById(int id) {

		List<GenreEntity> genres = null;

		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Get a List of Genres
			genres = manager.createQuery("SELECT g FROM GenreEntity g WHERE genre_id = " + id, GenreEntity.class).getResultList();

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
	 * Read all the Genres.
	 * 
	 * @return a List of Genres
	 */
	public static List<GenreEntity> readAll() {

		List<GenreEntity> genres = null;

		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Get a List of Genres
			genres = manager.createQuery("SELECT g FROM GenreEntity g", GenreEntity.class).getResultList();

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
