public class Developer extends Employee{
    //=======VARIABLES=======//
    private String ProgrammingLanguage;
    private double ProjectBonus;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Developer(String Name, int EmployeeID, double BaseSalary, String ProgrammingLanguage, double ProjectBonus) {
        super(Name, EmployeeID, BaseSalary);
        this.ProgrammingLanguage = ProgrammingLanguage;
        this.ProjectBonus = ProjectBonus;
        System.out.println("Developer positioned assigned!");
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    @Override
    public double calculateSalary() {
        return BaseSalary + ProjectBonus;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void deployProject() {
        System.out.println(Name + " deployed a project successfully! Bonus earned: " + ProjectBonus);
    }

    // @OVERRIDE
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Programming Language: " + ProgrammingLanguage);
        System.out.println("Project Bonus: " + ProjectBonus);
    }
    @Override
    public void Work() {
        super.Work();
        System.out.println(Name + " is coding in " + ProgrammingLanguage);
    }
}
