package Family;

// Creation Date: June 02, 2026. at 3:09 PM
// Last Modified: June 02, 2026. at  3:15 PM

public class Relative extends FamilyMember {
    //=======VARIABLES=======//
    private double visitDuration; // in hours

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Relative(String Name, String Role, int Age, String Gender, double visitDuration) {
        super(Name, Role, Age, Gender);
        this.visitDuration = visitDuration;
    }
    public Relative(String Name, String Role, int Age, double visitDuration) {
        super(Name, Role, Age);
        this.visitDuration = visitDuration;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
