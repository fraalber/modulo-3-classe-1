package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.classi.jpa.Actor;
import com.classi.jpa.Genre;
import com.classi.jpa.Movie;

import dao.ActorRepository;
import dao.GenreRepository;

public class Main {
	
	

	 // Create an EntityManagerFactory when you start the application.
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("JpaHelps");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inizia main");
		GenreRepository genreDAO = new GenreRepository();
		ActorRepository actorDAO = new ActorRepository();
		
		//try creating an Actor
		
//		createActor(1, "Tom", "Cruise", 1979);
		createActorNoId("Tom", "Cruise", 1977);
		createActorNoId("Tom", "Cruise", 1970);
		createActorNoId("Tom", "Cruise", 1976);
		createActorNoId("Tom", "Cruise", 1975);
		
		
		
		
		
		//Creating movie
//		createMovieNoId("Mission Impossible", 1995, 3);
		
		//Creating movie to test many to many
//		Actor actor = createActorNoId("Massimo", "Troisi", 1980);
//		createMovieNoId("Mission Impossible", 1995, 3, actor);
		
		//Creating Genre
//		createGenreNoId("azione");
//		genreDAO.createGenreNoId(ENTITY_MANAGER_FACTORY, "Azione");
//		genreDAO.createGenreNoId(ENTITY_MANAGER_FACTORY, "Commedia");
//		genreDAO.createGenreNoId(ENTITY_MANAGER_FACTORY, "Drammatico");
//		genreDAO.createGenreNoId(ENTITY_MANAGER_FACTORY, "Romantico");
		
		//Deleting a genre
//		genreDAO.deleteGenre(ENTITY_MANAGER_FACTORY, 2);
		
		
		//Retrieving all genres 
//		genreDAO.readAll(ENTITY_MANAGER_FACTORY);
		
		//Retrieving a genre by id
//		genreDAO.readGenreWithId(ENTITY_MANAGER_FACTORY, 3);
		
		//Retrieving a genre by name
//		genreDAO.readGenreWithName(ENTITY_MANAGER_FACTORY, "Romantico");
		
		
		//Insert actor by ActorRepository and try Many to Many
		Movie movie = new Movie();
		movie.setTitle("Ghost Rider");
		movie.setGenreId(1);
		movie.setReleaseYear(2001);
		createMovieNoId(movie);
		Set<Movie> movies = new HashSet<Movie>();
		movies.add(movie);
		
		Actor act = new Actor();
		act.setName("Nicolas");
		act.setLastName("Cage");
		act.setBirthdate(1977);
		act.setActedInMovies(movies);
		
		actorDAO.createActorNoId(ENTITY_MANAGER_FACTORY, act);
		
		//Find actor with a certain id
		actorDAO.findActorWithId(ENTITY_MANAGER_FACTORY, 5);
		
		//Find actors nati dopo l'anno x
		actorDAO.findActorBornAfterYear(ENTITY_MANAGER_FACTORY, 1976);
		
		//Find actors with a specific name
		actorDAO.findActorWithName(ENTITY_MANAGER_FACTORY, "tom");
		
		
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
	
//	public static Actor createActorNoId(String name, String surname, int birthdateYear) {
//        // Create an EntityManager
//        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
//        EntityTransaction transaction = null;
//        Actor act = new Actor();
//
//        try {
//            // Get a transaction
//            transaction = manager.getTransaction();
//            // Begin the transaction
//            transaction.begin();
//
//            // Create a new Actor object
//            act.setName(name);
//            act.setLastName(surname);
//            act.setBirthdate(birthdateYear);
//
//            // Save the actor object
//            manager.persist(act);
//
//            // Commit the transaction
//            transaction.commit();
//        } catch (Exception ex) {
//            // If there are any exceptions, roll back the changes
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            // Print the Exception
//            ex.printStackTrace();
//        } finally {
//            // Close the EntityManager
//            manager.close();
//        }
//		return act;
//    }
	
	
	public static void createActorNoId(String name, String surname, int birthdateYear) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Create a new actor object
            Actor act = new Actor();
            act.setName(name);
            act.setLastName(surname);
            act.setBirthdate(birthdateYear);

            // Save the actor object
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
	
//	public static void createMovieNoId(String title, int releaseYear , int genreId) {
//        // Create an EntityManager
//        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
//        EntityTransaction transaction = null;
//
//        try {
//            // Get a transaction
//            transaction = manager.getTransaction();
//            // Begin the transaction
//            transaction.begin();
//
//            // Create a new movie object
//            Movie mov = new Movie();
//            mov.setTitle(title);
//            mov.setReleaseYear(releaseYear);
//            mov.setGenreId(genreId);
//            
//
//            // Save the movie object
//            manager.persist(mov);
//
//            // Commit the transaction
//            transaction.commit();
//        } catch (Exception ex) {
//            // If there are any exceptions, roll back the changes
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            // Print the Exception
//            ex.printStackTrace();
//        } finally {
//            // Close the EntityManager
//            manager.close();
//        }
//    }
	
	public static void createMovieNoId(Movie movie) {
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
	
	//create movie per test many to many
//	public static void createMovieNoId(String title, int releaseYear , int genreId, Actor actor) {
//        // Create an EntityManager
//        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
//        EntityTransaction transaction = null;
//
//        try {
//            // Get a transaction
//            transaction = manager.getTransaction();
//            // Begin the transaction
//            transaction.begin();
//
//            // Create a new movie object
//            Movie mov = new Movie();
//            mov.setTitle(title);
//            mov.setReleaseYear(releaseYear);
//            mov.setGenreId(genreId);
//            Set<Actor> actorSet = new HashSet<Actor>();
//            actorSet.add(actor);
//            mov.setActorsInTheMovie(actorSet);
//            
//
//            // Save the movie object
//            manager.persist(mov);
//
//            // Commit the transaction
//            transaction.commit();
//        } catch (Exception ex) {
//            // If there are any exceptions, roll back the changes
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            // Print the Exception
//            ex.printStackTrace();
//        } finally {
//            // Close the EntityManager
//            manager.close();
//        }
//    }
	
	public static void createGenreNoId(String name) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Create a new genre object
            Genre gen = new Genre();
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
	
}
