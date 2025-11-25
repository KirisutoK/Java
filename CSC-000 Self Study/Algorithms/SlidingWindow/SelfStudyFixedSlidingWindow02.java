// Oct 23, 2025
import java.util.Arrays; // In order to use toString(), sort(), binarySearch(), etc.

public class SelfStudyFixedSlidingWindow02 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int WindowSize = 3;
        int sum = 0;

        System.out.println(Arrays.toString(numbers)); // This is what the import java.util.Arrays is used for

        for (int j = 0; j < numbers.length - WindowSize + 1; j++) {
            for (int i = 0+j; i < j+WindowSize; i++) {
                sum += numbers[i];
            }
            System.out.println(sum);
            sum = 0;
        }
    }
}