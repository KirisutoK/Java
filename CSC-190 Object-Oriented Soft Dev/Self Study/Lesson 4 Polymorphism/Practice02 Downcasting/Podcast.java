public class Podcast extends Media {
    //=======VARIABLES=======//
    private String Host;
    private int EpisodeNumber;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Podcast(String Title, String Duration, Double Rating, String Host, int EpisodeNumber) {
        super(Title, Duration, Rating);
        this.Host = Host;
        this.EpisodeNumber = EpisodeNumber;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void downloadEpisode() {
        System.out.println("Downloading episode "+EpisodeNumber+" of "+Title);
    }


    // @OVERRIDE
    @Override
    public void Play() {
        System.out.println("Playing podcast: " + Title + " - Episode " + EpisodeNumber +" hosted by " + Host);
    }
    @Override
    public void DisplayInformation() {
        super.DisplayInformation();
        System.out.println("Host: " + Host);
        System.out.println("Episode: " + EpisodeNumber);
    }
}
