// Creation Date: August 21, 2026. at 12:09 AM
// Last Modified: November 27, 2026. at 11:20 PM

import java.time.DateTimeException;
import java.time.LocalDate;

import Applications.MileStoneTracker.MileStoneTracker;
import Applications.MileStoneTracker.MileStoneTrackerMenu;
import Applications.SubscriptionTracker.SubscriptionTracker;
import Applications.SubscriptionTracker.SubscriptionTrackerMenu;
import Applications.WorkHoursTracker.WorkHoursTracker;
import Misc.DataManager;
import Misc.ReuseableMethodsCLI;
import Misc.FileManager;

public class Menu {
    //=======VARIABLES=======//
    // [USER DATA]
    private String Username;
    private LocalDate UserBirthday;

    // [CLASSES OR APPLICATIONS]
    private MileStoneTracker MST;
    private SubscriptionTracker ST;
    private WorkHoursTracker WHT;

    // [APPLICATION MENUS]
    private MileStoneTrackerMenu MSTMenu;
    private SubscriptionTrackerMenu STMenu;

    // [USER CONDITIONS]
    private boolean LockUsername = false;
    private boolean LockBirthday = false;

    //==================ENTRY POINT==================\\ NOTE: THIS IS WHERE THE PROGRAM STARTS (Launcher.java used to do this)
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.Main();
    }

    //==================MAIN==================\\ NOTE: THIS IS A PSUEDO MAIN METHOD, CALLING THIS METHOD WILL RUN A SEQUENCES OF METHODS (ALMOST LIKE THE STANDARD MAIN)
    public void Main() { // NOTE: This is a psuedo main method similar to what we used. we just have to call this method and the whole program will run in CLI.
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
                showingMenu = MainMenu(); //... This runs multiple process
                //... Runs menu.MainMenu()
                //... Returns boolean after the method
            }
            changeProfileMenu(); // this will only run if the user decided to choose the only answer that returns `false` which is the `Change Profile case`.
        }
    }

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Menu() {
        // I made it empty so that I am able to create the object without having to always have a parameter,
        // this way I can use the method setBirthday() and setUsername() dynamically.
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    void enterUsername() {
        boolean validUsername = false;
        while (!validUsername) {
            System.out.print("Enter Username: ");
            Username = ReuseableMethodsCLI.input.nextLine();

            if (Username.length() > 30) {
                System.out.println("[ERROR] Username can not be longer than 20 characters");
            } else {
                validUsername = true;   
            }
        }
        System.out.println();
    }
    void enterBirthday() {
        // PROCESS DATE INPUT
        boolean ValidInput = false;
        while (!ValidInput) {
            try {
                System.out.println("Please enter your Birthday: ");
                System.out.println("(Month DayOfMonth Year) => ex: 12/05/2006");
                System.out.print("Answer: ");
                String Birthday = ReuseableMethodsCLI.input.nextLine();

                // LETS SPLIT THEM LINES AND CONVERT IT INTO INTEGERS THEN PASS IT ON
                String[] Lines = Birthday.split("/");

                // ADD THE CONVERTED LINES INTO THE CONSTRUCTOR
                LocalDate UserBirthday = LocalDate.of(Integer.parseInt(Lines[2]), Integer.parseInt(Lines[0]), Integer.parseInt(Lines[1]));
                if (!(UserBirthday.isAfter(LocalDate.now()))) {
                    this.UserBirthday = UserBirthday;
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
    void changeProfileMenu() {
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
        int Answer = ReuseableMethodsCLI.getAnswer(1, 3);

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

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    boolean MainMenu() {
        // DISPLAY
        System.out.println("╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                            ChronoSuite 1.0                             ║");
        System.out.println("╠════════════════════════════════════════════════════════════════════════╣");
        System.out.println(ReuseableMethodsCLI.softWrapping("║ Username: "+Username, 74));
        System.out.println(ReuseableMethodsCLI.lineAutoSpacing("║ Birthday: "+ DataManager.toStringBirthday(UserBirthday), 74));
        System.out.println("╟──[APPLICATIONS]────────────────────────────────────────────────────────╢");
        System.out.println("║ 1. MileStone Tracker                 3. Subscription Tracker           ║");
        System.out.println("║ 2. Work Hours Tracker (WIP)          4. Change Profile                 ║");
        System.out.println("╠════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ By: Christ Aerjil C. Dampog                            August 28, 2026 ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝");
        System.out.println();


        // PROCESSING INPUTS
        int Answer = ReuseableMethodsCLI.getAnswer(1, 6); // CustomUtil.getAnswer(start, end);

        // PROCESSING OUTPUTS
        boolean FeatureRunning;
        switch (Answer) {
            case 1: // +[MILESTONE TRACKER]+
                // [SECURITY]
                if (MST == null) { //... this is to avoid having to re-enter credentials again
                    MST = new MileStoneTracker(Username, UserBirthday);
                    MSTMenu = new MileStoneTrackerMenu(MST);
                } else if( MST.getCurrentMST_Data() != null && !(MST.getCurrentMST_Data().getLoggedIn()) ) { // if the currentASMT_Data is not null and that the password is not passed (not logged in)
                    //... this is so that unauthorized users will not be able to see the file without having to log in again.
                    System.out.println("You currently have a file open in the Milestone Tracker Application, you will have to enter your password again for "+ FileManager.fileNameOnly(MST.getCurrentFile(), 5)+".");
                    System.out.println("[NOTE] input \"e\" to load the application with no current files open.");
                    System.out.println();
                    boolean ValidPassword = false;
                    while (!ValidPassword) {
                        System.out.print("Enter Password: ");
                        String UserInputPassword = ReuseableMethodsCLI.input.nextLine();
                        if (MST.getCurrentMST_Data().logIn(ReuseableMethodsCLI.hashPassword(UserInputPassword), Username)) {
                            ReuseableMethodsCLI.log("MileStoneTracker", FileManager.fileNameOnly(MST.getCurrentFile(), 5), "{User: "+Username+"} has logged in."); // records the action into a log file.

                            ValidPassword = true;
                            System.out.println();
                        } else {
                            System.out.println("[ERROR] Invalid Password");
                        }

                        if (UserInputPassword.equals("e")) { // NOTE: Lowky dont know how to deal with this, initially planning to go back to selecting files but dont know how
                            MST.resetCurrentFileData();
                            ValidPassword = true;
                        }
                    }
                }

                // [PROCESS] We need to add this so that every time a user changes their username/birthday in the main menu, it will also apply into AMST.
                MST.setUsername(Username);
                MST.setUserBirthday(UserBirthday);
                MSTMenu.setUser(Username, UserBirthday);

                // [DISPLAY]
                FeatureRunning = true;
                while (FeatureRunning) {
                    FeatureRunning = MSTMenu.MST_Menu(); //... This runs multiple process
                            //... Runs the Method
                            //... Returns boolean
                }

                break;
            case 2: // +[WORK HOURS TRACKER]+
                System.out.println("This application is still in progress.");
                System.out.println();
                break;
            case 3: // +[SUBSCRIPTION TRACKER]+
                // [SECURITY]
                if (ST == null) {
                    ST = new SubscriptionTracker(Username, UserBirthday);
                    STMenu = new SubscriptionTrackerMenu(ST);
                } else if (ST.getCurrentST_Data() != null && !ST.getCurrentST_Data().getLoggedIn()){ // If we currently have an open file and it's logged out
                    //... this is so that unauthorized users will not be able to see the file without having to log in again.
                    System.out.println("You currently have a file open in the Subscription Tracker Application, you will have to enter your password again for "+ FileManager.fileNameOnly(ST.getCurrentFile(), 5)+".");
                    System.out.println("[NOTE] input \"e\" to load the application with no current files open.");
                    System.out.println();
                    boolean ValidPassword = false;
                    while (!ValidPassword) {
                        System.out.print("Enter Password: ");
                        String UserInputPassword = ReuseableMethodsCLI.input.nextLine();

                        if (UserInputPassword.equals("e")) { // NOTE: Lowky dont know how to deal with this, initially planning to go back to selecting files but dont know how
                            ST.resetCurrentFileData();
                            ValidPassword = true;
                        } else if (ST.getCurrentST_Data().logIn(ReuseableMethodsCLI.hashPassword(UserInputPassword), Username)) { // If it matches
                            ReuseableMethodsCLI.log("SubscriptionTracker", FileManager.fileNameOnly(ST.getCurrentFile(), 5), "{User: "+Username+"} has logged in."); // records the action into a log file.

                            ValidPassword = true;
                            System.out.println();
                        } else {
                            System.out.println("[ERROR] Invalid Password");
                        }
                    }
                }

                // [PROCESS] We need to add this so that every time a user changes their username/birthday in the main menu, it will also apply into AMST.
                ST.setUsername(Username);
                STMenu.setUsername(Username);

                // [DISPLAY]
                FeatureRunning = true;
                while (FeatureRunning) {
                    FeatureRunning = STMenu.ST_Menu();  //... This runs multiple process
                            //... Runs the Method
                            //... Returns boolean
                }

                break;
            case 4: // +[CHANGE PROFILE]+
                return false;
        }
        return true; // Only Case 6 of Switch(Answer) will return `false` since its an indication of "Stop" or "Running is False"
    }

    // [DayPlanner Methods] ====================================================================================================<<<<<<<

    // [MultiTimeZoneMeetingPlanner Methods] ===================================================================================<<<<<<<

    // [WorkHoursTracker Methods] ==============================================================================================<<<<<<<


    // ================================================== OTHER CLASSES ================================================== \\
}

// INITIAL IDEA:
// This class will manage all the 4 classes and in the future objects too.

// [INITIAL IDEAS FROM Launcher.java]
// [INITIAL IDEA 1.2:]
// Add an exception if a user decides to exit the application because our application is running in an infinite while lopp.
// [INITIAL IDEA 1.3:]
// Add AES Encryption, Hashing Password
// I am currently using a raw password String and users are able to see it throught the object file.
// This whole cryptography thing will be a whole entire different thing so I am planning to learn it after I finish this project.
// Add AES Encryption, Hashing Password
// I am currently using a raw password String and users are able to see it throught the object file.
// This whole cryptography thing will be a whole entire different thing so I am planning to learn it after I finish this project.
