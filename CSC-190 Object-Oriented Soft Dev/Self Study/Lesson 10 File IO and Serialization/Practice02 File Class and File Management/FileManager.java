// Creation Date: July 17, 2026. at 9:47 PM
// Last Modified: July 18, 2026. at 10:12 PM

import java.io.File;
import java.io.IOException;
import java.util.logging.SocketHandler;

public class FileManager {
    //=======VARIABLES=======//
    private String WorkingDirectory;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public FileManager(String FolderPath) {
        File f = new File(FolderPath);
        if (!f.exists()) {
            f.mkdirs();
            System.out.println("Directory has been created: "+FolderPath);
        } else {
            WorkingDirectory = FolderPath;
        }
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public void listFiles() {
        File Directory = new File(WorkingDirectory);
        File[] Files = Directory.listFiles();

        if (Files != null) { // IF THE WORKING DIRECTORY IS NOT NULL THEN
            for (File f:Files) {
                System.out.println("Name: "+f.getName());
                System.out.println("Size: "+f.length()+" Bytes");
                System.out.println("File: "+f.isFile());
                System.out.println("Directory: "+f.isDirectory());
                System.out.println();
            }
        } else {
            System.out.println("Working Directory is Null or does not exists!");
        }
    }
    public void getFileInfo(String filename) {
        File file = new File(WorkingDirectory, filename);

        if (file.exists()) {
            System.out.println("Name: "+file.getName());
            System.out.println("Size: "+file.length()+" Bytes");
            System.out.println("File: "+file.isFile());
            System.out.println("Directory: "+file.isDirectory());
            System.out.println();
        } else if (file.isDirectory()) {
            System.out.println(filename+" is a directory, not a file!");
        } else {
            System.out.println(filename+" does not exists!");
            System.out.println();
        }
    };

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void createFile(String filename) {
        File f = new File(WorkingDirectory, filename); // Paramenter(Parent, Child) or Parameter(Folder, File)

        try {
            if (f.exists()) {
                System.out.println(filename+" already exist!");
            } else {
                f.createNewFile();
                System.out.println(filename+" has been created under "+WorkingDirectory);
            }
        } catch (IOException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
    public void deleteFile(String filename) {
        File f = new File(WorkingDirectory, filename); // Paramenter(Parent, Child) or Parameter(Folder, File)

        if (f.exists()) {
            f.delete();
            System.out.println(filename+" has been deleted");
        } else {
            System.out.println(filename+" does not exists!");
        }
    }
    public void renameFile(String oldname, String newname) {
        File oldfile = new File(oldname);
        File newfile = new File(newname);

        if (oldfile.exists()) {
            oldfile.renameTo(newfile);
        } else {
            System.out.println(oldname+" does not exists!");
        }
    };
    

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS


    // ================================================== OTHER CLASSES ================================================== \\
}
