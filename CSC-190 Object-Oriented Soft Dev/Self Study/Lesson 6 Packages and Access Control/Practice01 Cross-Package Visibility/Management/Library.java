package Management;

// Creation Date: March 26, 2026. at 10:23 AM
// Last Modified: May 24, 2026. at 10:43 AM

import Books.Book;
import Members.Member;
import Members.PremiumMember;
import Members.Staff;

public class Library {
    //=======VARIABLES=======//
    private String LibraryName;
    private Book[] Books;
    private int BookCount;
    private Member[] Members;
    private int MemberCount;
    private Staff[] Staffs;
    private int StaffCount;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Library(String LibraryName) {
        this.LibraryName = LibraryName;
        Books = new Book[20];
        Members = new Member[10];
        Staffs = new Staff[1];
        BookCount = 0;
        MemberCount = 0;
        StaffCount = 0;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public int countAvailableBooks() {
        int TotalAvailableBooks = 0;

        for (int i = 0; i < BookCount; i++) {
            if (Books[i].isAvailable) { // if Index of Book Array has its value of isAvailable to true
                TotalAvailableBooks++;
            }
        }

        return TotalAvailableBooks;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void addBook(Book b) {
        //? CHECK IF IT'S A BOOK
        if (b == null) {
            System.out.println("Book is null");
            return;
        }
        
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
        //? CHECK IF IT'S A MEMBER
        if (m == null) {
            System.out.println("Member is null");
            return; // stops the whole method here
        }

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
    public void addStaff(Staff s) {
        //? CHECK IF IT'S A MEMBER
        if (s == null) {
            System.out.println("Member is null");
            return; // stops the whole method here
        }

        //? CHECK LIMIT
        if (StaffCount >= Staffs.length) { // if MemberCount is greater than or equal to Members
            System.out.println(LibraryName+" is full!");
            return; // stops the whole method here
        }

        //? CHECK IF ITS ALREADY ADDED
        for (int i = 0; i < StaffCount; i++) { // for every index of Books (from 0 to BookCount)
            if (Staffs[i].equals(s)) { // if it matches
                System.out.println(s.getStaffName() + "  has already been added as a Staff into " + LibraryName);
                return; // stops the whole method here
            }
        }

        //? ADDING IT INTO THE LIBRARY
        Staffs[StaffCount] = s;
        StaffCount++;
        System.out.println(s.getStaffName()+" ("+s.getRole()+") has been added as a Member into "+LibraryName);

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
        System.out.println("| "+LibraryName+" ALL MEMBERS  |");
        System.out.println(" "); // Space for Readability
        for (int i = 0; i < MemberCount; i++) {
            Members[i].displayInformation();
            System.out.println(" "); // Space for Readability
        }
    }
}