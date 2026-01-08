public class Student {
    private String name;
    private int studentId;
    private double[] grades;
    private int gradeCount;

    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
        grades = new double[10];
        gradeCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void addGrade(double grade) {
        if (gradeCount < grades.length) {
            grades[gradeCount] = grade;
            gradeCount++;
            System.out.println("Added grade " + grade + " for " + name);
        } else {
            System.out.println("Cannot add more grades for " + name);
        }
    }

    public double calculateAverage() {
        if (gradeCount == 0) {
            return 0.0;
        }

        double sum = 0;
        for (int i = 0; i < gradeCount; i++) {
            sum += grades[i];
        }

        return sum / gradeCount;
    }

    public void displayInfo() {
        System.out.println("Student: " + name + " (ID: " + studentId + ")");
        System.out.print("Grades: ");

        for (int i = 0; i < gradeCount; i++) {
            System.out.print(grades[i] + " ");
        }

        System.out.println("\nAverage: " + calculateAverage());
    }
}