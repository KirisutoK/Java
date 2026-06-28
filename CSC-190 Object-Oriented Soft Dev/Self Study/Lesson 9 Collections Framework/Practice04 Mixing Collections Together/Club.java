// Creation Date: June 27, 2026. at 1:11 AM
// Last Modified: June 28, 2026. at  3:58 AM

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class Club {
    //=======VARIABLES=======//
    private String ClubName;
    private ArrayList<String> Members;
    private HashMap<String, String> MemberRoles;
    private HashSet<String> UniqueSkills;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Club(String clubName) {
        ClubName = clubName;
        Members = new ArrayList<>();
        MemberRoles = new HashMap<>();
        UniqueSkills = new HashSet<>();
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getMemberRole(String n) {
        if (!MemberRoles.containsKey(n)) {
            return "not a member"; //
        }

        return MemberRoles.get(n);
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void addMember(String n, String r) {
        if (MemberRoles.containsKey(n)) { // Checks if we already have this dude
            System.out.println(n+" is already a member");
        } else {
            Members.add(n);
            MemberRoles.put(n, r);
        }
    }
    public void removeMember(String n) {
        if (Members.remove(n)) { // if this runs then do this
            MemberRoles.remove(n);
        } else {
            System.out.println(n+" is not a member!");
        }
    }
    public void addSkill(String s) {
        UniqueSkills.add(s);
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayClub() {
        int count = 1;

        System.out.println("Club Name: "+ClubName);
        System.out.println("Members: ");
        for (String i: Members) {
            System.out.println(count+". "+i+" ["+MemberRoles.get(i)+"]");
            count++;
        }
        System.out.println("Unique Skills: "+UniqueSkills);
        System.out.println("Total Member Count: "+Members.size());
    }


    // ================================================== OTHER CLASSES ================================================== \\
}
