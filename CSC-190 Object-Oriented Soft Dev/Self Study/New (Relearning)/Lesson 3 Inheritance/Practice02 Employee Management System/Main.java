public class Main {
    public static void main(String[] args) {
        // CREATING INSTANCES or OBJECTS
        Manager Manager01 = new Manager("Lisa", 1000, 80000, 20000, 5);
        Developer Developer01 = new Developer("Christ", 1001, 70000, "Java", 10000);
        Developer Developer02 = new Developer("Benny", 1002, 75000, "Python", 15000);
        Intern Intern01 = new Intern("Shan", 1004, 30000, "MIT", Developer01);
        System.out.println(" "); // Space for Readability

        // DISPLAY INFO
        Manager01.DisplayInfo();
        System.out.println(" "); // Space for Readability
        Developer01.DisplayInfo();
        System.out.println(" "); // Space for Readability
        Developer02.DisplayInfo();
        System.out.println(" "); // Space for Readability
        Intern01.DisplayInfo();
        System.out.println(" "); // Space for Readability

        // WORK
        Manager01.Work();
        System.out.println(" "); // Space for Readability
        Developer01.Work();
        System.out.println(" "); // Space for Readability
        Developer02.Work();
        System.out.println(" "); // Space for Readability
        Intern01.Work();
        System.out.println(" "); // Space for Readability

        // SPECIFIC METHODS
        Developer01.deployProject();
        Developer02.deployProject();
        Intern01.attendTraining();
        System.out.println(" "); // Space for Readability

        // CALCULATE SALARY
        double TotalCompanyExpenses = Manager01.calculateSalary() + Developer01.calculateSalary() + Developer02.calculateSalary() + Intern01.calculateSalary(); // Sum of all the employee's salary
        System.out.println("Total Company Expenses: " + TotalCompanyExpenses);
    }
}
