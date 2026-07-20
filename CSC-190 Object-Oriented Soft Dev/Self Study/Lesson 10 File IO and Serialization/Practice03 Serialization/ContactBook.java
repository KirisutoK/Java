// Creation Date: July 20, 2026. at 6:41 PM
// Last Modified: July 20, 2026. at  7:19 PM

import java.util.ArrayList;

public class ContactBook {
    //=======VARIABLES=======//
    private ArrayList<Contact> Contacts;
    private String FileName;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public ContactBook(String FileName) {
        Contacts = new ArrayList<>();
        this.FileName = FileName;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //! public void saveToFile() {}

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void addContact(Contact c) {
        if (c == null) {
            System.out.println("ERROR: You can't add a null contact!");
            return; // stops the whole method here
        }

        Contacts.add(c);
    }
    public void removeContact(String n) {
        if (n == null) {
            System.out.println("ERROR: You can't delete a null contact!");
            return; // stops the whole method here
        }

        for (Contact c:Contacts) {
            if (c.getName().equals(n)) {
                Contacts.remove(c);
                System.out.println(n+" has successfully been removed from Contacts!");
                return; // stops the whole method here
            }
        }

        System.out.println("ERROR: "+n+" does not exists!");
    }
    //! public void loadFromFile() {}

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayAllContacts() {
        System.out.println("++++++++++++++++++ "+FileName+" Contacts ++++++++++++++++++");
        for (Contact c:Contacts) {
            c.displayInfo();
            System.out.println();
        }
    }




    // ================================================== OTHER CLASSES ================================================== \\
}
