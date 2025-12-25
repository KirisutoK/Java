public class main {
    public static void main(String[]args) {
        Book book1 = new Book("Harry Potter", "J.K. Rowling", 4100);
        Book book2 = new Book("PennyWise", "Stephen King", 229);

        book1.displayInfo();
        book2.displayInfo();

        System.out.println("Is Book 1 a long book? " + book1.isLongBook());
        System.out.println("Is Book 2 a long book? " + book2.isLongBook());
    }
}
