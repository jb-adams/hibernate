package org.jbadams.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.jbadams.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

    public static void run(String[] args) {

        SessionFactory factory = new Configuration()
                                 .configure()
                                 .addAnnotatedClass(Student.class)
                                 .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            // create 3 student objects
            System.out.println("Creating 3 student object");
            Student stu1 = new Student("John", "Doe", "john@luv2code.com");
            Student stu2 = new Student("Mary", "Public", "mary@luv2code.com");
            Student stu3 = new Student("Bonita", "Applebaum", "bonita@luv2code.com");

            session.beginTransaction();

            System.out.println("Saving the students");
            session.save(stu1);
            session.save(stu2);
            session.save(stu3);

            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}