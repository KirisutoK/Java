import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Creation Date: April 06, 2026. at 12:22 PM
// Last Modified: April 06, 2026. at  1:03 PM

public class FileProject {
    public static void main(String[] args) {
        // Check if filename is provided as command-line argument
        if (args.length != 1) {
            System.out.println("Usage: java Exercise <filename>");
            System.exit(1);
        }

        String filename = args[0];
        int characterCount = 0;
        int wordCount = 0;
        int lineCount = 0;

        try {
            // Create File object
            File file = new File(filename);

            // Create Scanner to read from file
            Scanner scanner = new Scanner(file);

            // Read file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineCount++;

                // Count characters (including the newline character)
                // Add 1 for the newline character that nextLine() removes
                characterCount += line.length() + 1;

                // Count words in this line
                // Use a separate scanner to tokenize the line by whitespace
                Scanner lineScanner = new Scanner(line);
                while (lineScanner.hasNext()) {
                    lineScanner.next();
                    wordCount++;
                }
                lineScanner.close();
            }

            // Adjust character count: subtract 1 for the last line
            // (it doesn't have a newline at the end in the file)
            if (lineCount > 0) {
                characterCount--;
            }

            scanner.close();

            // Display results
            System.out.println("File " + filename + " has");
            System.out.println(characterCount + " characters");
            System.out.println(wordCount + " words");
            System.out.println(lineCount + " lines");

        } catch (FileNotFoundException e) {
            System.out.println("File " + filename + " not found.");
            System.exit(1);
        }
    }
}
