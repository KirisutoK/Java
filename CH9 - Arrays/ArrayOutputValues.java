
/**
 * As an introduction to arrays, we will write a simple program with three
 * steps:
 * Create an array (size specified by the user).
 * Randomly populate it with numbers 1-100
 * Output the original array
 *
 * @author Christ Aerjil Dampog
 * @since Oct 18, 2025
 */
import java.util.Scanner;
import java.util.Random;;

public class ArrayOutputValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("seed:");
        int SEED = scanner.nextInt();

        Random random = new Random(SEED);

        System.out.println("length:");
        int Length = scanner.nextInt();

        System.out.println();

        int[] RandomizedArray = new int[Length];
        for (int i = 0; i < RandomizedArray.length; i++) {
            RandomizedArray[i] = random.nextInt(100)+1;
            System.out.print(RandomizedArray[i] + " ");
        }
    }
}
