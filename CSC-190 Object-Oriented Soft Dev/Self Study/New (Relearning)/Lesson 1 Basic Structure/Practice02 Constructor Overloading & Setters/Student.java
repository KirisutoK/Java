public class Student {
    private String Name = "";
    private int StudentID = 0;
    private double GPA = 0.0;
    private String Major = "";

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Student(String name, int studentid, double gpa, String major) { //A CONSTRUCTOR THAT TAKES ALL 4 PARAMETERS
        this.Name = name;
        this.StudentID = studentid;
        this.GPA = gpa;
        this.Major = major;
    }

    public Student(String name, int studentid) { // A CONSTRUCTUR THAT ONLY TAKES THE NAME AND STUDENTID
        this.Name = name;
        this.StudentID = studentid;
    }

    public Student(String name, int studentid, String major) { // A CONSTRUCTUR THAT DOES NOT TAKE THE MAJOR PARAMETER
        this.Name = name;
        this.StudentID = studentid;
        this.Major = major;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getName() {
        return Name;
    }
    public int getStudentID() {
        return StudentID;
    }
    public double getGPA() {
        return GPA;
    }
    public String getMajor() {
        return Major;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public String setName(String name) {
        return Name = name;
    }
    public int setStudentID(int studentid) {
        return StudentID = studentid;
    }
    public double setGPA(double gpa) {
        return GPA = gpa;
    }
    public String setMajor(String major) {
        return Major = major;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void DisplayInfo() { 
        System.out.println("Name: " + Name);
        System.out.println("Student ID: " + Name);
        System.out.println("GPA: " + Name);
        System.out.println("Major: " + Name);
    }
    
}
