package org.jbadams.hibernate.jdbc;
import java.sql.DriverManager;
import java.sql.Connection;

/*
    Test Connection to Local Postgresql via non-hibernate means
    Plain Vanilla, Jdbc Connection
*/
public class TestJdbc {
    public static void run(String[] args) {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String pass = "";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            // Connection myConn
            Connection db = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection successful");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}