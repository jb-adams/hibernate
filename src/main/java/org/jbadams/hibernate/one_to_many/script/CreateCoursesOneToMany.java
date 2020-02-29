package org.jbadams.hibernate.one_to_many.script;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbadams.hibernate.one_to_many.entity.Course;
import org.jbadams.hibernate.one_to_many.entity.Instructor;
import org.jbadams.hibernate.one_to_many.entity.InstructorDetail;
import org.jbadams.hibernate.one_to_many.util.HibernateUtil;

public class CreateCoursesOneToMany {

    public static void run(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            // get the instructor from db
            int theId = 1;
            Instructor instructor = session.get(Instructor.class, theId);

            // create some courses
            Course course1 = new Course("Air Guitar - The Ultimate Guide");
            Course course2 = new Course("The Pinball Masterclass");

            // add courses to instructor
            instructor.add(course1);
            instructor.add(course2);

            // save the courses
            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }


    }

}