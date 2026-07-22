// Creation Date: July 20, 2026. at 6:41 PM
// Last Modified: July 21, 2026. at  8:39 PM

import java.io.*;
import java.util.ArrayList;

public class ContactBook {
    //=======VARIABLES=======//
    private ArrayList<Contact> Contacts;
    private String FilePath;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public ContactBook(String FilePath) {
        Contacts = new ArrayList<>();
        this.FilePath = FilePath;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public void saveToFile() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FilePath));
            oos.writeObject(Contacts);
            oos.close();
            System.out.println("Contacts has been successfully saved into the File!");
        } catch (IOException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
    public void findContact() {
        for (Contact c:Contacts) {
            c.displayInfo();
        }
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void addContact(Contact c) {
        if (c == null) {
            System.out.println("ERROR: You can't add a null contact!");
            return; // stops the whole method here
        }

        for (Contact contact:Contacts) {
            if ((c.getName().equals(contact.getName())) && (c.getEmail().equals(contact.getEmail())) && (c.getPhoneNumber().equals(contact.getPhoneNumber()))) {
                System.out.println(c.getName()+" already exists!");
                return; // stops the whole method here
            }
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
    public void loadFromFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FilePath));
            Contacts = (ArrayList<Contact>) ois.readObject();
            ois.close();

            System.out.println("Contacts has been successfully loaded from the File!");
        } catch (IOException e) {
            System.out.println("EROR: "+e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("No Saved Contact File found!");;
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayAllContacts() {
        System.out.println("++++++++++++++++++ "+ FilePath +" Contacts ++++++++++++++++++");
        for (Contact c:Contacts) {
            c.displayInfo();
            System.out.println();
        }
    }




    // ================================================== OTHER CLASSES ================================================== \\
}
