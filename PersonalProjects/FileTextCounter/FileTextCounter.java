// Creation Date: April 08, 2026. at 12:10 PM
// Last Modified: April 08, 2026. at 12:26 PM

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileTextCounter {
    public static void main(String[] args) {
        int LineCounter = 0;
        int WordCounter = 0;
        int CharCounter = 0; // no text or without text is still undecided

        try {
            // Finding the File
            Scanner fileReader = new Scanner(new File("C:\\Users\\kiris\\OneDrive - Finger Lakes Community College\\Documents\\FLCC\\Coding\\Java\\PersonalProjects\\FileTextCounter\\FileTest.txt"));

            // Reading each line
            while (fileReader.hasNextLine()) {
                LineCounter++;
                String line = fileReader.nextLine(); // copies the words in 1 single line
                System.out.println(line);
            }

            // TODO: FIX THIS, THE WORD COUNTER DOESNT SEEM TO WORK (ORIGINALLY TESTING HOW THE COUNTING PROCESS WORKS)
            fileReader.useDelimiter("");
            while (fileReader.hasNext()) {
                WordCounter++;
                char character = fileReader.next().charAt(0);
                System.out.println(character);
            }

            // Submits the readings
            fileReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        } finally {
            System.out.println("Lines: "+LineCounter);
            System.out.println("Words: "+WordCounter);
            System.out.println("Characters: "+CharCounter);
        }
    }
}
