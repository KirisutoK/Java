package Management;

// Creation Date: March 26, 2026. at 10:23 AM
// Last Modified: May 21, 2026. at 12:39 AM

import Books.Book;
import Members.Member;
import Members.PremiumMember;

public class Library {
    //=======VARIABLES=======//
    private String LibraryName;
    private Book[] Books;
    private int BookCount;
    private Member[] Members;
    private int MemberCount;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Library(String LibraryName) {
        this.LibraryName = LibraryName;
        Books = new Book[20];
        Members = new Member[10];
        BookCount = 0;
        MemberCount = 0;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void addBook(Book b) {
        //? CHECK LIMIT
        if (BookCount >= Books.length) {
            System.out.println(LibraryName+" is full!");
            return; // stops the whole method here
        }

        //? CHECK IF ITS ALREADY ADDED
        for (int i = 0; i < BookCount; i++) { // for every index of Books (from 0 to BookCount)
            if (Books[i].equals(b)) { // if it matches
                System.out.println(b.getTitle()+" ("+b.getAuthor()+") has already been added into "+LibraryName);
                return; // stops the whole method here
            }
        }

        //? ADDING IT INTO THE LIBRARY
        Books[BookCount] = b;
        BookCount++;
        System.out.println(b.getTitle()+" ("+b.getAuthor()+") has been added into "+LibraryName);
    }
    public void addMember(Member m) {
        //? CHECK LIMIT
        if (MemberCount >= Members.length) { // if MemberCount is greater than or equal to Members
            System.out.println(LibraryName+" is full!");
            return; // stops the whole method here
        }

        //? CHECK IF ITS ALREADY ADDED
        for (int i = 0; i < MemberCount; i++) { // for every index of Books (from 0 to BookCount)
            if (Members[i].equals(m)) { // if it matches
                if (Members[i] instanceof PremiumMember) { // if it's a Premium Member
                    System.out.println(m.getName()+" ("+m.getMemberID()+") has already been added as a Premium Member into "+LibraryName);
                } else { // if it's a regular member
                    System.out.println(m.getName()+" ("+m.getMemberID()+") has already been added as a Member into "+LibraryName);
                }
                return; // stops the whole method here
            }
        }

        //? ADDING IT INTO THE LIBRARY
        Members[MemberCount] = m;
        MemberCount++;
        if (m instanceof PremiumMember) { // if the Member is a premium member
            System.out.println(m.getName()+" ("+m.getMemberID()+") has been added as a Premium Member into "+LibraryName);
        } else {
            System.out.println(m.getName()+" ("+m.getMemberID()+") has been added as a Member into "+LibraryName);
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayAllBooks() {
        System.out.println("| "+LibraryName+" ALL BOOKS  |");
        System.out.println(" "); // Space for Readability
        for (int i = 0; i < BookCount; i++) {
            Books[i].displayInformation();
            System.out.println(" "); // Space for Readability
        }
    }
    public void displayAllMembers() {

    }
}

// TODO: YOU LEFT AT displayAllMembers();