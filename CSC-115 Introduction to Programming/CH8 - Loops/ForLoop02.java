
/**
 * Using a for loop, write a small program that asks the user for a beginning
 * number and then outputs the next consecutive five numbers. Consult the Sample
 * Output for specific formatting.
 *
 * @author Christ Aerjil Dampog
 * @since October 4, 2025
 */
import java.util.Scanner;

public class ForLoop02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a starting point:");
        int StartingPoint = scanner.nextInt();

        System.out.println(" ");

        for (int i = 0; i <= 5; i++) {
            System.out.println(StartingPoint);
            StartingPoint++;
        }

        scanner.close();
    }
}
