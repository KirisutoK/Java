// Oct 23, 2025

import java.util.Arrays;

public class SelfStudyFixedSlidingWindow01 {
    public static void main (String []args) {
        int[] Numbers = {1, 3, 4, 8, 9, 2, 5};
<<<<<<< HEAD
=======

        System.out.println(Numbers); // Array is not formatted properly so it prints something instead of [1, 3, 4, 8, 9, 2, 5]

        // In order to make it print like [1, 3, 4, 8, 9, 2, 5], we have to create import array:
        // import java.util.Arrays;

>>>>>>> f4abbdc96b152f3be6fdc54a768a9301642361dd
        int WindowSize = 3;

        System.out.println("Numbers: " + Arrays.toString(Numbers) + " \n"); // In order to print the whole array, it needs to be like this.

        for (int j = 0; j < Numbers.length - WindowSize + 1; j++) { // + 1 because the required times the window must move is 5, not 4
            for (int i = j; i < j + WindowSize; i++) { // j + WindowSize so that Window will be able to move from 3 to j+(1) = 4. this mean i(1) < 4. i(2) < 5
                System.out.print(Numbers[i] + " ");
            }
            System.err.println();
        }

    }
}
