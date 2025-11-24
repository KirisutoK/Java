// Oct 23, 2025

public class SelfStudyFixedSlidingWindow01 {
    public static void main (String []args) {
        int[] Numbers = {1, 3, 4, 8, 9, 2, 5};

        int WindowSize = 3;

        System.out.println(Numbers.length);

        for (int j = 0; j < Numbers.length - WindowSize + 1; j++) { // + 1 because the required times the window must move is 5, not 4
            for (int i = j; i < j + WindowSize; i++) { // j + WindowSize so that Window will be able to move from 3 to j+(1) = 4. this mean i(1) < 4. i(2) < 5
                System.out.print(Numbers[i] + " ");
            }
            System.err.println();
        }

    }
}
