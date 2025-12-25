public class Book {
    private String title;
    private String author;
    private int pages;

    public Book(String TITLE, String AUTHOR, int PAGES) {
        this.title = TITLE;
        this.author = AUTHOR;
        this.pages = PAGES;
    }

    public boolean isLongBook() {
        if (pages > 300) {
            return true;
        } else {
            return false;
        }
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
    }
}
