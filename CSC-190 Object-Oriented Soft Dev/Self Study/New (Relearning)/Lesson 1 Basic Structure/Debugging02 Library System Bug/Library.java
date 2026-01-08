// Library.java
public class Library {
    private String libraryName;
    private Book[] books;
    private int bookCount;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        books = new Book[10];
        bookCount = 0;
    }

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
            System.out.println("Added: " + book.getTitle());
        }
    }
}