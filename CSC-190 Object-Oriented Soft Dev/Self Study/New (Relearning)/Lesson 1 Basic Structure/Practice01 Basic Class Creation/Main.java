public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("One Piece", "Eichiiro Oda", 1975); // Title, Author, PageCount
        Book book2 = new Book("Jojo","Mugen", 644); // Title, Author, PageCount

        book1.getBookInfo();
        System.out.println(" "); // makes a blank space for readabilty
        book2.getBookInfo();
    }
}
