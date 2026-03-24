public class Contractor extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public Contractor(String name, int employeeId, double hourlyRate, int hoursWorked) { // Wrong way of assigning variables
        super(name, employeeId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double calculateMonthlySalary() {
        return hourlyRate * hoursWorked;
    }

    @Override // ADDED
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
    }
}