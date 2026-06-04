// Creation Date: June 03, 2026. at 10:52 PM
// Last Modified: June 03, 2026. at 11:26 PM

public class Main {
    public static void main(String[] args) {
        // ============= CREATING OBJECT ============= \\
        MusicPlayer MPlayer01 = new MusicPlayer("ASUS");
        MusicPlayer.Song MP01_Song01 = MPlayer01.new Song("Random Title", "Random Artist", 160);
        MusicPlayer.Song MP01_Song02 = MPlayer01.new Song("Phonk", "TOMA TOMA TOMA", 60);
        MusicPlayer.Playlist MP01_Playlist01 = MPlayer01.new Playlist("Real Shit Playlist");

        // ============= METHODS ============= \\
        MPlayer01.turnOn();
        MP01_Playlist01.addSong(MP01_Song01);
        MP01_Playlist01.addSong(MP01_Song02);
        System.out.println(); // Space for Readability
        MP01_Playlist01.playAll();
        System.out.println(); // Space for Readability
        MP01_Playlist01.displayPlaylist();
        System.out.println(); // Space for Readability
    }
}

// NOTES: BASED ON WHAT I HAVE LEARNED, WHEN INSTANTIATING INNER CLASS, YOU MUST NEED AN OUTER CLASS THAT HAS ALREADY BEEN INSTANTIATED.
// NOTES: WHEN INSTANTIATING A STATIC NESTED CLASS, YOU DON'T NEED AN INSTANTIATED OUTER CLASS (YOU CAN DIRECTLY INSTANTIATE THE STATIC NESTED CLASS BY CALLING THE CLASS ITSELF)
