// Creation Date: September 12, 2026. at 3:32 PM
// Last Modified: September 13, 2026. at  9:08 PM

import com.google.gson.Gson;         // the core class you'll use
import com.google.gson.GsonBuilder; // needs this for pretty printing

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        Person Person01 = new Person("Christ", 19, true);
        Person01.addHobbies("Sleeping");
        Person01.addHobbies("Watching Anime");
        Person01.addHobbies("Playing video games");

        // [SERIALIZATION]
//        saveToFile(Person01, "Christ01");
//        saveToFilePrettyWriting(Person01, "Christ02");

        // [DESERIALIZATION]
        Person LoadedPerson01 = loadtoFile("Christ02");
        LoadedPerson01.displayInformation();
        System.out.println();

        Person LoadedPerson02 = loadtoFile("Christ01");
        LoadedPerson02.displayInformation();



    }

    // =========================== METHODS =========================== \\
    // [WRITING]
    public static void saveToFile(Person p, String filename) { //... Grabs the object, converts the object into string JSON, save the string into the file.
        Gson gson = new Gson(); // We need to initialize this so we can use Gson methods

        try {
            // [FILE CREATION] ...We need a file to save the string JSON into.
            File SavedFile = new File("JSON_Files", filename+".JSON"); // We will be creating files
            if (!SavedFile.exists()) {
                SavedFile.createNewFile();
            }

            // [SERIALIZATION] ...Enables the SavedFile to write and then uses gson to grab the object and FileWriter(file) to do the process.
            FileWriter fw = new FileWriter(SavedFile);
            gson.toJson(p, fw); // puts the string json formatted into the file.
            fw.close(); // NOTE: It is important to close so that the changes will be applied to the file.

            // [PRINT]
            System.out.println("OBJECT HAS BEEN SUCCESSFULLY SAVED INTO "+SavedFile.getName());
            System.out.println();
            System.out.println(gson.toJson(p));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void saveToFilePrettyWriting(Person p, String filename) { //... Grabs the object, converts the object into string JSON, save the string into the file.
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // This is a different type of initialization because we will be using a type of serializaition that enables better indexing for JSON files.

        try {
            // [FILE CREATION] ...We need a file to save the string JSON into.
            File SavedFile = new File("JSON_Files", filename+".JSON"); // We will be creating files
            if (!SavedFile.exists()) {
                SavedFile.createNewFile();
            }

            // [SERIALIZATION] ...Enables the SavedFile to write and then uses gson to grab the object and FileWriter(file) to do the process.
            FileWriter fw = new FileWriter(SavedFile);
            gson.toJson(p, fw);
            fw.close(); // NOTE: It is important to close so that the changes will be applied to the file.

            // [PRINT]
            System.out.println("OBJECT HAS BEEN SUCCESSFULLY SAVED INTO "+SavedFile.getName());
            System.out.println();
            System.out.println(gson.toJson(p));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // [READING]
    public static Person loadtoFile(String filename) {
        Gson gson = new Gson();
        String JSON_Data = ""; // Placeholder

        try {
            // [FINDING THE FILE]
            File SavedFolders = new File("JSON_Files");
            File SavedFile = null;
            filename = filename+".JSON";

            for (File f:SavedFolders.listFiles()) {
                if (filename.equals(f.getName())) {
                    SavedFile = new File(SavedFolders, f.getName());
                }
            }
            if (SavedFile == null) {
                System.out.println("File does not exist!");
                return null;
            }

            // [READING THE FILE CONTENT AND PUTTING IT INTO A STRING]
            JSON_Data = Files.readString(Path.of(SavedFile.getPath()));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // [USING THE STRING TO RETURN THE OBJECT]
        return gson.fromJson(JSON_Data, Person.class);
    }

}
