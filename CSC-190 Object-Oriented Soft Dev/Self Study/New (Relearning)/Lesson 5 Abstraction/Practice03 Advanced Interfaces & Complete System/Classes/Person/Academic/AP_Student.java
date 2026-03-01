package Classes.Person.Academic.People;
import Classes.Person.Academic.AcademicPerson;
import Classes.Course;
import Interfaces.Enrollable;
import Interfaces.Gradable;

// Creation Date: February 28, 2026. at 10:37 AM
// Last Modified: March 01, 2026. at 11:19 AM

public class Student
        extends AcademicPerson
        implements Enrollable, Gradable {
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
    // ENROLLABLE <==== [INTERFACE]
    @Override public int getEnrolledCount() {
        return CourseCount;
    }
    // TEACHABLE <==== [INTERFACE]
    //  ACADEMIC PERSON <==== [ABSTRACT]
    @Override public String getAcademicStatus() {
        if (Age < 23 ) {
            return "Undergraduate";
        }
        return "Graduate";
    }
    @Override public String getRole() {
        return "Student";
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    // --- @OVERRIDE
    // ENROLLABLE <==== [INTERFACE]

    @Override
    public void enroll(Course course) {
        
    }

    // TEACHABLE <==== [INTERFACE]
    //  ACADEMIC PERSON <==== [ABSTRACT]

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
