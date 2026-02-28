package Classes;

// Creation Date: February 27, 2026. at 9:19 PM
// Last Modified: February 27, 2026. at 9:23 PM

// ABSTRACTS ARE RULES TO ITS CHILDREN'S, (IT'S A KEY TERM OF "MUST HAVE")
public abstract class AcademicPerson // This a person that is on an education
        extends Person {
    //=======VARIABLES=======//
    protected String Department;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public AcademicPerson(String Name, String ID, int Age, String Department) {
        super(Name, ID, Age);
        this.Department = Department;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
