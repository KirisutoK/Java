package Rules;

// Creation Date: June 02, 2026. at 2:48 PM
// Last Modified: June 02, 2026. at  9:51 PM

import Family.FamilyMember;
import Family.Relative;

public class Rule {
    //=======VARIABLES=======//
    private FamilyMember Fmember;
    private String Text;
    private double Duration;
    private String Condition;
    private boolean isCondition;
    private boolean TempRule;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Rule(FamilyMember Fmember, String Text, double Duration) {
        this.Fmember = Fmember;
        this.Text = Text;
        this.Duration = Duration;
        isCondition = false;
        TempRule = Fmember instanceof Relative; // return true if FamilyMember is a relative
    }
    public Rule(FamilyMember Fmember, String Text, String Condition) {
        this.Fmember = Fmember;
        this.Text = Text;
        this.Condition = Condition;
        isCondition = true;
        TempRule = Fmember instanceof Relative; // return true if FamilyMember is a relative
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES


    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void addRule() {
        if (TempRule) {
            RulesDatabase.TempRules.add(this);
        } else {
            RulesDatabase.Rules.add(this);
        }
    }
    public void removeRule() {
        RulesDatabase.Rules.remove(this);
    }
    public void changeText(String text) {
        Text = text;
    }
    public void changeCondition(String text) {
        Condition = text;
        isCondition = true;
    }
    public void changeDuration(double duration) {
        Duration = duration;
        isCondition = false;
    }


    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInformation() {
        System.out.println("============ FAMILY INFORMATION ============");
        Fmember.displayInformation();
        System.out.println("|------------------+ RULE +------------------|");
        System.out.println("Rule: "+Text);
        if (isCondition) { System.out.println("Condition: "+Condition);
        } else {System.out.println("Duration: "+Duration);}
        System.out.println("|--------------------------------------------|");
    }


}
