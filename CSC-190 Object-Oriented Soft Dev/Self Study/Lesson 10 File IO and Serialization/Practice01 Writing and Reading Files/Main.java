// Creation Date: July 14, 2026. at 9:21 PM
// Last Modified: July 16, 2026. at  7:59 PM

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        //======= CREATING OBJECTS =======//
        Diary diary = new Diary("C:\\Users\\kiris\\OneDrive - Finger Lakes Community College\\Documents\\FLCC\\Coding\\Java\\CSC-190 Object-Oriented Soft Dev\\Self Study\\Lesson 10 File IO and Serialization\\Practice01 Writing and Reading Files\\Text.txt");

        //======= METHODS =======//
        // diary.addEntry("AYOOOO "); //... THIS WRITES TO FILE (.txt).
        // diary.readAllEntries(); //... THIS READS A FILE (.txt), i,e returning a string and printing them line-by-line.
        // diary.clearDiary(); //... THIS OVERWRITES THE TEXT FILE WITH A BLANK STRING WHICH IS "".
        // diary.fileExists(); //... THIS CHECKS IF THE FILE ACTUALLY EXISTS.

        //======= CLAUDE PROMPT =======//
        diary.fileExists();
        System.out.println();

        diary.addEntry("THIS IS THE FIRST ENTRY");
        diary.addEntry("FYI THIS IS THE SECOND");
        diary.addEntry("LMAOOOO YOU MADE IT TO THE THIRD");
        System.out.println();

        diary.readAllEntries();
        System.out.println();

        diary.clearDiary();
        System.out.println();

        diary.readAllEntries();
        System.out.println();

        diary.fileExists();
    }

    // =========================== OTHER METHODS =========================== \\
}
