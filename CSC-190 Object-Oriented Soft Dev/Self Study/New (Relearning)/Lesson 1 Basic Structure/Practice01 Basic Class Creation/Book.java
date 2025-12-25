/*
    Practice #1: Basic Class Creation
    Create a Book class with the following requirements:
    Requirements:

    1. The class should have three private attributes:
        title (String)
        author (String)
        pageCount (int)
    2. Create a constructor that takes all three parameters and initializes the attributes
    3. Create getter methods for all three attributes
    4. Create a method called getBookInfo() that returns a String with all the book information formatted nicely (however you want to format it)
    5. In your main method, create at least 2 Book objects and print their information

    NOTES:
    1. There are 3 classifications of Variables
        1. Private
        2. Public
        3. Protected
*/

public class Book { 
    private String Title = "";
    private String Author = "";
    private int PageCount = 0;

    //THIS IS A CONSTRUCTOR (IT MAKES IT SO THAT IT WILL BE ABLE TO CONNECT OR USED FROM OTHER FILES) NOTE: THIS IS NEEDED FOR OOP
    public Book(String t, String a, int pC) { // Title, Author, pC
        this.Title = t;
        this.Author = a;
        this.PageCount = pC;
    }

    //==========GETTERS==========\\ NOTE: GETTERS are important in order to access the private variables that are only accessible by using this file.
    public String getTitle() {
        return Title;
    }
    public String getAuthor() {
        return Author;
    }
    public int getPageCount() {
        return PageCount;
    }

    //==========METHODS==========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void getBookInfo() {
        System.out.println("Title: " + Title);
        System.out.println("Author: " + Author);
        System.out.println("Page Count: " + PageCount);
    }
}
