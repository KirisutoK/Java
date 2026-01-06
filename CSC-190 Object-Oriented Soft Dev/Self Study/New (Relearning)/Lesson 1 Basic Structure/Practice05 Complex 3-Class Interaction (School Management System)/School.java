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

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    public void addStudent(Student student) {
        boolean isEnrolled = false;

        //Check if the student is already in the Students[]
        for (int i = 0; i < StudentCount; i++) { // checks from 0 too how many StudentCount has
            if (Students[i].equals(student)) { // Checks if the student is already in the array
                System.out.println(student.getStudentName() + " is already enrolled at " + SchoolName);
                isEnrolled = true;
                break; // To stop the iteration when if function is triggered to stop unnecessary memory usage
            }
        }

        //Triggers if it is not in the Students[]
        if (isEnrolled == false) {
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
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

}