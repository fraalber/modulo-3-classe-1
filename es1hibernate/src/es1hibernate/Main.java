package es1hibernate;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
 
public class Main {
    public static void main(String[] args) {
        // 1
        Configuration configuration = new Configuration().configure();
        ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
        registry.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = registry.getBootstrapServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
         
        // 2
        Session session = sessionFactory.openSession();
        // 7
        session.beginTransaction();
        // 3
        Contact contact1 = new Contact("Nam", "hainatuatgmail.com", "Vietnam", "0904277091");
        session.persist(contact1);
        Contact contact2 = new Contact("Bill", "billatgmail.com", "USA", "18001900");
        Serializable id = session.save(contact2);
        System.out.println("created id: " + id);
         
        // 4
        Contact contact3 = (Contact) session.get(Contact.class, new Integer(1));
        if (contact3 == null) {
            System.out.println("There is no Contact object with id=1");
        } else {
            System.out.println("Contact3's name: " + contact3.getName());
        }
         
        // 4
        Contact contact4 = (Contact) session.load(Contact.class, new Integer(4));
        System.out.println("Contact4's name: " + contact4.getName());
         
        // 5
        Contact contact5 = (Contact) session.load(Contact.class, new Integer(5));
        contact5.setEmail("info1atcompany.com");
        contact5.setTelephone("1234567890");
        session.update(contact5);
        // 5
        Contact contact6 = new Contact(3, "Jobs", "jobsatapplet.com", "Cupertino", "0123456789");
        session.update(contact6);
         
        // 6
        Contact contact7 = new Contact();
        contact7.setId(7);
        session.delete(contact7);
        // 6
        Contact contact8 = (Contact) session.load(Contact.class, new Integer(8));
        session.delete(contact8);
         
        // 7
        session.getTransaction().commit();
        session.close();  
    }
}