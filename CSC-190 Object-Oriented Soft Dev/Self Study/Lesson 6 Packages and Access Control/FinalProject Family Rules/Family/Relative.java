package Family;

// Creation Date: June 02, 2026. at 3:09 PM
// Last Modified: June 02, 2026. at  9:51 PM

import Rules.Rule;

import java.util.concurrent.locks.Condition;

public class Relative extends FamilyMember {
    //=======VARIABLES=======//
    private double VisitDuration; // in hours
    private String VisitCondition;
    private boolean isCondition;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Relative(String Name, String Role, int Age, String Gender, double visitDuration) {
        super(Name, Role, Age, Gender);
        this.VisitDuration = visitDuration;
        isCondition = false;
    }
    public Relative(String Name, String Role, int Age, double visitDuration) {
        super(Name, Role, Age);
        this.VisitDuration = visitDuration;
        isCondition = false;
    }
    public Relative(String Name, String Role, int Age, String Gender, String VisitCondition) {
        super(Name, Role, Age, Gender);
        this.VisitCondition = VisitCondition;
        isCondition = true;
    }
    public Relative(String Name, String Role, int Age, String VisitCondition) {
        super(Name, Role, Age);
        this.VisitCondition = VisitCondition;
        isCondition = true;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void addRules(String text) {
        Rule rule = new Rule(this, text, VisitDuration);
        rule.addRule();
        System.out.println(Name+" has added a rule!");
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    @Override public void displayInformation() {
        super.displayInformation();
        if (isCondition) {System.out.println("Visit Condition: "+ VisitCondition);} else {System.out.println("Visit Duration: "+ VisitDuration);
        }
    }
}
