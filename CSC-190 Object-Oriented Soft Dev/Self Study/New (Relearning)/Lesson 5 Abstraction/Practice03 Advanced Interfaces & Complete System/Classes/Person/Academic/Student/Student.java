package Classes.Person.Academic.Student;

// Creation Date: February 28, 2026. at 10:37 AM
// Last Modified: February 28, 2026. at 11:19 AM

import Classes.Person.Academic.AcademicPerson;
import Classes.Course;

public class Student
        extends AcademicPerson {
    //=======VARIABLES=======//
    private Course[] EnrolledCourses = new Course[6];
    private double Grades;
    private int CourseCount;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Student(String Name, String ID, int Age, String Department) {
        super(Name, ID, Age, Department);
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    // --- @OVERRIDE
    @Override public String getAcademicStatus() {
        return "YOU LEFT HERE"; // YOU LEFT HEREEEEEEEEEEEEEEEEEEEEEEEEEEEEEE!!!
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
