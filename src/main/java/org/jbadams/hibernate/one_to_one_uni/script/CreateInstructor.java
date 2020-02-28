package org.jbadams.hibernate.one_to_one_uni.script;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbadams.hibernate.one_to_one_uni.entity.Instructor;
import org.jbadams.hibernate.one_to_one_uni.entity.InstructorDetail;
import org.jbadams.hibernate.one_to_one_uni.util.HibernateUtil;

public class CreateInstructor {

    public static void run(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            // create the objects

            // INSTRUCTOR 1
            /*
            Instructor instructor = new Instructor(
                "Chad", "Darby", "darby@luv2code.com");
            
            InstructorDetail detail = new InstructorDetail(
                "http://www.luv2code.com/youtube", "Luv 2 code");
            */

            // INSTRUCTOR 2
            Instructor instructor = new Instructor(
                "Madhu", "Babu", "madhu@gmail.com");
            
            InstructorDetail detail = new InstructorDetail(
                "http://www.youtube.com", "Guitar");

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

        }


    }

}