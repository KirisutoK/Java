public class Main {
    public static void main(String[] args) {

        // CREATING A SCHOOL
        School FLCC = new School("FLCC");

        // CREATING A COURSE
        Course Math = new Course("Math", "MAT-100", "Mclauglin", 12);
        Course English = new Course("English", "ENG-100", "Mary", 12);
        Course Java = new Course("Java", "CIS-100", "Paige Labar", 12);

        // CREATING A STUDENT
        Student Christ = new Student("Christ", 1);
        Student Shan = new Student("Shan", 2);
        Student Carl = new Student("Carl", 3);
        Student Sophia = new Student("Sophia", 4);

        // METHODS

        // -> Adding courses in to a school
        FLCC.addCourse(Math);
        FLCC.addCourse(English);
        FLCC.addCourse(Java);
        System.out.println(" "); // Space for readability
        FLCC.displayAllCourses();
        System.out.println(" "); // Space for readability
        FLCC.displayAllCoursesInformation();
        System.out.println(" "); // Space for readability

        // -> adding students in toa school
        FLCC.addStudent(Christ);
        FLCC.addStudent(Shan);
        FLCC.addStudent(Carl);
        FLCC.addStudent(Sophia);
        System.out.println(" "); // Space for readability
        FLCC.displayAllStudents();
        System.out.println(" "); // Space for readability

        // -> enrolling students into a course
        Christ.enrollInCourse(Math);
        Christ.enrollInCourse(English);
        Christ.enrollInCourse(Java);
        System.out.println(" "); // Space for readability
        Christ.DisplayStudentInformation();
        System.out.println(" "); // Space for readability
        Shan.enrollInCourse(Math);
        Sophia.enrollInCourse(English);
        Carl.enrollInCourse(Java);
        System.out.println(" "); // Space for readability
        Shan.enrollInCourse(Math);
        Christ.enrollInCourse(English);
        Sophia.enrollInCourse(Java);
        System.out.println(" "); // Space for readability

        // -> dropping students into a course
        Christ.dropCourse(English);
        Sophia.dropCourse(Math);

        // -> Display all
        System.out.println(" "); // Space for readability
        FLCC.displayAllStudentsInformation();
        System.out.println(" "); // Space for readability
        FLCC.displayAllCoursesInformation();
    }
}