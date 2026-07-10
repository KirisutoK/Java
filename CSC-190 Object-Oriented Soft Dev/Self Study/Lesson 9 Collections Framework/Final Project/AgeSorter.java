// Creation Date: July 01, 2026. at 12:50 PM
// Last Modified: July 10, 2026. at  5:55 PM

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class AgeSorter {
    //=======VARIABLES=======//
    //... REMOVED THE NAMES ARRAYLIST HERE BECAUSE IT WILL BE INSIDE THE HASHMAP
    private HashMap<Group, ArrayList<Profile>> Groups; // This is what binds both the Key(GroupName) and Value(Names)
    private HashSet<Group> GroupNames;  // This is the Key

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public AgeSorter() {
        Groups = new HashMap<>();
        GroupNames = new HashSet<>();
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public Profile getProfile(String name) {
        for (Group g:Groups.keySet()) { // FOR EVERY GROUPS
            for (Profile p:Groups.get(g)) { // FOR EVERY PROFILE INSIDE ARRAYLIST OF GROUPS
                if (p.getName().equals(name)) {
                    return p;
                }
            }
        }

        System.out.println(name+" does not exist!");
        return null;
    }
    public Group getGroup(String gname) {
        for (Group i:Groups.keySet()) { // FOR EVERY GROUP IN GROUPS<K>
            if (i.getGroupName().equals(gname)) {
                return i;
            }
        }

        System.out.println(gname+" does not exist!");
        return null;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    // [PROFILE]
    public void addProfile(Profile p) {
        // SECURITY MEASURES
        if (!securityCheck(p)) { // IF IT RETURNS FALSE
            return; // stops the whole method here
        }

        // CHECKS WHAT AGE GROUP BELONGS INTO
        for (Group i:Groups.keySet()) { // Check each index of Group Keys
            if (p.getAge() >= i.getGroupRangeStart() && p.getAge() <= i.getGroupRangeEnd()) { // CHECK AGE RANGE AND IF IT FALLS UNDER A GROUP
                Groups.get(i).add(p);
                System.out.println(p.getFullInformation()+" has successfully been added into "+i.getGroupName()+". ");
                return; // stops the whole method here;
            }
        }

        // IF DID NOT GET ADDED IN A GROUP
        System.out.println(p.getFullInformation()+" does not belong in any existing group!");
    }
    public void changeProfileAge(String name, int age) {
        Profile p = getProfile(name);
        if (p == null) {
            return; // stops the whole method here
        }
        if (p.changeAge(age)) { // IF AGE HAS CHANGED THEN

            // REMOVE FROM THE CURRENT LIST
            Group OriginalGroup = null;
            for (Map.Entry<Group, ArrayList<Profile>> entry: Groups.entrySet()) { //...  <============ THIS WAS NOT TAUGHT IN THE PRACTICES NOR QUIZZES SO BE MIND OF THAT (THIS IS SIMILAR TO keySet() and values()
                ArrayList<Profile> profileList = entry.getValue(); //... <================== THIS WAS NOT TAUGHT IN THE PRACTICES NOR QUIZZES SO BE MIND OF THAT (THIS IS NOT A METHOD VARIABLE, IT IS POINTING TO THE CLASS VARIABLE SO ANY CHANGES OF THIS VARIABLE WILL DIRECTLY CHANGE THE CLASS VARIABLE)
                if (profileList.contains(p)) {
                    OriginalGroup = entry.getKey();
                    profileList.remove(p); // removes the profile to the temp Arraylist
                }
            }

            // CHECKS WHAT AGE GROUP BELONGS INTO
            for (Group i:Groups.keySet()) { // Check each index of Group Keys
                if (p.getAge() >= i.getGroupRangeStart() && p.getAge() <= i.getGroupRangeEnd()) { // CHECK AGE RANGE AND IF IT FALLS UNDER A GROUP
                    Groups.get(i).add(p);
                    System.out.println(p.getFullInformation()+" has successfully been moved from "+OriginalGroup.getFullInformation()+" into "+i.getGroupName()+". ");
                    return; // stops the whole method here;
                }
            }

            // IF IT DOES NOT BELONG IN ANY GROUP
            System.out.println(p.getFullInformation()+" does not belong an any group!");
        }
    }

    // [GROUP]
    public void addGroup(Group groupParameter) {
        // SECURITY MEASURES
        if (!securityCheck(groupParameter)) { // if this returns false
            return; // stops the whole method here
        }

        // CHECK IF GROUPNAMES IS EMPTY
        if (GroupNames.isEmpty()) {
            GroupNames.add(groupParameter);
            Groups.put(groupParameter, new ArrayList<Profile>());
            System.out.println(groupParameter.getGroupName()+" has been added!");
            return; // stops the whole method here
        }

        // CHECK IF IT COLLIDES WITH ANY OTHER GROUP AND IF IT ALREADY EXISTS
        for (Group i:GroupNames) { // FOR EVERY GROUP
            // CHECK IF IT EXISTS
            if (i.getGroupName().equals(groupParameter.getGroupName())) {
                System.out.println(groupParameter.getGroupName()+" already exists!");
                return; // stops the whole method here
            }

            // CHECK AGE RANGE COLLISION
            HashSet<Integer> Comparison = new HashSet<>();

            // ADD ALL THE VALUES INSIDE THE HASHSET
            // [FIRST ARRAY (EXISTING/OLD GROUP)]
            for (int a = 0; a < i.GroupRange.length; a++) {
                Comparison.add(i.GroupRange[a]);
            }
            // [SECOND ARRAY (NEW GROUP)] <============= THIS WILL LET US KNOW IF THE NUMBERS COLLIDE WITH THE OTHER ARRAY
            for (int b = 0; b < groupParameter.GroupRange.length; b++) {
                if (!(Comparison.add(groupParameter.GroupRange[b]))) { // ADDS AND CHECKS IF IT RUN
                    System.out.println(groupParameter.getFullInformation()+" cannot be created because it has a collision with "+i.getFullInformation());
                    return; // stops the whole method here
                }
            }
        }

        // ADDING THE NEW GROUP
        GroupNames.add(groupParameter);
        System.out.println(groupParameter.getGroupName()+" has been added!");
        Groups.put(groupParameter, new ArrayList<Profile>());
    }
    public void removeGroup() {

    }
    public void changeGroupRange(String name, int startage, int endage) {
        // SECURITY MEASURES
        if (getGroup(name) == null) {
            return; // stops the whole method here
        } else if (startage < 0) { // If start is less than 0, end less than or equal to smart, if end is greater than 20
            System.out.println("Starting age can not be less than 0!");
            return; // stops the whole method here
        } else if (endage <= startage) {
            System.out.println("Ending age can not be the same as Starting Age!");
            return; // stops the whole method here
        } else if (endage > 200) {
            System.out.println("Ending age can not reach pass 200!");
            return; // stops the whole method here
        }

        // CHECKING IF IT EXISTS
        HashSet<Integer> Comparison = new HashSet<>();
        Group TargetGroup = getGroup(name);
       // [CREATING TEMP INT ARRAY] <================= THIS IS TO CHECK IF IT COLLIDES WITH ANY OTHER VALUES OF GROUPS
        int[] intTempArr = new int[endage-startage];
        int Values = startage;
        for (int a = 0; a < intTempArr.length; a++) { // from 0 to how many times it need to iterate
            intTempArr[a] = Values++;
            Comparison.add(intTempArr[a]);
        }
        // [FIRST ARRAY (OLD/EXISTING ARRAY)]
        for (Group i:Groups.keySet()) { // FOR EVERY GROUP IN GROUPS<K>
            if (!TargetGroup.getGroupName().equals(i.getGroupName())) { // IF IT'S NOT THE SELECTED GROUP
                // ADDING ALL THE VALUES THAT WE CURRENTLY HAVE
                for (int a = 0; a < i.GroupRange.length; a++) {
                    if(!Comparison.add(i.GroupRange[a])) {
                        System.out.println(TargetGroup.getFullInformation()+"cannot be changed into "+TargetGroup.getGroupName()+" ["+startage+" - "+endage+"] because it has a collision with "+i.getFullInformation());
                        return; // stops the whole method here
                    }
                }
            }
        }

        // CHANGING THE AGE
        TargetGroup.changeGroupRange(startage, endage);
        updateAgeSorter(); // THIS WILL REARRANGE THE PROFILES TO THEIR RESPECTIVE GROUP
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInformation() {
        for (Group i:Groups.keySet()) { //
            System.out.println("Group: "+i.getFullInformation());
            System.out.println("Profiles:");
            int count = 1;
            for (Profile j: Groups.get(i)) { // Checks every profile in the ArrayList
                System.out.println(count+". "+j.getFullInformation());
                count++;
            }
            System.out.println();
        }
    }
    public void updateAgeSorter() { // This rearranges the profiles to their respective age group
        ArrayList<Profile> TempProfiles = new ArrayList<>();

        // GRAB ALL THE PROFILES
        for (Group g:Groups.keySet()) { // FOR EVERY GROUP FROM THE HASHMAP(Groups)
            TempProfiles.addAll(Groups.get(g)); // GET ALL THE VALUES OF G (THIS LINE OF CODE ONLY WORKS WHEN THE PARAMETER IS A COLLECTION SUCH AS ARRAYLISTS
        }

        // CLEAR ALL THE HASHMAP
        Groups.clear();

        // ADD THE HASHSET(GROUPNAMES) INTO THE HASHMAP KEY
        for (Group g:GroupNames) {
            Groups.put(g, new ArrayList<Profile>());
        }

        // ADD THE ARRAYLIST(PROFILE) INTO THE HASHMAP VALUE
        for (Group i:Groups.keySet()) { // Check each index of Group Key
            for (Profile p: TempProfiles) { // Checks every profile in TempProfiles ArrayList
                if (p.getAge() >= i.getGroupRangeStart() && p.getAge() <= i.getGroupRangeEnd()) { // CHECK AGE RANGE AND IF IT FALLS UNDER A GROUP
                    Groups.get(i).add(p);
                }
            }
        }

        System.out.println(getClass().getName()+" has been successfully updated!");

    }
    public boolean securityCheck(Group gp) {
        if (gp == null) { // CHECK IF ITS EMPTY
            System.out.println("Group can not be null!");
            return false; // stops the whole method here
        } else if (gp.GroupRangeStart < 0) { // IF STARTING AGE IS LESS THAN 0
            System.out.println("[ERROR] GROUP CREATION DECLINED: Group's Starting Age can not be less than 0!");
            return false; // stops the whole method here
        } else if (gp.GroupRangeEnd < gp.GroupRangeStart) { // IF STARTING AGE IS GREATER THAN THE ENDING
            System.out.println("[ERROR] GROUP CREATION DECLINED: Group's Ending Age can not be less than the Group's Starting Age!");
            return false; // stops the whole method here
        } else if (gp.GroupRangeEnd == gp.GroupRangeStart) {
            System.out.println("[ERROR] GROUP CREATION DECLINED: Group's Starting age can not be the same as Group's Ending Age!");
            return false; // stops the whole method here
        } else if (gp.GroupRangeEnd > 200) {
            System.out.println("[ERROR] GROUP CREATION DECLINED: Group's maximum age can only reach 200!");
            return false;
        }

        return true;
    }
    public boolean securityCheck(Profile p) {
        // CHECK IF ITS EMPTY
        if (p == null) {
            System.out.println("Profile can not be null");
            return false; // Stops the whole method here
        }

        // CHECK IF THERE ARE NO GROUPS AVAILABLE
        if (GroupNames.isEmpty()) {
            System.out.println("There are no groups currently that exists!");
            System.out.println("Please create a group first before adding a profile.");
            return false; // Stops the whole method here
        }

        // CHECK IF AGE IS VALID
        if (p.getAge() < 0) {
            System.out.println(p.getName()+" can not have an age less than 0!");
            return false; // Stops the whole method here
        }

        // CHECK IF IT ALREADY EXISTS
        for (ArrayList<Profile> i:Groups.values()) { // FOR EVERY ARRAYLIST IN A GROUP
            for (int a = 0; a < i.size(); a++) { // FOR EVERY PROFILE IN AN ARRAYLIST OF PROFILE
                if (p.getName().equalsIgnoreCase(i.get(a).getName())) {
                    System.out.println(p.getFullInformation()+" already exists!");
                    return false;
                }
            }
        }

        // IF CHECKS HAD PASSED THEN RETURN TRUE
        return true;
    }

    // ================================================== OTHER CLASSES ================================================== \\
    public static class Profile {
        //=======VARIABLES=======//
        private String Name;
        private int Age;

        //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
        public Profile(String Name, int Age) {
            this.Name = Name;
            this.Age = Age;
        }

        //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
        public String getName() {
            return Name;
        }
        public int getAge() {
            return Age;
        }
        public String getFullInformation() {
            return Name+" ["+Age+"]";
        }

        //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
        public boolean changeAge(int age) {
            if (age < 0) {
                System.out.println(Name+" cannot have an age less than 0!");
                return false;
            } else {
                Age = age;
                return true;
            }
        }

        //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    }
    public static class Group {
        //=======VARIABLES=======//
        private String GroupName;
        private int GroupRangeStart;
        private int GroupRangeEnd;
        private int[] GroupRange;

        //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
        public Group(String GroupName, int GroupRangeStart, int GroupRangeEnd) {
            this.GroupName = GroupName;
            this.GroupRangeStart = GroupRangeStart;
            this.GroupRangeEnd = GroupRangeEnd;
            GroupRange = generateGroupRange(GroupRangeStart, GroupRangeEnd);
        }

        //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
        public String getGroupName() {
            return GroupName;
        }
        public int getGroupRangeStart() {
            return GroupRangeStart;
        }
        public int getGroupRangeEnd() {
            return GroupRangeEnd;
        }
        public int[] getGroupRange() {
            return GroupRange;
        }
        public String getFullInformation() {
            return GroupName+" ["+GroupRangeStart+" - "+GroupRangeEnd+"] ";
        }

        //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
        public void changeGroupRange(int start, int end) {
            // ORIGINAL GROUP AGE
            String OriginalStart = GroupRangeStart+"";
            String OriginalEnd = GroupRangeEnd+"";

            // CHANGING GROUP AGE
            GroupRangeStart = start;
            GroupRangeEnd = end;

            // GENERATE THE ARRAY
            GroupRange = generateGroupRange(start, end);

            // PRINT
            System.out.println(GroupName+" ["+OriginalStart+" - "+OriginalEnd+"] has changed into "+getFullInformation());
        }

        //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
        public int[] generateGroupRange(int start, int end) {
            int[] tempGroupRange = new int[(end-start)+1];
            // filling out the empty slots
            int Value = start;
            for (int i = 0; i < tempGroupRange.length; i++) {
                tempGroupRange[i] = Value++;
            }
            return tempGroupRange;
        }
    }
}

// TODO: FIXED ALL THE CHECK BUGS, JUST HAVE TO CREATE THE OTHER 2 METHODS WHICH IS REMOVE PROFILE AND REMOVE GROUP.

// INITIAL IDEAS:
//
// Age Sorter:
// Able to create groups based on age customizeably
// using HashSet as the HashSet as the group.
// HashSet but be binded to an int range that can be customized
// Ex:
//  Create new AgeGroup: Teens
//  Teen Group Age Range: From 1 to 3
//
//  When Creating a group that collides with an existing group's age range, decline the creation of the group.
//