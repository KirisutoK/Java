
/**
 * WRITE A PROGRAM WITH FOUR STEPS:
 * Create an array (size specified by the user).
 * Randomly populate it with numbers 1-100.
 * Output the original array.
 * Output the array with each value doubled.
 *
 * @author Christ Aerjil Dampog
 * @since Oct 18, 2025
 */
import java.util.Scanner;
import java.util.Random;;

public class ArrayBackwards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("seed:");
        int SEED = scanner.nextInt();

        Random random = new Random(SEED);

        System.out.println("length:");
        int Length = scanner.nextInt();

        scanner.close();
        System.out.println();

        int[] RandomizedArray = new int[Length]; //Get 10, Start from 10 then go to 0
        for (int i = RandomizedArray.length-1; i >= 0; i--) {
            RandomizedArray[i] = random.nextInt(100) + 1;
            System.out.print(RandomizedArray[i] + " ");
        }

        System.out.println();
        for (int i = 0; i < RandomizedArray.length; i++) {
            System.out.print(RandomizedArray[i] + " ");
        }
    }
}