package org.jbadams.hibernate.many_to_many.script;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbadams.hibernate.many_to_many.entity.Student;
import org.jbadams.hibernate.many_to_many.entity.Course;
import org.jbadams.hibernate.many_to_many.entity.Instructor;
import org.jbadams.hibernate.many_to_many.entity.InstructorDetail;
import org.jbadams.hibernate.many_to_many.entity.Review;
import org.jbadams.hibernate.many_to_many.util.HibernateUtil;

public class AddCoursesForMaryManyToMany {

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
            System.out.println("Course: " + student.getCourses());

            // create more courses
            Course course1 = new Course("Rubik's Cube - How to Speed Cube");
            Course course2 = new Course("Atari 2600 - Game Development");

            // add student to courses
            course1.addStudent(student);
            course2.addStudent(student);
            
            // save the courses
            System.out.println("Saving the courses");
            session.save(course1);
            session.save(course2); 

            // commit
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }


    }

}