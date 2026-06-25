// Creation Date: June 24, 2026. at 10:16 PM
// Last Modified: June 24, 2026. at 10:53 PM

public class Alcohol {
    //=======VARIABLES=======//
    private String Name;
    private int Age;
    private double Percentage;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Alcohol(String Name, int Age, double Percentage) {
        this.Name = Name;
        this.Age = Age;
        this.Percentage = Percentage;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public double getPercentage() {
        return Percentage;
    }
    public int getAge() {
        return Age;
    }
    public String getName() {
        return Name;
    }


    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS


    // ================================================== OTHER CLASSES ================================================== \\
}
