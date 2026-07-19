// Creation Date: July 17, 2026. at 9:47 PM
// Last Modified: July 19, 2026. at 11:02 AM

import java.io.File;
import java.io.IOException;

public class FileManager {
    //=======VARIABLES=======//
    private String WorkingDirectory;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public FileManager(String FolderPath) {
        File f = new File(FolderPath);
        if (!f.exists()) {
            f.mkdirs();
            System.out.println("Directory has been created: "+FolderPath);
        }
        WorkingDirectory = FolderPath;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public void listFiles() {
        File Directory = new File(WorkingDirectory);
        File[] Files = Directory.listFiles();

        System.out.println("+++++++++++++++++++++++++ "+Directory.getName()+" +++++++++++++++++++++++++");
        if (Files != null) { // IF THE WORKING DIRECTORY IS NOT NULL THEN
            for (File f:Files) {
                getFileInfo(f.getName());
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
    // [File]
    public void createFile(String filename) {
        File f = new File(WorkingDirectory, filename); // Paramenter(Parent, Child) or Parameter(Folder, File)

        try {
            if (f.exists()) {
                System.out.println("[File] "+filename+" already exist!");
            } else {
                f.createNewFile();
                System.out.println("[File] "+filename+" has been created under "+WorkingDirectory);
            }
        } catch (IOException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
    public void deleteFile(String filename) {
        File f = new File(WorkingDirectory, filename); // Paramenter(Parent, Child) or Parameter(Folder, File)

        if (f.exists()) {
            f.delete();
            System.out.println("[File] "+filename+" has been deleted");
        } else {
            System.out.println("[File] "+filename+" does not exists!");
        }
    }
    public void renameFile(String oldname, String newname) {
        File oldfile = new File(WorkingDirectory ,oldname);
        File newfile = new File(WorkingDirectory, newname);

        if (oldfile.exists()) {
            if (oldfile.renameTo(newfile)) {
                System.out.println("[File] "+oldname+" has been renamed into "+newname);
            } else {
                System.out.println("[File] "+oldname+" can not be renamed into "+newname+" because it already exists!");
            }
        } else {
            System.out.println("[File] "+oldname+" does not exists!");
        }
    };

    // [Directory]
    public void createDirectory(String directoryname) {
        File Directory = new File(WorkingDirectory, directoryname);

        if (Directory.exists()) {
            System.out.println("[Directory] "+directoryname+" already exists!");
        } else {
            Directory.mkdir();
            System.out.println("[Directory] "+directoryname+" has been successfully created!");
        }
    }
    public void changeDirectory(String FolderPath) {
        File oldf = new File(WorkingDirectory);
        File f = new File(FolderPath);
        if (!f.exists()) {
            System.out.println("[Directory] "+f.getName()+" does not exists!");
        } else {
            WorkingDirectory = FolderPath;
            System.out.println("[Directory] The working directory has successfully changed from "+oldf.getName()+" into "+f.getName());
        }
    }
    public void renameDirectory(String oldname, String newname) {
        File oldDirectory = new File(WorkingDirectory, oldname);
        File newDirectory = new File(WorkingDirectory, newname);

        if (oldDirectory.exists()) {
            if (oldDirectory.renameTo(newDirectory)) {
                System.out.println("[Directory] "+oldname+" has been renamed into "+newname);
            } else {
                System.out.println("[Directory] "+oldname+" can not be renamed into "+newname+" because it already exists!");
            }
        } else {
            System.out.println("[Directory] "+oldname+" does not exists!");
        }

    };

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS


    // ================================================== OTHER CLASSES ================================================== \\
}
