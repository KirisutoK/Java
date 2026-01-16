public class Main {
    public static void main(String[] args) {
        // CREATING OBJECTS or INSTANCES
        Professor Professor01 = new Professor("Paige Labar", 26, "P100", "CompSci Department", 5, 120000);
        Professor Professor02 = new Professor("Will Mclaughlin", 34, "P101", "Finance Department", 3, 90000);
        GraduateStudent GradStudent01 = new GraduateStudent("Michael", 24, "S102", 6, 3.8, "AI Jobs", Professor01);
        Student Student01 = new Student("Christ", 19, "S100", 1, 4.0);
        Student Student02 = new Student("Kevin", 26, "S101", 1, 4.0);
        Administrator Admin01 = new Administrator("Jonathan Mundy", 27, "A100", "Staff", "ON100");

        // INTRODUCE METHOD
        System.out.println("=== INTRODUCE METHOD ===");
        Professor01.Introduce();
        System.out.println(" "); // Space for Readability
        Professor02.Introduce();
        System.out.println(" "); // Space for Readability
        GradStudent01.Introduce();
        System.out.println(" "); // Space for Readability
        Student01.Introduce();
        System.out.println(" "); // Space for Readability
        Student02.Introduce();
        System.out.println(" "); // Space for Readability
        Admin01.Introduce();
        System.out.println(" "); // Space for Readability


        // DISPLAY INFORMATION METHOD
        System.out.println("=== DISPLAY INFORMATION METHOD ===");
        Professor01.DisplayInfo();
        System.out.println(" "); // Space for Readability
        Professor02.DisplayInfo();
        System.out.println(" "); // Space for Readability
        GradStudent01.DisplayInfo();
        System.out.println(" "); // Space for Readability
        Student01.DisplayInfo();
        System.out.println(" "); // Space for Readability
        Student02.DisplayInfo();
        System.out.println(" "); // Space for Readability
        Admin01.DisplayInfo();
        System.out.println(" "); // Space for Readability

        // COUNTERS
        System.out.println("=== COUNTERS ===");
        System.out.println("Total People: " + Person.TotalPeople);
        System.out.println("Total Students: " + Student.TotalStudents);
        System.out.println("Total Graduate Students: " + GraduateStudent.getTotalGraduateStudents());
        System.out.println("Total Professors: " + Professor.getTotalProfessors());
        System.out.println("Total Admins: " + Administrator.getTotalAdmins());
        System.out.println(" "); // Space for Readability

        // PRIVATE METHODS (CLASSES METHODS)
        System.out.println("=== PRIVATE METHODS (CLASSES METHODS) ===");
        GradStudent01.DefendThesis();
        Professor01.adviseMenTee(GradStudent01);
        System.out.println(Professor01.Name + " has tenure: " + Professor01.hasTenure());
        System.out.println(Professor02.Name + " has tenure: " + Professor02.hasTenure());
        System.out.println(" "); // Space for Readability

        // ADULT METHOD
        System.out.println("=== ADULT METHOD ===");
        System.out.println(Professor01.Name + " is an adult: " + Professor01.isAdult());
        System.out.println(Professor01.Name + " is an adult: " + Professor01.isAdult());
        System.out.println(GradStudent01.Name + " is an adult: " + GradStudent01.isAdult());
        System.out.println(Student01.Name + " is an adult: " + Student01.isAdult());
        System.out.println(Student02.Name + " is an adult: " + Student02.isAdult());
        System.out.println(Admin01.Name + " is an adult: " + Admin01.isAdult());
        System.out.println(" "); // Space for readability

        // PRIVATE METHODS (CLASSES METHODS)
        System.out.println("=== PRIVATE METHODS (CLASSES METHODS) ===");
        Student01.Study();
        Student02.Study();
        GradStudent01.Study();
        Professor01.Teach();
        Professor02.Teach();
        Admin01.handleAdminWork();





    }
}
