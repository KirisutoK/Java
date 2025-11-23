
/**
 * Using a for loop, write a small program that asks the user for a beginning
 * number, an ending number, and an incrementor. The program then outputs a list
 * of numbers starting at the beginning number and increasing by the
 * incrementor. The loop stops when the numbers meet or exceed the end value.
 * Consult the Sample Output for specific formatting.
 *
 * @author Christ Aerjil Dampog
 * @since October 5, 2025
 */
import java.util.Scanner;

public class ForLoop04 {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number to start:");
        int StartingNumber = scanner.nextInt();

        System.out.println("Enter a number to stop:");
        int StoppingNumber = scanner.nextInt();

        System.out.println("Enter a number to increase:");
        int IncrementNumber = scanner.nextInt();

        System.out.println(" ");

        for (int i = StartingNumber; i <= StoppingNumber; i += IncrementNumber) {
            System.out.println(i);
        }

        scanner.close();
    }
}
