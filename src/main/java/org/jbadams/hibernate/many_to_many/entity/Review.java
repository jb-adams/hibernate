package org.jbadams.hibernate.many_to_many.entity;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {

    // define fields

    // define constructor

    // define getter/setters

    // define tostring

    // annotate fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    private String comment;

    /* constructors */

    public Review() {
    }

    public Review(String comment) {
        this.comment = comment;
    }

    /* getter/setter */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String toString() {
        return "Review [id=" + id + ", comment=" + comment + "]";
    }
}