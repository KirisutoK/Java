import java.util.ArrayList;
import java.util.Scanner;

public class SelfStudy3 {
    public static void main(String[] args) {
        FavoriteFruits();
    }

    public static void FavoriteFruits() {

        ArrayList<String> FavoriteFruits = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first favorite fruit: ");
        String FirstFavoriteFruit = scanner.nextLine();
        FavoriteFruits.add(FirstFavoriteFruit);

        System.out.println("Enter your first favorite fruit: ");
        String SecondFavoriteFruit = scanner.nextLine();
        FavoriteFruits.add(SecondFavoriteFruit);

        System.out.println("Enter your first favorite fruit: ");
        String ThirdFavoriteFruit = scanner.nextLine();
        FavoriteFruits.add(ThirdFavoriteFruit);

        System.out.println(FavoriteFruits);

    }
}
