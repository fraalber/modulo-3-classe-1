package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.classi.jpa.Genre;

public class GenreRepository {
	
	
	public void createGenreNoId(EntityManagerFactory entityManager, String name) {
        // Create an EntityManager
        EntityManager manager = entityManager.createEntityManager();
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
	
	public static void deleteGenre(EntityManagerFactory entityManager, int id) {
        // Create an EntityManager
        EntityManager manager = entityManager.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get the Student object
            Genre gen = manager.find(Genre.class, id);

            // Delete the student
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
	
	
	public static List<Genre> readAll(EntityManagerFactory entityManager) {

        List<Genre> genres = null;

        // Create an EntityManager
        EntityManager manager = entityManager.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Students
            genres = manager.createQuery("SELECT g FROM Genre g",
                    Genre.class).getResultList();

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
        
        for (int i = 0; i< genres.size();i++) {
        	System.out.println("Genere con id " + genres.get(i).getId() + ": " + genres.get(i).getName());;
        }
        return genres;
    }
	
	
	public static Genre readGenreWithId(EntityManagerFactory entityManager, int id) {

        Genre gen = null;

        // Create an EntityManager
        EntityManager manager = entityManager.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Students
            gen = manager.createQuery("SELECT g FROM Genre g WHERE g.id = " + id,
                    Genre.class).getSingleResult();

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
        
        System.out.println("Genere con id " + gen.getId() + ": " + gen.getName());
        return gen;
    }
	
	public static Genre readGenreWithName(EntityManagerFactory entityManager, String name) {

        Genre gen = null;

        // Create an EntityManager
        EntityManager manager = entityManager.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Students
            gen = manager.createQuery("SELECT g FROM Genre g WHERE g.name = " + "'" + name + "'",
                    Genre.class).getSingleResult();

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
        
        System.out.println("Il Genere trovato ha id: " + gen.getId() + " e  nome: " + gen.getName());
        return gen;
    }
	

}
