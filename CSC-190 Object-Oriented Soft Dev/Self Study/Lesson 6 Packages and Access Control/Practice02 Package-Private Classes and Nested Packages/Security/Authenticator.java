package Security;

// Creation Date: May 29, 2026. at 3:32 AM
// Last Modified: May 30, 2026. at 10:49 AM

public class Authenticator {
    //=======VARIABLES=======//
    private static int LoginAttempts;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public static boolean authenticate(String username, String password) {
        return username.equals(password); //! I GENIUINELY DONT KNOW WHAT THIS IS.... PLEASE NEXT TIME CLAUDE COULD YOU ASK LOGICAL, REASONABLE, AND UNDERSTANDABLE ACTIVITES THAT ACTUALLY MAKE SENSE. BASED ON WHAT I UNDERSTAND, THIS METHOD DOESNT CORRELATE TO ANYTHING NOR THE RETURN IS. LIKE WHAT DO YOU MEAN IF USERNAME IS EQUALS TO PASSWORD???
    }
    public static String encryptData(String data) {
        return EncryptionHelper.encrypt(data);
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
