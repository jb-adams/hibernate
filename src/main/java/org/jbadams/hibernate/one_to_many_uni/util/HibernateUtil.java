package org.jbadams.hibernate.one_to_many_uni.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jbadams.hibernate.one_to_many_uni.entity.Course;
import org.jbadams.hibernate.one_to_many_uni.entity.Instructor;
import org.jbadams.hibernate.one_to_many_uni.entity.InstructorDetail;
import org.jbadams.hibernate.one_to_many_uni.entity.Review;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
        try {
            SessionFactory sessionFactory = 
                new Configuration()
                .configure("hibernate.one_to_many_uni.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
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