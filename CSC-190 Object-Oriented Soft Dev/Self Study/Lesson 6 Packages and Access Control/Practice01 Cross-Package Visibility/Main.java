// Creation Date: March 25, 2026. at 10:54 AM
// Last Modified: May 23, 2026. at  9:43 AM

import Books.*;
import Members.*;
import Management.*;

public class Main {
    public static void main(String[] args) {
        // ==================== CREATING INSTANCES OR OBJECTS ==================== \\
        // [BOOK]
        Book Book01 = new Book("Java OOP", "Paige Labar", "9782306123315", 145.50);
        Book EBook01 = new EBook("Java OOP", "Paige Labar", "9782303223315", 145.50, "PDF", 12300.5);
        Book AudioBook01 = new AudioBook("SCP-Something", "Zhiannelle Gravino", "9790303223315", 50.67, "Christ Aerjil Dampog", 125);

        // [MEMBER]
        Member Member01 = new Member("Christ Aerjil Dampog", "M01");
        PremiumMember PremiumMember01 = new PremiumMember("PremiumMember01", "PM01", 0.5);
        Staff Staff01 = new Staff("Staff01", "Staff");

        // [LIBRARY]
        Library Library01 = new Library("Library01");

        // ==================== METHODS ==================== \\
        // [ADDING BOOK TO THE LIBRARY]
        Library01.addBook(Book01);
        Library01.addBook(EBook01);
        Library01.addBook(AudioBook01);
        System.out.println(" "); // Space for Readability

        // [ADDING MEMBER TO THE LIBRARY]
        Library01.addMember(Member01);
        Library01.addMember(PremiumMember01);
        Library01.addStaff(Staff01);
        System.out.println(" "); // Space for Readability

        // [MEMBER BORROW THE BOOK]
        Member01.borrowBook(Book01);
        PremiumMember01.borrowBook(EBook01);
        System.out.println(" "); // Space for Readability

        // [PROCESS RETURN]
        Staff01.processReturn(Book01);
        Transaction Transaction01 = new Transaction("T01", Member01.getName(), Book01.getTitle(), "Return");
        Transaction01.displayTransaction();
        System.out.println(" "); // Space for Readability

        // [DISPLAY ALL BOOKS & MEMBERS]
        Library01.displayAllBooks();
        System.out.println("Available Books"+Library01.countAvailableBooks());
    }
}

//// Create 1 Book, 1 EBook, 1 AudioBook — add all to library
/// Create 1 Member, 1 PremiumMember, 1 Staff — add members to library
/// Have Member borrow the Book
/// Have PremiumMember borrow the EBook
/// Have Staff process a return for the Book
/// Create Transaction records for each borrow/return and display them
/// Display all books and all members
/// Call countAvailableBooks() and display the result
// In the access modifier test section, demonstrate with comments what IS and IS NOT accessible from outside packages

// ANSWERS: public methods/variables are able to be accessed anywhere within as long as the package is imported
// ANSWERS: private method/variables are unable to be accessed unless you create a getter/setter method for it or by @Overriding it
// ANSWERS: protected method/variabls are able to be accessed only within the same connection of classes (parents->children)