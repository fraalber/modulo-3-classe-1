package repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionFactory {

    private static ConnectionFactory instance = null;
    private SessionFactory sessionFactory = null;
    ConnectionFactory() {
        try {
            Configuration cfg = (Configuration) new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Session getSession() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return session;
    }

    public static ConnectionFactory getInstance() {
        return instance;
    }

    public static void setInstance(ConnectionFactory instance) {
        ConnectionFactory.instance = instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}