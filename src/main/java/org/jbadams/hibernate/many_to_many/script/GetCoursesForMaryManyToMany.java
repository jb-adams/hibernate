package org.jbadams.hibernate.many_to_many.script;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbadams.hibernate.many_to_many.entity.Student;
import org.jbadams.hibernate.many_to_many.entity.Course;
import org.jbadams.hibernate.many_to_many.entity.Instructor;
import org.jbadams.hibernate.many_to_many.entity.InstructorDetail;
import org.jbadams.hibernate.many_to_many.entity.Review;
import org.jbadams.hibernate.many_to_many.util.HibernateUtil;

public class GetCoursesForMaryManyToMany {

    public static void run(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // get the student mary from the database
            int studentId = 4; // mary's id
            Student student = session.get(Student.class, studentId);
            System.out.println("Loaded student: " + student);
            System.out.println("Courses: " + student.getCourses());

            // commit
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }


    }

}