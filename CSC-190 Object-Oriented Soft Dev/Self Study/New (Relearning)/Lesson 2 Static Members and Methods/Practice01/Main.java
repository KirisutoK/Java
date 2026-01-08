public class Main {
    public static void main(String[]args) {
        System.out.println(Student.getTotalStudents());

        Student Christ = new Student("Christ");
        Student Shan = new Student("Shan");
        Student Carl = new Student("Carl");
        Student Sophia= new Student("Sophia");
        Student Bella = new Student("Bella");

        System.out.println(Student.getTotalStudents());
        System.out.println(Christ.getStudentID());
        System.out.println(Shan.getStudentID());
        System.out.println(Carl.getStudentID());
        System.out.println(Sophia.getStudentID());
        System.out.println(Bella.getStudentID());

        Student.getTotalStudents();

        Student.resetCounter();

        System.out.println(Student.getTotalStudents());

        Student Micchell = new Student("Micchell");
        Student John = new Student("John");

        System.out.println(Micchell.getStudentID());
        System.out.println(John.getStudentID());
    }
}