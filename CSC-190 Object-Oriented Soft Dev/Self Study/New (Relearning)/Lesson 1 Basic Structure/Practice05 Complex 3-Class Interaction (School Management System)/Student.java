public class Student {
    //=======VARIABLES=======//
    private String StudentName;
    private int StudentID;
    private Course[] EnrolledCourse = new Course[5]; // A students enrolled course limit is 5
    private int CourseCount; // Counts how many courses has a student enrolled in to

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Student(String StudentName, int StudentID) {
        this.StudentName = StudentName;
        this.StudentID = StudentID;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getStudentName() {
        return StudentName;
    }
    public int getStudentID() {
        return StudentID;
    }
    public int getCourseCount() {
        return CourseCount;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void enrollInCourse(Course course) {
        // Add iteration to check if course is in the EnrolledCourse[]


        if (CourseCount >= EnrolledCourse.length) {
            System.out.println("You have reached the maximum amount of courses you can take.");
        } else if (course.isItFull() == true) {
            System.out.println("Course is full.");
        } else {

        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}