
/**
 * Write a program with four steps:
 * Create an array (size specified by the user).
 * Randomly populate it with numbers 1-100.
 * Output the original array.
 * Output the array with all values shifted one spot to the right (the last value wraps to be the first value).
 *
 * @author Christ Aerjil Dampog
 * @since Oct 18, 2025
 */


import java.util.Scanner;
import java.util.Random;

public class ArrayShiftRight {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("seed:");
        int Seed = scanner.nextInt();

        System.out.println("length:");
        int Length = scanner.nextInt();

        Random random = new Random(Seed);

        int[] RandomizedShiftArray = new int[Length];

        for (int i = 0; i < RandomizedShiftArray.length; i++) {
            RandomizedShiftArray[i] = random.nextInt(100)+1;
        }
        System.out.println();

        displayArray(RandomizedShiftArray);

        displayArrayShift(RandomizedShiftArray);

    }

    public static void displayArrayShift(int[] name) {
        System.out.print(name[name.length-1] + " ");
        for (int i = 0; i < name.length-1; i++) {
            System.out.print(name[i] + " ");
        }
        System.out.println();
    }
    public static void displayArray(int[] name) {
        for (int i = 0; i < name.length; i++) {
            System.out.print(name[i] + " ");
        }
        System.out.println();
    }
}

