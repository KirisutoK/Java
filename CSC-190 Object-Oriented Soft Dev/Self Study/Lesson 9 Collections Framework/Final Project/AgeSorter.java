// Creation Date: July 01, 2026. at 12:50 PM
// Last Modified: July 02, 2026. at 12:46 AM

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

        // DEFAULT GROUP (CANT BE DELETED)
//        Group DefaultGroup = new Group("Does not belong to a Group", 0, 200);
//        GroupNames.add(DefaultGroup);
//        Groups.put(DefaultGroup, new ArrayList<Profile>());
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void addProfile(Profile p) {
        // CHECK IF IT ALREADY EXISTS
        for (ArrayList<Profile> i:Groups.values()) {
            if (i.contains(p)) {
                System.out.println(p.getFullInformation()+" already exists!");
                return;
            }
        }

        if (p.getAge() < 0) { // CHECK IF AGE IS VALID
            System.out.println(p.getName()+" can not have an age less than 0!");
            return; // Stops the whole method here
        } else if (p.equals(null)) { // CHECK IF IT IS NOT EMPTY
            System.out.println("Profile can not be null!");
            return; // Stops the whole method here
        } else if (GroupNames.size() < 0) {
            System.out.println("There are no groups currently that exists!");
            return; // Stops the whole method here
        }

        // [ADDING AND ASSIGNING THE PROFILE TO A GROUP]
        // CHECKS WHAT AGE GROUP BELONGS INTO
        for (Group i:GroupNames) { // Check each index of GroupNames
            if (p.getAge() >= i.getGroupRangeStart() && p.getAge() <= i.getGroupRangeEnd()) { // CHECK AGE RANGE
                Groups.get(i).add(p);
            }
        }
    }



    public void updateAgeSorter() { // This rearranges the profiles to their respective age group

    }
    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInformation() {
        for (Group i:Groups.keySet()) { //
            i.displayInformation();
            System.out.println("Profiles:");
            int count = 1;
            for (Profile j: Groups.get(i)) { // Checks every profile in the ArrayList
                System.out.println(count+". "+j.getFullInformation());
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

        //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
        public Group(String GroupName, int GroupRangeStart, int GroupRangeEnd) {
            this.GroupName = GroupName;
            this.GroupRangeStart = GroupRangeStart;
            this.GroupRangeEnd = GroupRangeEnd;
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


        //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
        public void changeGroupRange(int start, int end) {
            GroupRangeStart = start;
            GroupRangeEnd = end;
        }

        //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
        private void displayInformation() {
            System.out.println("Group Name: "+GroupName);
            System.out.println("Group Range: "+GroupRangeStart+" to "+GroupRangeEnd);
        }
    }
}

// TODO: YOU CURRENTLY HAVE MADE A HASHMAP<Group, ArrayList<Profile>>
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