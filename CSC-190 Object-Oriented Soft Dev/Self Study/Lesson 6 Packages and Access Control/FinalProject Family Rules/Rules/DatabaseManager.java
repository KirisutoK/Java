package Rules;

// Creation Date: June 02, 2026. at 10:01 PM
// Last Modified: June 02, 2026. at 10:06 PM

import Family.FamilyMember;

import static Rules.RulesDatabase.*;

public class DatabaseManager {
    //=======VARIABLES=======//

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public static void removeRule(FamilyMember fmember, int position) {
        //? CHECK IF POSITION IS VALID
        if (position > Rules.size()-1 || position < 0) { // if position is greater than the lists or if the position is less than 0
            System.out.println("ERROR: the position is invalid for removing the rules.");
            return; // stops the whole method here
        }

        //? REMOVES
        Rules.remove(position);
        System.out.println(fmember.getName()+" ("+fmember.getRole()+") has removed Rule "+position);
    }
    public static void removeRule(FamilyMember fmember, Rule r) {
        //? CHECK IF RULE EXISTS
        int position = -1;
        for (int i = 0; i < Rules.size(); i++) {
            if (Rules.get(i).equals(r)) {
                position = i;
            }
        }
        if (position == -1) {
            System.out.println("Rule does not exist in the Database!");
            return; // Stops the whole method here
        }

        //? REMOVES
        Rules.remove(r);
        System.out.println(fmember.getName()+" ("+fmember.getRole()+") has removed Rule "+position);
    }

    public static void removeTempRule(FamilyMember fmember, int position) {
        //? CHECK IF POSITION IS VALID
        if (position > TempRules.size()-1 || position < 0) { // if position is greater than the lists or if the position is less than 0
            System.out.println("ERROR: the position is invalid for removing the rules.");
            return; // stops the whole method here
        }

        //? REMOVES
        TempRules.remove(position);
        System.out.println(fmember.getName()+" ("+fmember.getRole()+") has removed Rule "+position);
    }
    public static void removeTempRule(FamilyMember fmember, Rule r) {
        //? CHECK IF RULE EXISTS
        int position = -1;
        for (int i = 0; i < TempRules.size(); i++) {
            if (TempRules.get(i).equals(r)) {
                position = i;
            }
        }
        if (position == -1) {
            System.out.println("Rule does not exist in the Database!");
            return; // Stops the whole method here
        }

        //? REMOVES
        TempRules.remove(r);
        System.out.println(fmember.getName()+" ("+fmember.getRole()+") has removed Rule "+position);
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public static void displayRules() {
        System.out.println(">>================================= RULES =================================<<");
        System.out.println(" "); // Space for Readability
        for (int i = 0; i < Rules.size(); i++) { // from 0 to whatever the size of the arraylist is
            System.out.println("[Rule: "+i+"]");
            Rules.get(i).displayInformation();
            System.out.println(); // Space for Readability
        }
        System.out.println(">>=========================================================================<<");
    }
    public static void displayTempRules() {
        System.out.println(">>================================= TEMPORARY RULES =================================<<");
        System.out.println(" "); // Space for Readability
        for (int i = 0; i < TempRules.size(); i++) { // from 0 to whatever the size of the arraylist is
            System.out.println("[Rule: "+i+"]");
            TempRules.get(i).displayInformation();
            System.out.println(); // Space for Readability
        }
        System.out.println(">>=========================================================================<<");
    }
}
