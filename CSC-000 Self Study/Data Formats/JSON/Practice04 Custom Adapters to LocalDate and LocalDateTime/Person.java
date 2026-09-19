// Creation Date: September 17, 2026. at 2:14 PM
// Last Modified: September 18, 2026. at  8:27 PM

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Person {
    //=======VARIABLES=======//
    private String Name;
    private int Age;
    private LocalDate Birthday;
    private LocalDateTime CreationDate;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Person(String Name, int Age) {
        this.Name = Name;
        this.Age = Age;
        CreationDate = LocalDateTime.now();
    }
    public Person(String Name, int Age, LocalDate Birthday) {
        this.Name = Name;
        this.Age = Age;
        this.Birthday = Birthday;
        CreationDate = LocalDateTime.now();
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void setBirthday(LocalDate Birthday) {
        this.Birthday = Birthday;
    }
    public String getCreationDate() {
        DateTimeFormatter DTF = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");

        return DTF.format(CreationDate);
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInformation() {
        System.out.println("Name: "+Name);
        System.out.println("Age: "+Age);
        System.out.println("Birthday: "+((Birthday != null) ? Birthday.getMonth()+" "+Birthday.getDayOfMonth()+", "+Birthday.getYear() : "NULL") );
        System.out.println("Creation Date: "+getCreationDate());

    }

    // ================================================== OTHER CLASSES ================================================== \\
}
