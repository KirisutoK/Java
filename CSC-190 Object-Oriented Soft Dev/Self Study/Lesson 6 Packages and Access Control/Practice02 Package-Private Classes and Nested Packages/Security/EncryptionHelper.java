package Security;

// Creation Date: May 29, 2026. at 3:35 AM
// Last Modified: May 30, 2026. at 10:46 AM

class EncryptionHelper {
    //=======VARIABLES=======//

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    static String encrypt(String data) {
        
        String EncryptedString = "";
        for (int i = data.length()-1; i >= 0; i--) { // Start from the top, ends at 0
            EncryptedString += data.charAt(i);
        }

        return EncryptedString;
    }
    static String decrypt(String data) {

        String DecryptedString = "";
        for (int i = 0; i < data.length(); i++) { // Start from 0, ends at the top
            DecryptedString += data.charAt(i);
        }

        return DecryptedString;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}


// TODO: YOU LEFT HERE!!!!
// TODO: YOU WERE CONFUSED AT WHY CLAUDE GAVE US THIS PROMPT WHEN LITERALLY STATIC CANT BE CALLED SINCE THE CLASS IS PACKAGE-PRIVATE