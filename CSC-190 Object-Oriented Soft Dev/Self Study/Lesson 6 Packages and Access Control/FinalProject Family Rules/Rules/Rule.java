package Rules;

// Creation Date: June 02, 2026. at 2:48 PM
// Last Modified: June 02, 2026. at  3:08 PM

import Family.FamilyMember;

public class Rule {
    //=======VARIABLES=======//
    private FamilyMember Fmember;
    private String Text;
    private double Duration;
    private String Condition;
    private boolean isCondition;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Rule(FamilyMember Fmember, String Text, double Duration) {
        this.Fmember = Fmember;
        this.Text = Text;
        this.Duration = Duration;
        isCondition = false;
    }
    public Rule(FamilyMember Fmember, String Text, String Condition) {
        this.Fmember = Fmember;
        this.Text = Text;
        this.Condition = Condition;
        isCondition = true;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInformation() {
        System.out.println("========= FAMILY INFORMATION =========");
        Fmember.displayInformation();
        System.out.println("|==============+ RULE +==============|");
        if (isCondition) { System.out.println("Condition: "+Condition);
        } else {System.out.println("Duration: "+Duration);}
        System.out.println("Rule: "+Text);
        System.out.println("|====================================|");
    }


}
