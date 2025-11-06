
/**
 * Using a while loop, write a program that will ask the user for a number and then output the next 10 consecutive numbers.
 *
 * @author Christ Aerjil Dampog
 * @since October 4, 2025
 */
import java.util.Scanner;

public class WhileLoopB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number:");
        int UserNum = scanner.nextInt();

        int UserNumLimit = UserNum + 10;

        while (UserNum < UserNumLimit) {
            UserNum++;
            System.out.println(UserNum);
        }

        scanner.close();
    }

}
