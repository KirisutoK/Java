package Misc;

// Creation Date: September 29, 2026. at 3:10 PM
// Last Modified: September 29, 2026. at  3:44 PM

import java.security.MessageDigest;
import java.time.LocalDate;

import java.time.Period;


public class DataManager {
    //=======VARIABLES=======//

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    // [BIRTHDAYS]
    public static String toStringBirthday(LocalDate Birthday) {
        return Birthday.getMonth()+" "+ Birthday.getDayOfMonth()+", "+ Birthday.getYear();
    }
    public static int getAge(LocalDate Birthday) {
        return Period.between(Birthday, LocalDate.now()).getYears();
    }

    // [SECURITY]
    public static String hashPassword(String password) throws Exception { // NOTE: THIS IS METHOD IS ENTIRELY MADE BY CLAUADE
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashed = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashed) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    
    
    
    
    // ================================================== OTHER CLASSES ================================================== \\
}
