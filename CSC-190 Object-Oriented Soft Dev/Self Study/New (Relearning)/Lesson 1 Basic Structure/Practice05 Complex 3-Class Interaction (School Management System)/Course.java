public class Course {
    //=======VARIABLES=======//
    private String CourseName;
    private String CourseCode;
    private String Professor;
    private int MaxStudents;
    private int EnrolledStudents = 0;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Course(String CourseName, String CourseCode, String Professor, int MaxStudents) {
        this.CourseName = CourseName; // this. tells the code that it is telling the private variables above, not the parameter.
        this.CourseCode = CourseCode; // this. tells the code that it is telling the private variables above, not the parameter.
        this.Professor = Professor; // this. tells the code that it is telling the private variables above, not the parameter.
        this.MaxStudents = MaxStudents; // this. tells the code that it is telling the private variables above, not the parameter.
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getCourseName() {
        return CourseName;
    }
    public String getCourseCode() {
        return CourseCode;
    }
    public String getProfessor() {
        return Professor;
    }
    public int getMaxStudents() {
        return MaxStudents;
    }
    public int getEnrolledStudents() {
        return EnrolledStudents;
    }
    public boolean isItFull() { // Checks if the course is full
        if (EnrolledStudents >= MaxStudents) {
            return true;
        } else {
            return false;
        }
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void enrollStudent(String studentname) { // To Enroll a Students
        if (EnrolledStudents >= MaxStudents) {
            System.out.println("Course is Full!");
        } else {
            EnrolledStudents += 1;
            System.out.println(studentname + " has successfully enrolled the course.");
        }
    }
    public void dropStudent(String studentname) { // To Drop a Student
        if (EnrolledStudents <= 0) {
            System.out.println("There are no students in the course.");
        } else {
            EnrolledStudents -= 1;
            System.out.println(studentname + " has successfully dropped the course.");
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void DispalyCourseInformation() {
        System.out.println("Course: " + CourseName);
        System.out.println("Course Code: " + CourseCode);
        System.out.println("Professor: " + Professor);
        System.out.println("Course: " + CourseName);
        System.out.println("Max Students: " + MaxStudents);
        System.out.println("Enrolled Students: " + EnrolledStudents);
    }

}