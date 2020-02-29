package org.jbadams.hibernate.one_to_many_uni.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/* BIDIRECTIONAL MAPPING
    be able to go from Instructor to InstructorDetail,
    and also from InstructorDetail to Instructor
*/

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    // annotate the class as an entity and map to db table

    // define the fields

    // annotate the fields with db column names

    // create constructors

    // generate setter/getter methods
    
    // generate toString() method

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="youtube_channel")
    private String youtubeChannel;

    @Column(name="hobby")
    private String hobby;

    // add new field for instructor (also add getter/setters)

    // BIDIRECTIONAL DATA MAPPING
    // mappedBy will look up the "instructorDetail" property in the
    //      Instructor class
    // Cascade types includes everything except REMOVE, meaning that DELETION
    // of instructorDetail will not Cascade to an instructor Deletion
    @OneToOne(mappedBy="instructorDetail", cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Instructor instructor;

    /* constructors */

    public InstructorDetail() {}

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    /* getters and setters */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    /* toString() */

    public String toString() {
        return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel
               + ", hobby=" + hobby + "]";
    }

}