// Creation Date: June 25, 2026. at 12:19 AM
// Last Modified: June 25, 2026. at 12:40 AM

import java.util.ArrayList;

public class Roster {
    //=======VARIABLES=======//
    private ArrayList<String> Students;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Roster() {
        Students = new ArrayList<>();
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public void displayRoster() {
        System.out.println("===== STUDENTS ===== ");
        int Count = 0;
        for (String i: Students) {
            System.out.println(Count+". "+i);
            Count++;
        }
    }
    public boolean hasStudent(String name) {
        return Students.contains(name);
    }
    public String getStudent(int index) {
        if (index > Students.size() || index < 0) {
            System.out.println("Invalid Index!");
            return null;
        }

        return Students.get(index);
    }
    public int getRosterSize() {
        return Students.size();
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void addStudents(String name) {
        Students.add(name);
    }
    public void removeStudents(String name) {
        if (!(Students.remove(name))) { //... THE IF CONDITION WILL BOTH RUN AND CHECK AT THE SAME TIME (THIS IS BECAUSE IT IS NOT COMPARING
            System.out.println(name+" is not in the rooster");
        }
    }
    public void clearRoster() {
        Students.clear();
    }
    


    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS


    // ================================================== OTHER CLASSES ================================================== \\
}
