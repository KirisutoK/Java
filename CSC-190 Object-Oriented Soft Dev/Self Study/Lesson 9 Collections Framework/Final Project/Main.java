// Creation Date: June 30, 2026. at 3:13 AM
// Last Modified: July 04, 2026. at  7:19 PM

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in); //... CLASS OBJECT
    static AgeSorter AgeSorterObject = new AgeSorter(); //... CLASS OBJECT

    public static void main(String[] args) {
        Introduction();
        Options();


//        //======= ADDING =======//
//        AgeSorter01.addProfile(new AgeSorter.Profile("Christ", 5));
//        System.out.println();
//
//        AgeSorter01.addGroup(new AgeSorter.Group("Idiot Age", 0, 10));
//        System.out.println();
//
//        AgeSorter01.addProfile(new AgeSorter.Profile("Christ", 100));
//        AgeSorter01.addProfile(new AgeSorter.Profile("Christ", 5));
//        System.out.println();
//
//        AgeSorter01.addGroup(new AgeSorter.Group("Braindead Age", 11, 18));
//        System.out.println();
//
//        //======= CHANGING AGE =======//
//
//        //======= UPDATING =======//
//
//        AgeSorter01.displayInformation();
//        System.out.println();
//
//        AgeSorter01.updateAgeSorter();
//        System.out.println();
//
//        AgeSorter01.displayInformation();
//
//        AgeSorter01.addProfile(new AgeSorter.Profile("Shan",  16));
//
//        AgeSorter01.displayInformation();


    }

    public static void Options() {
        // DISPLAY THE OPTIONS
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║ 1. Create Profile          4. Create Group           ║");
        System.out.println("║ 2. Remove Profile          5. Remove Group           ║");
        System.out.println("║ 3. Change Profile Age      6. Change Group Range     ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.print("Choice: ");

        // GRAB THE INPUT

        int Choice = input.nextInt();
        input.nextLine(); // THIS CONSUMES THE LEFTOVER MADE FROM THE LAST SCANNER WHICH IS \n
        while (Choice < 1 || Choice > 6) {
            System.out.println();
            System.out.println("ERROR: Please choose from 1 to 6");
            System.out.println();
            System.out.print("Choice: ");
            Choice = input.nextInt();
        }
        System.out.println();
        input.nextLine(); // THIS CONSUMES THE LEFTOVER MADE FROM THE LAST SCANNER WHICH IS \n



        switch (Choice) {
            case 1: //... CREATING A PROFILE
                System.out.println("╔══════════════════════════╗");
                System.out.println("║  CREATING  A PROFILE...  ║");
                System.out.println("╚══════════════════════════╝");

                System.out.print("Name: ");
                String Name = input.nextLine();
                System.out.print("Age: ");
                int Age = input.nextInt();
                input.nextLine(); // THIS CONSUMES THE LEFTOVER MADE FROM THE LAST SCANNER WHICH IS \n
                System.out.println();
                AgeSorterObject.addProfile(new AgeSorter.Profile(Name, Age));
                System.out.println();
                Options();
                break;
            case 2: //... REMOVE PROFILE

                break;
            case 3: //... CHANGE PROFILE AGE

                break;
            case 4: //... CREATE GROUP

                break;
            case 5: //... REMOVE GROUP

                break;
            case 6: //... CHANGE GROUP AGE

                break;
        }
    }
    public static void Introduction() {
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║    AGE SORTER BY CHRIST AERJIL C. DAMPOG             ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("Java Techniques in this program include:");
        System.out.println("1. Collections Framework");
        System.out.println("2. Inner Classes");
        System.out.println("3. Enhanced For Loops");
        System.out.println("4. Object-Oriented Programming");
        System.out.println("5. Switches");
        System.out.println();
        System.out.println("Author: Have Fun!");
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