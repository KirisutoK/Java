package Applications.MileStoneTracker;

// Creation Date: November 27, 2026. at 11:30 PM
// Last Modified: November 27, 2026. at 11:30 PM

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import Misc.DataManager;
import Misc.ReuseableMethodsCLI;
import Misc.FileManager;
import Misc.Logger;
import com.google.gson.JsonSyntaxException;

public class MileStoneTrackerMenu {
    //=======VARIABLES=======//
    // [USER DATA]
    private String Username;
    private LocalDate UserBirthday;

    // [APPLICATION]
    private MileStoneTracker MST;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public MileStoneTrackerMenu(MileStoneTracker MST) {
        this.MST = MST;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void setUser(String Username, LocalDate UserBirthday) { // Menu.java calls this so the menu always has the latest profile
        this.Username = Username;
        this.UserBirthday = UserBirthday;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    // [MileStoneTracker Methods] ==============================================================================================<<<<<<<
    // +[MENUS]+
    public boolean MST_Menu() {
        // [DISPLAY]
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println("║                  MILESTONE TRACKER [ MENU ]                     ║");
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println(ReuseableMethodsCLI.softWrapping("║ Username: " + Username, 67));
        System.out.println(ReuseableMethodsCLI.softWrapping("║ Age: " + DataManager.getAge(UserBirthday), 67));
        if (MST.getCurrentFile() == null) {
            System.out.println(ReuseableMethodsCLI.lineAutoSpacing("║ Current File: NULL", 67));
        } else {
            System.out.println(ReuseableMethodsCLI.softWrapping("║ Current File: "+ FileManager.fileNameOnly(MST.getCurrentFile(), 5), 67));
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
                            if (MST.createFile(FileName)) {
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
                                MST.setNewFilePassword(Password);

                                //... FINISH TOUCH
                                System.out.println(FileName+" has been created!");
                                ReuseableMethodsCLI.log("MileStoneTracker", FileName, "{Author: "+MST.getCurrentMST_Data().getAuthor()+"} has created the file."); // records the action into a log file.
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
            case 2: // +[LOAD FILE]
                isRunningMethod = true;
                while (isRunningMethod) {
                    //... DISPLAY
                    if (!ReuseableMethodsCLI.printSavedFiles("MileStone Tracker" ,FileManager.getSavedFiles("MileStoneTracker"), MST.getCurrentFile())) {
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
                            if (MST.getCurrentFile() != null && FilenameAnswer.equals(FileManager.fileNameOnly(MST.getCurrentFile(), 5))) {
                                System.out.println("[ERROR] This file has already been loaded!");
                                System.out.println();
                                isRunningMethod = false;
                                ValidAnswer = true;
                                break;
                            }

                            //... LOAD THE FILE INTO THE MST OBJECT
                            if (!MST.loadFile(FilenameAnswer)) { // if it did not load
                                System.out.println(FilenameAnswer+" does not exist! please choose another file.");
                                continue;
                            }
                        } catch (JsonSyntaxException e) {
                            System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
                            MST.resetCurrentFileData(); // the file failed to load, so clear it
                            continue; // go back to "Choose File" instead of asking for a password
                        } catch (IOException e) {
                            System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
                            MST.resetCurrentFileData();
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
                                MST.resetCurrentFileData(); // since it was the data was loaded into the object but it was not logged in, it gotta be removed for security purposes.
                                System.out.println();
                                break; // exits out of the while loop (ValidPassword)
                            }

                            // Process
                            if (MST.getCurrentMST_Data().logIn(ReuseableMethodsCLI.hashPassword(Password), Username)) {
                                //... Runs the method and returns boolean

                                ValidPassword = true;
                                ValidAnswer = true;
                                isRunningMethod = false;

                                System.out.println(FilenameAnswer+" has been successfully loaded!");
                                ReuseableMethodsCLI.log("MileStoneTracker", FilenameAnswer, "{User: "+Username+"} has loaded the file.");
                                System.out.println();
                            } else {
                                System.out.println("[ERROR] Invalid Password");
                                System.out.println();
                            }
                        }
                    }
                }
                return true; // true means that this method will keep running due to a while loop of the caller.
            case 3: // +[VIEW FILE]
                // Security
                if (MST.getCurrentMST_Data() == null) {
                    System.out.println("[ERROR] There is currently no file at the moment.");
                    System.out.println();
                    return true; // true means that this method will keep running due to a while loop of the caller.
                }

                // Process
                isRunningMethod = true;
                while (isRunningMethod) {
                    isRunningMethod = MST_FileMenu();
                }
                return true; // true means that this method will keep running due to a while loop of the caller.
            case 4: // +[DELETE FILE]
                // Security
                File[] SavedFiles = FileManager.getSavedFiles("MileStoneTracker");
                if (MST.getCurrentFile() == null && (SavedFiles == null || SavedFiles.length == 0)) {
                    System.out.println("[ERROR] You currently do not have a Current File and Saved Files in the saved files Folder!");
                    System.out.println();
                    return true; // true means that this method will keep running due to a while loop of the caller.
                }

                // Process
                isRunningMethod = true;
                while (isRunningMethod) {
                    isRunningMethod = deleteFileConfirmationMST(SavedFiles);
                }

                return true; // true means that this method will keep running due to a while loop of the caller.
            case 5:
                if (MST.getCurrentMST_Data() != null) { // If its currently in.
                    MST.getCurrentMST_Data().logOut(); // logs it out
                    ReuseableMethodsCLI.log("MileStoneTracker", FileManager.fileNameOnly(MST.getCurrentFile(), 5), "{User: "+Username+"} has logged out."); // records the action into a log file.
                }
                return false; // false means it stopped running 
        }

        return true; // true means it's still running
    }
    public boolean MST_FileMenu() {
        try {
            ReuseableMethodsCLI.log("MileStoneTracker", FileManager.fileNameOnly(MST.getCurrentFile(), 5), "{User: "+Username+"} has viewed the file."); // records the action into a log file.

            // Error Check
            String DateCreation = FileManager.getDateCreated(MST.getCurrentFile()); // Note: this method throws an error so having this to be in the first process and catch early will not run any print as long as it catches.
            String LastModified = FileManager.getLastModified(MST.getCurrentFile()); // Note: this method throws an error so having this to be in the first process and catch early will not run any print as long as it catches.

            // Print
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("║                 MILESTONE TRACKER [ FILE MENU ]                 ║");
            System.out.println("╠═════════════════════════════════════════════════════════════════╣");
            System.out.println(ReuseableMethodsCLI.softWrapping("║ Author: " + MST.getCurrentMST_Data().getAuthor(), 67));
            System.out.println(ReuseableMethodsCLI.softWrapping("║ File Name: " + FileManager.fileNameOnly(MST.getCurrentFile(), 5), 67));
            System.out.println(ReuseableMethodsCLI.softWrapping("║ File Size: " + FileManager.formatFileSize(MST.getCurrentFile().length()), 67));
            System.out.println(ReuseableMethodsCLI.softWrapping("║ Date Created: " + DateCreation, 67));
            System.out.println(ReuseableMethodsCLI.softWrapping("║ Last Modified: " + LastModified, 67));
            System.out.println(ReuseableMethodsCLI.softWrapping("║ Last User: "+MST.getCurrentMST_Data().getLoggedUser(), 67));
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

            return false; // false means that this method will now stop running.
        } catch (IOException e) {
            System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
            return false; // false means that this method will now stop running.
        }

        // [PROCESSING INPUTS]
        int Answer = ReuseableMethodsCLI.getAnswer(1, 4);

        // [PROCESSING OUTPUTS]
        switch (Answer) {
            case 1:
                MST_displayData();
                ReuseableMethodsCLI.log("MileStoneTracker", FileManager.fileNameOnly(MST.getCurrentFile(), 5), "{User: "+Username+"} has viewed the data."); // records the action into a log file.
                return true; // true means that this method will keep running after this case finishes
            case 2:
                boolean isRunningAddMilestone = true;
                while (isRunningAddMilestone) {
                    isRunningAddMilestone = addMilestoneConfirmation();
                }
                return true; // true means that this method will keep running after this case finishes
            case 3:
                boolean isRunningRemoveMilestone = true;
                while (isRunningRemoveMilestone) {
                    isRunningRemoveMilestone = removeMilestoneConfirmation();
                }
                return true; // true means that this method will keep running after this case finishes
            case 4:
                return false; // false means that this method will now stop running.
        }

        return false; // false means that this method will now stop running.
    }
    // +[FILE MANAGEMENT]+
    public boolean deleteFileConfirmationMST(File[] SavedFiles) {
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
                    return false; // false means that this method will now stop running due to a while loop by the caller.
                }

                // Process
                if (ReuseableMethodsCLI.Confirmation("Delete Current File")) {
                    MST.deleteCurrentFile();
                }

                return false; // false means that this method will now stop running due to a while loop by the caller.
            case 2: // +[DELETE SELECTED FILE]+
                // DISPLAY
                ReuseableMethodsCLI.printSavedFiles("MileStone Tracker", FileManager.getSavedFiles("MileStoneTracker"), MST.getCurrentFile());

                // GATHER INPUT
                System.out.print("Choose File: ");
                String FileAnswer = ReuseableMethodsCLI.input.nextLine();
                if (FileAnswer.equals("e")) {
                    System.out.println();
                    return false; // false means that this method will now stop running due to a while loop by the caller.
                }

                // PROCESS
                if (MST.getCurrentFile() != null && FileAnswer.equals(FileManager.fileNameOnly(MST.getCurrentFile(), 5))) {
                    if (ReuseableMethodsCLI.Confirmation("Delete Current File")) {
                        MST.deleteCurrentFile();
                        return false; // false means that this method will now stop running due to a while loop by the caller.
                    }
                }

                for (File f: SavedFiles) {
                    if (FileManager.fileNameOnly(f, 5).equals(FileAnswer)) {
                        if (ReuseableMethodsCLI.Confirmation("Delete `"+FileAnswer+"` File") && MST.deleteSelectedFile(FileAnswer)) {
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
                    if (MST.getCurrentFile() != null) {
                        if (SavedFiles[0].getName().equals(MST.getCurrentFile().getName())) {
                            System.out.println("[ERROR] You only have a current file in your Saved Files Folder which can't be deleted.");
                            return false; // false means that this method will now stop running due to a while loop by the caller.
                        }
                    }
                }

                //... Process
                System.out.println("Note: `Delete All Saved File` will not delete your current File.");

                if (SavedFiles != null && ReuseableMethodsCLI.Confirmation("Delete All Saved Files")) {
                    for (File f : SavedFiles) {
                        if (MST.getCurrentFile() != null) { // if we currently have a file
                            if (!(f.getName().equals(MST.getCurrentFile().getName()))) { // if the f is not equal to the current file
                                Logger.deleteLog("MileStoneTracker", FileManager.fileNameOnly(f, 5));
                                if (!f.delete()) { // if it did not get deleted
                                    System.out.println("[ERROR] "+f.getName()+" did not get deleted!");
                                }
                            }
                        } else { // If there is no current file yet.
                            Logger.deleteLog("MileStoneTracker", FileManager.fileNameOnly(f, 5));
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
    // +[DATA MANAGEMENT]+
    public void MST_displayData() {
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println(ReuseableMethodsCLI.softWrapping("║ File Name: " + FileManager.fileNameOnly(MST.getCurrentFile(), 5) + ((MST.getCurrentMST_Data().AgeMilestoneIsEmpty() && MST.getCurrentMST_Data().DayMilestoneIsEmpty()) ? " (EMPTY)" : ""), 67));
        System.out.println("╟─────────────────────────────────────────────────────────────────╢");
        System.out.println(ReuseableMethodsCLI.softWrapping("║ Username: " + MST.getCurrentMST_Data().getAuthor(), 67));
        System.out.println(ReuseableMethodsCLI.softWrapping("║ Age: " + MST.getCurrentMST_Data().getAge(), 67));
        System.out.println(ReuseableMethodsCLI.softWrapping("║ Next Birthday: " + MST.getCurrentMST_Data().getNextBirthday(), 67));
        System.out.println(ReuseableMethodsCLI.softWrapping("║ Total Days Alive: " + MST.getCurrentMST_Data().getTotalDaysAlive(), 67));
        if (!MST.getCurrentMST_Data().DayMilestoneIsEmpty()) {
            System.out.println("╠═════════════════════════════════════════════════════════════════╣");
            System.out.println("║                         DAY MILESTONES                          ║");
            System.out.println("╟─────────────────────────────────────────────────────────────────╢");
            for (int d : MST.getCurrentMST_Data().getSortedDayKeys()) {
                System.out.println(ReuseableMethodsCLI.softWrapping("║ (Day: " + d + ") {Message: " + MST.getCurrentMST_Data().getDayMilestoneMessage(d) + "} ", 67));
            }
            System.out.println("║                                                                 ║");
        }
        if (!MST.getCurrentMST_Data().AgeMilestoneIsEmpty()) {
            System.out.println("╠═════════════════════════════════════════════════════════════════╣");
            System.out.println("║                         AGE MILESTONES                          ║");
            System.out.println("╟─────────────────────────────────────────────────────────────────╢");
            for (int a : MST.getCurrentMST_Data().getSortedAgeKeys()) {
                System.out.println(ReuseableMethodsCLI.softWrapping("║ (Age: " + a + ") {Message: " + MST.getCurrentMST_Data().getAgeMilestoneMessage(a) + "} ", 67));
            }
            System.out.println("║                                                                 ║");
        }
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println("║[NOTE] Input \"e\" to exit.                                        ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println();

        while (true) {
            System.out.print("Answer: ");
            String Answer = ReuseableMethodsCLI.input.nextLine();
            System.out.println();
            if (Answer.equals("e")) return;
        }
    }
    private boolean addMilestoneConfirmation() {
        // [DISPLAY]
        System.out.println("╔═══════════════════════════════════════════════════════════════════╗");
        System.out.println("║ Which milestone would you like to add?                            ║");
        System.out.println("╟───────────────────────────────────────────────────────────────────╢");
        System.out.println("║ 1. Age Milestone                                                  ║");
        System.out.println("║ 2. Day Milestone                                                  ║");
        System.out.println("║ 3. Go Back                                                        ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════╝");
        System.out.println();

        // [PROCESSING INPUT]
        int Answer = ReuseableMethodsCLI.getAnswer(1, 3);

        // [PROCESSING OUTPUT]
        boolean ValidInput = false;
        switch (Answer) {
            case 1: // +[AGE MILESTONE]+
                while (!ValidInput) {
                    try {
                        //... a. Processing Input
                        boolean ValidAgeInput = false;
                        int age = 0; // placeholder
                        while (!ValidAgeInput) {
                            System.out.print("Please enter an age: ");
                            age = ReuseableMethodsCLI.input.nextInt();

                            if (age < 0 || age > 130) {
                                System.out.println("[ERROR] Age can not be less than 0 or greater than 130");
                            } else {
                                ValidAgeInput = true;
                            }
                        }
                        ReuseableMethodsCLI.input.nextLine(); // this refreshes buffer
                        System.out.print("Please enter a message for the day: ");
                        String message = ReuseableMethodsCLI.input.nextLine();
                        System.out.println();

                        //... print
                        if (MST.getCurrentMST_Data().AgeMilestoneContains(age)) {
                            System.out.println("(Age: "+age+") {Message: "+message+"} has been successfully overwritten!");
                        } else {
                            System.out.println("(Age: "+age+") {Message: "+message+"} has been successfully added!");
                        }

                        //... b. Processing Output
                        ValidInput = MST.addAgeBasedMilestone(age, message);
                        FileManager.updateJsonFile(MST.getCurrentMST_Data(), MST.getCurrentFile());
                        ReuseableMethodsCLI.log("MileStoneTracker", FileManager.fileNameOnly(MST.getCurrentFile(), 5), "{User: "+Username+"} has added a new {Age: "+age+"} Milestone, with a message of {Message: "+message+"}."); // records the action into a log file.

                    } catch (InputMismatchException e) {
                        System.out.println("[ERROR: InputMismatchException] age must not be a letter, it must be a number or integer.");
                        System.out.println();
                        ReuseableMethodsCLI.input.nextLine(); // this refreshes buffer
                    } catch (IOException e) {
                        System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
                    }
                }

                return false; // false means that this method will now stop running (the caller of the method handles the boolean conditions)
            case 2:
                while (!ValidInput) {
                    try {
                        //... a. Processing Input
                        boolean ValidDayInput = false;
                        int day = 0; // placeholder
                        while (!ValidDayInput) {
                            System.out.print("Please enter a day: ");
                            day = ReuseableMethodsCLI.input.nextInt();

                            if (day < 0 || day > 45000) {
                                System.out.println("[ERROR] Day can not be less than 0 or greater than 45000 days");
                            } else {
                                ValidDayInput = true;
                            }
                        }
                        ReuseableMethodsCLI.input.nextLine(); // this refreshes buffer
                        System.out.print("Please enter a message for the day: ");
                        String message = ReuseableMethodsCLI.input.nextLine();
                        System.out.println();

                        //... print
                        if (MST.getCurrentMST_Data().DayMilestoneContains(day)) {
                            System.out.println("(Day: "+day+") {Message: "+message+"} has been successfully overwritten!");
                        } else {
                            System.out.println("(Day: "+day+") {Message: "+message+"} has been successfully added!");
                        }

                        //... b. Processing Output
                        ValidInput = MST.addDayBasedMilestone(day, message); // returns a boolean and processes data at the same time
                        ReuseableMethodsCLI.log("MileStoneTracker", FileManager.fileNameOnly(MST.getCurrentFile(), 5), "{User: "+Username+"} has added a new {Age: "+day+"} Milestone, with a message of {Message: "+message+"}."); // records the action into a log file.
                        FileManager.updateJsonFile(MST.getCurrentMST_Data(), MST.getCurrentFile());
                    } catch (InputMismatchException e) {
                        System.out.println("[ERROR: InputMismatchException] day must not be a letter, it must be a number or integer.");
                        System.out.println();
                        ReuseableMethodsCLI.input.nextLine(); // this refreshes buffer
                    } catch (IOException e) {
                        System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
                    }
                }

                return false; // false means that this method will now stop running (the caller of the method handles the boolean conditions)
            case 3:
                return false; // false means that this method will now stop running (the caller of the method handles the boolean conditions)
        }
        return true; // true means that this method will keep running (the caller of the method handles the boolean conditions)
    }
    private boolean removeMilestoneConfirmation() {
        // [DISPLAY]
        System.out.println("╔═══════════════════════════════════════════════════════════════════╗");
        System.out.println("║ Which milestone would you like to remove?                         ║");
        System.out.println("╟───────────────────────────────────────────────────────────────────╢");
        System.out.println("║ 1. Age Milestone                                                  ║");
        System.out.println("║ 2. Day Milestone                                                  ║");
        System.out.println("║ 3. Go Back                                                        ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════╝");
        System.out.println();

        // [PROCESSING INPUT]
        int Answer = ReuseableMethodsCLI.getAnswer(1, 3);

        // [PROCESSING OUTPUT]
        boolean ValidInput = false;
        switch (Answer) {
            case 1:
                // [SECURITY]
                if (MST.getCurrentMST_Data().AgeMilestoneIsEmpty()) {
                    System.out.println("There are currently no Age Milestones saved on this!"); // Note: might need to improve bit with this message
                    break;
                }

                // [PROCESS]
                while (!ValidInput) {
                    try {
                        //... a. showing display
                        printAgeMilestones(MST.getCurrentMST_Data());

                        //... b. Processing Input
                        System.out.print("Please enter a age: ");
                        int age = ReuseableMethodsCLI.input.nextInt();
                        ReuseableMethodsCLI.input.nextLine(); // this refreshes buffer

                        if (age == -1) {
                            System.out.println();
                            break;
                        }

                        if (MST.removeAgeBasedMilestone(age)) {
                            ValidInput = true;
                            System.out.println("age "+age+" has been successfully been removed!");

                            //... b. Serialization
                            ReuseableMethodsCLI.log("MileStoneTracker", FileManager.fileNameOnly(MST.getCurrentFile(), 5), "{User: "+Username+"} has removed {Age: "+age+"}."); // records the action into a log file.
                            FileManager.updateJsonFile(MST.getCurrentMST_Data(), MST.getCurrentFile());
                        } else {
                            System.out.println("age "+age+" does not exist!");
                        }

                        System.out.println();
                    } catch (InputMismatchException e) {
                        System.out.println("[ERROR: InputMismatchException] age must not be a letter, it must be a number or integer.");
                        System.out.println();
                        ReuseableMethodsCLI.input.nextLine(); // this refreshes buffer
                    } catch (IOException e) {
                        System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
                    }
                }

                return false; // false means that this method will now stop running (the caller of the method handles the boolean conditions)
            case 2:
                // [SECURITY]
                if (MST.getCurrentMST_Data().DayMilestoneIsEmpty()) {
                    System.out.println("There are currently no Day Milestones saved on this!"); // Note: might need to improve bit with this message
                    break;
                }

                // [PROCESS]
                while (!ValidInput) {
                    try {
                        //... a. Showing display
                        printDayMilestones(MST.getCurrentMST_Data());

                        //... b. Processing Input
                        System.out.print("Please enter a day: ");
                        int day = ReuseableMethodsCLI.input.nextInt();
                        ReuseableMethodsCLI.input.nextLine(); // this refreshes buffer

                        if (day == -1) {
                            System.out.println();
                            break;
                        }

                        if (MST.removeDayBasedMilestone(day)) {
                            ValidInput = true;
                            System.out.println("day "+day+" has been successfully been removed!");

                            //... b. Serialization
                            ReuseableMethodsCLI.log("MileStoneTracker", FileManager.fileNameOnly(MST.getCurrentFile(), 5), "{User: "+Username+"} has removed {Day: "+day+"}."); // records the action into a log file.
                            FileManager.updateJsonFile(MST.getCurrentMST_Data(), MST.getCurrentFile());
                        } else {
                            System.out.println("day "+day+" does not exist!");
                        }
                        System.out.println();

                    } catch (InputMismatchException e) {
                        System.out.println("[ERROR: InputMismatchException] day must not be a letter, it must be a number or integer.");
                        System.out.println();
                        ReuseableMethodsCLI.input.nextLine(); // this refreshes buffer
                    } catch (IOException e) {
                        System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
                    }
                }

                return false; // false means that this method will now stop running (the caller of the method handles the boolean conditions)
            case 3:
                return false; // false means that this method will now stop running (the caller of the method handles the boolean conditions)
        }
        return true; // true means that this method will keep running (the caller of the method handles the boolean conditions)
    }
    // +[PRINTS]+
    public void printDayMilestones(MileStoneTrackerData MST_Data) {
        // [PRINT]
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println("║                         DAY MILESTONES                          ║");
        System.out.println("╟─────────────────────────────────────────────────────────────────╢");
        for (int d: MST_Data.getSortedDayKeys()) {
            System.out.println(ReuseableMethodsCLI.softWrapping("║ (Day: "+d+") {Message: "+MST_Data.getDayMilestoneMessage(d)+"} ", 67));
        }
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println("║[NOTE] Input \"-1\" to exit.                                       ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println();
    }
    public void printAgeMilestones(MileStoneTrackerData MST_Data) {
        // [PRINT]
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println("║                         AGE MILESTONES                          ║");
        System.out.println("╟─────────────────────────────────────────────────────────────────╢");
        for (int a: MST_Data.getSortedAgeKeys()) {
            System.out.println(ReuseableMethodsCLI.softWrapping("║ (Age: "+a+") {Message: "+MST_Data.getAgeMilestoneMessage(a)+"} ", 67));
        }
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println("║[NOTE] Input \"-1\" to exit.                                       ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println();
    }

}
