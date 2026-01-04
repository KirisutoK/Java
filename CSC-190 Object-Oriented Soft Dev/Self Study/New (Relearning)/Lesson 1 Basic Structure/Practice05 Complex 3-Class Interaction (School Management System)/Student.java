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
        for (int i = 0; i < CourseCount; i++) { // Checks from 0 to how many course count
            if (EnrolledCourse[i].equals(course)) { // Checks if the enrolled course is the same as the course that needs to be enrolled
                System.out.println(StudentName + " is already enrolled in " + course.getCourseName());
                return; // this stops the iteration and moves in into the next code
            }
        }

        if (CourseCount >= EnrolledCourse.length) { // Checks if it exceeds the maximum amount of classes a student can take.
            System.out.println(StudentName + " has reached the maximum amount of courses enrolled");
        } else if (course.isItFull() == true) { // Checks if the courses is full.
            System.out.println(course.getCourseName() + " Course is full.");
        } else {
            EnrolledCourse[CourseCount] = course; // Course Count is what is the available open position in the array, course is the value that is going to put in so basically EnrolledCourse[position] = value
            CourseCount++;
            course.enrollStudent(this.StudentName);
        }
    }

    public void dropCourse(Course course) {
        int Position = -1;

        for (int i = 0; i < CourseCount; i++) { // FIND POSITION OF THE COURSE
            if (course.equals(EnrolledCourse[i])) { // if the value of course is equal to the value inside EnrolledCourse then do this
                Position = i;
                break; // so that when it is found, the code breaks (To make the thing go faster)
            }
        }

        if (Position != -1) { // If they are not equal
            for (int i = Position; i < CourseCount; i++) { // Position - Course Count
                if (i != CourseCount-1) { // if they not equal then do this
                    EnrolledCourse[i] = EnrolledCourse[i + 1];
                } else { // if i equal to CourseCount then do this
                    EnrolledCourse[i] = null;
                }
            }
            CourseCount--;
            System.out.println(StudentName + " have successfully dropped " + course.getCourseName());
        } else { // if it's still the same then do this
            System.out.println(StudentName + " is not enrolled in " + course.getCourseName());
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void DisplayStudentInformation() {
        System.out.println("Student Name: " + StudentName);
        System.out.println("Student ID: " + StudentID);
        System.out.print("Courses Enrolled: " );
        for (int i = 0; i < CourseCount; i++) {
            System.out.print(EnrolledCourse[i].getCourseName());
            System.out.print(" ");
        }
        System.out.println(" "); // Space for readability
    }
}