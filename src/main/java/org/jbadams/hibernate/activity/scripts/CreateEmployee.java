package org.jbadams.hibernate.activity.scripts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbadams.hibernate.activity.util.HibernateUtil;
import org.jbadams.hibernate.activity.entity.Employee;


public class CreateEmployee {

    public static void run(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            session.beginTransaction();
            Employee emp = new Employee("Bob", "Dole", "Microsoft");
            session.save(emp);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

}