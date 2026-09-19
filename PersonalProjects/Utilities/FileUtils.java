// Creation Date: September 17, 2026. at 3:16 PM
// Last Modified: September 18, 2026. at  9:04 PM

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FileUtils {
    //========== GSON SERIALIZATION METHODS ==========\\
    public static void saveToJson(Object c, String filename) {
        //... FIND DIRECTORY ON WHERE TO SAVE
        File JSON_Files = new File("json_Files");
        if (!JSON_Files.exists() || !JSON_Files.isDirectory()) {
            JSON_Files.mkdir();
        }

        //... SAVE THE FILE INTO THAT DIRECTORY
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                // NOTE: If you have a variable of the class like LocalDate, you will need to create a TypeAdapter for serialization and deserialization
        File SaveFile = new File(JSON_Files, filename+".json");

        try (FileWriter fw = new FileWriter(SaveFile)) {
            SaveFile.createNewFile(); // creates the file
            gson.toJson(c, fw); // gathers the variables of the object and write it using `FileWriter` into the `SaveFile`
            // `fw` will close automatically
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Object loadtoJson(String filename) {
        // [FIND THE FILE]
        File JSON_Files = new File("json_Files");
        if (!JSON_Files.exists() || !JSON_Files.isDirectory()) {
            JSON_Files.mkdir();
            System.out.println("The file does not exist!");
            return null;
        }

        // [READ THE FILE]
        String JSON_Data = "";
        try {
            File[] JSON_SavedFiles = JSON_Files.listFiles();
            for (File f:JSON_SavedFiles) {
                if (f.getName().substring(0, f.getName().lastIndexOf('.')).equals(filename)) { // If the selected file is equal to filename
                    JSON_Data = Files.readString(Path.of(f.getPath()));
                    break; // stops the loop
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // [CONVERT THE STRING INTO AN OBJECT]
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                // NOTE: If you have a variable of the class like LocalDate, you will need to create a TypeAdapter for serialization and deserialization


        return gson.fromJson(JSON_Data, Object.class); // placeholder
    }

    //========== JAVA SERIALIZATION METHODS ==========\\
    public static void serializeFile(Object AMST_Data, File SaveFile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SaveFile))) { // enabling serialization to a file (Output)
            oos.writeObject(AMST_Data); // serialize the object into the file
        } catch (IOException e) {
            System.out.println("[ERROR: " + e.getClass().getSimpleName() + "] " + e.getMessage());
        }
    }

    //========== METHODS ==========\\

    public static void removeFile(String Folderpath, String filename) {
        // NOTE: This method checks if the filename exist in a directory
        // NOTE: This method originally only had the `filename` variable

        //... FIND DIRECTORY ON WHERE TO SAVE
        File JSON_Files = new File(Folderpath);
        if (!JSON_Files.exists() || !JSON_Files.isDirectory()) {
            JSON_Files.mkdir();
        }

        // [READ THE FILE]
        File[] JSON_SavedFiles = JSON_Files.listFiles();
        for (File f:JSON_SavedFiles) {
            if (f.getName().substring(0, f.getName().lastIndexOf('.')).equals(filename)) { // If the selected file is equal to filename
                f.delete();
                System.out.println(filename+" has been deleted!");
                break; // stops the loop
            }
        }
    }

    // [METADATA]
    public static String getDateCreated(File f) throws NoSuchFileException { // NOTE: <================= THIS IS NEW AND WAS NOT PART OF THE LESSON (THANKS TO CLAUDE FOR HELPING ME OUT GET METADATA INFORMATION FROM A FILE)
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
        } catch (NoSuchFileException e) {
            throw new NoSuchFileException(e.getMessage());
        } catch (IOException e) {
            System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
        }

        return null;
    }
    public static String getLastModified(File f) throws NoSuchFileException{
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
        } catch (NoSuchFileException e) {
            throw new NoSuchFileException(e.getMessage());
        } catch (IOException e) {
            System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
        }

        return null;
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

    // ================================================== OTHER CLASSES ================================================== \\
}
