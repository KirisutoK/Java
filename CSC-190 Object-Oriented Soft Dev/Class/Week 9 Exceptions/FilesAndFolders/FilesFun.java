package FilesAndFolders;

// Creation Date: April 02, 2026. at 10:26 AM
// Last Modified: April 02, 2026. at 11:06 AM

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FilesFun {
    public static void main(String[] args) throws FileNotFoundException {
        // [CREATING INSTANCES]
        File File01 = new File("Frogs.txt"); // Creates a File (object)
        PrintWriter OutFile01 = new PrintWriter(File01); // Creates an object to change the file
        File File02 = new File("IronMan.jarvis"); // Creates a File (object)
        PrintWriter OutFile02 = new PrintWriter(File02); // Creates an object to change the file

        // [FILE01 METHODS]
        System.out.println("Name: "+File01.getName());
        System.out.println("File Path: "+File01.getPath());
        System.out.println("File Absolute Path: "+File01.getAbsolutePath());
        System.out.println("Last Modified: "+File01.lastModified());
        System.out.println("Is Directory: "+File01.isDirectory());
        System.out.println("Can Read: "+File01.canRead());
        System.out.println(" "); // Space for Readability

        // [FILE01 METHODS]
        System.out.println("Name: "+File02.getName());
        System.out.println("File Path: "+File02.getPath());
        System.out.println("File Absolute Path: "+File02.getAbsolutePath());
        System.out.println("Last Modified: "+File02.lastModified());
        System.out.println("Is Directory: "+File02.isDirectory());
        System.out.println("Can Read: "+File02.canRead());
        System.out.println(" "); // Space for Readability

        // =============[PRINT WRITER]============= - This writes to a file
        // [REGULAR PRINT]
        System.out.println("Frogs are cool.");
        System.out.println(" "); // Space for Readability

        // [OUTFILE01 METHODS]
        OutFile01.println("Frogs are awesome");
        OutFile01.close();
        System.out.println(" "); // Space for Readability

        // [OUTFILE02 METHODS]
        OutFile02.println("Jarvis, give this man a good day! :)");
        OutFile02.close();
        System.out.println(" "); // Space for Readability
    }
}
