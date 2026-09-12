// Creation Date: September 12, 2026. at 3:32 PM
// Last Modified: September 12, 2026. at  4:00 PM

import com.google.gson.Gson;         // the core class you'll use
import com.google.gson.JsonSyntaxException; // thrown when a JSON string is malformed

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        Person Person01 = new Person("Christ", 19, true);
        Person01.addHobbies("Sleeping");
        Person01.addHobbies("Watching Anime");
        Person01.addHobbies("Playing video games");

        Gson Gson01 = new Gson();

        String json01 = Gson01.toJson(Person01);

        System.out.println(json01); //! <=============== YOU LEFT HERE (THINKING ABOUT HOW TO CREATE THE FILE TO SAVE THE JSON AND THEN CONVERT THE JSON INTO ANOTHER OBJECT)

    }

    // =========================== METHODS =========================== \\
}
