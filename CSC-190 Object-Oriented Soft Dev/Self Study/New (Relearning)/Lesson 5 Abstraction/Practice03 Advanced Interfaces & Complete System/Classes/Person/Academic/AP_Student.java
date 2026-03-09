package Classes.Person.Academic;
import Classes.Course;
import Interfaces.Enrollable;
import Interfaces.Gradable;

// Creation Date: February 28, 2026. at 10:37 AM
// Last Modified: March 09, 2026. at  1:01 PM

public class AP_Student
        extends AcademicPerson
        implements Enrollable, Gradable { 
    //=======VARIABLES=======//
    private Course[] EnrolledCourses = new Course[6];
    private double[] Grades = new double[6];
    private int AssistCount;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public AP_Student(String Name, String ID, int Age, String Department) {
        super(Name, ID, Age, Department);
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    // --- @OVERRIDE
    // ENROLLABLE <==== [INTERFACE]
    @Override public int getEnrolledCount() {
        return AssistCount;
    }
    // GRADEABLE <==== [INTERFACE]
    @Override public double getGPA() {
        double temp = 0;
        for (int i = 0; i < AssistCount; i++) {
            temp += Grades[i];
        }
        return temp/ AssistCount;
    }

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
    @Override public void enroll(Course course) {
        // LIMIT NOTIFICATION
        if (AssistCount == EnrolledCourses.length) {
            System.out.println(Name+"have reached the limit for registering courses");
            return; // Stops the method here.
        }
        // DUPLICATION NOTIFICATION
        for (Course i:EnrolledCourses) {
            if (i == course) {
                System.out.println(Name+" is already registered on "+i.getCourseName());
                return; // Stops the method here.
            }
        }
        // ADDING COURSE INTO THE ARRAY
        EnrolledCourses[AssistCount] = course;
        AssistCount++;
        System.out.println(Name+" has successfully enrolled in "+course.getCourseName());
    }
    @Override public void drop(Course course) {
        boolean hasCourse = false;
        // REMOVING THE COURSE
        for (int i = 0; i < AssistCount; i++) { // for every CourseCount
            if (EnrolledCourses[i] == course) { // if it matches
                AssistCount--;
                hasCourse = true;
                for (int j = i; j < AssistCount; j++) { // for every CourseCount starting from where the course is found
                    if (j != EnrolledCourses.length-1) { // if the index is NOT in the last position of the array
                        EnrolledCourses[j] = EnrolledCourses[j+1];
                        Grades[j] = Grades[j+1];
                    }
                }
                System.out.println(Name+" has dropped "+course.getCourseName());
            }
        }
        // NOTIFIES IF YOU ARE NOT ENROLLED IN THAT COURSE
        if (!hasCourse) {
            System.out.println(Name+" is not enrolled in "+course.getCourseName());
        }
    }
    // GRADEABLE <==== [INTERFACE]
    @Override public void assignGrade(Course course, double grade) {
        for (int i = 0; i < AssistCount; i++) {
            if (EnrolledCourses[i] == course) { // if it matches
                Grades[i] = grade; // take the matched position and match it with grade
            }
        }
    }
    //  ACADEMIC PERSON <==== [ABSTRACT]

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayCourses() {
        System.out.print(Name+" Enrolled Courses:");
        for (int i = 0; i < AssistCount; i++) {
            System.out.print(" "+EnrolledCourses[i].getCourseName()+" |");
        }
    }
    public void displayGrades() {
        System.out.print(Name+" Enrolled Courses:");
        for (int i = 0; i < AssistCount; i++) {
            System.out.print(" "+Grades[i]+" |");
        }
    }

    // --- @OVERRIDE
    @Override public void displayInformation() {
        super.displayInformation();
        System.out.print("Enrolled Courses:"); for (int i = 0; i < AssistCount; i++) {System.out.print(" "+EnrolledCourses[i].getCourseName()+" |");}
        System.out.print("\nGrades:"); for (int i = 0; i < AssistCount; i++) {System.out.print(" "+Grades[i]+" |");}
        System.out.println("\nGPA: "+getGPA());

    }
}