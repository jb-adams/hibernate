package org.jbadams.hibernate.one_to_many.script;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbadams.hibernate.one_to_many.entity.Course;
import org.jbadams.hibernate.one_to_many.entity.Instructor;
import org.jbadams.hibernate.one_to_many.entity.InstructorDetail;
import org.jbadams.hibernate.one_to_many.util.HibernateUtil;

public class GetInstructorCoursesOneToMany {

    public static void run(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            // get the instructor from db
            int theId = 1;
            Instructor instructor = session.get(Instructor.class, theId);

            System.out.println("Instructor: " + instructor);

            // get courses for the instructor
            System.out.println("Courses: " + instructor.getCourses());

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }


    }

}