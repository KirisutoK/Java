// Creation Date: September 15, 2026. at 2:12 PM
// Last Modified: September 15, 2026. at  3:26 PM

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ClothesManager {
    //=======VARIABLES=======//
    private File JSON_File;
    private Clothes Cloth;
    private ArrayList<Clothes> Clothings;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public ClothesManager() {
        Clothings = new ArrayList<>();
    }
    public ClothesManager(File JSON_File, ArrayList<Clothes> Clothings) {
        this.JSON_File = JSON_File;
        this.Clothings = Clothings;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public File getFile() {
        return JSON_File;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    // [VARIABLE MANAGEMENT]
    public void changeClothColor(String color) {
        Cloth.changeColor(color);
        updateFile();
    }
    public void changeClothBrand(String brand) {
        Cloth.changeBrand(brand);
        updateFile();
    }
    public void changeClothSize(String size, String filename) {
        Cloth.changeSize(size);
        updateFile();
    }
    public void changeClothType(String type) {
        Cloth.changeType(type);
        updateFile();
    }

    // [FILE MANAGEMENT]
    private void updateFile() {
        try (FileWriter fw = new FileWriter(JSON_File)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(Cloth, fw);
            // the fw closes automatically because its in the paremeters of the try-catch.
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private void saveFile(String Name) {
        //... Locate Directory
        File JSON_Files = new File("JSON_Files");
        if (!JSON_Files.exists() || JSON_Files.isFile()) {
            JSON_Files.mkdir();
        }

        try {
            //... Create the file
            File SavedFile = new File(JSON_Files, Name+".JSON");
            JSON_File = SavedFile;
            SavedFile.createNewFile();

           //... Serialize the object into the file
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            FileWriter fw = new FileWriter(SavedFile);
            gson.toJson(Cloth, fw);
            fw.close();
            

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void loadFile(String name) {
        //... Locate Directory
        File JSON_Files = new File("JSON_Files");
        if (!JSON_Files.exists() || JSON_Files.isFile()) {
            System.out.println("There are currently no files in the JSON_Files directory");
        }

        //... Find the file
        File[] SavedFiles = JSON_Files.listFiles();
        for (File f:SavedFiles) {
            //... Load the file
            if (name.equals(f.getName().substring(0, f.getName().lastIndexOf('.')))) {
                JSON_File = f;
                System.out.println(name+" has been successfully loaded");
                break;
            } else {
                JSON_File = null;
            }
        }

        if (JSON_File == null) {
            System.out.println("File does not exist!");
            return;
        }

        //... Load the object
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String JSON_Data = "NULL";

        try {
            JSON_Data = Files.readString(Path.of(JSON_File.getPath()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Cloth = gson.fromJson(JSON_Data, Clothes.class);
    }

    public void deleteCurrentFile() {
        JSON_File.delete();
        Clothings.remove(Cloth);

        Cloth = null;
    }

    // [OBJECT MANAGEMENT]
    public void createClothes(String Type, String Brand, String Color, String Size, String filename) {
        Clothes CreatedCloth = new Clothes(Type, Brand, Color, Size);
        Cloth = CreatedCloth;
        Clothings.add(CreatedCloth);

        saveFile(filename);
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void viewClothings() {
        System.out.println("+++++++++++++++++++++++++[CLOTHINGS]+++++++++++++++++++++++++");
        for (Clothes c: Clothings) {
            c.dispalyInformation();
            System.out.println();
        }
    }


    // ================================================== OTHER CLASSES ================================================== \\
}
