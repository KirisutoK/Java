package Members;

// Creation Date: March 26, 2026. at 10:23 AM
// Last Modified: March 29, 2026. at 12:31 PM

import Books.*;

public class PremiumMember extends Member {
    //=======VARIABLES=======//
    private double DiscountRate;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public PremiumMember(String Name, String MemberID, double DiscountRate) {
        super(Name, MemberID);
        this.DiscountRate = DiscountRate;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    
    @Override public void borrowBook(Book book) {
        //? CHECK AVAILABILITY
        if (book.isAvailable) { // boolean default return is true, '!' if false.
            //? CHECK LIMIT NOTIFICATION
            if (BookCount == borrowedBooks.length) {
                System.out.println(Name+" have hit the maximum limit to borrow books. [5/5]");
                return; // stops the whole method here
            }
            //? CHECK DUPLICATION NOTIFICATION
            for (int i = 0; i < BookCount; i++) {
                if (book == borrowedBooks[i]) { // if it matches
                    System.out.println(Name+" is already borrowing "+book.getTitle()+" ("+book.getAuthor()+")");
                    return; // stops the whole method here
                }
            }
            //? SETTING UP
            borrowedBooks[BookCount] = book;
            book.isAvailable = false;
            BookCount++;
            System.out.println(Name+" has borrowed "+book.getTitle()+" ("+book.getAuthor()+")");

        } else { // if it's not available
            System.out.println(book.getTitle() + " (" + book.getAuthor() + ") is unavailable.");
        }

        // Comments:
        // - book.isAvailable is public so we don't need to make a getter for it.
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}


//// Private attribute: discountRate (double)
/// Constructor takes name, memberId, discountRate
// TODO: Override borrowBook(Book book) — print "Premium member [name] borrowing book", then call super.borrowBook(book)
// Note: Can access name because it's protected in parent AND same package