// Creation Date: March 09, 2026. at 1:18 PM
// Last Modified: March 20, 2026. at 10:22 PM

import Classes.Person.Academic.AP_Professor;
import Classes.Person.Academic.AP_Student;
import Classes.Person.Academic.S_TeachingAssistant;
import Classes.Person.Person;
import Classes.Course;
import Interfaces.Payable;

public class University {
    //=======VARIABLES=======//
    private String UniversityName;
    private Person[] People = new Person[20];
    private int PeopleCount;
    private Course[] Courses = new Course[10];
    private int CourseCount;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public University(String UniversityName) {
        this.UniversityName = UniversityName;
    }


    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getUniversityName() {
        return UniversityName;
    }
    public Course[] getCourses() {
        return Courses;
    }
    public double calculateTotalPayroll() {
        double total = 0;
        for (Person i:People) {
            if (i instanceof Payable) {
                total += ((Payable)i).calculateSalary();
            }
        }
        return total;
    }
    public Person[] getPeople() {
        return People;
    }
    public AP_Student[] getAllStudents() {
        // COUNT HOW MANY STUDENTS
        int StudentCount = 0;
        for (int i = 0; i < PeopleCount; i++) {
            if (People[i] instanceof AP_Student) { // if the value[index] is AP_Student
                StudentCount++;
            }
        }

        // CREATING A STUDENT ARRAY
        AP_Student[] TempStudents = new AP_Student[StudentCount];

        // ADDING STUDENTS INSIDE STUDENT ARRAY [UNFINISHED]
        int tempCount = 0;
        for (int i = 0; i < PeopleCount; i++) {
            if (People[i] instanceof AP_Student) {
                TempStudents[tempCount] = (AP_Student)People[i]; // DOWNCASTING
                tempCount++;
            }
        }

        return TempStudents;
    }
    public int getStudentsCount() {
        int StudentCount = 0;
        for (int i = 0; i < PeopleCount; i++) {
            if (People[i] instanceof AP_Student) {
                StudentCount++;
            }
        }
        return StudentCount;
    }
    public AP_Professor[] getAllProfessors() {
        // COUNT HOW MANY STUDENTS
        int ProfessorCount = 0;
        for (int i = 0; i < PeopleCount; i++) {
            if (People[i] instanceof AP_Professor) {
                ProfessorCount++;
            }
        }

        // CREATING A STUDENT ARRAY
        AP_Professor[] TempStudents = new AP_Professor[ProfessorCount];

        // ADDING STUDENTS INSIDE STUDENT ARRAY [UNFINISHED]
        int tempCount = 0;
        for (int i = 0; i < PeopleCount; i++) {
            if (People[i] instanceof AP_Professor) {
                TempStudents[tempCount] = (AP_Professor) People[i]; // DOWNCASTING
                tempCount++;
            }
        }

        return TempStudents;
    }
    public S_TeachingAssistant[] getAllTeachingAssistant() {
        AP_Student[] tempArray = getAllStudents();

        // COUNT HOW MANY STUDENTS
        int TeachingAssistantCount = 0;
        for (int i = 0; i < tempArray.length; i++) {
            if (tempArray[i] instanceof S_TeachingAssistant) {
                TeachingAssistantCount++;
            }
        }

        // CREATING A STUDENT ARRAY
        S_TeachingAssistant[] TempTeachingAssistant = new S_TeachingAssistant[TeachingAssistantCount];

        // ADDING STUDENTS INSIDE STUDENT ARRAY [UNFINISHED]
        int tempCount = 0;
        for (int i = 0; i < tempArray.length; i++) {
            if (tempArray[i] instanceof S_TeachingAssistant) {
                TempTeachingAssistant[tempCount] = (S_TeachingAssistant) tempArray[i]; // DOWNCASTING
                tempCount++;
            }
        }

        return TempTeachingAssistant;
    }
    

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void addPerson(Person person) {
        // LIMIT NOTIFICATION
        if (PeopleCount == People.length) {
            System.out.println("There are no more open slots for "+UniversityName);
            return; // Stops the method here.
        }
        // DUPLICATION NOTIFICATION
        for (Person i: People) {
            if (i == person) {
                System.out.println(person.getName()+" is already enrolled at "+UniversityName);
                return; // Stops the method here.
            }
        }
        // ADDING COURSE INTO THE ARRAY
        People[PeopleCount] = person;
        PeopleCount++;
        System.out.println(person.getName()+" is successfully enrolled at "+UniversityName);
    }
    public void addCourse(Course course) {
        // LIMIT NOTIFICATION
        if (CourseCount == Courses.length) {
            System.out.println(UniversityName+" Has reached the maximum amount of courses they can have");
            return; // Stops the method here.
        }
        // DUPLICATION NOTIFICATION
        for (Course i: Courses) {
            if (i == course) {
                System.out.println(course.getCourseName()+" is already added in "+UniversityName);
                return; // Stops the method here.
            }
        }
        // ADDING COURSE INTO THE ARRAY
        Courses[CourseCount] = course;
        CourseCount++;
        System.out.println(UniversityName+" has successfully added a new course: "+course.getCourseName()+" ("+course.getCourseCode()+") "+"["+course.getCredits()+" Credits]");
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    public void displayAllPeople() {
        System.out.println("============ ALL PEOPLE ============");
        for (Person i:People) {
            if (i != null) { // if the position is not empty
                i.displayInformation();
                System.out.println(" "); // Space for Readability
            }
        }
    }
    public void displayAllCourses() {
        System.out.println("============ ALL COURSES ============");
        for (Course i:Courses) {
            if (i != null) { // if the position is not empty
                i.displayInformation();
                System.out.println(" "); // Space for Readability
            }
        }
    }
    public void displayEnrollmentReport() {
        System.out.println("============ ENROLLMENT REPORT ============");
        for (int i = 0; i < CourseCount; i++) {
            System.out.println("Course: "+Courses[i].getCourseName()+" ("+Courses[i].getCourseCode()+") ["+Courses[i].getCredits()+" Credits]");
            if (Courses[i].getInstructor() != null) {System.out.println("Instructor : "+Courses[i].getInstructor().getName());} else {System.out.println("Instructor : N/A");}
            System.out.println("Enrolled Student: "+Courses[i].getTotalStudents());
            Courses[i].displayStudents();
            System.out.println(" "); // Space for readability
        }
    }
   
}
