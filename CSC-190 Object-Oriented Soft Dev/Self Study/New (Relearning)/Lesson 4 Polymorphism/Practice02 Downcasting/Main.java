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

        // DISPLAY INFO METHOD
        System.out.println("=== DISPLAY INFO ===");
        for (Media i: Medias) {
            i.DisplayInformation();
        }
    }
}
