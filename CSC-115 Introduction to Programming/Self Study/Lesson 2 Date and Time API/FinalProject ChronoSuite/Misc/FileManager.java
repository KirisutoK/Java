package Misc;

// Creation Date: September 28, 2026. at 4:35 PM
// Last Modified: September 28, 2026. at  4:52 PM

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static Misc.ReuseableMethodsCLI.gson;

public class FileManager {
    //=======VARIABLES=======//

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public static void updateJsonFile(Object obj, File file) throws IOException {
        // NOTE: I feel like this might cause an error issue if something wrongs with any of the methods this method had been used on
        try (FileWriter fw = new FileWriter(file)) {
            gson.toJson(obj, fw);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
    public static File createFile(String Directory, String Filename){
        File MileStoneTrackerFolder = new File("Saves/"+Directory+"/Datas");
        if (!MileStoneTrackerFolder.exists() || MileStoneTrackerFolder.isFile()) { // if the path does not exists or there is an existing file called "Saves" then
            MileStoneTrackerFolder.mkdirs();
        }

        //... UNDER `MileStoneTracker`, Check if it already exists in the list.
        File SaveFile = new File(MileStoneTrackerFolder, Filename+".json"); // NOTE: `.AMST_Data` append so that every file will be a `.AMST_Data` file
        try {
            if (!SaveFile.exists() || SaveFile.isDirectory()) { // if the SaveFile does not exist or is currently a directory then.
                SaveFile.createNewFile();
                return SaveFile;
            }
        } catch (IOException e) {
            return null;
        }

        return null;
    }
    public static File loadFile(String Directory, String Filename) {
        File MileStoneTrackerFolder = new File("Saves/"+Directory+"/Datas");
        if (!MileStoneTrackerFolder.exists() || MileStoneTrackerFolder.isFile()) { // if the path does not exists or there is an existing file called "Saves" then
            MileStoneTrackerFolder.mkdirs();
        }

        //... UNDER `MileStoneTracker`, find if any filename matches
        File[] SavedFiles = MileStoneTrackerFolder.listFiles();
        if (SavedFiles == null || SavedFiles.length == 0) {
            return null;
        }
        for (File f:SavedFiles) {
            if (ReuseableMethodsCLI.fileNameOnly(f, 5).equals(Filename)) {
                return f;
            }
        }

        return null;
    }


    // ================================================== OTHER CLASSES ================================================== \\
}
