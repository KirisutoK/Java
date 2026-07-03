// Creation Date: July 01, 2026. at 12:50 PM
// Last Modified: July 02, 2026. at 10:30 PM

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void addProfile(Profile p) {
        // CHECK IF ITS EMPTY
        if (p == null) {
            System.out.println("Profile can not be null");
            return; // Stops the whole method here
        }

        // CHECK IF THERE ARE NO GROUPS AVAILABLE
        if (GroupNames.isEmpty()) {
            System.out.println("There are no groups currently that exists!");
            System.out.println("Please create a group first before adding a profile.");
            return; // Stops the whole method here
        }

        // CHECK IF AGE IS VALID
        if (p.getAge() < 0) {
            System.out.println(p.getName()+" can not have an age less than 0!");
            return; // Stops the whole method here
        }

        // CHECK IF IT ALREADY EXISTS
        for (ArrayList<Profile> i:Groups.values()) {
            if (i.contains(p)) { //! THIS HAS A BIG FLAW WITH COMPARISON OF OBJECTS SINCE IT IS NOT COMPARING THE ACTUAL DETAILS, BUT ACTUALLY COMPARING THE MEMORY OF IT (IF IT HAS THE SAME NAME BUT DIFFERENT OBJECTS, IT WILL RETURN FALSE)
                System.out.println(p.getFullInformation()+" already exists!");
                return;
            }
        }

        // [ADDING AND ASSIGNING THE PROFILE TO A GROUP]
        // CHECKS WHAT AGE GROUP BELONGS INTO
        for (Group i:Groups.keySet()) { // Check each index of Group Keys
            if (p.getAge() >= i.getGroupRangeStart() && p.getAge() <= i.getGroupRangeEnd()) { // CHECK AGE RANGE AND IF IT FALLS UNDER A GROUP
                Groups.get(i).add(p);
                System.out.println(p.getFullInformation()+" has successfully been added into "+i.getGroupName()+". ");
            }
        }

        System.out.println("YOU LEFT HERE: LINE 60");
    }
    public void addGroup(Group groupParameter) {
        // CHECK IF ITS EMPTY
        if (groupParameter == null) {
            System.out.println("Group can not be null!");
            return; // stops the whole method here
        }

        // CHECK IF GROUPNAMES IS EMPTY
        if (GroupNames.isEmpty()) {
            if (GroupNames.add(groupParameter)) {
                Groups.put(groupParameter, new ArrayList<Profile>());
                System.out.println(groupParameter.getGroupName()+" has been added!");
                return; // stops the whole method here
            } else {
                System.out.println(groupParameter.getGroupName()+" already exists!");
                return; // stops the whole method here
            }
        }

        // CHECK IF IT COLLIDES WITH ANY OTHER GROUP
        for (Group i:GroupNames) { // FOR EVERY GROUP
            HashSet<Integer> Comparison = new HashSet<>();

            // ADD ALL THE VALUES INSIDE THE HASHSET
            // [FIRST ARRAY (EXISTING/OLD GROUP)]
            for (int a = 0; a < i.GroupRange.length; a++) {
                Comparison.add(i.GroupRange[a]);
            }
            // [SECOND ARRAY (NEW GROUP)] <============= THIS WILL LET US KNOW IF THE NUMBERS COLLIDE WITH THE OTHER ARRAY
            for (int b = 0; b < groupParameter.GroupRange.length; b++) {
                if (!(Comparison.add(groupParameter.GroupRange[b]))) {
                    System.out.println("Unable to create a new Group: "+GroupNames+" has a collision with "+i.getGroupName()+" Age Range ["+i.getGroupRangeStart()+" - "+i.GroupRangeEnd+"] ");
                    return; // stops the whole method here
                }
            }
        }

        // ADDING THE NEW GROUP
        GroupNames.add(groupParameter);
        System.out.println(groupParameter.getGroupName()+" has been added!");
        Groups.put(groupParameter, new ArrayList<Profile>());
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
        for (Group GpNames:GroupNames) {
            Groups.put(GpNames, new ArrayList<Profile>());
        }

        // ADD THE ARRAYLIST(PROFILE) INTO THE HASHMAP VALUE
        for (Profile tpiles: TempProfiles) {
            addProfile(tpiles);
        }

    }
    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInformation() {
        for (Group i:Groups.keySet()) { //
            i.displayInformation();
            System.out.println("Profiles:");
            int count = 1;
            for (Profile j: Groups.get(i)) { // Checks every profile in the ArrayList
                System.out.println(count+". "+j.getFullInformation());
                count++;
            }
        }
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
        public void changeAge(int age) {
            Age = age;
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

            // INITIALIZING THE GROUP RANGE
            GroupRange = new int[(GroupRangeEnd-GroupRangeStart)+1];
            int Values = GroupRangeStart; // Minus 1 because it will add up 6 first if not
            for (int i = 0; i < (GroupRangeEnd-GroupRangeStart)+1; i++) { // from 0 to how many times it need to iterate
                GroupRange[i] = Values++;
            }
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


        //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
        public void changeGroupRange(int start, int end) {
            GroupRangeStart = start;
            GroupRangeEnd = end;

            GroupRange = new int[GroupRangeEnd-GroupRangeStart];
            int Values = GroupRangeStart;
            for (int i = 0; i < GroupRangeEnd-GroupRangeStart; i++) { // from 0 to how many times it need to iterate
                GroupRange[i] = Values++;
            }
        }

        //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
        private void displayInformation() {
            System.out.println("Group Name: "+GroupName+" ["+GroupRangeStart+" - "+GroupRangeEnd+"] ");
        }
    }
}

// TODO: YOU CURRENTLY LEFT AT LINE 45 TO FIX THE ISSUES WITH CONTAINS OR EQUALS SINE DOES METHODS ONLY CHECK FOR MEMORY, NOT CONTENTS OF THE OBJECT. (SAME CONTENT BUT DIFFERENT OBJECT WILL RETURN FALSE)
// TODO: In order to show the data of the group, you must have to create a customize displayInformation(); instead of printing it in one line.
// TODO: you left at the adding the profile into the perspective group
// TODO: the DefaultGroup is dynamic, profiles are only assigned in the Default group when they dont belong in one.

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