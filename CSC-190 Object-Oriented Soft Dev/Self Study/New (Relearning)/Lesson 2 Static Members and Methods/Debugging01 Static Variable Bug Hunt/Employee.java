public class Employee {
    private String name;
    private String department;
    private int employeeId;
    private static int nextId = 1000;
    private static int totalEmployees = 0;

    static {
        System.out.println("Employee system initialized");
        nextId = 1000;
        totalEmployees = 0;
    }

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
        this.employeeId = nextId;
        nextId++;
        totalEmployees++;
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void resetCounters() {
        nextId = 1000;
        totalEmployees = 0; // This was the bug
    }

    public void displayInfo() {
        System.out.println("Employee: " + name);
        System.out.println("Department: " + department);
        System.out.println("ID: " + employeeId);
        System.out.println("Total in company: " + totalEmployees);
        System.out.println();
    }
}
