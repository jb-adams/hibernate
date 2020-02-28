package org.jbadams.hibernate.one_to_one_uni.script;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbadams.hibernate.one_to_one_uni.entity.Instructor;
import org.jbadams.hibernate.one_to_one_uni.util.HibernateUtil;

public class DeleteInstructor {

    public static void run(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            // get instructor by primary key
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("Found instructor: " + instructor);

            // delete the instructor
            // will ALSO delete the instructor_details object because of 
            // Cascade
            if (instructor != null) {
                System.out.println("Deleting: " + instructor);
                session.delete(instructor);
            }
            
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}