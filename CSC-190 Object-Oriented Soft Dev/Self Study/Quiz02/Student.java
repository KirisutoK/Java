public class Student {
    private String name;
    private int grade;
    private String studentId;

    public Student(String n, int g, String studentid) {
        this.name = n;
        this.studentId = studentid;
        setGrade(g);
    }
    //==================RETURNS=============\\
    public String getName() { 
        return name;
    }
    public int getGrades() {
        return grade;
    }
    public String getStudentId() {
        return studentId;
    }
    public boolean isPassing() {
        return grade > 60;
    }
    //==================VOID================\\
    public void setGrade(int g) {
        if (g >= 0 && g <= 100) { // if its not 0-100
            grade = g;
        } else {
            System.out.println("ERROR! Index out of bounds");
        }
    }

    public void displayStudentInfo() {
        System.out.println("Student: " + name);
        System.out.println("Student ID: " + studentId);
        System.out.println("Grade: " + grade);
        System.out.println("Passed: " + isPassing());
    }
}
