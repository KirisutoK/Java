// Creation Date: June 07, 2026. at 3:41 PM
// Last Modified: June 07, 2026. at  3:53 PM

// Office.java
public class Office {
    static public String officeName;
    private int employeeCount;


    public Office(String officeName) {
        this.officeName = officeName;
        this.employeeCount = 0;
    }

    public void displayInfo() {
        System.out.println("Office: " + officeName);
        System.out.println("Total Employees: " + employeeCount);
    }

    class Employee {
        private String name;
        private double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
            employeeCount++;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public void displayEmployee() {
            System.out.println("Employee: " + name);
            System.out.println("Salary: $" + salary);
            System.out.println("Office: " + officeName);
        }
    }
    static class Department {
        private String departmentName;
        private Employee[] employees;
        private int empCount;

        public Department(String departmentName) {
            this.departmentName = departmentName;
            employees = new Employee[10];
            empCount = 0;
        }

        public void addEmployee(Employee emp) {
            employees[empCount] = emp;
            empCount++;
        }

        public double calculateTotalSalary() {
            double total = 0;
            for (int i = 0; i < empCount; i++) { //... <========= REMOVED [FROM <= TO <]
                total += employees[i].getSalary();
            }
            return total;
        }

        public void displayDepartment() {
            System.out.println("Department: " + departmentName);
            for (int i = 0; i < empCount; i++) {
                employees[i].displayEmployee();
            }
        }
    }
    static class Address {
        private String street;
        private String city;

        public Address(String street, String city) {
            this.street = street;
            this.city = city;
        }

        public void displayAddress() {
            System.out.println("Address: " + street + ", " + city);
            System.out.println("Office: "+officeName);
        }
    }
}
