// Creation Date: August 21, 2026. at 12:02 AM
// Last Modified: September 19, 2026. at 12:10 AM

import Controller.CLI.Menu;
import Misc.ReuseableMethods;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Launcher {
    // =========================== CLASS VARIABLES =========================== \\

    // [OBJECTS]
    private static Menu menu = new Menu();

    // [USER CONDITIONS]
    private static boolean LockUsername = false;
    private static boolean LockBirthday = false;

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        boolean ApplicationRunning = true;
        while (ApplicationRunning) {
            if (!LockUsername) {
                enterUsername();
                LockUsername = true;
            }
            if (!LockBirthday) {
                enterBirthday();
                LockBirthday = true;
            }


            boolean showingMenu = true;
            while (showingMenu) {
                showingMenu = menu.MainMenu(); //... This runs multiple process
                //... Runs menu.MainMenu()
                //... Returns boolean after the method
            }
            changeProfileMenu(); // this will only run if the user decided to choose the only answer that returns `false` which is the `Change Profile case`.
        }
    }

    // =========================== METHODS =========================== \\
    public static void enterUsername() {
        System.out.print("Enter Username: ");
        menu.setUsername(ReuseableMethods.input.nextLine());
        System.out.println();
    }
    public static void enterBirthday() {
        // PROCESS DATE INPUT
        boolean ValidInput = false;
        while (!ValidInput) {
            try {
                System.out.println("Please enter your Birthday: ");
                System.out.println("(Month DayOfMonth Year) => ex: 12/05/2006");
                System.out.print("Answer: ");
                String Birthday = ReuseableMethods.input.nextLine();

                // LETS SPLIT THEM LINES AND CONVERT IT INTO INTEGERS THEN PASS IT ON
                String[] Lines = Birthday.split("/");

                // ADD THE CONVERTED LINES INTO THE CONSTRUCTOR
                LocalDate UserBirthday = LocalDate.of(Integer.parseInt(Lines[2]), Integer.parseInt(Lines[0]), Integer.parseInt(Lines[1]));
                if (!(UserBirthday.isAfter(LocalDate.now()))) {
                    menu.setBirthday(UserBirthday);
                    ValidInput = true;
                } else {
                    System.out.println("[ERROR] User Birthday must not be after today's date.");
                }
            } catch (DateTimeException e) {
                System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] Please follow the Date Format which is `MM/DD/YY` or `Month/DayOfMonth/Year`.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] You are missing the required numbers, please enter your Birthday, separating with `/`.");
            } catch (Exception e) {
                System.out.println("[UNEXPECTED ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }
    private static void changeProfileMenu() {
        // DISPLAY
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║ Which information would you like to change?       ║");
        System.out.println("╟───────────────────────────────────────────────────╢");
        System.out.println("║ 1. Username                                       ║");
        System.out.println("║ 2. Birthday                                       ║");
        System.out.println("║ 3. Username & Birthday                            ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");
        System.out.println();

        // PROCESSING INPUT
        int Answer = ReuseableMethods.getAnswer(1, 3);

        // PROCESSING OUTPUTS
        switch (Answer) {
            case 1:
                LockUsername = false;
                break;
            case 2:
                LockBirthday = false;
                break;
            case 3:
                LockUsername = false;
                LockBirthday = false;
                break;

        }

    }
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
