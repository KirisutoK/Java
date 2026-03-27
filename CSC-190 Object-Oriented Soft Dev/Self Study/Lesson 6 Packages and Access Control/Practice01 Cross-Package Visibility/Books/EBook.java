package Books;

// Creation Date: March 26, 2026. at 10:17 AM
// Last Modified: March 27, 2026. at  2:19 PM

public class EBook extends Book {
    //=======VARIABLES=======//
    private String FileFormat;
    private double FileSize; //in Megabyte(MB)


    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public EBook(String Title, String Author, String ISBN, double Price, String FileFormat, double FileSize) {
        super(Title, Author, ISBN, Price);
        this.FileFormat = FileFormat;
        this.FileSize = FileSize;
    }
    
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    // --- @OVERRIDE ---
    @Override protected String getBookType() {
        return "E-Book (PDF)";
    }


    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    // --- @OVERRIDE ---
    @Override public void displayInformation() {
        super.displayInformation();
        System.out.println("File Format: "+FileFormat);
        System.out.println("File Size: "+FileFormat);
    }


}


//// Private attributes: fileFormat (String), fileSize (double) in MB
/// Constructor takes all Book parameters + fileFormat and fileSize
/// Override getBookType() — returns "E-Book (PDF)" or whatever format
/// Public method: displayEBookInfo() — shows title (accessible because protected), format, and size