package Classes.Person.Academic;
import Classes.Course;
import Interfaces.Enrollable;
import Interfaces.Gradable;

// Creation Date: February 28, 2026. at 10:37 AM
// Last Modified: March 02, 2026. at  1:35 PM

public class AP_Student
        extends AcademicPerson
        implements Enrollable, Gradable {
    //=======VARIABLES=======//
    private Course[] EnrolledCourses = new Course[6];
    private double Grades;
    private int CourseCount;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public AP_Student(String Name, String ID, int Age, String Department) {
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
        for (int i = 0; i < EnrolledCourses.length; i++) {
            if (CourseCount <= 6) {
                EnrolledCourses[CourseCount] = course;
            } else {
                System.out.println("You have exceeded the maximum amount of courses you can enroll.");
            }
        }
    }
    public void drop(Course course) { /////// <======================== YOU LEFT HERE!!!!
        for (int i = 0; i < CourseCount; i++) { // for every CourseCount
            if (EnrolledCourses[i] == course) { // if it matches
                for (int j = i; j < CourseCount; j++) { // for every CourseCount starting from where the course is found
                    if (j != EnrolledCourses.length-1) {
                        EnrolledCourses[j] = EnrolledCourses[j+1];
                    }
                }
            }
        }
    } //////////////////// <<========================= TEST THIS IF THE SHIFTING WORKS!

    // TEACHABLE <==== [INTERFACE]
    //  ACADEMIC PERSON <==== [ABSTRACT]

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
