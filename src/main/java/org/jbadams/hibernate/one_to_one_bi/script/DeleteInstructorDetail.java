package org.jbadams.hibernate.one_to_one_bi.script;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbadams.hibernate.one_to_one_bi.entity.InstructorDetail;
import org.jbadams.hibernate.one_to_one_bi.util.HibernateUtil;

/*
    Get Instructor Details and associated info using bidirectional data
    mapping 
    THEN DELETE
*/

public class DeleteInstructorDetail {

    public static void run(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            // get the instructor detail object
            int id = 3;
            InstructorDetail detail = session.get(InstructorDetail.class, id);

            // print the instructor detail
            System.out.println("detail: " + detail);

            // print the associated instructor using bidirectional mapping
            System.out.println("associated instructor: " + detail.getInstructor());

            // now let's delete the instructor detail
            System.out.println("Deleting detail: " + detail);

            // remove the associated object reference to delete 
            // instructor detail independently
            detail.getInstructor().setInstructorDetail(null);
            session.delete(detail);

            session.getTransaction().commit();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            // handle connection leak issue
            session.close();
            factory.close();
        }
    }
}