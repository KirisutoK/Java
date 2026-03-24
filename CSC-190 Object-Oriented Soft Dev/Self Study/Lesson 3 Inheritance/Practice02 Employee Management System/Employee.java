public class Employee {
    //=======VARIABLES=======//
    protected String Name;
    protected int EmployeeID;
    protected double BaseSalary;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Employee(String Name, int EmployeeID, double BaseSalary) {
        this.Name = Name;
        this.EmployeeID = EmployeeID;
        this.BaseSalary = BaseSalary;

        System.out.println("Employee " + Name + " hired.");
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public double calculateSalary() {
        return BaseSalary;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void DisplayInfo() {
        System.out.println("Name: " + Name);
        System.out.println("Employee ID: " + EmployeeID);
        System.out.println("Base Salary: " + BaseSalary);
    }
    public void Work() {
        System.out.println(Name + " is working");
    }
}
