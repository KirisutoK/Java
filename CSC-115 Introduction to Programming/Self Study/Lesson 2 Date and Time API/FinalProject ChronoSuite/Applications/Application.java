package Applications;

// Creation Date: October 01, 2026. at 12:14 PM
// Last Modified: October 01, 2026. at 12:36 PM

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface Application { // A Template/Contract that gives requirements for a class
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    // [CLASS VARIABLES]
    public void resetCurrentFileData();
    public void setUsername(String username);

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    // [FILE MANAGEMENT]
    public boolean createFile(String FileName) throws IOException;
    public boolean setNewFilePassword(String FileName) throws IOException, NoSuchAlgorithmException;
    public boolean loadFile(String FileName) throws IOException;
    public boolean deleteSelectedFile(String FileName) ;
    public boolean deleteCurrentFile();
    public boolean deleteAllFiles();
}

// Methods and Interfaces are public by default
