package org.jbadams.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.jbadams.hibernate.demo.entity.Student;

/*
    This module demonstrates how we establish database sessions with Hibernate
*/

public class CreateStudentDemo {
    public static void run(String[] args) {

        // create session factory
        // NOTE: if no path arg is provided to the configure() method, 
        //       hibernate will check the default hibernate config xml path,
        //       which is "hibernate.cfg.xml"
        //       make sure to use this pathname when developing hibernate apps
        SessionFactory factory = new Configuration()
                                 .configure()
                                 .addAnnotatedClass(Student.class)
                                 .buildSessionFactory();
        
        // create session from the session factory
        Session session = factory.getCurrentSession();

        try {
            // use the session object to save Java object

            // create a student object
            System.out.println("Creating new student object");
            Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student");
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}