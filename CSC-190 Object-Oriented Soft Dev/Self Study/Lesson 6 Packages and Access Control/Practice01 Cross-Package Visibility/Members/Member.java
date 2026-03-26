package Members;

// Creation Date: March 26, 2026. at 10:23 AM
// Last Modified: March 26, 2026. at 10:59 AM

import Books.Book;

public class Member {
    //=======VARIABLES=======//
    protected String Name;
    protected String MemberID;
    private Book[] borrowedBooks = new Book[5];
    private int BookCount = 0;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Member(String Name, String MemberID) {
        this.Name = Name;
        this.MemberID = MemberID;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void borrowBook(Book book) {
        //? CHECK AVAILABILITY
        if (book.isAvailable) { // boolean default return is true, '!' if false.
            book.isAvailable = false;
            //? CHECK LIMIT NOTIFICATION
            if (BookCount == borrowedBooks.length) {
                System.out.println(Name+" have hit the maximum limit to borrow books. [5/5]");
                return; // stops the whole method here
            }
            //? CHECK DUPLICATION NOTIFICATION
            for (Book i:borrowedBooks) { // for every book borrow
                //! I DONT KNOW IF THIS WIL BE AN ERROR ABOUT COMPARING OBJECTS TO A NULL
                if (i.equals(book)) { // if it matches
                    System.out.println(Name+" is already borrowing "+book.getTitle()+" ("+book.getAuthor()+")");
                }
            }
            //? SETTING UP
            System.out.println(Name+" has borrowed "+book.getTitle()+" ("+book.getAuthor()+")");

        } else { // if it's not available
            System.out.println(book.getTitle()+" ("+book.getAuthor()+") is unavailable.");
        }


    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}

//// Protected attributes: name (String), memberId (String)
//// Private attributes: borrowedBooks (Book array, size 5), bookCount (int)
//// Constructor takes name and memberId
//Public method: borrowBook(Book book) — checks isAvailable (public so OK), sets it to false, adds to array
//Inside borrowBook(), add commented-out lines showing what you CANNOT access from outside the package:
