// Creation Date: June 26, 2026. at 12:55 AM
// Last Modified: June 27, 2026. at 12:12 AM

import java.util.HashMap;

public class GradeTracker {
    //=======VARIABLES=======//
    private HashMap<String, Double> Grades;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public GradeTracker() {
        Grades = new HashMap<>();
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public double getHighestGrade() {
        double HighestGrade = 0;
        for (String key:Grades.keySet()) {
            if (Grades.get(key) > HighestGrade) {
                HighestGrade = Grades.get(key);
            }
        }

        return HighestGrade;
    }
    public double getClassAverage() {
        double ClassAverage = 0;
        int Count = 0;

        for (String key:Grades.keySet()) {
            ClassAverage += Grades.get(key);
            Count++;
        }

        return ClassAverage/Count;
    }
    public double getGrade(String name) {
        if (Grades.containsKey(name)) {
            return Grades.get(name); //... this returns the value of that key
        }

        return -1.0;
    }
    public boolean hasStudent(String name) {
        return Grades.containsKey(name);
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    // [GRADES]
    public void addGrade(String name, double grade) { //... would use Double as the parameter but Java has an auto-boxing feature
        Grades.put(name, grade);
        System.out.println("A Grade has been added!");
    }
    public void updateGrade(String name, double grade) {
        if (Grades.containsKey(name)) { // if the Key exists
            Grades.put(name, grade); // Change the value of the existing key (Overwriting it)
        } else {
            System.out.println(name+" is not in the tracker");
        }
    }

    // [STUDENTS]
    public void removeStudent(String name) {
        if (Grades.containsKey(name)) {
            Grades.remove(name);
        } else {
            System.out.println(name+" is not in the tracker!");
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayAll() {
        System.out.println("================== DISPLAY ALL ==================");
        for (String key: Grades.keySet()) { //... keySet() makes it so that it returns an array of keys (Data type of the key);
            System.out.println(key+": "+Grades.get(key));
        }
    }


    // ================================================== OTHER CLASSES ================================================== \\
}
