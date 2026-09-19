package Classess;

// Creation Date: August 21, 2026. at 12:09 AM
// Last Modified: September 18, 2026. at  8:43 PM

import java.time.LocalDate;

import Classess.DayPlanner.DayPlanner;
import Classess.MileStoneTracker.MileStoneTracker;
import Classess.MultiTimeZoneMeetingPlanner.MultiTimeZoneMeetingPlanner;
import Classess.SubscriptionTracker.SubscriptionTracker;
import Classess.WorkHoursTracker.WorkHoursTracker;
import Misc.ReuseableMethods;

public class Menu {
    //=======VARIABLES=======//
    // [USER DATA]
    private String Username;
    private LocalDate UserBirthday;

    // [CLASSES OR APPLICATIONS]
    private static MileStoneTracker AMST;
    private static DayPlanner DP;
    private static MultiTimeZoneMeetingPlanner MTZMP;
    private static SubscriptionTracker ST;
    private static WorkHoursTracker WHT;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Menu() {
        // I made it empty so that I am able to create the object without having to always have a parameter,
        // this way I can use the method setBirthday() and setUsername() dynamically.
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void setBirthday(LocalDate UserBirthday) {
        this.UserBirthday = UserBirthday;
    }
    public void setUsername(String Username) {
        this.Username = Username;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public boolean MainMenu() {
        // DISPLAY
        System.out.println("╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                      DATE AND TIME CALCULATOR 1.0                      ║");
        System.out.println("╠════════════════════════════════════════════════════════════════════════╣");
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Username: "+Username, 74));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Birthday: "+ReuseableMethods.toStringBirthday(UserBirthday), 74));
        System.out.println("╟──[APPLICATIONS]────────────────────────────────────────────────────────╢");
        System.out.println("║ 1. MileStone Tracker                 4. Subscription Tracker (WIP)     ║");
        System.out.println("║ 2. Day Planner (WIP)                 5. Work Hours Tracker (WIP)       ║");
        System.out.println("║ 3. Multi-TimeZone Tracker (WIP)      6. Change Profile                 ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝");
        System.out.println();
        

        // PROCESSING INPUTS
        int Answer = ReuseableMethods.getAnswer(1, 6); // CustomUtil.getAnswer(start, end);

        // PROCESSING OUTPUTS
        switch (Answer) {
            case 1: // +[MILESTONE TRACKER]+
                // [SECURITY]
                if (AMST == null) { //... this is to avoid having to re-enter credentials again
                    AMST = new MileStoneTracker(Username, UserBirthday);
                } else if( AMST.getCurrentAMST_Data() != null && !(AMST.getCurrentAMST_Data().getPasswordPassed()) ) { // if the currentASMT_Data is not null and that the password is not passed (not logged in)
                    //... this is so that unauthorized users will not be able to see the file without having to log in again.
                    System.out.println("You currently have a file open in the Milestone Tracker Program, you will have to enter your password again for "+AMST.getCurrentFile().getName()+".");
                    System.out.println("[NOTE] input \"e\" to load the application with no current files open.");
                    System.out.println();
                    boolean ValidPassword = false;
                    while (!ValidPassword) {
                        System.out.print("Enter Password: ");
                        String UserInputPassword = ReuseableMethods.input.nextLine();
                        ValidPassword = AMST.getCurrentAMST_Data().logIn(UserInputPassword);

                        if (UserInputPassword.equals("e")) { // NOTE: Lowky dont know how to deal with this, initially planning to go back to selecting files but dont know how
                            AMST.resetCurrentFileData();
                            ValidPassword = true;
                        }
                    }
                }

                // [PROCESS] We need to add this so that every time a user changes their username/birthday in the main menu, it will also apply into AMST.
                AMST.setUsername(Username);
                AMST.setUserBirthday(UserBirthday);

                // [DISPLAY]
                boolean FeatureRunning = true;
                while (FeatureRunning) {
                    FeatureRunning = AMST.AMST_Menu(); //... This runs multiple process
                            //... Runs the Method
                            //... Returns boolean
                }

                break;
            case 2:
                System.out.println("This application is still in progress.");
                System.out.println();
                break;
            case 3:
                System.out.println("This application is still in progress.");
                System.out.println();
                break;
            case 4:
                System.out.println("This application is still in progress.");
                System.out.println();
                break;
            case 5:
                System.out.println("This application is still in progress.");
                System.out.println();
                break;
            case 6: // +[CHANGE PROFILE]+
                return false;
        }
        return true; // Only Case 6 of Switch(Answer) will return `false` since its an indication of "Stop" or "Running is False"
    }


    // [MileStoneTracker Methods]
    // [DayPlanner Methods]
    // [MultiTimeZoneMeetingPlanner Methods]
    // [SubscriptionTracker Methods]
    // [WorkHoursTracker Methods]


    // ================================================== OTHER CLASSES ================================================== \\
}

// INITIAL IDEA:
// This class will manage all the 4 classes and in the future objects too.