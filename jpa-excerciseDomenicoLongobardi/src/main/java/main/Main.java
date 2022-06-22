package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.classi.jpa.Actor;

public class Main {

	 // Create an EntityManagerFactory when you start the application.
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("JpaHelps");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ciao");
		
		//try creating an Actor
		
//		createActor(1, "Tom", "Cruise", 1979);
		createActorNoId("Tom", "Cruise", 1977);
		createActorNoId("Tom", "Cruise", 1970);
		createActorNoId("Tom", "Cruise", 1976);
		createActorNoId("Tom", "Cruise", 1975);

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
	
}
