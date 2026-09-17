// Creation Date: September 16, 2026. at 5:56 PM
// Last Modified: September 17, 2026. at  3:43 PM

import GSON_Adapters.DateTime_GSONAdapter;
import GSON_Adapters.Date_GSONAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        // [PERSON]
        Person P01 = new Person("Testing01", 19, LocalDate.of(2006, 12, 05));

        // [DISPLAY]
        P01.displayInformation();

        // [SAVE TO JSON]
        saveToJson(P01, "Test01");
    }

    // =========================== METHODS =========================== \\

    public static void saveToJson(Object c, String filename) {
        //... FIND DIRECTORY ON WHERE TO SAVE
        File JSON_Files = new File("JSON_Files");
        if (!JSON_Files.exists() || !JSON_Files.isDirectory()) {
            JSON_Files.mkdir();
        }

        //... SAVE THE FILE INTO THAT DIRECTORY
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new Date_GSONAdapter()).registerTypeAdapter(LocalDateTime.class, new DateTime_GSONAdapter()).setPrettyPrinting().create();
        File SaveFile = new File(JSON_Files, filename+".JSON");

        try (FileWriter fw = new FileWriter(SaveFile)) {
            SaveFile.createNewFile(); // creates the file
            gson.toJson(c, fw); // gathers the variables of the object and write it using `FileWriter` into the `SaveFile`
            // `fw` will close automatically
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Class loadtoJson(String filename) {
        // [FIND THE FILE]
        File JSON_Files = new File("JSON_Files");
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
        return gson.fromJson(JSON_Data, Class.class); // placeholder
    }
    public static void removeFile(String filename) {
        //... FIND DIRECTORY ON WHERE TO SAVE
        File JSON_Files = new File("JSON_Files");
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
}
