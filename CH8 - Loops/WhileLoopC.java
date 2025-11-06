
/**
 * Create a program that asks the user for a starting number and a number to
 * increase by (incrementor). Then, using a while loop, output six terms
 * (starting at the starting number) that increase by the incrementor that the
 * user entered.
 *
 * @author Christ Aerjil Dampog
 * @since October 4, 2025
 */
import java.util.Scanner;

public class WhileLoopC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter starting number: ");
        int StartingNumber = scanner.nextInt();

        System.out.println("\nEnter incrementor: ");
        int IncrementorNumber = scanner.nextInt();

        System.out.println(" ");

        int terms = 0;

        while (terms < 6) {
            System.out.println(StartingNumber);
            StartingNumber += IncrementorNumber;
            terms++;
        }

        scanner.close();
    }

    // Put yer dang tootin' code here!

}
