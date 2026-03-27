package Books;

// Creation Date: March 26, 2026. at 10:22 AM
// Last Modified: March 27, 2026. at  2:19 PM

public class AudioBook extends Book {
    //=======VARIABLES=======//
    private String Narrator;
    private int DurationMinutes; // in Minutes

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public AudioBook(String Title, String Author, String ISBN, double Price, String Narrator, int DurationMinutes) {
        super(Title, Author, ISBN, Price);
        this.Narrator = Narrator;
        this.DurationMinutes = DurationMinutes;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getNarrator() {
        return Narrator;
    }

    // --- @OVERRIDE ---
    @Override protected String getBookType() {
        return "Audio Book";
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}

//// Private attributes: narrator (String), durationMinutes (int)
/// Constructor takes all Book parameters + narrator and durationMinutes
/// Override getBookType() — returns "Audio Book"
/// Public getter: getNarrator()