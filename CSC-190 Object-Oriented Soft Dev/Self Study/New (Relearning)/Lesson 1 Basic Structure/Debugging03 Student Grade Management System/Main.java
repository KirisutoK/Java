public class Main {
    public static void main(String[] args) {
        Classroom classroom = new Classroom("Math 101", 5);

        Student student1 = new Student("Alice", 1001);
        Student student2 = new Student("Bob", 1002);
        Student student3 = new Student("Charlie", 1003);

        classroom.addStudent(student1);
        classroom.addStudent(student2);
        classroom.addStudent(student3);

        student1.addGrade(85.5);
        student1.addGrade(90.0);
        student1.addGrade(88.5);

        student2.addGrade(78.0);
        student2.addGrade(82.5);

        student3.addGrade(92.0);
        student3.addGrade(95.5);
        student3.addGrade(89.0);
        student3.addGrade(91.5);

        classroom.displayAllStudents();

        System.out.println("\nClassroom Average: " + classroom.calculateClassroomAverage());
    }
}