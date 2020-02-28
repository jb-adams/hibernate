package org.jbadams.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.jbadams.hibernate.demo.entity.Student;

/*
    This module demonstrates how we DELETE an object from the database table
    using Hibernate
*/

public class DeleteStudentDemo {
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

            // get the student with id of 1
            // Student myStudent = session.get(Student.class, studentId);

            // delete the student
            // System.out.println("Deleting student: " + myStudent);
            // session.delete(myStudent);

            session.getTransaction().commit();

            // DELETE STUDENT WITH ID OF 2 USING HQL
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("delete from Student where id=2").executeUpdate();
            session.getTransaction().commit();

            
        } finally {
            factory.close();
        }
    }
}