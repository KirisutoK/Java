package FilesAndFolders;

// Creation Date: April 02, 2026. at 11:28 AM
// Last Modified: April 02, 2026. at 11:52 AM

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AreYouFRRemoveString {
    public static void main(String[] args) {
        // [THE WORD TO REMOVE]
        String removeWord = "astonishingly";
        String fileName = "C:\\Users\\kiris\\OneDrive - Finger Lakes Community College\\Documents\\FLCC\\Coding\\Java\\CSC-190 Object-Oriented Soft Dev\\Class\\Week 9 Exceptions\\FilesAndFolders\\AreYouFRStory.txt";

        // [CREATING INSTANCES]
        Scanner inFile = null;
        try {
            inFile = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File not Found!");
            return;
        }

        // [READ THE FILE]
        String fileData = "";
        while(inFile.hasNext()) {
            String word = inFile.next();
            fileData += word + " ";
        }
        System.out.println(fileData);

        // [REMOVING THE WORD]
        Scanner textScanner = new Scanner(fileData);
        String answer = "";
        while (textScanner.hasNext()) {
            String word = textScanner.next();
            if(!word.equals(removeWord)) {
                answer += word + " ";
            }
        }

        // [OUTPUT] - Saves the changes
        try {
            PrintWriter OutFile01 = new PrintWriter("AreYouFr.Storytxt");
            OutFile01.print(answer);
            OutFile01.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(answer);
    }
}
