package Applications.SubscriptionTracker;

// Creation Date: November 27, 2026. at 11:30 PM
// Last Modified: November 27, 2026. at 11:46 PM

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.security.NoSuchAlgorithmException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import Misc.DataManager;
import Misc.ReuseableMethodsCLI;
import Misc.FileManager;
import Misc.Logger;
import com.google.gson.JsonSyntaxException;

public class SubscriptionTrackerMenu {
    //=======VARIABLES=======//
    // [USER DATA]
    private String Username;

    // [APPLICATION]
    private SubscriptionTracker ST;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public SubscriptionTrackerMenu(SubscriptionTracker ST) {
        this.ST = ST;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void setUsername(String Username) { // Menu.java calls this so the menu always has the latest username
        this.Username = Username;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    // [SubscriptionTracker Methods] ============================================================================================<<<<<<
    // NOTE: MAKE SURE TO IMPLEMENT THE LOG LATER ON WHEN THE APPLICATION IS FINISHED OR YOU NEED TO DEBUG SOMETHING (EVEN THOUGH WE CAN US THE INTELLIJ IDEA DEBUGGER)
    // +[MENUS]+
    public boolean ST_Menu() {
        // DISPLAY
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println("║                  SUBSCRIPTION TRACKER [ MENU ]                  ║");
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println(ReuseableMethodsCLI.softWrapping("║ Username: " + Username, 67));
        if (ST.getCurrentFile() != null) {
            System.out.println(ReuseableMethodsCLI.softWrapping("║ Current File: "+FileManager.fileNameOnly(ST.getCurrentFile(), 5)+((ST.getCurrentST_Data().isEmpty()) ? " (EMPTY)" : ""), 67));
        }
        System.out.println("╟──[ACTIONS]──────────────────────────────────────────────────────╢");
        System.out.println("║ 1. Create File                                                  ║");
        System.out.println("║ 2. Load File                                                    ║");
        System.out.println("║ 3. View File                                                    ║");
        System.out.println("║ 4. Delete File                                                  ║");
        System.out.println("║ 5. Go Back                                                      ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println();

        // INPUT
        int Answer = ReuseableMethodsCLI.getAnswer(1, 5);

        // OUTPUT
        boolean isRunningMethod;
        switch (Answer) {
            case 1: // +[CREATE FILE]+
                isRunningMethod = true;
                while (isRunningMethod) {
                    // GET FILENAME INPUT
                    boolean validFile = false;
                    while (!validFile) {
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

                        try {
                            if (ST.createFile(FileName)) {
                                //... IF THE CREATION FILE RETURNS TRUE
                                //... CREATE PASSWORD
                                boolean validNewPassword = false;
                                String Password = ""; // just for placeholder
                                while (!validNewPassword) {
                                    System.out.print("Please enter a password for the data: ");
                                    Password = ReuseableMethodsCLI.input.nextLine();

                                    // [SECURITY]
                                    //    private final int minimumPassword = 5; // must have at least 5 characters
                                    //    private final int maximumPassword = 20; // must have at least 20 characters
                                    //    private final int specialCharactersPassword = 1; // must have at least 2 special characters
                                    //    private final int numbersPassword = 1; // must have at least 1 int characters

                                    validNewPassword = ReuseableMethodsCLI.passwordValidation(Password, 5, 20, 1, 1);
                                }

                                //... SET THE PASSWORD
                                ST.setNewFilePassword(Password);

                                //... FINISH TOUCH
                                System.out.println(FileName+" has been created!");
                                ReuseableMethodsCLI.log("SubscriptionTracker", FileName, "{Author: "+ST.getCurrentST_Data().getAuthor()+"} has created the file."); // records the action into a log file.
                                System.out.println();
                                isRunningMethod = false;
                                validFile = true;
                            } else {
                                System.out.println(FileName + " already exist! please try another name");
                            }
                        } catch (NoSuchAlgorithmException | IOException e) {
                            System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
                        }
                    }

                }
                return true; // true means that this method will keep running due to a while loop of the caller.
            case 2: // +[LOAD FILE]+
                isRunningMethod = true;
                while (isRunningMethod) {
                    //... DISPLAY
                    if (!ReuseableMethodsCLI.printSavedFiles("Subscription Tracker", FileManager.getSavedFiles("SubscriptionTracker"), ST.getCurrentFile())) {
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
                            if (ST.getCurrentFile() != null && FilenameAnswer.equals(FileManager.fileNameOnly(ST.getCurrentFile(), 5))) {
                                System.out.println("[ERROR] This file has already been loaded!");
                                System.out.println();
                                isRunningMethod = false;
                                ValidAnswer = true;
                                break;
                            }

                            //... LOAD THE FILE INTO THE ST OBJECT
                            if (!ST.loadFile(FilenameAnswer)) { // if it did not load
                                System.out.println(FilenameAnswer+" does not exist! please choose another file.");
                                continue;
                            }
                        } catch (JsonSyntaxException e) {
                            System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
                            ST.resetCurrentFileData(); // the file failed to load, so clear it
                            continue; // go back to "Choose File" instead of asking for a password
                        } catch (IOException e) {
                            System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
                            ST.resetCurrentFileData();
                            continue;
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
                                ST.resetCurrentFileData(); // since it was the data was loaded into the object but it was not logged in, it gotta be removed for security purposes.
                                System.out.println();
                                break; // exits out of the while loop (ValidPassword)
                            }

                            // Process
                            if (ST.getCurrentST_Data().logIn(ReuseableMethodsCLI.hashPassword(Password), Username)) {
                                //... Runs the method and returns boolean

                                ValidPassword = true;
                                ValidAnswer = true;
                                isRunningMethod = false;

                                System.out.println(FilenameAnswer+" has been successfully loaded!");
                                ReuseableMethodsCLI.log("SubscriptionTracker", FilenameAnswer, "{User: "+Username+"} has loaded the file.");
                                System.out.println();
                            } else {
                                System.out.println("[ERROR] Invalid Password");
                                System.out.println();
                            }
                        }
                    }
                }
                return true; // true means that this method will keep running due to a while loop of the caller.
            case 3: // +[VIEW FILE]+
                // Security
                if (ST.getCurrentFile() == null) {
                    System.out.println("[ERROR] There is currently no loaded file at the moment.");
                    System.out.println();
                    break;
                }

                // Process
                isRunningMethod = true;
                while (isRunningMethod) {
                    isRunningMethod = ST_FileMenu();
                }

                break;
            case 4: // +[DELETE FILE]+
                /// Security
                File[] SavedFiles = FileManager.getSavedFiles("SubscriptionTracker");
                if (ST.getCurrentFile() == null && (SavedFiles == null || SavedFiles.length == 0)) {
                    System.out.println("[ERROR] You currently do not have a Current File and Saved Files in the saved files Folder!");
                    System.out.println();
                    return true; // true means that this method will keep running due to a while loop of the caller.
                }

                // Process
                isRunningMethod = true;
                while (isRunningMethod) {
                    isRunningMethod = deleteFileConfirmationST(SavedFiles); // CLAUDE: named with an "ST" suffix since `deleteFileConfirmation(File[])` already exists for MST — same signature, needs a distinct name
                }

                return true; // true means that this method will keep running due to a while loop of the caller.
            case 5: // +[GO BACK]+
                if (ST.getCurrentFile() != null) {
                    ST.getCurrentST_Data().logOut();

                }

                return false; // false means that this method will now stop running because of the while loop from the caller
        }

        return true; // true means that this method will keep running because of the while loop from caller.
    }
    public boolean ST_FileMenu()  {
        try {
            ReuseableMethodsCLI.log("SubscriptionTracker", FileManager.fileNameOnly(ST.getCurrentFile(), 5), "{User: "+Username+"} has viewed the file."); // records the action into a log file.

            // Error Check
            String DateCreation = FileManager.getDateCreated(ST.getCurrentFile()); // Note: this method throws an error so having this to be in the first process and catch early will not run any print as long as it catches.
            String LastModified = FileManager.getLastModified(ST.getCurrentFile()); // Note: this method throws an error so having this to be in the first process and catch early will not run any print as long as it catches.

            // Print
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("║              SUBSCRIPTION TRACKER [ FILE MENU ]                 ║");
            System.out.println("╠═════════════════════════════════════════════════════════════════╣");
            System.out.println(ReuseableMethodsCLI.softWrapping("║ Author: " + ST.getCurrentST_Data().getAuthor(), 67));
            System.out.println(ReuseableMethodsCLI.softWrapping("║ Last User: " + ST.getCurrentST_Data().getLoggedUser(), 67));
            System.out.println(ReuseableMethodsCLI.softWrapping("║ File Name: " + FileManager.fileNameOnly(ST.getCurrentFile(), 5), 67));
            System.out.println(ReuseableMethodsCLI.softWrapping("║ File Size: " + FileManager.formatFileSize(ST.getCurrentFile().length()), 67));
            System.out.println(ReuseableMethodsCLI.softWrapping("║ Date Created: " + DateCreation, 67));
            System.out.println(ReuseableMethodsCLI.softWrapping("║ Last Modified: " + LastModified, 67));
            System.out.println("╟──[ACTIONS]──────────────────────────────────────────────────────╢ ");
            System.out.println("║ 1. View Subscriptions                                           ║");
            System.out.println("║ 2. Add Subscriptions                                            ║");
            System.out.println("║ 3. Remove Subscriptions                                         ║");
            System.out.println("║ 4. Go Back                                                      ║");
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
            System.out.println();
        } catch (NoSuchFileException e) {
            ST.resetCurrentFileData(); // turns currentfile and currentdata into null

            System.out.println("[ERROR] Current File has been either deleted or moved.");
            System.out.println();

            return false; // false means that this method will now stop running.
        } catch (IOException e) {
            System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
            return false; // false means that this method will now stop running.
        }

        // [PROCESSING INPUTS]
        int Answer = ReuseableMethodsCLI.getAnswer(1, 4);

        // [PROCESSING OUTPUTS]
        boolean methodRunning;
        switch (Answer) {
            case 1: // +[VIEW SUBSCRIPTIONS]+
                methodRunning = true;
                while (methodRunning) {
                    methodRunning = ST_ViewData();
                }
                return true; // true means that this method will keep running becasue of  the while loop from the caller.
            case 2: // +[ADD SUBSCRIPTIONS]+
                ST_AddSubscription();
                return true; // true means that this method will keep running becasue of  the while loop from the caller.
            case 3: // +[REMOVE SUBSCRIPTIONS]+
                ST_RemoveSubscription();
                return true; // true means that this method will keep running becasue of  the while loop from the caller.
            case 4:// +[GO BACK]+

                return false; // false means that this method will now stop running because of the while loop from the caller
        }

        return false; // false means that this method will now stop running because of the while loop from the caller
    }
    // +[FILE MANAGEMENT]+
    public boolean deleteFileConfirmationST(File[] SavedFiles) {
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
                if (ST.getCurrentFile() == null) {
                    System.out.println("[ERROR] There is currently no file at the moment.");
                    System.out.println();
                    return false; // false means that this method will now stop running due to a while loop by the caller.
                }

                // Process
                if (ReuseableMethodsCLI.Confirmation("Delete Current File")) {
                    ST.deleteCurrentFile();
                }

                return false; // false means that this method will now stop running due to a while loop by the caller.
            case 2: // +[DELETE SELECTED FILE]+
                // DISPLAY
                ReuseableMethodsCLI.printSavedFiles("SubscriptionTracker" ,FileManager.getSavedFiles("SubscriptionTracker"), ST.getCurrentFile());

                // GATHER INPUT
                System.out.print("Choose File: ");
                String FileAnswer = ReuseableMethodsCLI.input.nextLine();
                if (FileAnswer.equals("e")) {
                    System.out.println();
                    return false; // false means that this method will now stop running due to a while loop by the caller.
                }

                // PROCESS
                if (ST.getCurrentFile() != null && FileAnswer.equals(FileManager.fileNameOnly(ST.getCurrentFile(), 5))) {
                    if (ReuseableMethodsCLI.Confirmation("Delete Current File")) {
                        ST.deleteCurrentFile();
                        return false; // false means that this method will now stop running due to a while loop by the caller.
                    }
                }

                for (File f: SavedFiles) {
                    if (FileManager.fileNameOnly(f, 5).equals(FileAnswer)) {
                        if (ReuseableMethodsCLI.Confirmation("Delete `"+FileAnswer+"` File") && ST.deleteSelectedFile(FileAnswer)) {
                            System.out.println(FileAnswer+" has been successfully deleted!");
                            return false; // false means that this method will now stop running due to a while loop by the caller.
                        } else {
                            System.out.println("[ERROR] "+FileAnswer+" did not get deleted!");
                            return false; // false means that this method will now stop running due to a while loop by the caller.
                        }
                    }
                }
                System.out.println(FileAnswer+" does not exist!");
                System.out.println();
                return false; // false means that this method will now stop running due to a while loop by the caller.
            case 3: // +[DELETE ALL SAVED FILES]+
                //... Security
                if (SavedFiles.length == 1 ) { // Note: initially compared files but it was comparing the instance memory allocation instead of the content of the file
                    if (ST.getCurrentFile() != null) {
                        if (SavedFiles[0].getName().equals(ST.getCurrentFile().getName())) {
                            System.out.println("[ERROR] You only have a current file in your Saved Files Folder.");
                            System.out.println();
                            return false; // false means that this method will now stop running due to a while loop by the caller.
                        }
                    }
                }

                //... Process
                System.out.println("Note: `Delete All Saved File` will not delete your current File.");

                if (SavedFiles != null && ReuseableMethodsCLI.Confirmation("Delete All Saved Files")) {
                    for (File f : SavedFiles) {
                        if (ST.getCurrentFile() != null) { // if we currently have a file
                            if (!(f.getName().equals(ST.getCurrentFile().getName()))) { // if the f is not equal to the current file
                                Logger.deleteLog("SubscriptionTracker", FileManager.fileNameOnly(f, 5));
                                if (!f.delete()) { // if it did not get deleted
                                    System.out.println("[ERROR] "+f.getName()+" did not get deleted!");
                                }
                            }
                        } else { // If there is no current file yet.
                            Logger.deleteLog("SubscriptionTracker", FileManager.fileNameOnly(f, 5));
                            if (!f.delete()) { // if it did not get deleted
                                System.out.println("[ERROR] "+f.getName()+" did not get deleted!");
                            }
                        }
                    }
                    System.out.println("Delete All Saved File has successfully completed!");
                }
                System.out.println();

                return false; // false means that this method will now stop running due to a while loop by the caller.
            case 4:
                return false; // false means that this method will now stop running due to a while loop by the caller.
        }
        return false; // false means that this method will now stop running due to a while loop by the caller.
    }
    // +[DATA MANAGEMENT]
    public boolean ST_ViewData() {
        // [SECURITY]
        if (ST.getCurrentST_Data().isEmpty()) {
            System.out.println("[ERROR] "+FileManager.fileNameOnly(ST.getCurrentFile(), 5)+" is empty, it does not have any data (Subscriptions) inside.");
            System.out.println();
            return false; // false means that this method will now stop running becasue of the while loop from the caller.
        }

        // [PROCESS]
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println(ReuseableMethodsCLI.softWrapping("║ Current Date: "+DataManager.toStringDate(LocalDate.now(), "MMMM dd, yyyy") , 67));
        System.out.println(ReuseableMethodsCLI.softWrapping("║ Total Monthly Cost Due: $"+String.format("%.2f", ST.getCurrentST_Data().getTotalMonthlyCost()), 67));
        System.out.println(ReuseableMethodsCLI.softWrapping("║ Total Yearly Cost Due: $"+String.format("%.2f", ST.getCurrentST_Data().getTotalYearlyCost()), 67));
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println("║                         SUBSCRIPTIONS                           ║");
        System.out.println("╟─────────────────────────────────────────────────────────────────╢");
        SubscriptionPrint();
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println("║[NOTE] Input \"e\" to exit.                                        ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println();

        // [INPUT]
        String Answer = ReuseableMethodsCLI.input.nextLine();

        // [OUTPUT]
        if (Answer.equals("e")) {
            System.out.println();
            return false; // false means that this method will now stop running becasue of the while loop from the caller.
        }

        return true; // true means that this method will keep running becasue of  the while loop from the caller.
    }
    public boolean ST_AddSubscription() {
        // [INPUT]
        String SubscriptionName = null;
        double SubscriptionPrice = -1.0;
        int BillingCycle = -1;

        boolean ValidInput = false;
        while (!ValidInput) {
            boolean ValidSubscriptionName = false;
            while (!ValidSubscriptionName) {
                System.out.print("Subscription Name: ");
                SubscriptionName = ReuseableMethodsCLI.input.nextLine();

                // CHECK IF NAME ALREADY EXISTS
                ValidSubscriptionName = true;
                for (SubscriptionData SD: ST.getCurrentST_Data().getSubscriptions()) {
                    if (SD.getSubscriptionName().equals(SubscriptionName)) {
                        ValidSubscriptionName = false;
                        System.out.println("[ERROR] Subscription Name already exist! please create another Subscription Name that does not match existing Subscription Names.");
                        break;
                    }
                }
            }
            
            boolean ValidPrice = false;
            while (!ValidPrice) {
                try {
                    System.out.print("Price: ");
                    SubscriptionPrice = ReuseableMethodsCLI.input.nextDouble();
                    if (SubscriptionPrice <= 0) {
                        System.out.println("[ERROR] Subscription Price can not be less than or equal to 0");
                    } else {
                        ValidPrice = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("[ERROR: InputMismatchException] Subscription Price must be a number");
                    ReuseableMethodsCLI.input.nextLine(); // this refreshes buffer
                }
            }

            boolean ValidBillingCycle = false;
            while (!ValidBillingCycle) {
                try {
                    System.out.print("Billing Cycle (Days): ");
                    BillingCycle = ReuseableMethodsCLI.input.nextInt();
                    if (BillingCycle < 1) {
                        System.out.println("[ERROR] Billing Cycle (Days) can not be less than 1");
                    } else {
                        ValidBillingCycle = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("[ERROR: InputMismatchException] Billing Cycle must be a number");
                    ReuseableMethodsCLI.input.nextLine(); // this refreshes buffer
                }
            }

            ValidInput = true;
        }

        System.out.println("Is this subcription already started or it just started today?");
        System.out.println("1. Today");
        System.out.println("2. Already Started");
        System.out.println();

        int SubscriptionChoice = ReuseableMethodsCLI.getAnswer(1, 2);

        // [OUTPUT]
        switch(SubscriptionChoice) {
            case 1: // +[TODAY]+
                try {
                    ST.addSubscription(SubscriptionName, SubscriptionPrice, BillingCycle);
                    Logger.log("SubscriptionTracker", FileManager.fileNameOnly(ST.getCurrentFile(), 5), "{User: "+Username+"} has added subscription -> \""+SubscriptionName+"\"");
                    FileManager.updateJsonFile(ST.getCurrentST_Data(), ST.getCurrentFile());

                    System.out.println(SubscriptionName+" has been successfully added into [File: "+FileManager.fileNameOnly(ST.getCurrentFile(), 5)+"] ");
                    System.out.println();
                } catch (InputMismatchException e) {
                    System.out.println("[ERROR: InputMismatchException] "+e.getMessage());
                    System.out.println();
                    ReuseableMethodsCLI.input.nextLine(); // this refreshes buffer
                } catch (IOException e) {
                    System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
                    System.out.println();
                } catch (Exception e) {
                    System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
                }
                break;
            case 2: // +[ALREADY STARTED]+
                // [INPUT]
                LocalDate SubscriptionDateCreation = null;
                ValidInput = false;
                while (!ValidInput) { //! <====================================  NEED TO WORK ON THIS
                    try {
                        System.out.println("[NOTE] input \"e\" to exit");
                        System.out.println("[NOTE] (Month DayOfMonth Year) => ex: 12/05/2006");
                        System.out.print("Date Creation: ");
                        String SDC = ReuseableMethodsCLI.input.nextLine();

                        // IF EXIT
                        if (SDC.equals("e")) {
                            return false; // false means the add and creation of the subscription has been unsuccessful.
                        }

                        // LETS SPLIT THEM LINES AND CONVERT IT INTO INTEGERS THEN PASS IT ON
                        String[] Lines = SDC.split("/");

                        // ADD THE CONVERTED LINES INTO THE CONSTRUCTOR
                        SubscriptionDateCreation = LocalDate.of(Integer.parseInt(Lines[2]), Integer.parseInt(Lines[0]), Integer.parseInt(Lines[1]));

                        // PRINT
                        ValidInput = true;
                    } catch (DateTimeException e) {
                        System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] Please follow the Date Format which is `MM/DD/YYYY` or `Month/DayOfMonth/Year`.");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] You are missing the required numbers, please enter the Date Creation, separating with `/`.");
                    } catch (Exception e) {
                        System.out.println("[UNEXPECTED ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
                    } finally {
                        System.out.println();
                    }
                }

                // [OUTPUT]
                try {
                    if (ST.addSubscription(SubscriptionName, SubscriptionPrice, BillingCycle, SubscriptionDateCreation)) { // if it returned true (successfully added subscription)
                        System.out.println(SubscriptionName+" has been successfully added into [File: "+FileManager.fileNameOnly(ST.getCurrentFile(), 5)+"] ");
                        System.out.println();
                        Logger.log("SubscriptionTracker", FileManager.fileNameOnly(ST.getCurrentFile(), 5), "{User: "+Username+"} has added subscription -> \""+SubscriptionName+"\"");
                        FileManager.updateJsonFile(ST.getCurrentST_Data(), ST.getCurrentFile());
                        return true; // true means that the add and creation of the subscription has been successful.
                    } else {
                        System.out.println("[ERROR] "+SubscriptionName+" could not be added into [File: "+FileManager.fileNameOnly(ST.getCurrentFile(), 5)+"] ");
                        System.out.println();
                        Logger.log("SubscriptionTracker", FileManager.fileNameOnly(ST.getCurrentFile(), 5), "{User: "+Username+"} has failed to add subscription -> \""+SubscriptionName+"\"");
                        FileManager.updateJsonFile(ST.getCurrentST_Data(), ST.getCurrentFile());
                        return false; // false means that the add and creation of the subscription was unsuccessful.
                    }
                } catch (InputMismatchException e) {
                    System.out.println("[ERROR: InputMismatchException] "+e.getMessage());
                    System.out.println();
                    ReuseableMethodsCLI.input.nextLine(); // this refreshes buffer
                } catch (IOException e) {
                    System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
                    System.out.println();
                } catch (Exception e) {
                    System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
                }
        }

        return false;
    }
    public boolean ST_RemoveSubscription() {
        // [INPUT]
        System.out.println("╔═══[SUBSCRIPTIONS]═══════════════════════════════════════════════╗");
        SubscriptionPrint();
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println("║[NOTE] Input \"e\" to exit.                                        ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("Which Subscription would you like to remove? ");
        System.out.println();

        boolean ValidInput = false;
        while (!ValidInput) {
            System.out.print("Answer: ");
            String Answer = ReuseableMethodsCLI.input.nextLine();

            if (Answer.equals("e")) {
                System.out.println();
                return false;
            }

            SubscriptionData SelectedSD = ST.getCurrentST_Data().getSubscription(Answer);

            if (SelectedSD == null) {
                System.out.println("[ERROR] "+Answer+" does not exists!");
                System.out.println();
            } else {
                try {
                    ST.removeSubscription(SelectedSD);
                    System.out.println(Answer+" has been successfully deleted!");
                    System.out.println();
                    Logger.log("SubscriptionTracker", FileManager.fileNameOnly(ST.getCurrentFile(), 5), "{User: "+Username+"} has removed a subscription -> \""+Answer+"\"");
                    FileManager.updateJsonFile(ST.getCurrentST_Data(), ST.getCurrentFile());
                    ValidInput = true;
                    return true;
                } catch (IOException e) {
                    System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
                    ReuseableMethodsCLI.input.nextLine();
                }
            }
        }

        return false; // false means that it did not remove successfully
    }
    // +[PRINTS]+   
    public void SubscriptionPrint() {
        for (SubscriptionData SD : ST.getCurrentST_Data().getSubscriptions()) {
            System.out.println(ReuseableMethodsCLI.softWrapping("║ Subscription Name: "+SD.getSubscriptionName(), 67));
            System.out.println(ReuseableMethodsCLI.softWrapping("║ Creation Date: "+SD.getCreationDate(), 67));
            System.out.println(ReuseableMethodsCLI.softWrapping("║ Price: "+SD.getPrice(), 67));
            System.out.println(ReuseableMethodsCLI.softWrapping("║ Billing Cycle: "+SD.getBillingCycle(), 67));
            System.out.println("╟─────────────────────────────────────────────────────────────────╢");
        }
    }

}
