package com.example;

import java.util.Arrays;

import javax.management.Query;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // student s = new student();


        /**
         * 1. add the hibernate dependn3cies in pom file
         * 2. create session. for that create session factory. for that create configuration. 
         * 3. for that add hibernate.cfg.xml file in resources.
         * 4. go to the class file and make it entity annotation and id annotation for pk
         * 5. create addAnnotatedClass to make it an entity
         * 6. use session.persist - create, remove- ddelete, merge - update, get - read
         * 7. use Transaction for everything except get
         * 8. commit transaction, close session, session factory
         * 9. use @onetoone @onetomany @manytoone @maneytomany at appropriate entity classes (use list for variables of many)
         */




        // s.setRno(4);
        // s.setSage(21);
        // s.setSname("adolf");
        // System.out.println(s);

        // Configuration cfg = new Configuration();
        // cfg.addAnnotatedClass(com.example.student.class);
        // cfg.configure("hibernate.cfg.xml");

        // SessionFactory sf = new Configuration()
        //     .configure()
        //     .addAnnotatedClass(com.example.student.class)
        //     .buildSessionFactory();
        // Session session = sf.openSession();

        //Transaction transaction = session.beginTransaction();
        //session.persist(s);
        //transaction.commit();

        // student s2 = session.get(student.class, 2);
        // System.out.println(s2);


        // session.close();
        // sf.close();

        SessionFactory sf = new Configuration().
            configure().
            // addAnnotatedClass(com.example.alien.class).
            addAnnotatedClass(com.example.Laptop.class).
            buildSessionFactory();

        Session session = sf.openSession();
        // Transaction t = session.beginTransaction();
        // s = session.get(student.class,4);
        // System.out.println(s);
        //session.remove(s);
        // session.merge(s);

        // Laptop p= new Laptop();
        // p.setBrand("asus");
        // p.setModel("vivo");
        // p.setRam(16);
        // p.setLid(1);

        // Laptop p2= new Laptop();
        // p2.setBrand("lenovo");
        // p2.setModel("nokia");
        // p2.setRam(16);
        // p2.setLid(2);

        // Laptop p3= new Laptop();
        // p3.setBrand("apple");
        // p3.setModel("mac");
        // p3.setRam(32);
        // p3.setLid(3);

        //alien a = new alien();
        // a.setAid(1); 
        // a.setAname("farhan");
        // a.setAtech("java");

        // alien a2 = new alien();
        // a2.setAid(2); 
        // a2.setAname("loval");
        // a2.setAtech("python");

        // alien a3 = new alien();
        // a3.setAid(3); 
        // a3.setAname("atif");
        // a3.setAtech("java");

        // a.setLaptops(Arrays.asList(p,p2));
        // a2.setLaptops(Arrays.asList(p2,p3));
        // a3.setLaptops(Arrays.asList(p));

        // p.setAliens(Arrays.asList(a,a3));
        // p2.setAliens(Arrays.asList(a,a2));
        // p3.setAliens(Arrays.asList(a2));

        
        // session.persist(a);
        // session.persist(a2);
        // session.persist(a3);
        // session.persist(p3);
        // session.persist(p);
        // session.persist(p2);
        // t.commit();
        
        session.close();

        Session session2 = sf.openSession();
        // alien a5 = session2.get(com.example.alien.class,2);
        // System.out.println(a5);

        int ram = 16;
        // List<Laptop> result = session2.createQuery("from Laptop where ram=?1",Laptop.class).setParameter(1,ram).getResultList();
        List<Object[]> result = session2.createQuery("select brand,model from Laptop where ram = ?1",Object[].class).setParameter(1,ram).getResultList();
        System.out.println(result);
        
        for (Object[] data : result){
            System.out.println((String)data[0]+(String)data[1]);
        }

        session2.close();
        sf.close();


    



    }
}
