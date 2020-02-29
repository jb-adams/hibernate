package org.jbadams.hibernate.one_to_many.script;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbadams.hibernate.one_to_many.entity.Instructor;
import org.jbadams.hibernate.one_to_many.entity.InstructorDetail;
import org.jbadams.hibernate.one_to_many.util.HibernateUtil;

public class CreateInstructorOneToMany {

    public static void run(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            // create the objects
            Instructor instructor = new Instructor(
                "Susan", "Public", "susan.public@luv2code.com");
            
            InstructorDetail detail = new InstructorDetail(
                "http://www.youtube.com", "Video Games");

            // associate the objects in memory
            instructor.setInstructorDetail(detail);

            // save the instructor
            // NOTE: this will ALSO save the details object because of Cascade
            // CascadeType.ALL means it will save the object, and save any
            // object associated with it
            // saves to 2 separate tables
            System.out.println("Saving Instructor: " + instructor);
            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }


    }

}