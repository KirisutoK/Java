//Oct 17, 2025
// Difference between regular loop and enhanced loop

import java.util.ArrayList;

public class SelfStudyArrayList02 {
    public static void main(String[] args) {
        ArrayList<String> FavoriteAnime = new ArrayList<>();

        FavoriteAnime.add("Frieren");
        FavoriteAnime.add("SKET Dance");
        FavoriteAnime.add("Oshi no Ko");


        System.out.println("List:"); //Regular for loop
        for (int i = 0; i < FavoriteAnime.size(); i++) {
            System.out.println(FavoriteAnime.get(i));
        }

        System.out.println("\nList:"); //Enhanced for loop
        for (String values : FavoriteAnime) { //runs for each value inside a variable which is FavoriteAnime
            System.out.println(values);
        }
    }
}
