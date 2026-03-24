public class Main {
    public static void main(String[] args) {
        //===========INSTANCES/OBJECTS===========\\
        Book book1 = new Book("One Piece", "Eichiro Oda", "03243243"); // Title, Author, ISBN
        Book book2 = new Book("Gachiakuta", "Artist Mangaka", "6767667"); // Title, Author, ISBN
        Book book3 = new Book("Rent a Girlfriend", "SIMP", "69696969"); // Title, Author, ISBN

        Member member1 = new Member("John", 123);
        Member member2 = new Member("Sarah", 231);

        //=================PROCESS=================\\
        member1.memberborrowBook(book1); //if book1 isAvailable then turn isAvailable into false
        System.out.println(" "); // Just a space for better readability
        member1.DisplayMemberBookInfo(); // ============= THIS IS WHERE YOU LEFT (THERE IS AN ERROR)
        System.out.println(" "); // Just a space for better readability
        member2.memberborrowBook(book1); // Return the book and turn isAvailable into true
        System.out.println(" "); // Just a space for better readability
        member1.returnBook(book1); // Return the book and turn isAvailable into true
        System.out.println(" "); // Just a space for better readability
        member2.memberborrowBook(book1); // Now Sarah can borrow the book
        System.out.println(" "); // Just a space for better readability
        member2.DisplayMemberBookInfo(); // Display Sarah's borrowed book info
        System.out.println(" "); // Just a space for better readability
        member1.DisplayMemberBookInfo();
        System.out.println(" "); // Just a space for better readability
    }
}
