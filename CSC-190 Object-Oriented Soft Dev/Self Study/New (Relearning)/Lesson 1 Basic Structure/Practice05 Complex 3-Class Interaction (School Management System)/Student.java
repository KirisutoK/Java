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
        for (int i = 0; i < CourseCount; i++) { // Checks on all the enrolled courses in the array (not all the array values inside)
            if (EnrolledCourse[i].equals(course)) { // Checks if the enrolled course is the same as the course that needs to be enrolled
                System.out.println("You are already enrolled in this course.");
                return; // this stops the iteration and moves in into the next code
            }
        }

        if (CourseCount >= EnrolledCourse.length) { // Checks if it exceeds the maximum amount of classes a student can take.
            System.out.println("You have reached the maximum amount of courses you can take.");
        } else if (course.isItFull() == true) { // Checks if the courses is full.
            System.out.println("Course is full.");
        } else {
            EnrolledCourse[CourseCount] = course; // Course Count is what is the available open position in the array, course is the value that is going to put in so basically EnrolledCourse[position] = value
            CourseCount++;
            course.enrollStudent(this.StudentName);
        }
    }

    public void dropCourse(Course course) {
        // Removes the value inside the array
        // Decrease CourseCount
        // active dropStudent method


        for (int i = 0; i < CourseCount; i++) { // for every CourseCount
            if (EnrolledCourse[i].equals(course)) { // Checks if the courses matches the courses inside the arra




                course.dropStudent(this.StudentName); // Drops the course
                CourseCount--;
            }
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}