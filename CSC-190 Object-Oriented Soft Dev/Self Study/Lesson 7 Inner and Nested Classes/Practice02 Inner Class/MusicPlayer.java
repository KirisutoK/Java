// Creation Date: June 03, 2026. at 10:53 PM
// Last Modified: June 03, 2026. at 11:27 PM

public class MusicPlayer {
    //=======VARIABLES=======//
    private String Brand;
    private boolean isOn;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public MusicPlayer(String Brand) {
        this.Brand = Brand;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void turnOn() {
        if (isOn) {
            System.out.println(Brand+" has already been turned on!");
        } else {
            isOn = true;
            System.out.println(Brand+" has been turned on!");
        }
    }
    public void turnOff() {
        if (isOn) {
            isOn = false;
        } else {
            System.out.println(Brand+" has already been turned off!");
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInfo() {
        System.out.println("Brand: "+Brand);
        System.out.println("Active: "+isOn);
    }

    // ================================================== OTHER CLASSES ================================================== \\
    class Song {
        //=======VARIABLES=======//
        private String Title;
        private String Artist;
        private int Duration; // in seconds

        //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
        public Song(String Title, String Artist, int Duration) {
            this.Title = Title;
            this.Artist = Artist;
            this.Duration = Duration;
        }

        //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

        //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
        public void play() {
            if (isOn) {
                System.out.println(Brand+" is now playing: "+Title+" by "+Artist);
            } else {
                System.out.println("Turn on the Music Player first!");
            }
        }

        //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
        public void displaySongInfo() {
            System.out.println("Title: "+Title);
            System.out.println("Artist: "+Artist);
            System.out.println("Duration: "+Duration);
        }
    }
    class Playlist {
        //=======VARIABLES=======//
        private String PlaylistName;
        private Song[] SongArray;
        private int songCount;

        //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
        public Playlist(String PlaylistName) {
            this.PlaylistName = PlaylistName;
            SongArray = new Song[10];
        }

        //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

        //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
        public void addSong(Song song) {
            //? CHECK IF FULL
            if (songCount > SongArray.length-1) {
                System.out.println(PlaylistName+" is currently full");
                return; // stops the whole method
            }

            //? ADDING THE SONG IN TO THE PLAYLIST
            SongArray[songCount] = song;
            songCount++;
            System.out.println(song.Title+" by "+song.Artist+" has been added into the playlist: "+PlaylistName);
        }
        public void playAll() {

            if (isOn) {
                for (int i = 0; i < songCount; i++) {
                    SongArray[i].play();
                }
            } else {
                System.out.println("Turn on the Music Player first!");
            }
        }

        //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
        public void displayPlaylist() {
            System.out.println("Playlist: "+PlaylistName);
            System.out.println("Total Songs: "+songCount);
            System.out.println("========== ALL SONGS ==========");
            for (int i = 0; i < songCount; i++) {
                System.out.println("["+i+"]");
                SongArray[i].displaySongInfo();
                System.out.println(); // space for Readability
            }
        }
    }
}
