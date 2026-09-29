package Misc;// Creation Date: August 21, 2026. at 10:50 PM
// Last Modified: September 29, 2026. at  5:11 PM

import com.google.gson.*;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReuseableMethodsCLI {
    //=======VARIABLES=======//
    public static Scanner input = new Scanner(System.in);
        // LESSON LEARNED: I learned that you can use an object anywhere in the project if it is a static public

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public static int getAnswer(int start, int end) {  // Note: i am planning to add a throw in this reuseable method so that we can reuse "e" to exit.
        boolean ValidAnswer = false; //... Placeholders
        int Answer = 0; //... Placeholders
        while (!ValidAnswer) {
            try {
                System.out.print("Answer: ");
                Answer = input.nextInt();
                input.nextLine(); // Refreshes buffer
                if (Answer < start || Answer > end) {
                    throw new InputMismatchException();
                }

                ValidAnswer = true;
            } catch (InputMismatchException e) {
                System.out.println("Please choose between "+start+" through "+end);
                input.nextLine(); // Refreshes buffer
            }
        }
        System.out.println();

        return Answer;
    }
    public static String lineAutoSpacing(String line, int width) {
        // DISPLAY
        int totalWidth = width;
        int spacesNeeded = Math.max(0, totalWidth - line.length() - 1); // NOTE: (spacesNeeded = totalWidth - prefixLength - usernameLength - 1) <========= FORMULA BY CLAUDE
        String padding = " ".repeat(spacesNeeded);

        return line + padding + line.toCharArray()[0];
    }
    public static String softWrapping(String line, int width) { // NOTE: THIS IS METHOD IS ENTIRELY MADE BY CLAUADE
        if (line.length() + 1 <= width) { // +1 for the closing ║
            return lineAutoSpacing(line, width);
        }

        StringBuilder result = new StringBuilder();
        String continuationPrefix = "║   "; // indent for wrapped lines

        // split at the threshold
        String firstChunk = line.substring(0, width - 2); // -2 for closing ║ and space
        String remainder = line.substring(width - 2).trim();

        result.append(lineAutoSpacing(firstChunk, width)).append("\n");

        // handle remainder in chunks
        while (!remainder.isEmpty()) {
            if (continuationPrefix.length() + remainder.length() + 1 <= width) {
                result.append(lineAutoSpacing(continuationPrefix + remainder, width));
                remainder = "";
            } else {
                int space = width - continuationPrefix.length() - 2;
                result.append(lineAutoSpacing(continuationPrefix + remainder.substring(0, space), width)).append("\n");
                remainder = remainder.substring(space).trim();
            }
        }

        return result.toString();
    }

    // [SECURITY]
    public static boolean passwordValidation(String Password, int minimum, int maximum, int specialCharacters, int Numbers){

        // Count how many Characters, how many special characters, and numbers
        int CharacterCounts = 0;
        int SpecialCaracterCounts = 0;
        int NumberCharacterCounts = 0;
        for (int i = 0; i < Password.length(); i++) {
            CharacterCounts++;

            // If the character is a special character
            if (!(Character.isLetterOrDigit(Password.charAt(i)) || Character.isWhitespace(Password.charAt(i)))) {
                SpecialCaracterCounts++;
            }

            // If the character is a number
            if (Character.isDigit(Password.charAt(i))) {
                NumberCharacterCounts++;
            }
        }

        // Do Checks
        if (!((CharacterCounts >= minimum && CharacterCounts <= maximum) && SpecialCaracterCounts >= specialCharacters && NumberCharacterCounts >= Numbers)) {
            System.out.println("[ERROR] Invalid Password! must have:");
            System.out.println(minimum+" minimum characters,");
            System.out.println(maximum+" maximum characters,");
            System.out.println(specialCharacters+" special characters minimum,");
            System.out.println(Numbers+" number characters minimum.");
            return false;
        }


        return true;
    }
    public static String hashPassword(String password) { // NOTE: THIS IS METHOD IS ENTIRELY MADE BY CLAUADE
        try {
            return DataManager.hashPassword(password);
        } catch (Exception e) {
            System.out.println("[ERROR: " + e.getClass().getSimpleName() + "] " + e.getMessage());
            return null;
        }
    }
    public static boolean Confirmation(String process) {
        // DISPLAY
        System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println(ReuseableMethodsCLI.lineAutoSpacing("║ Are you sure you would like to confirm \""+process+"\"?", 85));
        System.out.println("╟───────────────────────────────────────────────────────────────────────────────────╢");
        System.out.println("║ 1. Yes                                     2. No                                  ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════╝");
        System.out.println();

        // PROCESSING INPUT
        int Answer = ReuseableMethodsCLI.getAnswer(1, 2);

        // PROCESSING OUTPUT
        return Answer == 1; // if it's 1, return true, else false
    }

    // [FILE MANAGEMENT]
    public static boolean printSavedFiles(File[] savedFiles, File currentFile) {
        // Check if it's null
        if (savedFiles == null || savedFiles.length == 0) {
            System.out.println("[ERROR] Saved Files is empty!");
            System.out.println();
            return false; // false means it did not load successfully
        }

        // Print
        System.out.println("╒══════════[AGE MILESTONE TRACKER SAVES]════════════╕");
        for (File f:savedFiles) {
            if (currentFile != null) {
                System.out.println(ReuseableMethodsCLI.lineAutoSpacing("│ Name: "+ FileManager.fileNameOnly(f, 5)+((f.getName().equals(currentFile.getName())) ? " (CURRENT FILE)":""), 53)); // The extra methods are meant to remove the `.txt
            } else {
                System.out.println(ReuseableMethodsCLI.lineAutoSpacing("│ Name: "+ FileManager.fileNameOnly(f, 5), 53)); // The extra methods are meant to remove the `.txt`
            }
            try {
                System.out.println(ReuseableMethodsCLI.lineAutoSpacing("│ Size: "+ FileManager.formatFileSize(f.length()), 53));
                System.out.println(ReuseableMethodsCLI.lineAutoSpacing("│ Date Created: "+ FileManager.getDateCreated(f), 53));
                System.out.println(ReuseableMethodsCLI.lineAutoSpacing("│ Last Modified: "+ FileManager.getLastModified(f), 53));
            } catch (IOException e) { // Note: I feel like we will never run into this because savedFiles are called every single time to double check so it's impossible to delete a file in nanoseconds while this method runs
                System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
            }

            System.out.println("╞═══════════════════════════════════════════════════╡");
        }
        System.out.println("│[NOTE] Input \"e\" to exit.                          │");
        System.out.println("╘═══════════════════════════════════════════════════╛");
        System.out.println();

        return true; // true means that it loaded successfully
    }
    public static boolean log(String ApplicationName, String FileName, String Action) { // NOTE: This is a method to remove unnessary try catch clutter in the code structures
        try {
            Logger.log(ApplicationName, FileName, Action);
            return true;
        } catch (IOException e) {
            System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
            return false;
        }
    }


    // ================================================== OTHER CLASSES ================================================== \\
}

// NOTE: THIS IS JUST TO STORE METHODS THAT ARE UNIVERSALLY USED THROUGHOUT CLASSES
// NOTE: THIS IS A `REUSABLE METHODS FILE`