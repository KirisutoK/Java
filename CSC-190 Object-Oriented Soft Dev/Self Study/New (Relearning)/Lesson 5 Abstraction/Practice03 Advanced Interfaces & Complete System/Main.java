// Creation Date: February 27, 2026. at 9:25 PM
// Last Modified: March 17, 2026. at 11:11 AM

import Classes.Course;
import Classes.Person.Academic.AP_Professor;
import Classes.Person.Academic.AP_Student;
import Classes.Person.Academic.S_TeachingAssistant;

public class Main {
    public static void main(String[] args) {
        // ==================== CREATING INSTANCES OR OBJECTS ==================== \\
        // [UNIVERSITY]
        University FLCC = new University("Finger Lakes Community College");

        // [COURSES]
        Course Course01 = new Course("History", "HIS100", 3, 1);
        Course Course02 = new Course("Coding", "COD100", 4, 12);
        Course Course03 = new Course("English", "ENG100", 3, 20);

        // [PEOPLE]
        AP_Student Test01 = new AP_Student("Test01", "S01", 18, "Computer Science");
        AP_Professor TestProf01 = new AP_Professor("TestProf01", "P01", 36, "Computer Science", 60000, 10);
        S_TeachingAssistant TestAs01 = new S_TeachingAssistant("TestAs01", "T01", 20, "Computer Science", 16.50, 15);

        // ==================== METHODS ==================== \\
        

        // [ENROLLING A STUDENT TO A COURSE]
        Test01.enroll(Course01);
        TestAs01.enroll(Course01);
        System.out.println(" "); // Space for readability


        // [ASSIGN PROF TO A COURSE]
        TestProf01.teach(Course01);
        System.out.println(" "); // Space for Readability

        // [ADDING PEOPLE]
        FLCC.addPerson(Test01);
        FLCC.addPerson(TestProf01);
        FLCC.addPerson(TestAs01);
        System.out.println(" "); // Space for Readability

        // [ADDING COURSES]
        FLCC.addCourse(Course01);
        FLCC.addCourse(Course02);
        FLCC.addCourse(Course03);
        System.out.println(" "); // Space for Readability

        FLCC.displayAllPeople();
        FLCC.displayAllCourses();
        FLCC.displayEnrollmentReport();

        // GETTERS FOR STUDENTS, PROFESSORS, TEACHING ASSISTANTS
        System.out.println("STUDENTS: "+FLCC.getAllStudents().toString());
        System.out.println("PROFESSORS: "+FLCC.getAllProfessors().toString());
        System.out.println("TEACHING ASSISTANTS: "+FLCC.getAllTeachingAssistant().toString());

    }
}

// NOTES:
// <================================================================ SOMETHING IS WRONG WITH THE PRINTING METHOD FOR GETTERS OF ALL STUDENTS, PROFESSORS, AND TEACHING ASSISTANT.