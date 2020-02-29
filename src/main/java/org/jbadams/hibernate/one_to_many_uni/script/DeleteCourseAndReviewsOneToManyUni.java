package org.jbadams.hibernate.one_to_many_uni.script;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbadams.hibernate.one_to_many_uni.entity.Course;
import org.jbadams.hibernate.one_to_many_uni.entity.Instructor;
import org.jbadams.hibernate.one_to_many_uni.entity.InstructorDetail;
import org.jbadams.hibernate.one_to_many_uni.entity.Review;
import org.jbadams.hibernate.one_to_many_uni.util.HibernateUtil;

public class DeleteCourseAndReviewsOneToManyUni {

    public static void run(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // get the course
            int theId = 1;
            Course course = session.get(Course.class, theId);

            // print the course
            System.out.println("Deleting the course...");
            System.out.println("Course: " + course);

            // print the course reviews
            System.out.println("Reviews: " + course.getReviews());

            // delete the course
            session.delete(course);

            // commit
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }


    }

}