package Members;

// Creation Date: March 26, 2026. at 10:23 AM
// Last Modified: May 23, 2026. at  9:26 AM

import Books.Book;

public class Staff {
    //=======VARIABLES=======//
    private String StaffName;
    private String Role;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Staff(String StaffName, String Role) {
        this.StaffName = StaffName;
        this.Role = Role;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getStaffName() {
        return StaffName;
    }
    public String getRole() {
        return Role;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void processReturn(Book b) {
        //? CHECK IF IT'S A BOOK
        if (b == null) {
            System.out.println("Book is null");
            return;
        }

        //? CHECK IF THE BOOK HAS BEEN BORROWED
        if (b.isAvailable) { // if the Book is available
            System.out.println(b.getTitle()+" ("+b.getAuthor()+") has already been returned.");
            return;
        }

        //? RETURN THE BOOK
        b.isAvailable = true;
        System.out.println(b.getTitle()+" ("+b.getAuthor()+") has been returned.");
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInformation() {
        System.out.println("Name: "+StaffName);
        System.out.println("Role: "+Role);
    }
}


//// Private attributes: staffName (String), role (String)
/// Constructor takes staffName and role
/// Public method: displayInfo() — shows staff name and role
/// Public method: processReturn(Book book) — sets book.isAvailable to true and prints confirmation