import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // CREATING INSTANCES or OBJECTS
        Movie Movie01 = new Movie("One Piece", "124623", 4.6, "Oda Eiichiro", true);
        Movie Movie02 = new Movie("Frieren", "1200", 4.9, "Tomoya Kitagawa", false);
        Song Song01 = new Song("Blue", "3", 4.2, "Yung Kai", "Romance");
        Song Song02 = new Song("Out of my League", "3", 4.6, "Fitz and Tantrums", "Hopeless Romantics");
        Podcast Podcast01 = new Podcast("Scariest SCP", "132", 4.8, "NarratorSCP", 143);
        Podcast Podcast02 = new Podcast("Anime 2025 Trending", "30", 4.1, "Anime is Life", 34);

        Media[] Medias = {Movie01, Movie02, Song01, Song02, Podcast01, Podcast02};

        // PLAY METHOD
        System.out.println("=== PLAY METHOD ===");
        for (Media i : Medias) { // for every value inside Medias
            i.Play();
        }
        System.out.println(" "); // Space for Readability

        // DISPLAY INFO METHOD
        System.out.println("=== DISPLAY INFO ===");
        for (Media i: Medias) {
            i.DisplayInformation();
            System.out.println(" "); // Space for Readability
        }

        // FILTER BY RATING
        System.out.println("=== FILTER BY RATING (4.0 Above) ===");
        for (Media i: Medias) {
            if (i.Rating >= 4.0) {
                System.out.println(i.Title + ": " + i.Rating);
            }
        }
        System.out.println(" "); // Space for Readability

        // FILTER BY DURATION
        System.out.println("=== FILTER BY DURATION (120 Minutes Above) ===");
        for (Media i: Medias) {
            if (i.isLongContent() == true) {
                System.out.println(i.Title + ": " + i.Duration + " Minutes");
            }
        }
        System.out.println(" "); // Space of Readability

        // DOWNCASTING
        System.out.println("=== DOWNCASTING ===");
        for (Media i: Medias) {
            if (i instanceof Movie) {
                ((Movie)i).enableSubtitles(); // Concatenating the Parent Class into Child Class (Which is called Downcasting)
            } else if (i instanceof Song) {
                ((Song)i).addToPlaylist("Favorites");
            } else if (i instanceof Podcast) {
                ((Podcast) i).downloadEpisode();
            }
        }
        System.out.println(" "); // Space for Readability

        // COUNTING AND SEPARATING MEDIA TYPES
        System.out.println("=== COUNTING AND SEPARATING MEDIA TYPES ===");
        int MovieCount = 0;
        int SongCount = 0;
        int PodcastCount = 0;

        for (Media i: Medias) { // To Count
            if (i instanceof Movie) {
                MovieCount++;
            } else if (i instanceof Song) {
                SongCount++;
            } else if (i instanceof Podcast) {
                PodcastCount++;
            }
        }

        ArrayList<Movie> Movies = new ArrayList<>();


        System.out.println("Movie Count: " + MovieCount);
        System.out.println("Song Count: " + SongCount);
        System.out.println("Podcast Count: " + PodcastCount);
        System.out.println("Arrays for each Media Types");

    }
}
