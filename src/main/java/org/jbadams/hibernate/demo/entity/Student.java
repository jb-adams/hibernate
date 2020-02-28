package org.jbadams.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* 
    Hibernate Basics
    With Hibernate, we need to map 2 things:
        1. Java Class to Database Table
        2. Java Class Attributes to Database Table Columns
    @Entity annotates a class, saying that it is represented in a relational db
    @Table maps to Entity to a specific database table

    @Column maps an attribute to a table column
    @Id identifies the class/table primary key

    @GeneratedValue lets SQL generate unique values based on how the schema
        is configured
        it needs a "strategy", look up ID Generation Strategies for more info
    In this case, the IDENTITY column in SQL is AUTOINCREMENT, so it will
    autoincrement
    You can also develop your own CUSTOM ID Generation Strategy
*/

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    public Student() {

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /* Getters and Setters */
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + 
               ", lastName=" + lastName + ", email=" + email +"]";
    }

}