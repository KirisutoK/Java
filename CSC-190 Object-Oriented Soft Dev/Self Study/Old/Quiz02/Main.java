public class Main {
    public static void main(String[]args) {
        Student student1 = new Student("Christ", 65, "177013");

        // setGrade(),
        
        student1.setGrade(150);
        System.out.println();

        student1.displayStudentInfo();
        System.out.println();

        student1.setGrade(0);
        System.out.println();

        student1.displayStudentInfo();
        System.out.println();

        student1.setGrade(85);
        System.out.println();

        student1.displayStudentInfo();
        System.out.println();

        student1.setGrade(30);
        System.out.println();

        student1.displayStudentInfo();
    }
}