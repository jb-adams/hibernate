package org.jbadams.hibernate.one_to_many.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jbadams.hibernate.one_to_many.entity.Course;
import org.jbadams.hibernate.one_to_many.entity.Instructor;
import org.jbadams.hibernate.one_to_many.entity.InstructorDetail;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
        try {
            SessionFactory sessionFactory = 
                new Configuration()
                .configure("hibernate.one_to_many.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
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