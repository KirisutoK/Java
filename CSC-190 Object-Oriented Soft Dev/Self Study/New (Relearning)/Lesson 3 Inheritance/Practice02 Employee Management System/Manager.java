public class Manager extends Employee{
    //=======VARIABLES=======//
    private double Bonus;
    private int TeamSize;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Manager(String Name, int EmployeeID, double BaseSalary, double Bonus, int TeamSize) {
        super(Name, EmployeeID, BaseSalary);
        this.Bonus = Bonus;
        this.TeamSize = TeamSize;
        System.out.println("Manager Positioned Assigned!");
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    @Override
    public double calculateSalary() {
        return super.BaseSalary + Bonus;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Bonus: " + Bonus);
        System.out.println("Team Size: " + TeamSize);
    }
    @Override
    public void Work() {
        super.Work();
        System.out.println(Name + " is managing a team of " + TeamSize + " people.");
    }
}
