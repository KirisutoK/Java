// Creation Date: September 16, 2026. at 4:56 PM
// Last Modified: September 16, 2026. at  5:52 PM

import java.util.ArrayList;

public class Class {
    //=======VARIABLES=======//
    private String Class_Name;
    private ArrayList<String> Students;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Class(String Class_Name) {
        this.Class_Name = Class_Name;
        Students = new ArrayList<>();
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES


    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void addStudent(String name) {
        Students.add(name);
    }
    public void removeStudent(String name) {
        if (Students.remove(name)) { // .remove() actually returns a boolean and itterates through the list to remove.
            System.out.println(name + " has been successfully removed!");
        } else {
            System.out.println(name + " does not exist in the list!");
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInformation() {
        System.out.println("Class Name: "+Class_Name);
        System.out.println("Students: "+Students.toString());
    }


    // ================================================== OTHER CLASSES ================================================== \\
}
