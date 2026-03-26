package Books;

// Creation Date: March 26, 2026. at 10:09 AM
// Last Modified: March 26, 2026. at 10:43 AM

public class Book {
    //=======VARIABLES=======//
    public Boolean isAvailable = true;
    protected String Title;
    protected String Author;
    private double Price;
    // TODO: <======================== YOU LEFT HERE (WHAT IS PACKAGE-PRIVATE ATTRIBUTE?)
    

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Book() {

    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getTitle() {
        return Title;
    }
    public String getAuthor() {
        return Author;
    }
    public double getPrice() {
        return Price;
    }


    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}


//// Private attribute: price (double)
//// Protected attributes: title (String), author (String)
// TODO: Package-private attribute: isbn (String) — no modifier
//// Public attribute: isAvailable (boolean)
// Constructor takes all four parameters, sets isAvailable to true
// Public method: getPrice() — returns price
// Package-private method: applyDiscount(double percent) — reduces price by percent (only callable within library.books!)
// Protected method: getBookType() — returns "Physical Book"
// Public method: displayInfo() — displays all book info