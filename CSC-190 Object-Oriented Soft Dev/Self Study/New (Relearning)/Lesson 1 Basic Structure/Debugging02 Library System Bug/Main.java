// Main.java
public class Main {
    public static void main(String[] args) {
        Library library = new Library("City Library");

        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("Dune", "Frank Herbert");

        library.addBook(book1);
        library.addBook(book2);

        Member member1 = new Member("John", 101);

        member1.borrowBook(book1);
        member1.borrowBook(book2);

        member1.displayBorrowedBooks();

        member1.returnBook(book1);

        member1.displayBorrowedBooks();
    }
}