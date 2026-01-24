public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursPerMonth;

    public PartTimeEmployee(String name, int employeeId, double hourlyRate, int hoursPerMonth) {
        super(name, employeeId);
        this.hourlyRate = hourlyRate;
        this.hoursPerMonth = hoursPerMonth;
    }

    @Override // ADDED
    public double calculateMonthlySalary() {
        return hourlyRate * hoursPerMonth; // Changed from + (Addition) to * (Multiplication)
    }

    @Override // ADDED
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Hours/Month: " + hoursPerMonth);
    }
}