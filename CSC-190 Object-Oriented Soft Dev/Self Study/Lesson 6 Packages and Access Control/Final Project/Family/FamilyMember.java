package Family;

// Creation Date: June 02, 2026. at 2:42 PM
// Last Modified: June 02, 2026. at 10:06 PM

import Rules.*;

public class FamilyMember {
    //=======VARIABLES=======//
    protected String Name;
    protected String Role;
    protected int Age;
    protected String Gender;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public FamilyMember(String Name, String Role, int Age, String Gender) {
        this.Name = Name;
        this.Role = Role;
        this.Age = Age;
        this.Gender = Gender;
    }
    public FamilyMember(String Name, String Role, int Age) {
        this.Name = Name;
        this.Role = Role;
        this.Age = Age;
        if (Role.equalsIgnoreCase("Mother") || Role.equalsIgnoreCase("Aunt") || Role.equalsIgnoreCase("Daughter")) {
            Gender = "Female";
        } else if (Role.equalsIgnoreCase("Father") || Role.equalsIgnoreCase("Uncle") || Role.equalsIgnoreCase("Son")) {
            Gender = "Male";
        } else {
            Gender = "N/A";
        }
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getName() {
        return Name;
    }
    public String getRole() {
        return Role;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void addRules(String text, double Duration) {
        Rule rule = new Rule(this, text, Duration);
        rule.addRule();
        System.out.println(Name+" has added a rule!");
    }
    public void addRules(String text, String Conditions) {
        Rule rule = new Rule(this, text, Conditions);
        rule.addRule();
        System.out.println(Name+" has added a rule!");
    }
    public void removeRules(int position) {
        DatabaseManager.removeRule(this, position);
    }
    public void removeRules(Rule r) {
        DatabaseManager.removeRule(this, r);
    }
    public void removeTempRules(int position) {
        DatabaseManager.removeTempRule(this, position);
    }
    public void removeTempRules(Rule r) {
        DatabaseManager.removeTempRule(this, r);
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInformation() {
        System.out.println("Name: "+Name);
        System.out.println("Role: "+Role);
        System.out.println("Age: "+Age);
        System.out.println("Gender: "+Gender);
    }
}
