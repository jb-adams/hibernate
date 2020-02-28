package org.jbadams.hibernate.one_to_one_uni.test;

import java.sql.DriverManager;
import java.sql.Connection;

/*
    Test Connection to Local Postgresql via non-hibernate means
    Plain Vanilla, Jdbc Connection
*/
public class TestJdbcOneToOneUni {
    public static void run(String[] args) {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/hb_student_tracker?currentSchema=hb-01-one-to-one-uni&useSSL=false";
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