public class Song extends Media {
    //=======VARIABLES=======//
    private String Artist;
    private String Album;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Song(String Title, String Duration, Double Rating, String Artist, String Album) {
        super(Title, Duration, Rating);
        this.Artist = Artist;
        this.Album = Album;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void addToPlaylist(String PlaylistName)  {
        System.out.println(Title + " added to playlist: " + PlaylistName); // something is odd...
    }


    // @OVERRIDE
    @Override
    public void Play() {
        System.out.println("Playing song: " + Title + " by " + Artist);
    }
    @Override
    public void DisplayInformation() {
        super.DisplayInformation();
        System.out.println("Artist: " + Artist);
        System.out.println("Album: " + Album);
    }
}
