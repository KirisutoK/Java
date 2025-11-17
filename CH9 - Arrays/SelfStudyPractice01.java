// Oct 17, 2025
import java.util.Scanner;

public class SelfStudyPractice01 {

    public static void main(String[] args) {
        MovieRatingSystemArray();
    }

    public static void MovieRatingSystemArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n=== Movie Rating System ===\n");

        System.out.print("\nHow many movies do you want to rate? ");
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

        System.out.print("\n=== Your Movie Ratings ===");
        for (int i = 0; i <ArrayMaximum; i++) {
            System.out.print("\n" + (i+1) + ". " + ArrayValues[i] + " - " );

            for (int j = 0; j < ArrayRating[i]; j++) {
                System.out.print("⭐");
            }
            
            System.out.print(" (" + ArrayRating[i] + " Stars)");
        }

        int HighestRating = ArrayRating[0]; //Default 
        for (int i = 0; i < ArrayMaximum; i++) { 
            if (ArrayRating[i] > HighestRating ) { // Finds which is the highest rating
                HighestRating = ArrayRating[i];
            }
        }

        System.out.print("\n🏆 Highest Rated: ");
        for (int i = 0; i < ArrayMaximum; i++) {
            if (ArrayRating[i] == HighestRating) { // Finds the Movie of that rating and then prints out
                System.out.print(ArrayValues[i] + " (" + ArrayRating[i] + " stars)\n");
                break;
            }
        }
    }
}
