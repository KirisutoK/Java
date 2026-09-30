package Applications.MileStoneTracker;

// Creation Date: August 21, 2026. at 12:04 AM
// Last Modified: September 30, 2026. at  6:10 PM

import Misc.DataManager;
import Misc.Logger;
import Misc.ReuseableMethodsCLI;
import Misc.FileManager;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.time.*;

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
    public boolean createFile(String FileName) throws IOException {
        // [SECURITY]
        if (CurrentMST_Data != null) {
            CurrentMST_Data.logOut();
            Logger.log("MileStoneTracker", FileManager.fileNameOnly(CurrentFile, 5), "{User: "+Username+"} has logged out."); // records the action into a log file.
        }

        //... UNDER `MileStoneTracker`, Check if it already exists in the list.
        File SaveFile = FileManager.createFile("MileStoneTracker", FileName); // NOTE: this method will return null if the filename already existed

        if (SaveFile != null) { // if the SaveFile is not null.
            //... c. Create the file and return true.
            CurrentMST_Data = new MileStoneTrackerData(Username, UserBirthday);
            CurrentFile = SaveFile;

            //... d. Serialize the data into the file
            FileManager.updateJsonFile(CurrentMST_Data, CurrentFile);

            // NOTE: We can use IntelliJ IDEA Debugging tool to find bugs and the process of the program.
            return true; // true means that it has successfully been created!
        }

        // NOTE: We can use IntelliJ IDEA Debugging tool to find bugs and the process of the program.
        //... a. Return false if it the createdsavefile is null (must be because it already exist or that something went wrong)
        return false; // false means that it did not work or something
    }
    public boolean setNewFilePassword(String Password) throws  IOException, NoSuchAlgorithmException {
        if (CurrentMST_Data.getEmptyPassword()) { // if the current file is an empty password.
            //... a. Create the password for the file.
            String HashedPassword = DataManager.hashPassword(Password); // NOTE: In order for this to run, it needs to do a security check before running the program.
            CurrentMST_Data.setPassword(HashedPassword);
            CurrentMST_Data.logIn(HashedPassword, Username); // this auto logIn's the current selected object as it is created

            //... b. Serialize the data into the file
            FileManager.updateJsonFile(CurrentMST_Data, CurrentFile);

            return true; // true means the process was successsfull
        }

        return false; // false means the process was not successful (password was not set).
    }
    public boolean loadFile(String Filename) throws IOException {
        // [SECURITY CHECK]
        CurrentFile = FileManager.getFile("MileStoneTracker", Filename);

        if (CurrentMST_Data != null) {
            CurrentMST_Data.logOut(); // Logs out so that if the CurrentMST_Data was not selected to the MST Object, it will show logged out for its JSON data.
            Logger.log("MileStoneTracker", FileManager.fileNameOnly(CurrentFile, 5), "{User: "+Username+"} has logged out."); // records the action into a log file.
        }
        if (CurrentFile == null) {
            resetCurrentFileData();
            return false; // False means that it did not load successfully
        }

        // [DESERIALIZATION]
        CurrentMST_Data = FileManager.getObject(CurrentFile ,MileStoneTrackerData.class);

        // NOTE: Dont forget to log in when loading the file in
        return true; // True means that it loaded successfully into MST
    }
    public boolean deleteSelectedFile(String Filename) {
        File SelectedFile = FileManager.getFile("MileStoneTracker", Filename);

        if (SelectedFile != null && SelectedFile.delete()) { // If it's SelectedFile is not null then run SelectedFile.delete();
            Logger.deleteLog("MileStoneTracker", Filename);
            return true;
        }

        return false;
    }
    public boolean deleteCurrentFile() {
        // NOTE: BEFORE CALLING THIS METHOD, IT MUST FIRST RUN A CONFIRMATION PROCESS

        if (CurrentFile.delete()) { // if the deletion is successful
            Logger.deleteLog("MileStoneTracker", FileManager.fileNameOnly(CurrentFile, 5));
            resetCurrentFileData();
            return true; // if it got deleted
        } else {  // if the file did not got deleted (or the deletion did not run)
            resetCurrentFileData();
            return false;
        }
    }

    // [DATA MANAGEMENT]
    public boolean addDayBasedMilestone(int day, String message) {
        return CurrentMST_Data.addDayBasedMilestone(day, message);
    }
    public boolean addAgeBasedMilestone(int age, String message) {
        return CurrentMST_Data.addAgeBasedMilestone(age, message);
    }
    public boolean removeDayBasedMilestone(int day) {
        return CurrentMST_Data.removeDayBasedMilestone(day);
    }
    public boolean removeAgeBasedMilestone(int age) {
        return CurrentMST_Data.removeAgeBasedMilestone(age);
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS


    //===========REUSABLE METHODS===========\\ NOTE: THIS ARE THE SPECIFIC METHODS THAT ARE REPEATEDLY USED ALL OVER THE PROGRAM


    // ================================================== OTHER CLASSES ================================================== \\
}