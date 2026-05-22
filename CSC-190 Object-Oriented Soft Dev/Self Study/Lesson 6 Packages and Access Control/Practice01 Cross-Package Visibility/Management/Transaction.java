package Management;

// Creation Date: March 26, 2026. at 10:23 AM
// Last Modified: May 22, 2026. at  1:06 AM

public class Transaction {
    //=======VARIABLES=======//
    private String TransactionID;
    private String MemberName;
    private String BookTitle;
    private String Type; // BORROW OR RETURN

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Transaction(String TransactionID, String MemberName, String BookTitle, String Type) {
        this.TransactionID = TransactionID;
        this.MemberName = MemberName;
        this.BookTitle = BookTitle;
        this.Type = Type;
    }
    
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayTransaction() {
        System.out.println("Transaction ID: "+TransactionID);
        System.out.println("Member Name: "+MemberName);
        System.out.println("Book Title: "+BookTitle);
        System.out.println("Type: "+Type);
    }
}
