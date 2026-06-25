// Creation Date: June 24, 2026. at 10:01 PM
// Last Modified: June 24, 2026. at 11:02 PM

import Exceptions.CloseAndOpenBarException;

public class Main {
    public static void main(String[] args) {
        //======= CREATING OBJECTS =======//
        Bar Bar01 = new Bar("Random's Bar", 5);

        //======= ADDING ALCOHOL INTO THE BAR =======//
        try {
            Bar01.addAlcohol(new Alcohol("A01", 2, 99.99));
        } catch (Exception e) {
            e.getMessage();
        } finally {
            System.out.println("Finished Adding Alcohol!");
        }

        //======= CREATING OBJECTS =======//
    }
}




// REQUIREMENTS:
//
// Must have at least 3 custom exception classes that are meaningful and make real-world sense
// Must demonstrate try-catch with multiple catch blocks at least once
// Must use finally at least once in a meaningful way — not just printing "done", it should actually make sense WHY finally is there
// Must use throws in at least 2 method signatures
// Must use throw to manually trigger exceptions in at least 3 different places
// Must have at least 2 classes outside of exception classes
// Must have a fully working Main.java that triggers both successful operations AND each custom exception at least once
// The system must make real-world logical sense — exceptions should represent things that could actually go wrong in that system

// MY INITIAL IDEA:

// BAR object (MANAGER OF OBJECTS{PEOPLE, ALCOHOL} )
// BAR methods will consist of:
//  -> closeBar();
//  -> openBar();
//  -> addAlcohol(Alcohol a);
//  -> removeAlcohol(Alcohol a);
// PEOPLE methods will consist of:
//  -> drinkAlcohol();
//  -> enterBar();
//  -> leaveBar();
// ALCOHOL methods will consist of:
//  ->