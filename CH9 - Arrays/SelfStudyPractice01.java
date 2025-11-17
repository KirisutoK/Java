// Oct 17, 2025
import java.util.Scanner;

public class SelfStudyPractice01 {

    public static void main(String[] args) {
        MovieRatingSystemArray();
    }

    public static void MovieRatingSystemArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Movie Rating System ===\n");

        System.out.println("How many movies do you want to rate?");
        int ArrayMaximum = scanner.nextInt();

        String[] ArrayValues = new String[ArrayMaximum];
        int[] ArrayRating = new int[ArrayMaximum];

        for (int i = 0; i < ArrayMaximum; i++) {
            System.out.print("\nEnter movie #" + (i+1) +" name: ");
            scanner.nextLine();
            ArrayValues[i] = scanner.nextLine();

            System.out.print("Rate " + ArrayValues[i] + " (1-5 stars): ");
            ArrayRating[i] = scanner.nextInt();
        }

        scanner.close();

        //==============DISPLAY==============\\

        System.out.println("=== Your Movie Ratings ===");
        for (int i = 0; i <ArrayMaximum; i++) {
            System.out.println((i+1) + "." + ArrayValues + " - " + ArrayRating + " (" + ArrayRating + " Stars)");
        }
        System.out.println("\n");
    }
}
