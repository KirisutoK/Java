// Creation Date: February 27, 2026. at 9:25 PM
// Last Modified: March 07, 2026. at 12:03 PM

import Classes.Course;
import Classes.Person.Academic.AP_Student;

public class Main {
    public static void main(String[] args) {
        // CREATING INSTANCES OR OBJECTS
        // [COURSES]
        Course Course01 = new Course("History", "HIS100", 3);
        Course Course02 = new Course("Coding", "COD100", 4);
        Course Course03 = new Course("English", "ENG100", 3);

        AP_Student Test01 = new AP_Student("Test01", "01", 18, "Computer Science");

        Test01.enroll(Course01);
        Test01.enroll(Course02);
        Test01.enroll(Course03);
        Test01.enroll(Course03);

        System.out.println("===COURSES===");
        Test01.displayCourses();
        System.out.println(" "); // Space for Readability

        System.out.println("\n===REMOVING COURSES===");
        Test01.drop(Course01);
        Test01.drop(Course01);
        Test01.displayCourses();
        System.out.println(" "); // Space for Readability
    }
}