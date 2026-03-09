// Creation Date: February 27, 2026. at 9:25 PM
// Last Modified: March 08, 2026. at 11:40 PM

import Classes.Course;
import Classes.Person.Academic.AP_Professor;
import Classes.Person.Academic.AP_Student;

public class Main {
    public static void main(String[] args) {
        // CREATING INSTANCES OR OBJECTS
        // [COURSES]
        Course Course01 = new Course("History", "HIS100", 3);
        Course Course02 = new Course("Coding", "COD100", 4);
        Course Course03 = new Course("English", "ENG100", 3);

        AP_Student Test01 = new AP_Student("Test01", "S01", 18, "Computer Science");
        AP_Professor TestProf01 = new AP_Professor("TestProf01", "P01", 36, "Computer Science", 60000, 10);

        TestProf01.teach(Course01);

        TestProf01.displayInformation();




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