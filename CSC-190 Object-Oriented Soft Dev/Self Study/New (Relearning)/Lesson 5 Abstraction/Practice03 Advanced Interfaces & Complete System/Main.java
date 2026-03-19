// Creation Date: February 27, 2026. at 9:25 PM
// Last Modified: March 18, 2026. at  9:02 PM

import Classes.Course;
import Classes.Person.Academic.AP_Professor;
import Classes.Person.Academic.AP_Student;
import Classes.Person.Academic.S_TeachingAssistant;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // ==================== CREATING INSTANCES OR OBJECTS ==================== \\
        // [UNIVERSITY]
        University FLCC = new University("Finger Lakes Community College");
        // [COURSES]
        Course Course01 = new Course("History", "HIS100", 3, 1);
        Course Course02 = new Course("Coding", "COD100", 4, 12);
        Course Course03 = new Course("English", "ENG100", 3, 20);
        // ========[PEOPLE]========
        // [PROFESSORS]
        AP_Professor Prof01 = new AP_Professor("Paige Labar", "P01", 30, "Computer Science", 75500, 5);
        AP_Professor Prof02 = new AP_Professor("Will Mclaughlin", "P02", 33, "Mathematics", 69000, 7);
        // [STUDENT]
        AP_Student Student01 = new AP_Student("Christ", "S01", 19, "Computer Science");
        AP_Student Student02 = new AP_Student("Kevin", "S02", 26, "Computer Science");
        AP_Student Student03 = new AP_Student("Christian", "S03", 18, "Environmental Science");
        AP_Student Student04 = new AP_Student("Jackson", "S04", 18, "Mathematics");
        // [TEACHING ASSISTANT]
        S_TeachingAssistant TeachingAss01 = new S_TeachingAssistant("Peire", "TA01", 26, "Mathematics", 20.50, 25);
        S_TeachingAssistant TeachingAss02 = new S_TeachingAssistant("Wendy", "TA02", 65, "Business", 19.60, 20);

        // ==================== METHODS ==================== \\

        // ADDING PEOPLE TO UNIVERSITY
        System.out.println("=========== ADDING PEOPLE TO UNIVERSITY ===========");
        FLCC.addPerson(Prof01);
        FLCC.addPerson(Prof02);
        FLCC.addPerson(Student01);
        FLCC.addPerson(Student02);
        FLCC.addPerson(Student03);
        FLCC.addPerson(Student04);
        FLCC.addPerson(TeachingAss01);
        FLCC.addPerson(TeachingAss02);
        System.out.println(" "); // Space for Readability

        // ADDING COURSES TO UNIVERSITY
        System.out.println("=========== ADDING COURSES TO UNIVERSITY ===========");
        FLCC.addCourse(Course01);
        FLCC.addCourse(Course02);
        FLCC.addCourse(Course03);
        System.out.println(" "); // Space for Readability

        // ========[ENROLLMENT OPERATIONS]========
        // ENROLLING STUDENTS TO COURSES
        System.out.println("=========== ENROLLING STUDENTS TO COURSES ===========");
        Student01.enroll(Course01);
        Student01.enroll(Course02);
        Student01.enroll(Course03);
        System.out.println(" "); // Space for Readability

        Student02.enroll(Course01);
        Student02.enroll(Course02);
        System.out.println(" "); // Space for Readability

        Student03.enroll(Course01);
        Student03.enroll(Course02);
        Student03.enroll(Course03);
        System.out.println(" "); // Space for Readability

        Student04.enroll(Course01);
        Student04.enroll(Course03);
        System.out.println(" "); // Space for Readability



    }
}

// NOTES:
// <================================================================ YOU LEFT AT DOING THE MAIN STUFF METHODS