public class GraduateStudent extends Student{
    //=======VARIABLES=======//
    private static int TotalGraduateStudents = 0;

    private String ThesisTopic;
    private Professor Advisor;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public GraduateStudent(String Name, int Age, String ID, int GradeLevel, double GPA, String ThesisTopic, Professor Advisor) {
        super(Name, Age, ID, GradeLevel, GPA);
        this.ThesisTopic = ThesisTopic;
        this.Advisor = Advisor;
        TotalGraduateStudents++;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getThesisTopic() {
        return ThesisTopic;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void DefendThesis() {
        System.out.println(Name + " is defending thesis on " + ThesisTopic + " under " + Advisor.Name );
    }


    // @OVERRIDE
    @Override
    public void Study() {
        super.Study();
        System.out.println("Researching for thesis on " + ThesisTopic);
    }
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
