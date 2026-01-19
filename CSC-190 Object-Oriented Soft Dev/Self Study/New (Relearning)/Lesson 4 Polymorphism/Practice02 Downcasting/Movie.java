public class Movie extends Media {
    //=======VARIABLES=======//
    private String Director;
    private Boolean HasSubtitles;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Movie(String Title, String Duration, Double Rating, String Director, Boolean HasSubtitles) {
        super(Title, Duration, Rating);
        this.Director = Director;
        this.HasSubtitles = HasSubtitles;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void enableSubtitles() {
        if (HasSubtitles == true) { // If it's true
            System.out.println("Subtitles is already on");
        } else { // if it's false
            HasSubtitles = true;
            System.out.println("Subtitles has been turned on");
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    // @OVERRIDE
    @Override
    public void Play() {
        System.out.println("Playing movie:" + Title + " directed by " + Director);
    }
    @Override
    public void DisplayInformation() {
        super.DisplayInformation();
        System.out.println("Director: " + Director);
        System.out.println("Subtitles: " + HasSubtitles);
    }
}
