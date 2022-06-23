package repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.classe1.jpa.Actor;

public class ActorRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	public ActorRepository(EntityManager manager) {
		super();
		this.manager = manager;
	}
	
	public List<Actor> allActorsAfter(int year) {

		EntityTransaction transaction = null;

		List<Actor> list = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			list = manager.createQuery("FROM Actor WHERE yearOfBirth > "+year, Actor.class).getResultList();

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
