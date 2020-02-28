package org.jbadams.hibernate.activity.scripts;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbadams.hibernate.activity.util.HibernateUtil;
import org.jbadams.hibernate.activity.entity.Employee;

public class QueryEmployee {

    public static void run(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            List<Employee> employees = session.createQuery(
                "from Employee e where e.company='Microsoft'", Employee.class
            ).getResultList();

            for (Employee employee : employees) {
                System.out.println(employee);
            }

            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }

}