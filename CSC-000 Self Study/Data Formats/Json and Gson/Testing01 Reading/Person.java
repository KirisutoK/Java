// Creation Date: September 12, 2026. at 3:32 PM
// Last Modified: September 12, 2026. at  3:37 PM

import java.util.ArrayList;

public class Person {
    //=======VARIABLES=======//
    public String Name;
    public int Age;
    public ArrayList<String> Hobbies;
    public boolean Employment;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Person(String Name, int Age, boolean Employment) {
        this.Name = Name;
        this.Age = Age;
        this.Hobbies = new ArrayList<>();
        this.Employment = Employment;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES


    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void addHobbies(String hobby) {
        Hobbies.add(hobby);
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS


    // ================================================== OTHER CLASSES ================================================== \\
}
