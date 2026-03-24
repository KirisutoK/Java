public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Jonathan", 001, 4.5, "Hamon"); //Name, StudentID, GPA, Major
        Student student2 = new Student("Jotaro", 002); //Name, StudentID   
        Student student3 = new Student("Polnaref", 003, "Fencing"); //Name, StudentID, Major

        System.out.println("===STUDENTS INFORMATION===");
        student1.DisplayInfo();
        System.out.println(" "); // creates a new space for readability
        student2.DisplayInfo();
        System.out.println(" "); // creates a new space for readability
        student3.DisplayInfo();
        System.out.println(" ");
        System.out.println("UPDATING INFORMATION...");
        System.out.println(".."); // creates a new space for readability
        System.out.println("."); // creates a new space for readability

        student2.setGPA(5.0);
        student2.setMajor("AuraFarming");
        student3.setGPA(3.6);

        System.out.println("===STUDENTS INFORMATION===");
        student1.DisplayInfo();
        System.out.println(" "); // creates a new space for readability
        student2.DisplayInfo();
        System.out.println(" "); // creates a new space for readability
        student3.DisplayInfo();
        System.out.println(" ");
    }
}
