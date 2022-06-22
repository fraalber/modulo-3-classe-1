package com.classe1.jpa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import repository.ActorRepository;
import repository.GenericRepository;
import repository.GenreRepository;
import repository.MovieRepository;

public class Main {

    //@PersistenceContext
    //private EntityManager entityManager;

    // Create an EntityManagerFactory when you start the application.
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("JavaHelps");

    public static void main(String[] args) {
    	
    	EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    	GenericRepository genericRepository = new GenericRepository(entityManager);
    	    	
    	Set<Movie> set = new HashSet<>();
    	
    	Movie movie = new Movie();
    	movie.setTitle("Spider-Man: Homecoming");
    	movie.setYearOfRelease(2017);
    	
    	genericRepository.insert(movie);
    	
    	set.add(movie);
    	
    	movie = new Movie();
    	movie.setTitle("Uncharted");
    	movie.setYearOfRelease(2022);
    	
    	genericRepository.insert(movie);
    	
    	set.add(movie);
    	
    	movie = new Movie();
    	movie.setTitle("Spider-Man: No Way Home");
    	movie.setYearOfRelease(2021);
    	
    	genericRepository.insert(movie);
    	
    	set.add(movie);
    	
    	Actor actor = new Actor();
    	actor.setName("Tom");
    	actor.setLastName("Holland");
    	actor.setTotalFilm(3);
    	actor.setYearOfBirth(1996);
    	actor.setMovies(set);
    	
    	genericRepository.insert(actor);
    	
    	actor = new Actor();
    	actor.setName("Mark");
    	actor.setLastName("Wahlberg");
    	actor.setTotalFilm(1);
    	actor.setYearOfBirth(1971);
    	
    	Set<Movie> set2 = new HashSet<>();
    	set2.add(genericRepository.findById(2, Movie.class));
    	
    	actor.setMovies(set2);
    	
    	genericRepository.insert(actor);
    	
    	Genre genre = new Genre();
    	genre.setName("Azione");
    	
    	genericRepository.insert(genre);
    	
    	genre = new Genre();
    	genre.setName("Avventura");
    	
    	genericRepository.insert(genre);
    	
    	GenreRepository genreRepo = new GenreRepository(entityManager);

    	List<Genre> list = genreRepo.retrieveAll();
    	
    	for(Genre g: list) {
    		System.out.println(g);
    	}
    	
    	list = genreRepo.retrieveByName("Azione");
    	for(Genre g: list) {
    		System.out.println(g);
    	}
    	
    	Genre genreRetrieved = genericRepository.findById(2, Genre.class);
    	
    	System.out.println("Retrieved genre by id: "+genreRetrieved);
    	
    	Actor actorRetrieved = genericRepository.findById(1, Actor.class);
    	
    	System.out.println("Actor retrieved: "+actorRetrieved);
    	
    	ActorRepository actRepo = new ActorRepository(entityManager);
    	
    	List<Actor> actAfterYear = actRepo.allActorsAfter(1970);
    	
    	for(Actor a: actAfterYear) {
    		System.out.println(a);
    	}
    	
    	MovieRepository movieRepo = new MovieRepository(entityManager);
    	
    	List<Movie> listMovie = movieRepo.retrieveByTitle("Uncharted");
    	
    	for(Movie m: listMovie) {
    		System.out.println(m);
    	}
    	
//    	listMovie = movieRepo.leftJoinWithActor();
//    	
//    	for(Movie m: listMovie) {
//    		System.out.println(m);
//    	}
    	
        // NEVER FORGET TO CLOSE THE ENTITY_MANAGER_FACTORY
        ENTITY_MANAGER_FACTORY.close();
    }

//    /**
//     * Create a new Student.
//     * 
//     * @param name
//     * @param age
//     */
//    //@Transactional
//    public static void create(int id, String name, int age) {
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
//            // Create a new Student object
//            Student stu = new Student();
//            stu.setId(id);
//            stu.setName(name);
//            stu.setAge(age);
//
//            // Save the student object
//            manager.persist(stu);
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
//
//    /**
//     * Read all the Students.
//     * 
//     * @return a List of Students
//     */
//    public static List<Student> readAll() {
//
//        List<Student> students = null;
//
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
//            // Get a List of Students
//            students = manager.createQuery("SELECT s FROM Student s",
//                    Student.class).getResultList();
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
//        return students;
//    }
//
//    /**
//     * Delete the existing Student.
//     * 
//     * @param id
//     */
//    public static void delete(int id) {
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
//            // Get the Student object
//            Student stu = manager.find(Student.class, id);
//
//            // Delete the student
//            manager.remove(stu);
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
//
//    /**
//     * Update the existing Student.
//     * 
//     * @param id
//     * @param name
//     * @param age
//     */
//    public static void upate(int id, String name, int age) {
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
//            // Get the Student object
//            Student stu = manager.find(Student.class, id);
//
//            // Change the values
//            stu.setName(name);
//            stu.setAge(age);
//
//            // Update the student
//            manager.persist(stu);
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
}
