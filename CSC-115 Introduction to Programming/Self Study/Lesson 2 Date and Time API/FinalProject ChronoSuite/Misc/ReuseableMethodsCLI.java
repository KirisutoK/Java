package Misc;// Creation Date: August 21, 2026. at 10:50 PM
// Last Modified: September 26, 2026. at  2:39 AM

import Misc.GSON_Adapters.GsonAdapter_Date;
import com.google.gson.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.MessageDigest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReuseableMethodsCLI {
    //=======VARIABLES=======//
    public static Scanner input = new Scanner(System.in);
    public static Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new GsonAdapter_Date()).create();
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
    public static String fileNameOnly(File file, int TypeWidth) {
        return file.getName().substring(0, file.getName().length() - TypeWidth);
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
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashed = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashed) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
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
                System.out.println(ReuseableMethodsCLI.lineAutoSpacing("│ Name: "+ ReuseableMethodsCLI.fileNameOnly(f, 5)+((f.getName().equals(currentFile.getName())) ? " (CURRENT FILE)":""), 53)); // The extra methods are meant to remove the `.txt
            } else {
                System.out.println(ReuseableMethodsCLI.lineAutoSpacing("│ Name: "+ ReuseableMethodsCLI.fileNameOnly(f, 5), 53)); // The extra methods are meant to remove the `.txt`
            }
            try {
                System.out.println(ReuseableMethodsCLI.lineAutoSpacing("│ Size: "+ ReuseableMethodsCLI.formatFileSize(f.length()), 53));
                System.out.println(ReuseableMethodsCLI.lineAutoSpacing("│ Date Created: "+ ReuseableMethodsCLI.getDateCreated(f), 53));
                System.out.println(ReuseableMethodsCLI.lineAutoSpacing("│ Last Modified: "+ ReuseableMethodsCLI.getLastModified(f), 53));
            } catch (NoSuchFileException e) { // Note: I feel like we will never run into this because savedFiles are called every single time to double check so it's impossible to delete a file in nanoseconds while this method runs
                System.out.println("[ERROR: NoSuchFileException] "+e.getMessage());
            }

            System.out.println("╞═══════════════════════════════════════════════════╡");
        }
        System.out.println("│[NOTE] Input \"e\" to exit.                          │");
        System.out.println("╘═══════════════════════════════════════════════════╛");
        System.out.println();

        return true; // true means that it loaded successfully
    }
    public static void updateJsonFile(Object obj, File file) {
        // NOTE: I feel like this might cause an error issue if something wrongs with any of the methods this method had been used on
        try (FileWriter fw = new FileWriter(file)) {
            gson.toJson(obj, fw);
        } catch (IOException e) {
            System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
        }
    }
    public static File createFile(String Directory, String Filename){
        //... CHECK THE DIRECTORY OF `Saves`
        File SavesFolder = new File("Saves");
        if (!SavesFolder.exists() || SavesFolder.isFile()) { // if the path does not exist or there is an existing file called "Saves" then.
            SavesFolder.mkdir();
        }

        //... UNDER DIRECTORY OF `Saves`, CREATE ANOTHER DIRECTORY CALLED `MileStoneTracker`
        File MileStoneTrackerFolder = new File(SavesFolder, Directory);
        if (!MileStoneTrackerFolder.exists() || MileStoneTrackerFolder.isFile()) { // if the path does not exists or there is an existing file called "Saves" then
            MileStoneTrackerFolder.mkdir();
        }

        //... UNDER `MileStoneTracker`, Check if it already exists in the list.
        File SaveFile = new File(MileStoneTrackerFolder, Filename+".json"); // NOTE: `.AMST_Data` append so that every file will be a `.AMST_Data` file
        try {
            if (!SaveFile.exists() || SaveFile.isDirectory()) { // if the SaveFile does not exist or is currently a directory then.
                SaveFile.createNewFile();
                return SaveFile;
            }
        } catch (IOException e) {
            return null;
        }

        return null;
    }
    public static File loadFile(String Directory, String Filename) {
        //... CHECK THE DIRECTORY OF `Saves`
        File SavesFolder = new File("Saves");
        if (!SavesFolder.exists() || SavesFolder.isFile()) { // if the path does not exist or there is an existing file called "Saves" then.
            SavesFolder.mkdir();
        }

        //... UNDER DIRECTORY OF `Saves`, CREATE ANOTHER DIRECTORY CALLED `MileStoneTracker`
        File MileStoneTrackerFolder = new File(SavesFolder, Directory);
        if (!MileStoneTrackerFolder.exists() || MileStoneTrackerFolder.isFile()) { // if the path does not exists or there is an existing file called "Saves" then
            MileStoneTrackerFolder.mkdir();
        }

        //... UNDER `MileStoneTracker`, find if any filename matches
        File[] SavedFiles = MileStoneTrackerFolder.listFiles();
        if (SavedFiles == null || SavedFiles.length == 0) {
            return null;
        }
        for (File f:SavedFiles) {
            if (ReuseableMethodsCLI.fileNameOnly(f, 5).equals(Filename)) {
                return f;
            }
        }

        return null;
    }
    public static File[] getSavedFiles(String Directory) {
        return new File(Directory).listFiles();
    }

    // [BIRTHDAYS]
    public static String toStringBirthday(LocalDate Birthday) {
        return Birthday.getMonth()+" "+ Birthday.getDayOfMonth()+", "+ Birthday.getYear();
    }
    public static int getAge(LocalDate Birthday) {
        return Period.between(Birthday, LocalDate.now()).getYears();
    }

    // [METADATA]
    public static String getDateCreated(File f) throws NoSuchFileException { // NOTE: <================= THIS IS NEW AND WAS NOT PART OF THE LESSON (THANKS TO CLAUDE FOR HELPING ME OUT GET METADATA INFORMATION FROM A FILE)
        DateTimeFormatter DTF = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mma");

        //... METADATA
        try {
            BasicFileAttributes metaData = Files.readAttributes(f.toPath(), BasicFileAttributes.class); // NOTE: <================= THIS IS NEW AND WAS NOT PART OF THE LESSON (THANKS TO CLAUDE FOR HELPING ME OUT GET METADATA INFORMATION FROM A FILE)
                                                                            // NOTE: ^ is a standard class similar to `Integer.class` or `String.class`.
                                                                            // LESSON LEARNED: NIO stands for New Input Output, its the advanced class for IO
                                                                            // LESSON LEARNED: BasicFileAttirbutes.class can read an attribute of a file.

            //... FORMATTING THE METADATA TO BE READABLE (METADATAS CONSIST OF LONG VALUES)
            LocalDateTime LDT = LocalDateTime.ofInstant(metaData.creationTime().toInstant(), ZoneId.systemDefault());
            return LDT.format(DTF);
        } catch (NoSuchFileException e) {
            throw new NoSuchFileException(e.getMessage());
        } catch (IOException e) {
            System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
        }

        return null;
    }
    public static String getLastModified(File f) throws NoSuchFileException{
        DateTimeFormatter DTF = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mma");

        //... METADATA
        try {
            BasicFileAttributes metaData = Files.readAttributes(f.toPath(), BasicFileAttributes.class); // NOTE: <================= THIS IS NEW AND WAS NOT PART OF THE LESSON (THANKS TO CLAUDE FOR HELPING ME OUT GET METADATA INFORMATION FROM A FILE)
                                                                            // NOTE: ^ is a standard class similar to `Integer.class` or `String.class`.
                                                                            // LESSON LEARNED: NIO stands for New Input Output, its the advanced class for IO
                                                                            // LESSON LEARNED: BasicFileAttirbutes.class can read an attribute of a file.

            //... FORMATTING THE METADATA TO BE READABLE (METADATAS CONSIST OF LONG VALUES)
            LocalDateTime LDT = LocalDateTime.ofInstant(metaData.lastModifiedTime().toInstant(), ZoneId.systemDefault());
            return LDT.format(DTF);
        } catch (NoSuchFileException e) {
            throw new NoSuchFileException(e.getMessage());
        } catch (IOException e) {
            System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
        }

        return null;
    }
    public static String formatFileSize(long FileSize) { // NOTE: This method and it's formula is created by Claude (made some tweaks to make it readable to me)
        if (FileSize < 1024) {
            return FileSize + " B";
        } else if (FileSize < 1024 * 1024) {
            return String.format("%.2f KB", FileSize / 1024.0);
        } else {
            return String.format("%.2f MB", FileSize / (1024.0 * 1024.0));
        }
    }


    // ================================================== OTHER CLASSES ================================================== \\
}

// NOTE: THIS IS JUST TO STORE METHODS THAT ARE UNIVERSALLY USED THROUGHOUT CLASSES
// NOTE: THIS IS A `REUSABLE METHODS FILE`