public class Employee {
    protected String name;
    protected int employeeId;

    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public double calculateMonthlySalary() {
        return 0.0;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + employeeId);
        System.out.println("Monthly Salary: $" + calculateMonthlySalary());
    }
}