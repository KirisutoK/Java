// Creation Date: September 15, 2026. at 3:29 PM
// Last Modified: September 16, 2026. at  5:47 PM

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        // [CREATING OBJECTS]
        Class Class01 = new Class("English");
        Class Class02 = new Class("Math");
        Class Class03 = new Class("Empty Class");

        // [ADDING STUDENTS TO AN CLASS OBJECT]
        Class01.addStudent("Christ Aerjil Dampog");
        Class01.addStudent("Stephanie Slusser");
        Class01.addStudent("Evelyn Mack");

        Class02.addStudent("Christian");
        Class02.addStudent("Kevin");
        Class02.addStudent("Avalyn");

        // [SAVE THE JSON]
        saveToJson(Class01, "SavedFile01");
        saveToJson(Class02, "SavedFile02");
        saveToJson(Class03, "SavedFile03");

        // [PRINT]
        System.out.println("++++++++++++++++++++++++++++CLASSES++++++++++++++++++++++++++++");
        Class01.displayInformation();
        System.out.println();
        Class02.displayInformation();
        System.out.println();
        Class03.displayInformation();
        System.out.println();

        // [LOAD THE JSON INTO AN OBJECT]
        Class03 = loadtoJson("SavedFile01");

        Class03.displayInformation();
        System.out.println();
        
        // [REMOVE A STUDENT IN A CLASS]
        Class03.removeStudent("Christ Aerjil Dampog");

        Class03.displayInformation();
        System.out.println();

        // [REMOVE A FILE]
        removeFile("SavedFile01");
    }

    // =========================== METHODS =========================== \\
    public static void saveToJson(Class c, String filename) {
        //... FIND DIRECTORY ON WHERE TO SAVE
        File JSON_Files = new File("JSON_Files");
        if (!JSON_Files.exists() || !JSON_Files.isDirectory()) {
            JSON_Files.mkdir();
        }

        //... SAVE THE FILE INTO THAT DIRECTORY
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
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
