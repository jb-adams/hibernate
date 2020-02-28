package org.jbadams.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.jbadams.hibernate.demo.entity.Student;

/*
    This module demonstrates how we UPDATE an object to the database table using
    Hibernate
*/

public class UpdateStudentDemo {
    public static void run(String[] args) {

        SessionFactory factory = new Configuration()
                                 .configure()
                                 .addAnnotatedClass(Student.class)
                                 .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;

            session.beginTransaction();
            System.out.println("Getting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);
            System.out.println("Updating student");
            myStudent.setFirstName("Scooby");

            // this will save to the database, no need to use 'save' because
            // this is an already persistent object
            session.getTransaction().commit();

            // NEW CODE: BULK UPDATE

            // update email for all students
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Update email for all students");
            session.createQuery("update Student set email='foo@gmail.com'")
                .executeUpdate();
            session.getTransaction().commit();
            
        } finally {
            factory.close();
        }
    }
}