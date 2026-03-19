package Classes;
import Classes.Person.Academic.AP_Professor;
import Classes.Person.Academic.AP_Student;

// Creation Date: February 28, 2026. at 10:54 AM
// Last Modified: March 18, 2026. at  9:00 PM

public class Course {
    //=======VARIABLES=======//
    private String CourseName;
    private String CourseCode;
    private int Credits;
    private AP_Professor Instructor;
    private int MaximumStudents;
    private AP_Student[] EnrolledCourseStudent;
    private int StudentCount;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Course(String CourseName, String CourseCode, int Credits, int MaximumStudents) {
        this.CourseName = CourseName;
        this.CourseCode = CourseCode;
        this.Credits = Credits;
        this.MaximumStudents = MaximumStudents;
        this.EnrolledCourseStudent = new AP_Student[MaximumStudents];
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public int getMaximumStudents() {
        return MaximumStudents;
    }
    public int getTotalStudents() {
        return StudentCount;
    }
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
        Instructor.teach(this);
    }
    public void setInstructor(AP_Professor Instructor) {
        this.Instructor = Instructor;
    }
    public void addStudents(AP_Student Student) {
        EnrolledCourseStudent[StudentCount] = Student;
        StudentCount++;
        Student.addCourse(this);
    }
    public void removeStudent(AP_Student Student) {
        boolean hasStudent = false;
        // REMOVING THE STUDENT
        for (int i = 0; i < StudentCount; i++) {
            if (EnrolledCourseStudent[i] == Student) {
                StudentCount--;
                hasStudent = true;
                for (int j = i; j < StudentCount; j++) {
                    if (j != EnrolledCourseStudent.length-1) {
                        EnrolledCourseStudent[j] = EnrolledCourseStudent[j+1];
                    }
                }
                EnrolledCourseStudent[StudentCount] = null; // clean last slot
                System.out.println(Student.getName()+" has been removed from "+CourseName);
            }
        }
        // NOTIFIES IF STUDENT IS NOT ENROLLED IN THAT COURSE
        if (!hasStudent) {
            System.out.println(Student.getName()+" is not enrolled in "+CourseName);
            return; // Stops the method here
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInformation() {
        System.out.println("Course Name: "+CourseName);
        System.out.println("Course Code: "+CourseCode);
        System.out.println("Course Credits: "+Credits);
        if (Instructor != null) {System.out.println("Course AP_Professor: "+Instructor.getName());} else {System.out.println("Course AP_Professor: N/A");}
    }
    public void displayStudents() {
        for (int i = 0; i < StudentCount; i++) {
            System.out.println("- "+EnrolledCourseStudent[i].getName());
        }
    }
}
