package org.jbadams.hibernate.many_to_many.script;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbadams.hibernate.many_to_many.entity.Student;
import org.jbadams.hibernate.many_to_many.entity.Course;
import org.jbadams.hibernate.many_to_many.entity.Instructor;
import org.jbadams.hibernate.many_to_many.entity.InstructorDetail;
import org.jbadams.hibernate.many_to_many.entity.Review;
import org.jbadams.hibernate.many_to_many.util.HibernateUtil;

public class DeleteCourseManyToMany {

    public static void run(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // get the pacman course from the database
            int courseId = 2; // pacman course id
            Course course = session.get(Course.class, courseId);

            // delete the course
            System.out.println("Deleting course: " + course);
            session.delete(course);

            // commit
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }


    }

}