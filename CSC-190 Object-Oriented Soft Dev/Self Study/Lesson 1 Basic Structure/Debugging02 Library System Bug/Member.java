// Member.java
public class Member {
    private String name;
    private int memberId;
    private Book[] borrowedBooks;
    private int bookCount;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        borrowedBooks = new Book[3];
        bookCount = 0;
    }

    public void borrowBook(Book book) {
        if (!book.isAvailable()) {
            System.out.println("Book is not available");
            return;
        }

        if (bookCount >= borrowedBooks.length) {
            System.out.println("Cannot borrow more books");
            return;
        }

        borrowedBooks[bookCount] = book;
        bookCount++;
        book.setAvailable(false);
        System.out.println(name + " borrowed: " + book.getTitle());
    }

    public void returnBook(Book book) {
        int position = -1;

        for (int i = 0; i < bookCount; i++) { // Finding its position of the book
            if (borrowedBooks[i] == book) {
                position = i;
                break;
            }
        }

        if (position == -1) { // If the position is did not change
            System.out.println("Book not found in borrowed list");
            return;
        }

        // Shift books left
        for (int i = position; i < bookCount; i++) {
            borrowedBooks[i] = borrowedBooks[i + 1];
        }

        bookCount--;
        book.setAvailable(true);
        System.out.println(name + " returned: " + book.getTitle());
    }

    public void displayBorrowedBooks() {
        System.out.println(name + "'s borrowed books:");
        if (bookCount == 0) {
            System.out.println("No books borrowed");
            return;
        }

        for (int i = 0; i < bookCount; i++) {
            System.out.println("- " + borrowedBooks[i].getTitle());
        }
    }
}