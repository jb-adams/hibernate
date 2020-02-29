package org.jbadams.hibernate.eager_vs_lazy.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {

    // annotate the class as an entity and map to db table

    // define the fields

    // annotate the fields with db column names

    // create constructors

    // generate setter/getter methods
    
    // generate toString() method

    // SET UP RELATIONSHIP / MAPPING BETWEEN INSTRUCTOR AND INSTRUCTOR DETAIL

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

    // set up the relational mapping between the instructor's 
    // instructor_detail_id and the instructor detail's id
    // ie there is a One-To-One mapping (@OneToOne)
    // with instructorDetail table (data type)
    // joined on the specific column (@JoinColumn)
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    private InstructorDetail instructorDetail;

    // add one to many mapping of instructor to its courses
    // FetchType for eager or lazy loading
    @OneToMany(mappedBy="instructor",
               // fetch=FetchType.EAGER, 
               fetch=FetchType.LAZY,
               cascade={CascadeType.PERSIST, CascadeType.MERGE,
                        CascadeType.DETACH, CascadeType.REFRESH}) // refers to instructor property in course class
    private List<Course> courses;

    /* constructors */

    public Instructor() {

    }

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /* getters and setters */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetail getInstructorDetail() {
        return this.instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // add convenience method for bi-directional relationship between
    // course and instructor

    public void add(Course tempCourse) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(tempCourse);
        tempCourse.setInstructor(this);
    }

    /* toString() */
    public String toString() {
        return "InstructorDetail [id=" + id + ", firstName=" + firstName +
               ", lastName=" + lastName + ", email=" + email + 
               ", instructorDetail=" + instructorDetail + "]";
    }
}