package repository;

import model.Dvd;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Repository {

    ConnectionFactory cF = new ConnectionFactory();

    Session session = cF.getSession();

    public void addDVD(Dvd dvd) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(dvd);
            tx.commit();
            session.flush();
        } catch (HibernateException e) {
            tx.rollback();
        }
    }

    public List getAllDVD(Dvd dvd) {
        return cF.getSessionFactory().getCurrentSession().createCriteria(Dvd.class).list();
    }
}