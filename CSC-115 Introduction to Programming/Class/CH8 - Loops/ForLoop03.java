
/**
 * Using a for loop, write a small program that asks the user for a beginning
 * number and an ending number. Then the program outputs consecutive numbers,
 * from the beginning to the ending number, incrementing by 1. Consult the
 * Sample Output for specific formatting.
 *
 * @author Christ Aerjil Dampog
 * @since October 4, 2025
 */
import java.util.Scanner;

public class ForLoop03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number to start:");
        int StartingNumber = scanner.nextInt();

        System.out.println("Enter a number to stop:");
        int EndingNumber = scanner.nextInt();

        System.out.println(" ");

        for (int i = StartingNumber; i <= EndingNumber; i++) {
            System.out.println(i);
        }
        
        scanner.close();
    }
}
