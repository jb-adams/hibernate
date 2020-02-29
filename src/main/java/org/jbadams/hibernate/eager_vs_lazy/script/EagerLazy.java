package org.jbadams.hibernate.eager_vs_lazy.script;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbadams.hibernate.eager_vs_lazy.entity.Course;
import org.jbadams.hibernate.eager_vs_lazy.entity.Instructor;
import org.jbadams.hibernate.eager_vs_lazy.entity.InstructorDetail;
import org.jbadams.hibernate.eager_vs_lazy.util.HibernateUtil;

public class EagerLazy {

    public static void run(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            // get the instructor from db
            int theId = 1;
            Instructor instructor = session.get(Instructor.class, theId);

            System.out.println("luv2code: Instructor: " + instructor);

            // get courses for the instructor
            // this is lazily loaded, and can be retrieved if the session is 
            // still open
            //System.out.println("luv2code: Courses: " + instructor.getCourses());

            // how to get lazy data?
            // option 1: call getter method while session is open
            System.out.println("luv2code: Courses: " + instructor.getCourses());
            // option 2: 

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