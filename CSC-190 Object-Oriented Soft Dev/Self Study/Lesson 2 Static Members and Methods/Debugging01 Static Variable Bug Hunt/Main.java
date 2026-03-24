public class Main {
    public static void main(String[] args) {
        System.out.println("Total employees: " + Employee.getTotalEmployees());

        Employee emp1 = new Employee("Alice", "Engineering");
        Employee emp2 = new Employee("Bob", "Marketing");
        Employee emp3 = new Employee("Charlie", "Sales");

        emp1.displayInfo();
        emp2.displayInfo();
        emp3.displayInfo();

        System.out.println("\nTotal employees: " + Employee.getTotalEmployees());
        System.out.println("Next employee ID will be: " + Employee.getNextId());

        Employee.resetCounters();

        Employee emp4 = new Employee("Diana", "HR");
        emp4.displayInfo();
    }
}