// Creation Date: March 25, 2026. at 10:54 AM
// Last Modified: March 28, 2026. at 11:00 AM

import Books.*;
import Members.*;
import Management.*;

public class Main {
    public static void main(String[] args) {
        // ==================== CREATING INSTANCES OR OBJECTS ==================== \\
        // [LIBRARY]

        // [BOOK]
        Book Book01 = new Book("Java OOP", "Paige Labar", "9782306123315", 145.50);
        Book EBook01 = new EBook("Java OOP", "Paige Labar", "9782303223315", 145.50, "PDF", 12300.5);
        Book AudioBook01 = new AudioBook("SCP-Something", "Zhiannelle Gravino", "9790303223315", 50.67, "Christ Aerjil Dampog", 125);

        // [MEMBER]
        Member Member01 = new Member("Christ Aerjil Dampog", "M01");

        // ==================== METHODS ==================== \\
        Member01.borrowBook(Book01);
        Member01.borrowBook(Book01);
    }
}

// TODO: Create a Library
// Create 1 Book, 1 EBook, 1 AudioBook — add all to library
// Create 1 Member, 1 PremiumMember, 1 Staff — add members to library
// Have Member borrow the Book
// Have PremiumMember borrow the EBook
// Have Staff process a return for the Book
// Create Transaction records for each borrow/return and display them
// Display all books and all members
// Call countAvailableBooks() and display the result
// In the access modifier test section, demonstrate with comments what IS and IS NOT accessible from outside packages
