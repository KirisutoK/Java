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
        member1.DisplayMemberBookInfo(); // ============= THIS IS WHERE YOU LEFT (THERE IS AN ERROR)
    }
}
