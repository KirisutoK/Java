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

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
