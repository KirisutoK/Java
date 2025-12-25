/*
    Practice #1: Basic Class Creation
    Create a Book class with the following requirements:
    Requirements:

    1. The class should have three private attributes:
        title (String)
        author (String)
        pageCount (int)
    2. Create a constructor that takes all three parameters and initializes the attributes
    3. Create getter methods for all three attributes
    4. Create a method called getBookInfo() that returns a String with all the book information formatted nicely (however you want to format it)
    5. In your main method, create at least 2 Book objects and print their information
*/

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("One Piece", "Eichiiro Oda", 1975); // Title, Author, PageCount
        Book book2 = new Book("Jojo","Mugen", 644); // Title, Author, PageCount

        book1.getBookInfo();
        System.out.println(" "); // makes a blank space for readabilty
        book2.getBookInfo();
    }
}
