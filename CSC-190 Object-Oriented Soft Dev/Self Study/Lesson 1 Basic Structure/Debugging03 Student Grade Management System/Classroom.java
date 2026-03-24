public class Classroom {
    private String className;
    private Student[] students;
    private int studentCount;
    private int maxStudents;

    public Classroom(String className, int maxStudents) {
        this.className = className;
        this.maxStudents = maxStudents;
        students = new Student[maxStudents];
        studentCount = 0;
    }

    public void addStudent(Student student) {
        if (studentCount >= maxStudents) {
            System.out.println("Classroom is full!");
            return;
        }

        students[studentCount] = student;
        studentCount++;
        System.out.println(student.getName() + " added to " + className);
    }

    public Student findStudent(int studentId) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == studentId) {
                return students[i];
            }
        }
        return null;
    }

    public double calculateClassroomAverage() {
        if (studentCount == 0) {
            return 0.0;
        }

        double totalAverage = 0;
        for (int i = 0; i < studentCount; i++) {
            totalAverage += students[i].calculateAverage();
        }

        return totalAverage / studentCount;
    }

    public void displayAllStudents() {
        System.out.println("=== " + className + " ===");
        for (int i = 0; i < studentCount; i++) {
            students[i].displayInfo();
            System.out.println();
        }
    }
}