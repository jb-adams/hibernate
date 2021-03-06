package org.jbadams.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.jbadams.hibernate.demo.entity.Student;

/*
    This module demonstrates how we READ data from the database table using
    Hibernate
*/

public class ReadStudentDemo {
    public static void run(String[] args) {

        SessionFactory factory = new Configuration()
                                 .configure()
                                 .addAnnotatedClass(Student.class)
                                 .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            // create a student object
            System.out.println("Creating new student object");
            Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student");
            System.out.println(tempStudent);
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();

            // NEW CODE FOR RETRIEVING STUDENT FROM THE DB
            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            // now get a new session and start transaction
            // always use transactions, for all CRUD operations
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + tempStudent.getId());
            Student myStudent = session.get(Student.class, tempStudent.getId());
            System.out.println("Get complete: " + myStudent);
            
            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}