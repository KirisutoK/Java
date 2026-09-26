package Classess.MileStoneTracker;

// Creation Date: August 21, 2026. at 12:04 AM
// Last Modified: September 25, 2026. at 11:54 PM

import Misc.GSON_Adapters.GsonAdapter_Date;
import Misc.ReuseableMethodsCLI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.*;
import java.util.InputMismatchException;

public class MileStoneTracker {
    //=======VARIABLES=======//
    private String Username;
    private LocalDate UserBirthday;

    // [MISC]

    // [DYNAMIC VARIABLE]
    private MileStoneTrackerData CurrentMST_Data; // This will be the current selected object or data (Object)
    private File CurrentFile; // This will be the holder or container of that selected object or data (File)

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public MileStoneTracker(String Username, LocalDate UserBirthday) {
        this.Username = Username;
        this.UserBirthday = UserBirthday;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public MileStoneTrackerData getCurrentMST_Data() {
        return CurrentMST_Data;
    }
    public File getCurrentFile() {
        return CurrentFile;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    // [CLASS VARIABLE MANAGEMENT]
    public void resetCurrentFileData() {
        CurrentMST_Data = null;
        CurrentFile = null;
    }
    public void setUsername(String Username) {
        this.Username = Username;
    }
    public void setUserBirthday(LocalDate UserBirthday) {
        this.UserBirthday = UserBirthday;
    }

    // [FILE MANAGEMENT]
    public boolean createFile(String FileName) {
        // [SECURITY]
        if (CurrentMST_Data != null) {
            CurrentMST_Data.logOut();
        }

        //... UNDER `MileStoneTracker`, Check if it already exists in the list.
        File SaveFile = ReuseableMethodsCLI.createFile("MileStoneTracker", FileName); // NOTE: this method will return null if the filename already existed

        if (SaveFile != null) { // if the SaveFile is not null.
            //... c. Create the file and return true.
            CurrentMST_Data = new MileStoneTrackerData(Username, UserBirthday);
            CurrentFile = SaveFile;

            //... d. Serialize the data into the file
            ReuseableMethodsCLI.updateJsonFile(CurrentMST_Data, CurrentFile);

            // NOTE: We can use IntelliJ IDEA Debugging tool to find bugs and the process of the program.
            return true; // true means that it has successfully been created!
        }

        // NOTE: We can use IntelliJ IDEA Debugging tool to find bugs and the process of the program.
        //... a. Return false if it the createdsavefile is null (must be because it already exist or that something went wrong)
        return false; // false means that it did not work or something
    }
    public boolean setNewFilePassword(String Password) {
        if (CurrentMST_Data.getEmptyPassword()) { // if the current file is an empty password.
            //... a. Create the password for the file.
            String HashedPassword = ReuseableMethodsCLI.hashPassword(Password); // NOTE: In order for this to run, it needs to do a security check before running the program.
            CurrentMST_Data.setPassword(HashedPassword);
            CurrentMST_Data.logIn(HashedPassword); // this auto logIn's the current selected object as it is created

            //... b. Serialize the data into the file
            ReuseableMethodsCLI.updateJsonFile(CurrentMST_Data, CurrentFile);

            return true; // true means the process was successsfull
        }

        return false; // false means the process was not successful (password was not set).
    }
    public boolean loadFile(String Filename) throws IOException {
        // [SECURITY CHECK]
        CurrentFile = ReuseableMethodsCLI.loadFile("MileStoneTracker", Filename);

        if (CurrentMST_Data != null) {
            CurrentMST_Data.logOut(); // Logs out so that if the CurrentMST_Data was not selected to the MST Object, it will show logged out for its JSON data.
        }
        if (CurrentFile == null) {
            resetCurrentFileData();
            return false; // False means that it did not load successfully
        }

        // [DESERIALIZATION]
        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new GsonAdapter_Date()).create();
        String JSON_Data;
        try {
            JSON_Data = Files.readString(Path.of(CurrentFile.getPath()));
        } catch (IOException e) {
            throw new IOException();
        }
        CurrentMST_Data = gson.fromJson(JSON_Data, MileStoneTrackerData.class);

        // NOTE: Dont forget to log in when loading the file in
        return true; // True means that it loaded successfully into MST
    }
    public boolean deleteSelectedFile(String Filename) {
        File SelectedFile = ReuseableMethodsCLI.loadFile("MileStoneTracker", Filename);
        if (SelectedFile.delete()) {
            return true;
        }

        return false;
    }
    public boolean deleteCurrentFile() {
        // NOTE: BEFORE CALLING THIS METHOD, IT MUST FIRST RUN A CONFIRMATION PROCESS

        if (CurrentFile.delete()) { // if the deletion is successful
            resetCurrentFileData();
            return true; // if it got deleted
        } else {  // if the file did not got deleted (or the deletion did not run)
            resetCurrentFileData();
            return false;
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    // [MENUS]
    private boolean AMST_FileMenu() {

        // [PROCESSING OUTPUTS]
        int Answer = 0; // Placeholder
        boolean isRunning; // this variable is just a placeholder so that each cases can have the same name;
        switch (Answer) {
            case 1: // +[View Milestone]+

                break;
            case 2: // +[Add Milestone]+

                break;
            case 3: // +[Remove Milestone]+
                isRunning = true;
                while (isRunning) {
                    isRunning = removeMilestoneConfirmation();
                }
                break;
            case 4: // +[Go Back]+
                return false; // `false` means that this method will now stop running (there is a variable at AMST_Menu)
        }
        return true; // `true` means that this method will keep running
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
                if (CurrentMST_Data.AgeMilestoneIsEmpty()) {
                    System.out.println("There are currently no Age Milestones saved on this!"); // Note: might need to improve bit with this message
                    break;
                }

                // [PROCESS]
                while (!ValidInput) {
                    try {
                        //... a. showing display
                        CurrentMST_Data.printAgeMilestones();

                        //... b. Processing Input
                        System.out.print("Please enter a age: ");
                        int age = ReuseableMethodsCLI.input.nextInt();
                        ReuseableMethodsCLI.input.nextLine(); // this refreshes buffer

                        if (age == -1) {
                            System.out.println();
                            break;
                        }

                        ValidInput = CurrentMST_Data.removeAgeBasedMilestone(age);
                        System.out.println();
                    } catch (InputMismatchException e) {
                        System.out.println("[ERROR: InputMismatchException] day must not be a letter, it must be a number or integer.");
                        System.out.println();
                        ReuseableMethodsCLI.input.nextLine(); // this refreshes buffer
                    }
                }

                //... b. Serialization
                ReuseableMethodsCLI.updateJsonFile(CurrentMST_Data, CurrentFile);

                return false; // false means that this method will now stop running (the caller of the method handles the boolean conditions)
            case 2:
                // [SECURITY]
                if (CurrentMST_Data.DayMilestoneIsEmpty()) {
                    System.out.println("There are currently no Day Milestones saved on this!"); // Note: might need to improve bit with this message
                    break;
                }

                // [PROCESS]
                while (!ValidInput) {
                    try {
                        //... a. Showing display
                        CurrentMST_Data.printDayMilestones();

                        //... b. Processing Input   
                        System.out.print("Please enter a day: ");
                        int day = ReuseableMethodsCLI.input.nextInt();
                        ReuseableMethodsCLI.input.nextLine(); // this refreshes buffer

                        if (day == -1) {
                            System.out.println();
                            break;
                        }

                        ValidInput = CurrentMST_Data.removeDayBasedMilestone(day);
                        System.out.println();
                        
                    } catch (InputMismatchException e) {
                        System.out.println("[ERROR: InputMismatchException] day must not be a letter, it must be a number or integer.");
                        System.out.println();
                        ReuseableMethodsCLI.input.nextLine(); // this refreshes buffer
                    }
                }

                //... b. Serialization
                ReuseableMethodsCLI.updateJsonFile(CurrentMST_Data, CurrentFile);

                return false; // false means that this method will now stop running (the caller of the method handles the boolean conditions)
            case 3:
                return false; // false means that this method will now stop running (the caller of the method handles the boolean conditions)
        }
        return true; // true means that this method will keep running (the caller of the method handles the boolean conditions)
    }

    //===========REUSABLE METHODS===========\\ NOTE: THIS ARE THE SPECIFIC METHODS THAT ARE REPEATEDLY USED ALL OVER THE PROGRAM


    // ================================================== OTHER CLASSES ================================================== \\
}

// NOTE: I am kind of confused here because of the roadmap.
// NOTE: It says that i need to create another class for prompting inputs/outputs into the same level of Menu.class which is under Controller<CLI.
// NOTE: Is it so i can use this class for JavaFX? just keep the logic and the prompting just needs to be removed and redirected?