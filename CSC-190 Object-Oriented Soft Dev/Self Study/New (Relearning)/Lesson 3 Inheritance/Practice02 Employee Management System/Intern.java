public class Intern extends Employee {
    //=======VARIABLES=======//
    private String University;
    private Employee Mentor;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Intern(String Name, int EmployeeID, double BaseSalary, String University, Employee Mentor) {
        super(Name, EmployeeID, BaseSalary);
        this.University = University;
        this.Mentor = Mentor;
        System.out.println("Intern position assigned!");
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void attendTraining() {
        System.out.println(Name + " from " + University + " is attending training.");
    }

    // @OVERRIDE
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("University: " + University);
        System.out.println("Mentor: " + Mentor.Name);
    }
    @Override
    public void Work() {
        super.Work();
        System.out.println(Name + " from " + University + " is learning from " + Mentor.Name);
    }
}
