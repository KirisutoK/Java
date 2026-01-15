public class Professor extends Person {
    //=======VARIABLES=======//
    private static int TotalProfessors = 0;

    private final int TENURE_YEARS = 5;
    private String Department;
    private int YearsOfExperience;
    private double Salary;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Professor(String Name, int Age, String ID) {
        super(Name, Age, ID);
        TotalProfessors++;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public int getTotalProfessors() {
        return TotalProfessors;
    }
    public boolean hasTenure() {
        return YearsOfExperience >= TENURE_YEARS;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void Teach() {
        System.out.println("Professor " + Name + " is teaching " + Department);
    }
    public void adviseMenTee(GraduateStudent GradStudent) {
        System.out.println("Professor " + Name + " is advising " + GradStudent.Name + " on " + GradStudent.ThesisTopic);
    }

    // @OVERRIDE
    @Override
    public void Introduce() {
        super.Introduce();
        System.out.println("I'm a professor in " + Department);
    }
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Experience: " + YearsOfExperience);
        System.out.println("Salary: " + Salary);
        System.out.println("Tenure Status: " + TENURE_YEARS);
    }
}
