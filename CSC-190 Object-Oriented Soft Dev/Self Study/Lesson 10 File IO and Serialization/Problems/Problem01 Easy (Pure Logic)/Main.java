// Creation Date: July 23, 2026. at 8:13 PM
// Last Modified: July 23, 2026. at  8:25 PM

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        System.out.println(countLines("C:\\Users\\kiris\\OneDrive - Finger Lakes Community College\\Documents\\FLCC\\Coding\\Java\\CSC-190 Object-Oriented Soft Dev\\Self Study\\Lesson 10 File IO and Serializatio"));
        System.out.println(countLines("C:\\Users\\kiris\\OneDrive - Finger Lakes Community College\\Documents\\FLCC\\Coding\\Java\\CSC-190 Object-Oriented Soft Dev\\Self Study\\Lesson 10 File IO and Serialization\\Problems\\Problem01 Easy (Pure Logic)\\poem.txt"));
    }

    // =========================== METHODS =========================== \\
    public static int countLines(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            int totalLines = 0;
            while ((line = br.readLine()) != null) {
                totalLines++;
            }
            return totalLines;
        } catch (FileNotFoundException e) {
            return -1;
        } catch (IOException e) { // IF THE FILE COULDN'T FIND ANYTHING THEN THIS CATCHES
            return -1;
        }
    }
}
