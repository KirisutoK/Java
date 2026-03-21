// Creation Date: February 27, 2026. at 9:25 PM
// Last Modified: March 21, 2026. at 11:09 AM

import Classes.Course;
import Classes.Person.Academic.AP_Professor;
import Classes.Person.Academic.AP_Student;
import Classes.Person.Academic.S_TeachingAssistant;
import Classes.Person.Person;
import Classes.University;
import Interfaces.Enrollable;
import Interfaces.Payable;
import Interfaces.Teachable;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // ==================== CREATING INSTANCES OR OBJECTS ==================== \\
        Random random = new Random();

        // [UNIVERSITY]
        University FLCC = new University("Finger Lakes Community College");
        // [COURSES]
        Course Course01 = new Course("History", "HIS100", 3, 5);
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
        Student04.enroll(Course03);
        System.out.println(" "); // Space for Readability

        // ENROLLING TEACHING ASSISTANTS TO COURSES
        System.out.println("=========== ENROLLING TEACHING ASSISTANTS TO COURSES ===========");
        TeachingAss01.enroll(Course01);
        TeachingAss01.enroll(Course03);
        System.out.println(" "); // Space for Readability

        TeachingAss02.enroll(Course01);
        TeachingAss02.enroll(Course02);
        System.out.println(" "); // Space for Readability

        // ASSIGNING TEACHING ASSISTANTS TO COURSES
        System.out.println("=========== ASSIGNING TEACHING ASSISTANTS TO COURSES ===========");
        TeachingAss01.teach(Course02);
        TeachingAss02.teach(Course03);
        System.out.println(" "); // Space for Readability

        // ASSIGNING PROFESSORS TO COURSES
        System.out.println("=========== ASSIGNING PROFESSORS TO COURSES ===========");
        Prof01.teach(Course03);
        Prof02.teach(Course03);
        Prof02.teach(Course01);
        Prof02.teach(Course02);

        // ========[GRADING OPERATIONS]========
        // ASSIGN GRADES TO STUDENTS
        System.out.println("=========== ASSIGNING GRADES TO STUDENTS ===========");
        Student01.assignGrade(Course01, random.nextDouble(4));
        Student01.assignGrade(Course02, random.nextDouble(4));
        Student01.assignGrade(Course03, random.nextDouble(4));
        System.out.println(" "); // Space for Readability

        Student02.assignGrade(Course01, random.nextDouble(4));
        Student02.assignGrade(Course02, random.nextDouble(4));
        Student02.assignGrade(Course03, random.nextDouble(4));
        System.out.println(" "); // Space for Readability

        Student03.assignGrade(Course01, random.nextDouble(4));
        Student03.assignGrade(Course02, random.nextDouble(4));
        Student03.assignGrade(Course03, random.nextDouble(4));
        System.out.println(" "); // Space for Readability

        Student04.assignGrade(Course01, random.nextDouble(4));
        Student04.assignGrade(Course02, random.nextDouble(4));
        Student04.assignGrade(Course03, random.nextDouble(4));
        System.out.println(" "); // Space for Readability

        // CALCULATE AND DISPLAY GPA
        System.out.println("=========== CALCULATE AND DISPLAY GPA ===========");
        System.out.println(Student01.getName() + " GPA: " + Student01.getGPA());
        System.out.println(Student02.getName() + " GPA: " + Student02.getGPA());
        System.out.println(Student03.getName() + " GPA: " + Student03.getGPA());
        System.out.println(Student04.getName() + " GPA: " + Student04.getGPA());
        System.out.println(" "); // Space for Readability

        // ========[PAYMENT OPERATIONS]========
        // CALCULATE AND DISPLAY PROFESSOR'S SALARY
        System.out.println("=========== CALCULATE AND DISPLAY PROFESSOR'S SALARY ===========");
        System.out.println(Prof01.getName() + " Salary: $" + Prof01.calculateSalary());
        System.out.println(Prof02.getName() + " Salary: $" + Prof02.calculateSalary());
        System.out.println(" "); // Space for Readability

        // CALCULATE AND DISPLAY TEACHING ASSISTANTS SALARY
        System.out.println("=========== CALCULATE AND DISPLAY TEACHING ASSISTANTS SALARY ===========");
        System.out.println(TeachingAss01.getName() + " Salary: $" + TeachingAss01.calculateSalary());
        System.out.println(TeachingAss02.getName() + " Salary: $" + TeachingAss02.calculateSalary());
        System.out.println(" "); // Space for Readability

        // DISPLAY TOTAL UNIVERSITY PAYROLL
        System.out.println("=========== DISPLAY TOTAL UNIVERSITY PAYROLL ===========");
        System.out.println(FLCC.getUniversityName() + " Total Payroll: $" + FLCC.calculateTotalPayroll());
        System.out.println(" "); // Space for Readability

        // ========[PAYMENT OPERATIONS]========
        // PERSON DISPLAY INFO
        System.out.println("=========== PERSON DISPLAY INFO ===========");
        for (Person i:FLCC.getPeople()) {
            if (i != null) {
                i.displayInformation();
                System.out.println(" "); // Space for Readability
            }
        }
        // INTERFACES COUNT
        System.out.println("=========== INTERFACES COUNT ===========");
        int EnrollableCount = 0;
        int PayableCount = 0;
        int TeachableCount = 0;
        for (Person i:FLCC.getPeople()) {
            if (i instanceof Enrollable) {
                EnrollableCount++;
            }
            if (i instanceof Payable) {
                PayableCount++;
            }
            if (i instanceof Teachable) {
                TeachableCount++;
            }
        }
        System.out.println("Enrollables: "+EnrollableCount);
        System.out.println("Payable: "+PayableCount);
        System.out.println("Teachable: "+TeachableCount);
        System.out.println(" "); // Space for Readability

        // ==================== METHODS ==================== \\
        // ENROLLMENT REPORT FLCC
        FLCC.displayEnrollmentReport();

        // STUDENT DROPPING A COURSE
        System.out.println("=========== STUDENT DROPPING COURSES ===========");
        Student01.displayInformation();
        System.out.println("DROPS: ");
        Student01.drop(Course01);
        Student01.drop(Course02);
        System.out.println(" "); // Space for Readability
        Student02.displayInformation();
        System.out.println(" "); // Space for Readability

        Student02.displayInformation();
        System.out.println("DROPS: ");
        Student02.drop(Course03);
        System.out.println(" "); // Space for Readability
        Student02.displayInformation();
        System.out.println(" "); // Space for Readability

        Student03.displayInformation();
        System.out.println("DROPS: ");
        Student03.drop(Course03);
        System.out.println(" "); // Space for Readability
        Student02.displayInformation();
        System.out.println(" "); // Space for Readability

        // ENROLLMENT REPORT FLCC
        FLCC.displayEnrollmentReport();
    }
}
