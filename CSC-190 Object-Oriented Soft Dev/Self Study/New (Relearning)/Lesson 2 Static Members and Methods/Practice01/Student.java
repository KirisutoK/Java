public class Student {
    //=======VARIABLES=======//
    private String Name;
    private int StudentID;
    private static int TotalStudents;
    private static int NextID = 1000;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Student(String Name) {
        this.Name = Name;
        StudentID += NextID;
        NextID += 1000;
        TotalStudents++;
        System.out.println("Student Created");
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getName() {
        return Name;
    }
    public int getStudentID() {
        return StudentID;
    }
    public static int getTotalStudents() {
        return TotalStudents;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public static void resetCounter() {
        TotalStudents = 0;
        NextID = 1000;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInfo() {
        System.out.println("Name: " + Name);
        System.out.println("Student ID: " + StudentID);
    }
}
