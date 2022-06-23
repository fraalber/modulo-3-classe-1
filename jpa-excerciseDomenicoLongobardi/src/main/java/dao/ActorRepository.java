package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.classi.jpa.Actor;
import com.classi.jpa.Genre;

public class ActorRepository {
	
	
	public void createActorNoId(EntityManagerFactory entityManager, Actor actor) {
        // Create an EntityManager
        EntityManager manager = entityManager.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();


            // Save the actor object
            manager.persist(actor);

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
	
	public static Actor findActorWithId(EntityManagerFactory entityManager, int id) {

        Actor act = null;

        // Create an EntityManager
        EntityManager manager = entityManager.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Actors
            act = manager.createQuery("SELECT a FROM Actor a WHERE a.id = " + id,
                    Actor.class).getSingleResult();

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
        
        System.out.println("Actor con id " + act.getId() + ": " + act.toString());
        return act;
    }
	
	public static List<Actor> findActorBornAfterYear(EntityManagerFactory entityManager, int year) {

        List<Actor> act = null;

        // Create an EntityManager
        EntityManager manager = entityManager.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Actors
            act = manager.createQuery("SELECT a FROM Actor a WHERE a.birthdateYear > " + year,
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
        for (int i=0;i<act.size();i++) {
        	System.out.println("Actor con birthdate year > " + year + ": " + act.get(i).toString());
        }
        
        return act;
    }
	
	public static List<Actor> findActorWithName(EntityManagerFactory entityManager, String name) {

        List<Actor> act = null;

        // Create an EntityManager
        EntityManager manager = entityManager.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Actors
            act = manager.createQuery("SELECT a FROM Actor a WHERE a.name = '" + name + "'",
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
        if (act.size()>0) {
        	for (int i=0;i<act.size();i++) {
            	System.out.println("Attore che ha come nome " + name + ": " + act.get(i).toString());
            }
        } else {
        	System.out.println("Nessun attore con nome: " + name);
        }
        
        
        return act;
    }

}
