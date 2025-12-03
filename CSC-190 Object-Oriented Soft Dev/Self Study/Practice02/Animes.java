public class Animes {
    private String Anime;
    private int Rating;

    public Animes(String anime, int rating) {
        this.Anime = anime;
        this.Rating = rating;
    }

    public void DISPLAYINFO() {
        System.out.println("Anime: " + Anime);
        System.out.println("Rating: " + Rating);
    }
}