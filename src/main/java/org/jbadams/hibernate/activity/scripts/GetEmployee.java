package org.jbadams.hibernate.activity.scripts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbadams.hibernate.activity.util.HibernateUtil;
import org.jbadams.hibernate.activity.entity.Employee;

public class GetEmployee {

    public static void run(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();

        try {
            int studentId = 1;
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee emp = session.get(Employee.class, studentId);
            System.out.println(emp);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }

}