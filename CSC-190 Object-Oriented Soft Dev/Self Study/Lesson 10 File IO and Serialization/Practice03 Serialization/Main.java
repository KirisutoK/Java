// Creation Date: July 20, 2026. at 6:41 PM
// Last Modified: July 22, 2026. at  7:01 PM

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        //======= CREATING OBJECTS/INSTANCES =======//
        ContactBook CBook01 = new ContactBook("First Contact Book");

        //======= FOR CLAUDE =======//
        CBook01.loadFromFile(); // Should say null or error because nothing has saved up yet
        CBook01.addContact(new Contact("Test@Gmail.com", "123456789", "Tester01"));
        CBook01.addContact(new Contact("Test@Gmail.com", "123456789", "Tester02"));
        CBook01.addContact(new Contact("Test@Gmail.com", "123456789", "Tester03"));
        System.out.println();

        // [DISPLAY]
        CBook01.displayAllContacts();
        System.out.println();

        // [SAVE TO FILE]
        CBook01.saveToFile();
        System.out.println();

        // [REMOVING A CONTACT]
        CBook01.removeContact("Tester01");
        System.out.println();

        // [DISPLAY]
        CBook01.displayAllContacts();
        System.out.println();

        // [LOAD FILE]
        CBook01.loadFromFile(); // Loads up the previous saved file
        System.out.println();

        // [DISPLAY]
        CBook01.displayAllContacts();
        System.out.println();

        // [FIND CONTACT]
        CBook01.findContact("Tester01");
    }

    // =========================== OTHER METHODS =========================== \\
}
