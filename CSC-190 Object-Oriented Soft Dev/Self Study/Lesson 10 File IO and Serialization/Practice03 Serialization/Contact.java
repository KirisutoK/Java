// Creation Date: July 20, 2026. at 6:41 PM
// Last Modified: July 20, 2026. at  7:10 PM

import java.io.Serializable;

public class Contact implements Serializable {
    //=======VARIABLES=======//
    private String Name;
    private String PhoneNumber;
    private String Email;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Contact(String Email, String PhoneNumber, String Name) {
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Name = Name;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getName() {
        return Name;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public String getEmail() {
        return Email;
    }


    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInfo() {
        System.out.println("Name: "+Name);
        System.out.println("Phone Number: "+PhoneNumber);
        System.out.println("Email: "+Email);
    }


    // ================================================== OTHER CLASSES ================================================== \\
}
