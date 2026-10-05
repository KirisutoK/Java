package Applications.SubscriptionTracker;

// Creation Date: August 21, 2026. at 12:03 AM
// Last Modified: October 05, 2026. at  4:50 PM

import Applications.Application;
import Misc.DataManager;
import Misc.FileManager;
import Misc.Logger;

import java.io.File;
import java.io.IOException; 
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

public class SubscriptionTracker implements Application {
    //=======VARIABLES=======//
    String Username;
    LocalDate UserBirthday;

    // [DYNAMIC VARIABLE]
    private SubscriptionTrackerData CurrentST_Data; // This will be the current selected object or data (Object)
    private File CurrentFile; // This will be the holder or container of that selected object or data (File)

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public SubscriptionTracker(String Username, LocalDate UserBirthday) {
        this.Username = Username;
        this.UserBirthday = UserBirthday;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public SubscriptionTrackerData getCurrentST_Data() {
        return CurrentST_Data;
    }
    public File getCurrentFile() {
        return CurrentFile;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    // [CLASS VARIABLE MANAGEMENT]
    public void resetCurrentFileData() {
        CurrentST_Data = null;
        CurrentFile = null;
    }
    public void setUsername(String Username) {
        this.Username = Username;
    }

    // [FILE MANAGEMENT]
    public boolean createFile(String FileName) throws IOException {
        // [SECURITY]
        if (CurrentST_Data != null) {
            CurrentST_Data.logOut();
            Logger.log("SubscriptionTracker", FileManager.fileNameOnly(CurrentFile, 5), "{User: "+Username+"} has logged out."); // records the action into a log file.
        }

        //... UNDER `SubscriptionTracker`, Check if it already exists in the list.
        File SaveFile = FileManager.createFile("SubscriptionTracker", FileName); // NOTE: this method will return null if the filename already existed

        if (SaveFile != null) { // if the SaveFile is not null.
            //... c. Create the file and return true.
            CurrentST_Data = new SubscriptionTrackerData(Username);
            CurrentFile = SaveFile;

            //... d. Serialize the data into the file
            FileManager.updateJsonFile(CurrentST_Data, CurrentFile);

            // NOTE: We can use IntelliJ IDEA Debugging tool to find bugs and the process of the program.
            return true; // true means that it has successfully been created!
        }

        // NOTE: We can use IntelliJ IDEA Debugging tool to find bugs and the process of the program.
        //... a. Return false if it the createdsavefile is null (must be because it already exist or that something went wrong)
        return false; // false means that it did not work or something
    }
    public boolean setNewFilePassword(String Password) throws IOException, NoSuchAlgorithmException {
        if (CurrentST_Data.getEmptyPassword()) { // if the current file is an empty password.
            //... a. Create the password for the file.
            String HashedPassword = DataManager.hashPassword(Password); // NOTE: In order for this to run, it needs to do a security check before running the program.
            CurrentST_Data.setPassword(HashedPassword);
            CurrentST_Data.logIn(HashedPassword, Username); // this auto logIn's the current selected object as it is created

            //... b. Serialize the data into the file
            FileManager.updateJsonFile(CurrentST_Data, CurrentFile);

            return true; // true means the process was successsfull
        }

        return false; // false means the process was not successful (password was not set).
    }
    public boolean loadFile(String Filename) throws IOException {
        // [SECURITY CHECK]
        CurrentFile = FileManager.getFile("SubscriptionTracker", Filename);

        if (CurrentST_Data != null) {
            CurrentST_Data.logOut(); // Logs out so that if the CurrentST_Data was not selected to the ST Object, it will show logged out for its JSON data. // CLAUDE: uncommented this — it was disabled while the log line below still claimed a logout happened
            Logger.log("SubscriptionTracker", FileManager.fileNameOnly(CurrentFile, 5), "{User: "+Username+"} has logged out.");
        }
        if (CurrentFile == null) {
            resetCurrentFileData();
            return false; // False means that it did not load successfully
        }

        // [DESERIALIZATION]
        CurrentST_Data = FileManager.getObject(CurrentFile , SubscriptionTrackerData.class);

        // NOTE: Dont forget to log in when loading the file in
        return true; // True means that it loaded successfully into MST
    }
    public boolean deleteSelectedFile(String Filename) {
        File SelectedFile = FileManager.getFile("SubscriptionTracker", Filename);

        if (SelectedFile != null && SelectedFile.delete()) { // If it's SelectedFile is not null then run SelectedFile.delete();
            Logger.deleteLog("SubscriptionTracker", Filename);
            return true;
        }

        return false;
    }
    public boolean deleteCurrentFile() {
        // NOTE: BEFORE CALLING THIS METHOD, IT MUST FIRST RUN A CONFIRMATION PROCESS

        if (CurrentFile.delete()) { // if the deletion is successful
            Logger.deleteLog("SubscriptionTracker", FileManager.fileNameOnly(CurrentFile, 5));
            resetCurrentFileData();
            return true; // if it got deleted
        } else {  // if the file did not got deleted (or the deletion did not run)
            resetCurrentFileData();
            return false;
        }
    }
    public boolean deleteAllFiles() {
        File[] SavedFiles = FileManager.getSavedFiles("SubscriptionTracker");

        // Security
        if (SavedFiles == null || SavedFiles.length == 1) {
            return false; // false means that the deletion process was not successful
        }

        // Deletion Process
        for (File f : SavedFiles) {
            if (CurrentFile != null) { // if we currently have a file
                if (!(f.getName().equals(CurrentFile.getName()))) { // if the f is not equal to the current file
                    Logger.deleteLog("SubscriptionTracker", FileManager.fileNameOnly(f, 5));
                    if (!f.delete()) { // if it did not get deleted
                        return false; // false means that the deletion process was not successful
                    }
                }
            } else { // If there is no current file yet.
                Logger.deleteLog("SubscriptionTracker", FileManager.fileNameOnly(f, 5));
                if (!f.delete()) { // if it did not get deleted
                    return false; // false means that something went wrong with the deletion
                }
            }
        }

        return true; // true means that a deletion process has been successful
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS


    // ================================================== OTHER CLASSES ================================================== \\
}

// INITIAL IDEA:
// A list of subscriptions or licenses each with a start date and duration — calculates expiry dates,
// flags what's expiring soon or already expired, and sorts by urgency.
// Reusable in any SaaS, license management, or reminder system.