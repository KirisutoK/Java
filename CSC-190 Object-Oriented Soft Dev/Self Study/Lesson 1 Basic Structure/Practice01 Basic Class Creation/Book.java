public class Book {
    private String Title = "";
    private String Author = "";
    private int PageCount = 0;

    //THIS IS A CONSTRUCTOR (IT MAKES IT SO THAT IT WILL BE ABLE TO CONNECT OR USED FROM OTHER FILES) NOTE: THIS IS NEEDED FOR OOP
    public Book(String t, String a, int pC) { // Title, Author, pC
        this.Title = t;
        this.Author = a;
        this.PageCount = pC;
    }

    //==========GETTERS==========\\ NOTE: GETTERS are important in order to access the private variables that are only accessible by using this file.
    public String getTitle() {
        return Title;
    }
    public String getAuthor() {
        return Author;
    }
    public int getPageCount() {
        return PageCount;
    }

    //==========METHODS==========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void getBookInfo() {
        System.out.println("Title: " + Title);
        System.out.println("Author: " + Author);
        System.out.println("Page Count: " + PageCount);
    }
}
