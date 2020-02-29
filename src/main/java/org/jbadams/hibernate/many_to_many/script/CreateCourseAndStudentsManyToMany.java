package org.jbadams.hibernate.many_to_many.script;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbadams.hibernate.many_to_many.entity.Student;
import org.jbadams.hibernate.many_to_many.entity.Course;
import org.jbadams.hibernate.many_to_many.entity.Instructor;
import org.jbadams.hibernate.many_to_many.entity.InstructorDetail;
import org.jbadams.hibernate.many_to_many.entity.Review;
import org.jbadams.hibernate.many_to_many.util.HibernateUtil;

public class CreateCourseAndStudentsManyToMany {

    public static void run(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // create a course
            Course course = new Course("Pacman - How to Score One Million Points");

            // save the course
            System.out.println("Saving the course");
            session.save(course);
            System.out.println("Saved the course: " + course);

            // create the students
            Student student1 = new Student("John", "Doe", "john@luv2code.com");
            Student student2 = new Student("Mary", "Public", "mary@luv2code.com");

            // add students to course
            course.addStudent(student1);
            course.addStudent(student2);

            // save the students
            System.out.println("Saving students");
            session.save(student1);
            session.save(student2);
            System.out.println("Saved students: " + course.getStudents());

            // commit
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }


    }

}