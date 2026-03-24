public class Member {
    //=======VARIABLES=======//
    private String MemberName = "";
    private int MemberID = 0;
    private Book MemberBook;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Member(String membername, int memberid) {
        this.MemberName = membername;
        this.MemberID = memberid;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getMemberName() {
        return MemberName;
    }
    public int getMemberID() {
        return MemberID;
    }
    public Book getBorrowedBook() {
        return MemberBook;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void memberborrowBook(Book b) { //Book = DataType | book = variable
        if (b.getIsAvailable() == true) { //Checks if Book is available through the variable in the Book Class
            b.borrowBook(MemberName); // turns isAvailable to false
            this.MemberBook = b; // Assigns the borrowed book to the member
        } else {
            System.out.println(b.getTitle() + " is not available");
        }
    }

    public void returnBook(Book b) {
        b.returnBook(MemberName);
        this.MemberBook = null;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    public void DisplayMemberBookInfo() {
        System.out.println("Member Name: " + MemberName);
        System.out.println("Member ID: " + MemberID);
        if (MemberBook == null) {
            System.out.println("Member Book: None");
            return;
        } else {
            System.out.println("Member Book: " + MemberBook.getTitle());
        }
    }
}
