import java.util.ArrayList; // Adds an Array that is flexible (Removing, Adding, Changing)

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

        // ======= PLAY METHOD =======
        System.out.println("=== PLAY METHOD ===");
        for (Media i : Medias) { // for every value inside Medias
            i.Play();
        }
        System.out.println(" "); // Space for Readability

        // ======= DISPLAY INFO METHOD =======
        System.out.println("=== DISPLAY INFO ===");
        for (Media i: Medias) {
            i.DisplayInformation();
            System.out.println(" "); // Space for Readability
        }

        // ======= FILTER BY RATING =======
        System.out.println("=== FILTER BY RATING (4.0 Above) ===");
        for (Media i: Medias) {
            if (i.Rating >= 4.0) {
                System.out.println(i.Title + ": " + i.Rating);
            }
        }
        System.out.println(" "); // Space for Readability

        // ======= FILTER BY DURATION =======
        System.out.println("=== FILTER BY DURATION (120 Minutes Above) ===");
        for (Media i: Medias) {
            if (i.isLongContent() == true) {
                System.out.println(i.Title + ": " + i.Duration + " Minutes");
            }
        }
        System.out.println(" "); // Space of Readability

        // ======= DOWNCASTING =======
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

        // ======= COUNTING AND SEPARATING MEDIA TYPES =======
        System.out.println("=== COUNTING AND SEPARATING MEDIA TYPES ===");
        int MovieCount = 0;
        int SongCount = 0;
        int PodcastCount = 0;

        // ArrayLists (Not Regular Array)
        ArrayList<Movie> Movies = new ArrayList<>();
        ArrayList<Song> Songs = new ArrayList<>();
        ArrayList<Podcast> Podcasts = new ArrayList<>();

        for (Media i: Medias) { // To Count
            if (i instanceof Movie) {
                Movies.add((Movie)i);
                MovieCount++;
            } else if (i instanceof Song) {
                Songs.add((Song)i);
                SongCount++;
            } else if (i instanceof Podcast) {
                Podcasts.add((Podcast)i);
                PodcastCount++;
            }
        }

        System.out.println("Movie Count: " + MovieCount);
        System.out.println("Song Count: " + SongCount);
        System.out.println("Podcast Count: " + PodcastCount);
        System.out.println(" "); // Space for Readability
        System.out.println("Arrays for each Media Types:"); // Movies
        System.out.print("Movies: [" );
        for (int i = 0; i < Movies.size(); i++) {
            System.out.print(Movies.get(i).Title); // This is different because we are using Arraylist
            if (i != Movies.size() - 1 ) { // If it's not the last index of the array
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.print("\nSongs: [" ); // Songs
        for (int i = 0; i < Songs.size(); i++) {
            System.out.print(Songs.get(i).Title); // This is different because we are using Arraylist
            if (i != Songs.size() - 1 ) { // If it's not the last index of the array
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.print("\nPodcasts: [" ); // Podcasts
        for (int i = 0; i < Podcasts.size(); i++) {
            System.out.print(Podcasts.get(i).Title); // This is different because we are using Arraylist
            if (i != Podcasts.size() - 1 ) { // If it's not the last index of the array
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println(" \n"); // Space for Readability

        //        ============== REGULAR ARRAYS ==============
//        Movie[] MoviesArray = new Movie[MovieCount];
//        Podcast[] PodcastArray = new Podcast[PodcastCount];
//        Song[] SongArray = new Song[SongCount];
//
//        int MovieIndex = 0;
//        int PodcastIndex = 0;
//        int SongIndex = 0;
//
//        for (Media i: Medias) {
//            if (i instanceof Movie) {
//                MoviesArray[MovieIndex] = (Movie)i;
//                MovieIndex++;
//            } else if (i instanceof Song) {
//                SongArray[SongIndex] = (Song)i;
//                SongIndex++;
//            } else if (i instanceof Podcast) {
//                PodcastArray[PodcastIndex] = (Podcast)i;
//                PodcastIndex++;
//            }
//        }

        // ======= FIND MEDIA BY TITLE =======
        System.out.println("=== FIND MEDIA BY TITLE ===");
        Media Result = findMediaByTitle(Medias, "One Piece");
        if (Result != null) { // Checks if Result is not null
            System.out.println(Result.Title + " was found!");
        } else {
            System.out.println("No Media Found!");
        }
    }

    public static Media findMediaByTitle(Media[] library, String title) { // A METHOD THAT SEARCHES UP IF TITLE EXIST IN AN ARRAYS VARIABLE (TITLE)
        for (Media i: library) {
            if (i.Title.equals(title)) {
                return i;
            } else {
                return null;
            }
        }
        return null;
    }
}
