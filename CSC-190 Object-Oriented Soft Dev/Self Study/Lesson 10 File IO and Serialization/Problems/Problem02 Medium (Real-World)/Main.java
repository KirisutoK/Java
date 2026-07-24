// Creation Date: July 23, 2026. at 8:28 PM
// Last Modified: July 23, 2026. at  8:44 PM

import java.io.*;
import java.util.HashMap;

public class Main implements Serializable {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {


    }

    // =========================== METHODS =========================== \\
    public static void saveGrades(String filepath, HashMap<String, Double> grades) {
        try (ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(filepath))) {
            oos.writeObject(grades);
            // THIS SHOULD AUTOMATICALLY CLOSE BECAUSE OF A TRY CATCH
        } catch (IOException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    public static HashMap<String, Double> loadGrades(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            HashMap<String, Double> grades = new HashMap<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                String name = split[0];
                double grade = Double.parseDouble(split[1]);
                grades.put(name, grade);
            }
            return grades;
        } catch (IOException e) {
            return new HashMap<>();
        }
    }
}

//! SO I MISREAD THE PROMPT AND IT WAS SUPPOSED TO INPUT A INFORMATION INTO A TEXT FILE SO IT IS NOT SERIALIZATION
//! SERIALIZATION IS FOR OBJECTS