public class Media {
    //=======VARIABLES=======//
    protected String Title;
    protected String Duration; //in Minutes
    protected double Rating;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Media(String Title, String Duration, Double Rating) {
        this.Title = Title;
        this.Duration = Duration;
        this.Rating = Rating;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public Boolean isLongContent() {
        int DurationInMinutes = Integer.parseInt(Duration);
        return DurationInMinutes >= 120; // in Minutes
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void Play() {
        System.out.println("Playing " + Title);
    }
    public void DisplayInformation() {
        System.out.println("Title: " + Title);
        System.out.println("Duration: " + Duration);
        System.out.println("Rating: " + Rating);
    }
}
