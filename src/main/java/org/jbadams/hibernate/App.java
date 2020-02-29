/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.jbadams.hibernate;
import org.jbadams.hibernate.jdbc.TestJdbc;
import org.jbadams.hibernate.one_to_one_bi.script.GetInstructorDetail;
import org.jbadams.hibernate.one_to_one_bi.script.DeleteInstructorDetail;
import org.jbadams.hibernate.demo.CreateStudentDemo;
import org.jbadams.hibernate.demo.PrimaryKeyDemo;
import org.jbadams.hibernate.demo.ReadStudentDemo;
import org.jbadams.hibernate.demo.QueryStudentDemo;
import org.jbadams.hibernate.demo.UpdateStudentDemo;
import org.jbadams.hibernate.demo.DeleteStudentDemo;
import org.jbadams.hibernate.activity.scripts.CreateEmployee;
import org.jbadams.hibernate.activity.scripts.GetEmployee;
import org.jbadams.hibernate.activity.scripts.QueryEmployee;
import org.jbadams.hibernate.activity.scripts.DeleteEmployee;
import org.jbadams.hibernate.one_to_one_uni.test.TestJdbcOneToOneUni;
import org.jbadams.hibernate.one_to_one_uni.script.CreateInstructor;
import org.jbadams.hibernate.one_to_one_uni.script.DeleteInstructor;
import org.jbadams.hibernate.one_to_many.script.CreateInstructorOneToMany;
import org.jbadams.hibernate.one_to_many.script.CreateCoursesOneToMany;
import org.jbadams.hibernate.one_to_many.script.GetInstructorCoursesOneToMany;
import org.jbadams.hibernate.one_to_many.script.DeleteCourseOneToMany;
import org.jbadams.hibernate.eager_vs_lazy.script.EagerLazy;
import org.jbadams.hibernate.eager_vs_lazy.script.FetchJoin;
import org.jbadams.hibernate.one_to_many_uni.script.CreateCourseAndReviewsOneToManyUni;
import org.jbadams.hibernate.one_to_many_uni.script.GetCourseAndReviewsOneToManyUni;
import org.jbadams.hibernate.one_to_many_uni.script.DeleteCourseAndReviewsOneToManyUni;
import org.jbadams.hibernate.many_to_many.script.CreateCourseAndStudentsManyToMany;
import org.jbadams.hibernate.many_to_many.script.AddCoursesForMaryManyToMany;
import org.jbadams.hibernate.many_to_many.script.GetCoursesForMaryManyToMany;
import org.jbadams.hibernate.many_to_many.script.DeleteCourseManyToMany;
import org.jbadams.hibernate.many_to_many.script.DeleteStudentManyToMany;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        
        if (args[0].equals("TestJdbc")) {
            TestJdbc.run(args);
        } else if (args[0].equals("CreateStudentDemo")) {
            CreateStudentDemo.run(args);
        } else if (args[0].equals("PrimaryKeyDemo")) {
            PrimaryKeyDemo.run(args);
        } else if (args[0].equals("ReadStudentDemo")) {
            ReadStudentDemo.run(args);
        } else if (args[0].equals("QueryStudentDemo")) {
            QueryStudentDemo.run(args);
        } else if (args[0].equals("UpdateStudentDemo")) {
            UpdateStudentDemo.run(args);
        } else if (args[0].equals("DeleteStudentDemo")) {
            DeleteStudentDemo.run(args);
        } else if (args[0].equals("CreateEmployee")) {
            CreateEmployee.run(args);
        } else if (args[0].equals("GetEmployee")) {
            GetEmployee.run(args);
        } else if (args[0].equals("QueryEmployee")) {
            QueryEmployee.run(args);
        } else if (args[0].equals("DeleteEmployee")) {
            DeleteEmployee.run(args);
        } else if (args[0].equals("TestJdbcOneToOneUni")) {
            TestJdbcOneToOneUni.run(args);
        } else if (args[0].equals("CreateInstructor")) {
            CreateInstructor.run(args);
        } else if (args[0].equals("DeleteInstructor")) {
            DeleteInstructor.run(args);
        } else if (args[0].equals("GetInstructorDetail")) {
            GetInstructorDetail.run(args);
        } else if (args[0].equals("DeleteInstructorDetail")) {
            DeleteInstructorDetail.run(args);
        } else if (args[0].equals("CreateInstructorOneToMany")) {
            CreateInstructorOneToMany.run(args);
        } else if (args[0].equals("CreateCoursesOneToMany")) {
            CreateCoursesOneToMany.run(args);
        } else if (args[0].equals("GetInstructorCoursesOneToMany")) {
            GetInstructorCoursesOneToMany.run(args);
        } else if (args[0].equals("DeleteCourseOneToMany")) {
            DeleteCourseOneToMany.run(args);
        } else if (args[0].equals("EagerLazy")) {
            EagerLazy.run(args);
        } else if (args[0].equals("FetchJoin")) {
            FetchJoin.run(args);
        } else if (args[0].equals("CreateCourseAndReviewsOneToManyUni")) {
            CreateCourseAndReviewsOneToManyUni.run(args);
        } else if (args[0].equals("GetCourseAndReviewsOneToManyUni")) {
            GetCourseAndReviewsOneToManyUni.run(args);
        } else if (args[0].equals("DeleteCourseAndReviewsOneToManyUni")) {
            DeleteCourseAndReviewsOneToManyUni.run(args);
        } else if (args[0].equals("CreateCourseAndStudentsManyToMany")) {
            CreateCourseAndStudentsManyToMany.run(args);
        } else if (args[0].equals("AddCoursesForMaryManyToMany")) {
            AddCoursesForMaryManyToMany.run(args);
        } else if (args[0].equals("GetCoursesForMaryManyToMany")) {
            GetCoursesForMaryManyToMany.run(args);
        } else if (args[0].equals("DeleteCourseManyToMany")) {
            DeleteCourseManyToMany.run(args);
        } else if (args[0].equals("DeleteStudentManyToMany")) {
            DeleteStudentManyToMany.run(args);
        } else {
            System.out.println("No Flag Provided");
        }
    }
}
