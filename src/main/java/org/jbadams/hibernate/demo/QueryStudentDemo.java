package org.jbadams.hibernate.demo;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.jbadams.hibernate.demo.entity.Student;



/*
    This module demonstrates how we query a table, getting a result LIST,
    using Hibernate AND Hibernate Query Language (HQL)
*/

public class QueryStudentDemo {

    public static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    public static void run(String[] args) {

        SessionFactory factory = new Configuration()
                                 .configure()
                                 .addAnnotatedClass(Student.class)
                                 .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // query students using HQL
            List<Student> theStudents = session.createQuery(
                "from Student", Student.class).getResultList();
            
            // display the students
            displayStudents(theStudents);
            
            // commit transaction
            session.getTransaction().commit();

            // ANOTHER QUERY: QUERY STUDENTS WHERE LASTNAME=DOE
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("\nNew Query: Get Students where LastName is Doe");
            theStudents = session.createQuery(
                "from Student s where s.lastName='Doe'", Student.class
            ).getResultList();
            displayStudents(theStudents);
            session.getTransaction().commit();

            // ANOTHER QUERY: QUERY STUDENTS WHERE LASTNAME=DOE OR FIRSTNAME=DAFFY
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("\nNew Query: Get Students where LastName is Doe OR FirstName is Daffy");
            theStudents = session.createQuery(
                "from Student s where s.lastName='Doe' or s.firstName='Daffy'", Student.class
            ).getResultList();
            displayStudents(theStudents);
            session.getTransaction().commit();

            // ANOTHER QUERY: QUERY STUDENTS WHERE EMAIL LIKE gmail.com
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("\nNew Query: Get Students where email like gmail.com");
            theStudents = session.createQuery(
                "from Student s where s.email LIKE '%gmail.com'", Student.class
            ).getResultList();
            displayStudents(theStudents);
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}