package org.jbadams.hibernate.one_to_many_uni.script;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbadams.hibernate.one_to_many_uni.entity.Course;
import org.jbadams.hibernate.one_to_many_uni.entity.Instructor;
import org.jbadams.hibernate.one_to_many_uni.entity.InstructorDetail;
import org.jbadams.hibernate.one_to_many_uni.entity.Review;
import org.jbadams.hibernate.one_to_many_uni.util.HibernateUtil;

public class CreateCourseAndReviewsOneToManyUni {

    public static void run(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // create a course
            Course course = new Course("Pacman - How to Score One Million Points");

            // add some reviews
            course.addReview(new Review("Great course ... loved it!"));
            course.addReview(new Review("Cool course, job well done"));
            course.addReview(new Review("What a dumb course, you are an idiot!"));

            // save the course ... and leverage the cascade all
            System.out.println("Saving the course");
            System.out.println(course);
            System.out.println(course.getReviews());
            session.save(course); // the save gets cascaded to all reviews

            // commit
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }


    }

}