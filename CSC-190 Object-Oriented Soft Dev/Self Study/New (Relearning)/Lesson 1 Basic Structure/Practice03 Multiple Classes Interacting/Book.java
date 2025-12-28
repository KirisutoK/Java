public class Book {
    //=======VARIABLES=======//
    private String Title = "";
    private String Author = "";
    private String ISBN = "";
    private Boolean IsAvailable = true;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Book(String title, String author, String isbn) { // A CONSTRUCTUR THAT DOES NOT TAKE isAvailable
        this.Title = title;
        this.Author = author;
        this.ISBN = isbn;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getTitle() {
        return Title;
    }
    public String getAuthor() {
        return Author;
    }
    public String getISBN() {
        return ISBN;
    }
    public Boolean getIsAvailable() {
        return IsAvailable;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void borrowBook(String membername) { // Sets the IsAvailabe to false
        this.IsAvailable = false;
        System.out.println(membername + " have borrowed: " + Title);
    }
    public void returnBook(String membername) { // Sets the IsAvailabe to true
        this.IsAvailable = true;
        System.out.println(membername + " have returned: " + Title);
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void DisplayBookInfo() {
        System.out.println("Title: " + Title);
        System.out.println("Author: " + Author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Available: " + IsAvailable);
    }
    
}
