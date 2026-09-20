// Creation Date: August 21, 2026. at 12:02 AM
// Last Modified: September 20, 2026. at 12:02 PM

import Controller.CLI.Menu;
import Misc.ReuseableMethods;

public class Launcher {
    // =========================== CLASS VARIABLES =========================== \\

    // [OBJECTS]
    private static Menu menu = new Menu();

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        System.out.println("1. CLI   2. JavaFX");
        int Answer = ReuseableMethods.getAnswer(1, 2);

        switch (Answer) {
            case 1:
                menu.Main();
                break;
            case 2:

                break;
        }

    }

    // =========================== METHODS =========================== \\
}

// [INITIAL IDEA 1.2:]
// Add an exception if a user decides to exit the application because our application is running in an infinite while lopp.
// [INITIAL IDEA 1.3:]
// Add AES Encryption, Hashing Password
// I am currently using a raw password String and users are able to see it throught the object file.
// This whole cryptography thing will be a whole entire different thing so I am planning to learn it after I finish this project.
// Add AES Encryption, Hashing Password
// I am currently using a raw password String and users are able to see it throught the object file.
// This whole cryptography thing will be a whole entire different thing so I am planning to learn it after I finish this project.
// [INITIAL IDEA 1.4:]
// turn this application into JavaFX so that non-technical people are able to navigate freely and easily with just a click of a button.
// Keep this CLI application as it is and replicate another one to convert it into JavaFX.
// [INITIAL IDEA 1.5:]
// I will be changing the classess/applications majorly to start JavaFX phase. I will be refactoring the code structure as much as possible
// to be dynamically be used for both CLI and JavaFX versions.
//
// The new structure will consist of [Classes(ProgramHandler, ProgramData)],
// the Classes will be used for manipulating data through a Controller called [UI(CLI/JavaFX)]
// where we call the methods of the classes and then run it through either CLI or JavaFX depending on user preferences.
// A
// I will be making another repo for future
