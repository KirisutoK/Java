
/**
 * Write a program that will ask the user to enter a number. Using a while loop,
 * keep asking the user to enter a number until they enter 3. Once 3 is entered,
 * the program displays a message.
 *
 * @author Christ Aerjil Dampog
 * @since October 4, 2025
 */
import java.util.Scanner;

public class WhileLoopD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = 0;

        while (num != 3) {
            System.out.println("Enter a number: ");
            num = scanner.nextInt();
        }
        
        System.out.println("You chose " + num + ".");

        scanner.close();
    }

}
