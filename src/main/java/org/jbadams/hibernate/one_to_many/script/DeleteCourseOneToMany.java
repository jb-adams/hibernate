package org.jbadams.hibernate.one_to_many.script;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbadams.hibernate.one_to_many.entity.Course;
import org.jbadams.hibernate.one_to_many.entity.Instructor;
import org.jbadams.hibernate.one_to_many.entity.InstructorDetail;
import org.jbadams.hibernate.one_to_many.util.HibernateUtil;

public class DeleteCourseOneToMany {

    public static void run(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            // get a course
            int theId = 1;
            Course course = session.get(Course.class, theId);

            // delete a course
            System.out.println("Deleting course: " + course);

            session.delete(course);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }


    }

}