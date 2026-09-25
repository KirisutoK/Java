package Controller.CLI;

// Creation Date: August 21, 2026. at 12:09 AM
// Last Modified: September 24, 2026. at 11:58 PM

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.time.DateTimeException;
import java.time.LocalDate;

import Classess.DayPlanner.DayPlanner;
import Classess.MileStoneTracker.MileStoneTracker;
import Classess.MultiTimeZoneMeetingPlanner.MultiTimeZoneMeetingPlanner;
import Classess.SubscriptionTracker.SubscriptionTracker;
import Classess.WorkHoursTracker.WorkHoursTracker;
import Misc.ReuseableMethodsCLI;

public class Menu {
    //=======VARIABLES=======//
    // [USER DATA]
    private String Username;
    private LocalDate UserBirthday;

    // [CLASSES OR APPLICATIONS]
    private MileStoneTracker MST;
    private DayPlanner DP;
    private MultiTimeZoneMeetingPlanner MTZMP;
    private SubscriptionTracker ST;
    private WorkHoursTracker WHT;

    // [USER CONDITIONS]
    private boolean LockUsername = false;
    private boolean LockBirthday = false;

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
        System.out.print("Enter Username: ");
        Username = ReuseableMethodsCLI.input.nextLine();
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
        System.out.println(ReuseableMethodsCLI.lineAutoSpacing("║ Username: "+Username, 74));
        System.out.println(ReuseableMethodsCLI.lineAutoSpacing("║ Birthday: "+ ReuseableMethodsCLI.toStringBirthday(UserBirthday), 74));
        System.out.println("╟──[APPLICATIONS]────────────────────────────────────────────────────────╢");
        System.out.println("║ 1. MileStone Tracker                 4. Subscription Tracker (WIP)     ║");
        System.out.println("║ 2. Day Planner (WIP)                 5. Work Hours Tracker (WIP)       ║");
        System.out.println("║ 3. Multi-TimeZone Tracker (WIP)      6. Change Profile                 ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝");
        System.out.println();
        

        // PROCESSING INPUTS
        int Answer = ReuseableMethodsCLI.getAnswer(1, 6); // CustomUtil.getAnswer(start, end);

        // PROCESSING OUTPUTS
        switch (Answer) {
            case 1: // +[MILESTONE TRACKER]+
                // [SECURITY]
                if (MST == null) { //... this is to avoid having to re-enter credentials again
                    MST = new MileStoneTracker(Username, UserBirthday);
                } else if( MST.getCurrentAMST_Data() != null && !(MST.getCurrentAMST_Data().getLoggedIn()) ) { // if the currentASMT_Data is not null and that the password is not passed (not logged in)
                    //... this is so that unauthorized users will not be able to see the file without having to log in again.
                    System.out.println("You currently have a file open in the Milestone Tracker Program, you will have to enter your password again for "+ MST.getCurrentFile().getName()+".");
                    System.out.println("[NOTE] input \"e\" to load the application with no current files open.");
                    System.out.println();
                    boolean ValidPassword = false;
                    while (!ValidPassword) {
                        System.out.print("Enter Password: ");
                        String UserInputPassword = ReuseableMethodsCLI.input.nextLine();
                        ValidPassword = MST.getCurrentAMST_Data().logIn(UserInputPassword);

                        if (UserInputPassword.equals("e")) { // NOTE: Lowky dont know how to deal with this, initially planning to go back to selecting files but dont know how
                            MST.resetCurrentFileData();
                            ValidPassword = true;
                        }
                    }
                }

                // [PROCESS] We need to add this so that every time a user changes their username/birthday in the main menu, it will also apply into AMST.
                MST.setUsername(Username);
                MST.setUserBirthday(UserBirthday);

                // [DISPLAY]
                boolean FeatureRunning = true;
                while (FeatureRunning) {
                    FeatureRunning = AMST_Menu(); //... This runs multiple process
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
    // +[MENUS]+
    public boolean AMST_Menu() {
        // [DISPLAY]
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println("║              AGE MILESTONE TRACKER [Launcher Menu]              ║");
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println(ReuseableMethodsCLI.softWrapping("║ Username: " + Username, 67));
        System.out.println(ReuseableMethodsCLI.softWrapping("║ Age: " + ReuseableMethodsCLI.getAge(UserBirthday), 67));
        if (MST.getCurrentFile() == null) {
            System.out.println(ReuseableMethodsCLI.lineAutoSpacing("║ Current File: NULL", 67));
        } else {
            System.out.println(ReuseableMethodsCLI.softWrapping("║ Current File: "+ ReuseableMethodsCLI.fileNameOnly(MST.getCurrentFile(), 5), 67));
        }
        System.out.println("╟──[ACTIONS]──────────────────────────────────────────────────────╢");
        System.out.println("║ 1. Create File                                                  ║");
        System.out.println("║ 2. Load File                                                    ║");
        System.out.println("║ 3. View File                                                    ║");
        System.out.println("║ 4. Delete File                                                  ║");
        System.out.println("║ 5. Go Back                                                      ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println();

        // [PROCESSING INPUTS]
        int Answer = ReuseableMethodsCLI.getAnswer(1, 5);

        // [PROCESSING OUTPUTS]
        boolean isRunningMethod; // this is just a place holder (I am trying to avoid using many instance of variables of boolean) since variables are shared throughout switch cases.
        switch (Answer) {
            case 1: // +[CREATE FILE]
                isRunningMethod = true;
                while (isRunningMethod) {
                    // GET FILENAME INPUT
                    boolean validFile = false;
                    while (validFile == false) {
                        // INPUT
                        System.out.println("Input \"e\" to exit.");
                        System.out.print("Enter File Name: ");
                        String FileName = ReuseableMethodsCLI.input.nextLine();

                        // Security
                        if (FileName.equals("e")) {
                            System.out.println();
                            isRunningMethod = false;
                            break;
                        }

                        if (MST.createFile(FileName)) {
                            //... IF THE CREATION FILE RETURNS TRUE
                            System.out.print("Please enter a password for the data: ");

                            //... CREATE PASSWORD
                            boolean validNewPassword = false;
                            String Password = ""; // just for placeholder
                            while (validNewPassword == false) {
                                Password = ReuseableMethodsCLI.input.nextLine();

                                // [SECURITY]
                                //    private final int minimumPassword = 5; // must have at least 5 characters
                                //    private final int maximumPassword = 20; // must have at least 20 characters
                                //    private final int specialCharactersPassword = 1; // must have at least 2 special characters
                                //    private final int numbersPassword = 1; // must have at least 1 int characters

                                validNewPassword = ReuseableMethodsCLI.passwordValidation(Password, 5, 20, 1, 1);
                            }

                            //... SET THE PASSWORD
                            MST.setNewFilePassword(Password);

                            //... FINISH TOUCH
                            System.out.println(FileName+" has been created!");
                            System.out.println();
                            isRunningMethod = false;
                            validFile = true;
                        } else {
                            System.out.println(FileName + " already exist! please try another name");
                        }
                    }
                }
                break;
            case 2: // +[LOAD FILE]
                isRunningMethod = true;
                while (isRunningMethod) {
                    //... DISPLAY
                    if (!ReuseableMethodsCLI.printSavedFiles(new File("Saves/MileStoneTracker").listFiles(), MST.getCurrentFile())) {
                        isRunningMethod = false;
                        continue;
                    }

                    //... GET INPUT
                    boolean ValidAnswer = false;
                    while (!ValidAnswer) {
                        String FilenameAnswer = "NULL";
                        try {
                            System.out.print("Choose File: ");
                            FilenameAnswer = ReuseableMethodsCLI.input.nextLine(); // get input

                            // security
                            if(FilenameAnswer.equals("e")) {
                                isRunningMethod = false;
                                ValidAnswer = true;
                                System.out.println();
                                break;
                            }

                            //... LOAD THE FILE INTO THE MST OBJECT
                            if (!MST.loadFile(FilenameAnswer)) { // if it did not load
                                System.out.println(FilenameAnswer+" does not exist! please choose another file.");
                                continue;
                            }
                        } catch (IOException e) {
                            System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
                        }

                        //... ENTER PASSWORD <======== LOGGING IN
                        boolean ValidPassword = false;
                        while (!ValidPassword) {
                            // Grab Input
                            System.out.print("Please enter password for "+FilenameAnswer+": ");
                            String Password = ReuseableMethodsCLI.input.nextLine();

                            // Security
                            if (Password.equals("e")) {
                                isRunningMethod = false;
                                ValidAnswer = true;
                                MST.resetCurrentFileData(); // since it was the data was loaded into the object but it was not logged in, it gotta be removed for security purposes.
                                System.out.println();
                                break; // exits out of the while loop (ValidPassword)
                            }

                            // Process
                            if (MST.getCurrentAMST_Data().logIn(ReuseableMethodsCLI.hashPassword(Password))) {
                                //... Runs the method and returns boolean

                                ValidPassword = true;
                                ValidAnswer = true;
                                isRunningMethod = false;

                                System.out.println(FilenameAnswer+" has been successfully loaded!");
                                System.out.println();
                            } else {
                                System.out.println("[ERROR] Invalid Password");
                                System.out.println();
                            }
                        }
                    }
                }
                break;
            case 3:

                break;
            case 4: // +[VIEW FILE]
                isRunningMethod = true;
                while (isRunningMethod) {
                    // DISPLAY
                    System.out.println("╔═══════════════════════════════════════════════════════════════════╗");
                    System.out.println("║ Please specify which type of delete method would you like to run? ║");
                    System.out.println("╟───────────────────────────────────────────────────────────────────╢");
                    System.out.println("║ 1. Delete Current File                                            ║");
                    System.out.println("║ 2. Delete Selected File                                           ║");
                    System.out.println("║ 3. Delete All Saved Files                                         ║");
                    System.out.println("║ 4. Go Back                                                        ║");
                    System.out.println("╚═══════════════════════════════════════════════════════════════════╝");
                    System.out.println();

                    int AnswerViewFile = ReuseableMethodsCLI.getAnswer(1, 4);

                    switch (AnswerViewFile) {
                        case 1: // +[DELETE CURRENT FILE]+
                            // Security
                            if (MST.getCurrentFile() == null) {
                                System.out.println("[ERROR] There is currently no file at the moment.");
                                System.out.println();
                                isRunningMethod = false;
                                break;
                            }

                            // Process
                            if (ReuseableMethodsCLI.Confirmation("Delete Current File")) {
                                MST.deleteCurrentFile();
                            }

                            isRunningMethod = false;
                            break;
                        case 2: // +[DELETE SELECTED FILE]+
                            // DISPLAY
                            ReuseableMethodsCLI.printSavedFiles(new File("Saves/MileStoneTracker").listFiles(), MST.getCurrentFile());

                            // GATHER INPUT
                            System.out.print("Choose File: ");
                            String FileAnswer = ReuseableMethodsCLI.input.nextLine();
                            if (FileAnswer.equals("e")) {
                                System.out.println();
                                isRunningMethod = false;
                                break;
                            }

                            // PROCESS
                            if (MST.getCurrentFile() != null && FileAnswer.equals(ReuseableMethodsCLI.fileNameOnly(MST.getCurrentFile(), 5))) {
                                if (ReuseableMethodsCLI.Confirmation("Delete Current File")) {
                                    MST.deleteCurrentFile();
                                    isRunningMethod = false;
                                    break;
                                } else {
                                    continue;
                                }
                            }

                            if (ReuseableMethodsCLI.Confirmation("Delete `"+FileAnswer+"` File") && MST.deleteSelectedFile(FileAnswer)) {
                                System.out.println(FileAnswer+" has been successfully deleted!");
                                isRunningMethod = false;
                            } else {
                                System.out.println("[ERROR] "+FileAnswer+" did not get deleted!");
                                isRunningMethod = false;
                            }

                            break;
                        case 3: //! +[DELETE CURRENT FILE]+ BUG: NULLPOINTER EXCEPTION, WHEN DELETING ALL FILES WITH ONLY THE CURRENT FILE LEFT
                            System.out.println("Note: `Delete All Saved File` will not delete your current File.");

                            File[] SavedFiles = MST.getCurrentFile().getParentFile().listFiles();
                            if (SavedFiles != null && ReuseableMethodsCLI.Confirmation("Delete All Saved Files")) {
                                for (File f : SavedFiles) {
                                    if (MST.getCurrentFile() != null) { // if we currently have a file
                                        if (!(f.getName().equals(MST.getCurrentFile().getName()))) { // if the f is equal to the current file
                                            if (!f.delete()) { // if it did not get deleted
                                                System.out.println("[ERROR] "+f.getName()+" did not get deleted!");
                                            }
                                        }
                                    } else { // If there is no current file yet.
                                        if (!f.delete()) { // if it did not get deleted
                                            System.out.println("[ERROR] "+f.getName()+" did not get deleted!");
                                        }
                                    }
                                }
                            }
                            System.out.println("Delete All Saved File has successfully completed!");
                            System.out.println();

                            isRunningMethod = false;
                            break;
                        case 4:
                            isRunningMethod = false;
                            break;
                    }
                }


                //! <==================================== YOU LEFT HERE (GOTTA ADD THE VIEW FILE NEXT AND TRY TO CREATE ATLEAST 2 REUSEABLE METHODS FOR BOTH CLI AND JAVAFX)
                break;
            case 5:

                return false; // false means it stopped running 
        }

        return true; // true means it's still running
    }
    private boolean AMST_FileMenu() {
        // [DISPLAY]
        try {
            // Error Check
            String DateCreation = ReuseableMethodsCLI.getDateCreated(MST.getCurrentFile()); // Note: this method throws an error so having this to be in the first process and catch early will not run any print as long as it catches.
            String LastModified = ReuseableMethodsCLI.getLastModified(MST.getCurrentFile()); // Note: this method throws an error so having this to be in the first process and catch early will not run any print as long as it catches.

            // Print
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("║                AGE MILESTONE TRACKER [FILE MENU]                ║");
            System.out.println("╠═════════════════════════════════════════════════════════════════╣");
            System.out.println(ReuseableMethodsCLI.softWrapping("║ Author: " + MST.getCurrentAMST_Data().getUsername(), 67));
            System.out.println(ReuseableMethodsCLI.softWrapping("║ Current File: " + ReuseableMethodsCLI.fileNameOnly(MST.getCurrentFile(), 5), 67));
            System.out.println(ReuseableMethodsCLI.softWrapping("║ File Size: " + ReuseableMethodsCLI.formatFileSize(MST.getCurrentFile().length()), 67));
            System.out.println(ReuseableMethodsCLI.softWrapping("║ Date Created: " + DateCreation, 67));
            System.out.println(ReuseableMethodsCLI.softWrapping("║ Last Modified: " + LastModified, 67));
            System.out.println("╟──[ACTIONS]──────────────────────────────────────────────────────╢ ");
            System.out.println("║ 1. View MileStones                                              ║");
            System.out.println("║ 2. Add MileStones                                               ║");
            System.out.println("║ 3. Remove MileStones                                            ║");
            System.out.println("║ 4. Go Back                                                      ║");
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
            System.out.println();
        } catch (NoSuchFileException e) {
            MST.resetCurrentFileData(); // turns currentfile and currentdata into null

            System.out.println("[ERROR] Current File has been either deleted or moved.");
            System.out.println();

            return false; // false means that this menu will stop running (called in the parent menu or in the AMST_Menu())
        }

        // [PROCESSING INPUTS]
        int Answer = ReuseableMethodsCLI.getAnswer(1, 4);

        // [PROCESSING OUTPUTS]
        boolean isRunning; // this variable is just a placeholder so that each cases can have the same name;
        switch (Answer) {
            case 1: // +[View Milestone]+

                break;
            case 2: // +[Add Milestone]+

                break;
            case 3: // +[Remove Milestone]+

                break;
            case 4: // +[Go Back]+
                return false; // `false` means that this method will now stop running (there is a variable at AMST_Menu)
        }
        return true; // `true` means that this method will keep running
    }

    // [DayPlanner Methods]
    // [MultiTimeZoneMeetingPlanner Methods]
    // [SubscriptionTracker Methods]
    // [WorkHoursTracker Methods]


    // ================================================== OTHER CLASSES ================================================== \\
}

// INITIAL IDEA:
// This class will manage all the 4 classes and in the future objects too.

//! STREAK, REMOVE THIS