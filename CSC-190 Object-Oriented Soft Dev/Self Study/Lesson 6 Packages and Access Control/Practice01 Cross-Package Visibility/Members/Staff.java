package Members;

// Creation Date: March 26, 2026. at 10:23 AM
// Last Modified: March 30, 2026. at 12:39 PM

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

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}


//// Private attributes: staffName (String), role (String)
/// Constructor takes staffName and role
// Public method: displayInfo() — shows staff name and role
// Public method: processReturn(Book book) — sets book.isAvailable to true and prints confirmation