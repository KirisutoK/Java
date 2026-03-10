// Creation Date: February 27, 2026. at 9:25 PM
// Last Modified: March 10, 2026. at  9:53 AM

import Classes.Course;
import Classes.Person.Academic.AP_Professor;
import Classes.Person.Academic.AP_Student;
import Classes.Person.Academic.S_TeachingAssistant;

public class Main {
    public static void main(String[] args) {
        // CREATING INSTANCES OR OBJECTS
        // [UNIVERSITY]
        University FLCC = new University("Finger Lakes Community College");

        // [COURSES]
        Course Course01 = new Course("History", "HIS100", 3);
        Course Course02 = new Course("Coding", "COD100", 4);
        Course Course03 = new Course("English", "ENG100", 3);

        // [PEOPLE]
        AP_Student Test01 = new AP_Student("Test01", "S01", 18, "Computer Science");
        AP_Professor TestProf01 = new AP_Professor("TestProf01", "P01", 36, "Computer Science", 60000, 10);
        S_TeachingAssistant TestAs01 = new S_TeachingAssistant("TestAs01", "T01", 20, "Computer Science", 16.50, 15);

        FLCC.addPerson(Test01);
        FLCC.addPerson(TestProf01);
        FLCC.addPerson(TestAs01);

        System.out.println(" "); // Space for Readability

        FLCC.displayAllPeople();




//        Test01.enroll(Course01);
//        Test01.enroll(Course02);
//        Test01.enroll(Course03);
//        Test01.enroll(Course03);
//
//        Test01.assignGrade(Course01, 20);
//        Test01.assignGrade(Course02, 30);
//        Test01.assignGrade(Course03, 25);
//
//        Test01.drop(Course03);
//
//        Test01.displayInformation();
//
    }
}