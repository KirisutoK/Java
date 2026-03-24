public class FullTimeEmployee extends Employee {
    private double annualSalary;

    public FullTimeEmployee(String name, int employeeId, double annualSalary) {
        super(name, employeeId);
        this.annualSalary = annualSalary;
    }

    @Override // ADDED
    public double calculateMonthlySalary() {
        return annualSalary / 12;
    }

    public void giveRaise(double percent) {
        annualSalary = annualSalary * (1 + percent);
        System.out.println(name + " received a " + percent + "% raise");
    }

    @Override // ADDED
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Annual Salary: $" + annualSalary);
    }
}