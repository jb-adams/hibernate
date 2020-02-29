package org.jbadams.hibernate.many_to_many.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jbadams.hibernate.many_to_many.entity.Student;
import org.jbadams.hibernate.many_to_many.entity.Course;
import org.jbadams.hibernate.many_to_many.entity.Instructor;
import org.jbadams.hibernate.many_to_many.entity.InstructorDetail;
import org.jbadams.hibernate.many_to_many.entity.Review;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
        try {
            SessionFactory sessionFactory = 
                new Configuration()
                .configure("hibernate.many_to_many.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}