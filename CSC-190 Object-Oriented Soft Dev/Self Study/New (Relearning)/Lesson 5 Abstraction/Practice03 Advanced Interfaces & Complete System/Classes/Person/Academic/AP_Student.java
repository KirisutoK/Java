package Classes.Person.Academic;
import Classes.Course;
import Interfaces.Enrollable;
import Interfaces.Gradable;

// Creation Date: February 28, 2026. at 10:37 AM
// Last Modified: March 04, 2026. at  1:49 PM

public class AP_Student
        extends AcademicPerson
        implements Enrollable { // Add Gradeable
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
    // GRADEABLE <==== [INTERFACE]

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
    public void enroll(Course course) { // ADD RESTRICTION IF COURSES IS ALREADY ADDED AND A LIMIT NOTIFICATION
        // LIMIT NOTIFICATION
        if (CourseCount == EnrolledCourses.length) {
            System.out.println("You have reached the limit for registering courses");
            return; // Stops the method here.
        }
        // DUPLICATION NOTIFICATION
        for (Course i:EnrolledCourses) {
            if (i == course) {
                System.out.println("You are already registered on "+i.getCourseName());
                return; // Stops the method here.
            }
        }
        // ADDING COURSE INTO THE ARRAY
        EnrolledCourses[CourseCount] = course;
        CourseCount++;
    }
    public void drop(Course course) { /////// <======================== YOU LEFT HERE!!!!
        boolean hasCourse = false;
        // REMOVING THE COURSE
        for (int i = 0; i < CourseCount; i++) { // for every CourseCount
            if (EnrolledCourses[i] == course) { // if it matches
                hasCourse = true;
                for (int j = i; j < CourseCount; j++) { // for every CourseCount starting from where the course is found
                    if (j != EnrolledCourses.length-1) {
                        EnrolledCourses[j] = EnrolledCourses[j+1];
                    }
                }
            }
        }
        // NOTIFIES IF YOU ARE NOT ENROLLED IN THAT COURSE
        if (!hasCourse) {
            System.out.println("You are not enrolled in "+course.getCourseName());
        }
    } //////////////////// <<========================= TEST THIS IF THE SHIFTING WORKS!

    // TEACHABLE <==== [INTERFACE]
    // GRADEABLE <==== [INTERFACE]
    //  ACADEMIC PERSON <==== [ABSTRACT]

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayCourses() {
        System.out.print("Enrolled Courses:");
        for (int i = 0; i < getEnrolledCount(); i++) {
            System.out.print(" "+EnrolledCourses[i].getCourseName()+" |");
        }
    }
}
