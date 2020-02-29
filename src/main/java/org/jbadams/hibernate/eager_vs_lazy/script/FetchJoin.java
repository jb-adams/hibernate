package org.jbadams.hibernate.eager_vs_lazy.script;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbadams.hibernate.eager_vs_lazy.entity.Course;
import org.jbadams.hibernate.eager_vs_lazy.entity.Instructor;
import org.jbadams.hibernate.eager_vs_lazy.entity.InstructorDetail;
import org.jbadams.hibernate.eager_vs_lazy.util.HibernateUtil;

public class FetchJoin {

    public static void run(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            // how to get lazy data?
            // option 2: hibernate query with HQL

            // get the instructor from db
            int theId = 1;
            Query<Instructor> query = 
                session.createQuery(
                    "select i from Instructor i "
                    + "JOIN FETCH i.courses "
                    + "WHERE i.id=:theInstructorId",
                    Instructor.class);

            // set parameter query
            query.setParameter("theInstructorId", theId);

            // execute query and get instructor
            Instructor instructor = query.getSingleResult();

            System.out.println("luv2code: Instructor: " + instructor);
            // System.out.println("luv2code: Courses: " + instructor.getCourses());
            

            session.getTransaction().commit();
            session.close();

            // if the session is closed, then the lazy load method will raise
            // an error
            System.out.println("luv2code: Courses: " + instructor.getCourses());

        } finally {
            session.close();
            factory.close();
        }
    }
}