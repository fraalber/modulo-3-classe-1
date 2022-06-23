package dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.classi.jpa.Actor;
import com.classi.jpa.Genre;
import com.classi.jpa.Movie;

public class MovieRepository {
	
	
	public void createMovieNoId(EntityManagerFactory entityManager, Movie movie) {
		
		// Create an EntityManager
        EntityManager manager = entityManager.createEntityManager();
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
	
	public void deleteMovie(EntityManagerFactory entityManager, int id) {
        // Create an EntityManager
        EntityManager manager = entityManager.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get the Movie object
            Movie mov = manager.find(Movie.class, id);

            // Delete the movie
            manager.remove(mov);

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
	
	public static List<Movie> findMovieWithTitle(EntityManagerFactory entityManager, String title) {

        List<Movie> mov = null;

        // Create an EntityManager
        EntityManager manager = entityManager.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Movies
            mov = manager.createQuery("SELECT m FROM Movie m WHERE m.title = '" + title + "'",
                    Movie.class).getResultList();

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
        if (mov.size()>0) {
        	for (int i=0;i<mov.size();i++) {
            	System.out.println("Film che ha come titolo " + title + ": " + mov.get(i).toString());
            }
        } else {
        	System.out.println("Nessun film con titolo: " + title);
        }
        
        
        return mov;
    }
	
	public static Movie findMovieWithId(EntityManagerFactory entityManager, int id) {

        Movie mov = null;

        // Create an EntityManager
        EntityManager manager = entityManager.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Movies
            mov = manager.createQuery("SELECT m FROM Movie m WHERE m.id = " + id,
                    Movie.class).getSingleResult();

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
        
        System.out.println("Film con id " + mov.getId() + ": " + mov.toString());
        return mov;
    }
	
	public List<Movie> readAllMovies(EntityManagerFactory entityManager) {

        List<Movie> movies = null;

        // Create an EntityManager
        EntityManager manager = entityManager.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Movies
            movies = manager.createQuery("SELECT m FROM Movie m",
                    Movie.class).getResultList();

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
        
        if (movies.size()>0) {
        	System.out.println("Ecco tutti i film nel database");
            for (int i = 0; i< movies.size();i++) {
            	System.out.println(movies.get(i).toString());;
            }
		} else {
			System.out.println("Non ci sono film nel database");
		}
        
        return movies;
    }
	
	public List<Actor> findActorsInMovie(EntityManagerFactory entityManager, int id) {

        List<Actor> movies = null;

        // Create an EntityManager
        EntityManager manager = entityManager.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Movies
            movies = manager.createQuery("SELECT a FROM Actor a LEFT JOIN FETCH a.actedInMovies m WHERE m.id = " + id,
                    Actor.class).getResultList();

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
        
        System.out.println("Nel film con id " + id + " ci sono questi attori:");
        for (int i = 0; i < movies.size(); i++) {
        	
			System.out.println(movies.get(i).toString());
		}
        
//        System.out.println("Film con id " + mov.getId() + ": " + mov.toString());
        return movies;
    }

}
