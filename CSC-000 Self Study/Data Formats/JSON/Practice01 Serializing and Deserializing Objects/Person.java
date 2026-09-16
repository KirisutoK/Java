// Creation Date: September 12, 2026. at 3:32 PM
// Last Modified: September 13, 2026. at  8:59 PM

import java.util.ArrayList;

public class Person {
    //=======VARIABLES=======//
    private String Name;
    private int Age;
    private ArrayList<String> Hobbies;
    private boolean Employment;

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
    public void displayInformation() {
        System.out.println("Name: "+Name);
        System.out.println("Age: "+Age);
        System.out.println("Hobbies: "+Hobbies.toString());
        System.out.println("Employment: "+Employment);
    }


    // ================================================== OTHER CLASSES ================================================== \\
}
