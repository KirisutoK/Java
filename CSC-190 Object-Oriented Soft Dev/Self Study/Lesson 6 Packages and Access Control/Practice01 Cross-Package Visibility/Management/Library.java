package Management;

// Creation Date: March 26, 2026. at 10:23 AM
// Last Modified: May 20, 2026. at 11:39 PM

import Books.Book;
import Members.Member;

public class Library {
    //=======VARIABLES=======//
    private String LibraryName;
    private Book[] Books = new Book[20];
    private int BookCount;
    private Member[] Members = new Member[10];
    private int MemberCount;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Library(String LibraryName) {
        this.LibraryName = LibraryName;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void addBook(Book b) {
        // CHECK IF ITS ALREADY ADDED

        // CHECK IF THE LIBRARY IS FULL

        // ADDING IT INTO THE LIBRARY
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
