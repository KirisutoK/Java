public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new FullTimeEmployee("Alice", 1001, 60000);
        employees[1] = new PartTimeEmployee("Bob", 1002, 20, 150);
        employees[2] = new Contractor("Charlie", 1003, 50, 40);
        employees[3] = new FullTimeEmployee("Diana", 1004, 75000);
        employees[4] = new PartTimeEmployee("Eve", 1005, 25, 100);

        System.out.println("=== All Employees ===");
        displayAllEmployees(employees);

        System.out.println("\n=== Total Monthly Payroll ===");
        System.out.println("$" + calculateTotalPayroll(employees));

        System.out.println("\n=== Full-Time Employees Only ===");
        Employee[] fullTime = filterByType(employees, "FullTimeEmployee");
        displayAllEmployees(fullTime);

        System.out.println("\n=== Highest Paid Employee ===");
        Employee highest = findHighestPaid(employees);
        highest.displayInfo();

        System.out.println("\n=== Give Raises ===");
        giveRaises(employees, 5);
    }

    public static void displayAllEmployees(Employee[] employees) {
        for (Employee e : employees) {
            e.displayInfo();
            System.out.println();
        }
    }

    public static double calculateTotalPayroll(Employee[] employees) {
        double total = 0;
        for (Employee e : employees) {
            total += e.calculateMonthlySalary();
        }
        return total;
    }

    public static Employee[] filterByType(Employee[] employees, String type) { // IT HAS NO RETURN
        int count = 0;
        for (Employee e : employees) {
            if (e.getClass().getSimpleName().equals(type)) { // from == to .equals() (CHANGED)
                count++;
            }
        }

        Employee[] result = new Employee[count];
        int index = 0;
        for (Employee e : employees) {
            if (e.getClass().getSimpleName().equals(type)) {
                result[index] = e;
                index++; // Added
            }
        }
        return result;
    }

    public static Employee findHighestPaid(Employee[] employees) {
        Employee highest = employees[0];
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].calculateMonthlySalary() > highest.calculateMonthlySalary()) { // from < to > (CHANGED)
                highest = employees[i];
            }
        }
        return highest;
    }

    public static void giveRaises(Employee[] employees, double percent) {
        for (Employee e : employees) {
            if (e instanceof FullTimeEmployee) {
                FullTimeEmployee ft = (FullTimeEmployee) e;
                ft.giveRaise(percent);
            }
        }
    }
}