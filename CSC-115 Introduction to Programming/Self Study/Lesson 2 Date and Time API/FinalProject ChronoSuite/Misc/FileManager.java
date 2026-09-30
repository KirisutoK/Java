package Misc;

// Creation Date: September 28, 2026. at 4:35 PM
// Last Modified: September 30, 2026. at  5:40 PM

import Misc.GSON_Adapters.GsonAdapter_Date;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class FileManager {
    //=======VARIABLES=======//
    public static Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new GsonAdapter_Date()).create();

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public static File[] getSavedFiles(String ApplicationName) {
        return new File("Saves/"+ApplicationName+"/Datas").listFiles();
    }
    public static String fileNameOnly(File file, int TypeWidth) {
        return file.getName().substring(0, file.getName().length() - TypeWidth);
    }
    public static File getFile(String Directory, String Filename) {
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
            if (fileNameOnly(f, 5).equals(Filename)) {
                return f;
            }
        }

        return null;
    }
    public static <T> T getObject(File file, Class<T> object) throws IOException { // Note: <T> is called generic, it is used to determine objects similar to HashMaps
        try {
            String JSON_Data = Files.readString(Path.of(file.getPath()));
            return gson.fromJson(JSON_Data, object);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    // [METADATA]
    public static String getDateCreated(File f) throws IOException { // NOTE: <================= THIS IS NEW AND WAS NOT PART OF THE LESSON (THANKS TO CLAUDE FOR HELPING ME OUT GET METADATA INFORMATION FROM A FILE)
        DateTimeFormatter DTF = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mma");

        //... METADATA
        try {
            BasicFileAttributes metaData = Files.readAttributes(f.toPath(), BasicFileAttributes.class); // NOTE: <================= THIS IS NEW AND WAS NOT PART OF THE LESSON (THANKS TO CLAUDE FOR HELPING ME OUT GET METADATA INFORMATION FROM A FILE)
            // NOTE: ^ is a standard class similar to `Integer.class` or `String.class`.
            // LESSON LEARNED: NIO stands for New Input Output, its the advanced class for IO
            // LESSON LEARNED: BasicFileAttirbutes.class can read an attribute of a file.

            //... FORMATTING THE METADATA TO BE READABLE (METADATAS CONSIST OF LONG VALUES)
            LocalDateTime LDT = LocalDateTime.ofInstant(metaData.creationTime().toInstant(), ZoneId.systemDefault());
            return LDT.format(DTF);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
    public static String getLastModified(File f) throws IOException{
        DateTimeFormatter DTF = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mma");

        //... METADATA
        try {
            BasicFileAttributes metaData = Files.readAttributes(f.toPath(), BasicFileAttributes.class); // NOTE: <================= THIS IS NEW AND WAS NOT PART OF THE LESSON (THANKS TO CLAUDE FOR HELPING ME OUT GET METADATA INFORMATION FROM A FILE)
            // NOTE: ^ is a standard class similar to `Integer.class` or `String.class`.
            // LESSON LEARNED: NIO stands for New Input Output, its the advanced class for IO
            // LESSON LEARNED: BasicFileAttirbutes.class can read an attribute of a file.

            //... FORMATTING THE METADATA TO BE READABLE (METADATAS CONSIST OF LONG VALUES)
            LocalDateTime LDT = LocalDateTime.ofInstant(metaData.lastModifiedTime().toInstant(), ZoneId.systemDefault());
            return LDT.format(DTF);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
    public static String formatFileSize(long FileSize) { // NOTE: This method and it's formula is created by Claude (made some tweaks to make it readable to me)
        if (FileSize < 1024) {
            return FileSize + " B";
        } else if (FileSize < 1024 * 1024) {
            return String.format("%.2f KB", FileSize / 1024.0);
        } else {
            return String.format("%.2f MB", FileSize / (1024.0 * 1024.0));
        }
    }

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
    public static File createFile(String Directory, String Filename) throws IOException {
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
            throw new IOException(e);
        }

        return null;
    }


    // ================================================== OTHER CLASSES ================================================== \\
}
