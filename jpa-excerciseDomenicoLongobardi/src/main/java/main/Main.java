package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.classi.jpa.Actor;
import com.classi.jpa.Genre;
import com.classi.jpa.Movie;

import dao.GenreRepository;

public class Main {

	 // Create an EntityManagerFactory when you start the application.
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("JpaHelps");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inizia main");
		GenreRepository genreDAO = new GenreRepository();
		
		//try creating an Actor
		
//		createActor(1, "Tom", "Cruise", 1979);
		createActorNoId("Tom", "Cruise", 1977);
		createActorNoId("Tom", "Cruise", 1970);
		createActorNoId("Tom", "Cruise", 1976);
		createActorNoId("Tom", "Cruise", 1975);
		
		//Creating movie
		createMovieNoId("Mission Impossible", 1995, 3);
		
		//Creating Genre
//		createGenreNoId("azione");
		genreDAO.createGenreNoId(ENTITY_MANAGER_FACTORY, "Azione");
		genreDAO.createGenreNoId(ENTITY_MANAGER_FACTORY, "Commedia");
		genreDAO.createGenreNoId(ENTITY_MANAGER_FACTORY, "Drammatico");
		genreDAO.createGenreNoId(ENTITY_MANAGER_FACTORY, "Romantico");
		
		//Deleting a genre
		genreDAO.deleteGenre(ENTITY_MANAGER_FACTORY, 2);
		
		
		//Retrieving all genres 
		genreDAO.readAll(ENTITY_MANAGER_FACTORY);
		
		//Retrieving a genre by id
		genreDAO.readGenreWithId(ENTITY_MANAGER_FACTORY, 3);
		
		//Retrieving a genre by name
		genreDAO.readGenreWithName(ENTITY_MANAGER_FACTORY, "Romantico");
		
		
	}
	
	
	public static void createActor(int id, String name, String surname, int birthdateYear) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Create a new Student object
            Actor act = new Actor();
            act.setId(id);
            act.setName(name);
            act.setLastName(surname);
            act.setBirthdate(birthdateYear);

            // Save the student object
            manager.persist(act);

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
	
	
	public static void createActorNoId(String name, String surname, int birthdateYear) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Create a new Student object
            Actor act = new Actor();
            act.setName(name);
            act.setLastName(surname);
            act.setBirthdate(birthdateYear);

            // Save the student object
            manager.persist(act);

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
	
	public static void createMovieNoId(String title, int releaseYear , int genreId) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Create a new Student object
            Movie mov = new Movie();
            mov.setTitle(title);
            mov.setReleaseYear(releaseYear);
            mov.setGenreId(genreId);

            // Save the student object
            manager.persist(mov);

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
	
	public static void createGenreNoId(String name) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Create a new Student object
            Genre gen = new Genre();
            gen.setName(name);

            // Save the student object
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
	
}
