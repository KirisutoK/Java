// Creation Date: July 15, 2026. at 8:58 PM
// Last Modified: July 15, 2026. at  8:59 PM

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Diary {
    //=======VARIABLES=======//
    private String FileName;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Diary(String FileName) {
        this.FileName = FileName;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void addEntry(String entry) { //! YOU LEFT HERE IN THIS METHOD TRYING TO FIGUER OUT HOW TO WRITE INTO A FILE!
        PrintWriter pw = new PrintWriter(FileName);

        try() {

        } catch (FileNotFoundException e) {
            System.out.println("File can not be found!");
        } catch (IOException e) {
            System.out.println("Something went wrong with the file!");
        }
    }


    // ================================================== OTHER CLASSES ================================================== \\
}
