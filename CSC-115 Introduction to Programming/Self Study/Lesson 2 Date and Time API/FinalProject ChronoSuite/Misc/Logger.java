package Misc;

// Creation Date: September 28, 2026. at 4:31 PM
// Last Modified: September 28, 2026. at  4:52 PM

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    //=======VARIABLES=======//

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    public static void log(String ApplicationName, String FileName, String action) throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        File LogParentFile = new File("Saves/"+ApplicationName+"/Logs");
        File LogFile = new File(LogParentFile, FileName+".log");
        try { // true = append, don't overwrite
            if (!LogParentFile.exists()) {
                LogParentFile.mkdirs();
            }
            if (!(LogFile.isFile() && LogFile.exists())) {
                LogFile.createNewFile();
            }
            FileWriter fw = new FileWriter(LogFile, true);
            fw.write("["+timestamp+"] "+action+"\n");
            fw.close();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
    public static boolean deleteLog(String ApplicationName, String FileName) {
        File LogParentFile = new File("Saves/"+ApplicationName+"/Logs");
        File LogFile = new File(LogParentFile, FileName+".log");

        if (LogFile.delete()) {
            return true;
        }

        return false;
    }

    
    // ================================================== OTHER CLASSES ================================================== \\
}

// NOTE: This is just a class for logging stuff into the file.
