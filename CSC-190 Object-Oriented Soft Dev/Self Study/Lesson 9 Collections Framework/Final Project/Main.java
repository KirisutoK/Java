// Creation Date: June 30, 2026. at 3:13 AM
// Last Modified: July 03, 2026. at  1:20 PM

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        //======= CREATING OBJECTS =======//
        AgeSorter AgeSorter01 = new AgeSorter();

        //======= ADDING =======//
        AgeSorter01.addProfile(new AgeSorter.Profile("Christ", 5));
        System.out.println("");

        AgeSorter01.addGroup(new AgeSorter.Group("Idiot Age", 0, 10));
        System.out.println();

        AgeSorter01.addProfile(new AgeSorter.Profile("Christ", 5));
        System.out.println("");

        AgeSorter01.updateAgeSorter();

        AgeSorter01.displayInformation();
        System.out.println();


    }
}

// Requirements:
// 1. Must use all 3 collections — ArrayList, HashMap, and HashSet — each serving a meaningful and logical purpose
// 2. Must have at least 3 classes outside of Main
// 3. Must demonstrate at least one case where collections work together — not just separately
// 4. Must use each of these methods at least once across your entire project:
//      → add(), remove(), contains() or containsKey(), size(), and a loop through a collection
// 5. Must have a fully working Main.java demonstrating the full system end-to-end
// 6. The system must make real-world logical sense — each collection choice should make sense for why that specific collection was chosen
// 7. Must handle at least one case where a duplicate is rejected and show it in Mai


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
// 1. Create a AgeSorter Class
//      a. ArrayList<String> Names
//      b. HashMap<String, String>
//      c. HashSet<String>
// 2.
//