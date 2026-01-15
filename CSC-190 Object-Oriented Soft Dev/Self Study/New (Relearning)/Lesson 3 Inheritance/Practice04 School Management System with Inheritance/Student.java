public class Student extends Person{
    //=======VARIABLES=======//
    private static int TotalStudents = 0;

    protected int GradeLevel;
    protected double GPA;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Student(String Name, int Age, String ID, int GradeLevel, double GPA) {
        super(Name, Age, ID);
        this.GradeLevel = GradeLevel;
        this.GPA = GPA;
        TotalStudents++;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public int getTotalStudents() {
        return TotalStudents;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void Study() {
        System.out.println(Name + " is studying hard");
    }

    // @OVERRIDE
    @Override
    public void Introduce() {
        super.Introduce();
        System.out.println("I'm a student in grade " + GradeLevel);
    }
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Grade: " + GradeLevel);
        System.out.println("GPA: " + GPA);
    }
}
