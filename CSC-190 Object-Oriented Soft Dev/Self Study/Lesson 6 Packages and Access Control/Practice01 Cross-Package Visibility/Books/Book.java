package Books;

// Creation Date: March 26, 2026. at 10:09 AM
// Last Modified: March 27, 2026. at  2:08 PM

public class Book {
    //=======VARIABLES=======//
    public Boolean isAvailable = true;
    protected String Title;
    protected String Author;
    String ISBN; // ACCESSIBLE ONLY INSIDE THE PACKAGES (Shared with other classes with the same package)
    private double Price;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Book(String Title, String Author, String ISBN, double Price) {
        this.Title = Title;
        this.Author = Author;
        this.ISBN = ISBN;
        this.Price = Price;
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
    protected String getBookType() {
        return "Physical Book";
    }



    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    void applyDiscount(double percent) { // only accessible within the same package
        Price = getPrice()-(getPrice()*percent); // P-(P*%)
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInformation() {
        System.out.println("Title: "+Title);
        System.out.println("Author: "+Author);
        System.out.println("ISBN: "+ISBN);
        System.out.println("Price: "+Price);
        System.out.println("Available: "+isAvailable);

    }
}

//// Private attribute: price (double)
/// Protected attributes: title (String), author (String)
/// Package-private attribute: isbn (String) — no modifier
/// Public attribute: isAvailable (boolean)
/// Constructor takes all four parameters, sets isAvailable to true
/// Public method: getPrice() — returns price
/// Package-private method: applyDiscount(double percent) — reduces price by percent (only callable within library.books!)
/// Protected method: getBookType() — returns "Physical Book"
/// Public method: displayInfo() — displays all book info