public class School {
    //=======VARIABLES=======//
    private String SchoolName;
    private Student[] Students = new Student[10];
    private int StudentCount;
    private Course[] Courses = new Course[10];
    private int CourseCount;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public School(String SchoolName) {
        this.SchoolName = SchoolName;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public int getStudentCount() {
        return StudentCount;
    }
    public int getCourseCount() {
        return CourseCount;
    }
    public Student[] getStudents() {
        return Students;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    public void addStudent(Student student) { // Adds a Student into Students Array
        boolean isEnrolled = false;

        //Check if the student is already in the Students[]
        for (int i = 0; i < StudentCount; i++) { // checks from 0 too how many StudentCount has
            if (Students[i].equals(student)) { // Checks if the student is already in the array
                isEnrolled = true;
                System.out.println(student.getStudentName() + " is already enrolled at " + SchoolName);
                break; // To stop the iteration when if function is triggered to stop unnecessary memory usage
            }
        }

        //Triggers if it is not in the Students[]
        if (!isEnrolled) { // if it is not (false) then do this
            if (StudentCount < Students.length) { // Student Array is 10 so StudentCOunt can only reach to 9
                Students[StudentCount] = student;
                StudentCount++;
                System.out.println(student.getStudentName() + " Has successfully enrolled at " + SchoolName);
            } else {
                System.out.println(SchoolName + " is currently full!");
            }
        }
    }

    public void addCourse(Course course) {
        boolean isPartofCourses = false;

        // Checks if the course is already in the Courses
        for (int i = 0; i < CourseCount; i++) {
            if (Courses[i].equals(course)) {
                isPartofCourses = true;
                System.out.println(course.getCourseName() + " has already been added in to " + SchoolName + " courses.");
                break;
            }
        }

        // Adds the course if it is not in the Courses
        if (!isPartofCourses) {
            // Checks if the amount of courses had reach the maximum values inside Courses array
            if (CourseCount < Courses.length) { // If CourseCount is less than the amount of Courses.length which is 9 (Originally is 10 but readed from 0-9)
                Courses[CourseCount] = course;
                CourseCount++;
                System.out.println(course.getCourseName() + " has successfully been added into " + SchoolName +" courses.");
            } else {
                System.out.println("There are no more available slots for courses");
            }
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    public Student findStudent(int StudentID) {
        Student getStudent = null;

        // Find if student matches
        for (int i = 0; i < StudentCount; i++) { // Iterates the whole Students Array
            if (Students[i].getStudentID() == (StudentID)) {
                getStudent = Students[i];
                break; // to stop iterating once if functions triggers
            }
        }

        return getStudent;
    }

    public Course findCourse(String courseCode) {
        Course getCourse = null;

        for (int i = 0; i < CourseCount; i++) {
            if (Courses[i].getCourseCode().equals(courseCode)) {
                getCourse = Courses[i];
                break;
            }
        }

        return getCourse;
    }

    public void displayAllStudents() {
        System.out.print(SchoolName + " Students: ");

        for (int i = 0; i < StudentCount; i++) {
            System.out.print(Students[i].getStudentName() + " |");
        }
    }

    public void displayAllCourses() {
        System.out.print(SchoolName + " Courses: ");

        for (int i = 0; i < CourseCount; i++) {
            System.out.print(Courses[i].getCourseName() + " |");
        }
    }

    public void displayAllStudentsInformation() {
        for (int i = 0; i < StudentCount; i++) {
            Students[i].DisplayStudentInformation();
            System.out.println(" "); // Space for readability
        }
    }

    public void displayAllCoursesInformation() {
        for (int i = 0; i < CourseCount; i++) {
            Courses[i].DispalyCourseInformation();
            System.out.println(" "); // Space for readability
        }
    }
}