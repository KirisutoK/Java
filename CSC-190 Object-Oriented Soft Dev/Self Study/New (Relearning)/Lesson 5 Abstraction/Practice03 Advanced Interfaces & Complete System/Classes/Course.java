package Classes;
import Classes.Person.Academic.AP_Professor;

// Creation Date: February 28, 2026. at 10:54 AM
// Last Modified: March 07, 2026. at 12:02 PM

public class Course {
    //=======VARIABLES=======//
    private String CourseName;
    private String CourseCode;
    private int Credits;
    private AP_Professor Instructor;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Course(String CourseName, String CourseCode, int Credits) {
        this.CourseName = CourseName;
        this.CourseCode = CourseCode;
        this.Credits = Credits;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getCourseName() {
        return CourseName;
    }
    public AP_Professor getInstructor() {
        return Instructor;
    }
    public int getCredits() {
        return Credits;
    }
    public String getCourseCode() {
        return CourseCode;
    }
    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void assignInstructor(AP_Professor Instructor) {
        this.Instructor = Instructor;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInformation() {
        System.out.println("Course Name: "+CourseName);
        System.out.println("Course Code: "+CourseCode);
        System.out.println("Course Credits: "+Credits);
        System.out.println("Course AP_Professor: "+Instructor);
    }
}
