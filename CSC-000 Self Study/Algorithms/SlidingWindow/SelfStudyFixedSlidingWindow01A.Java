// Oct 23, 2025

public class SelfStudyFixedSlidingWindow01A {
    public static void main (String []args) {
        int[] Numbers =  new int[] {1, 3, 4, 8, 9, 2, 5};

        System.out.println(Numbers); // Array is not formatted properly so it prints something instead of [1, 3, 4, 8, 9, 2, 5]

        // In order to make it print like [1, 3, 4, 8, 9, 2, 5], we have to create an array properly:
        // int[] Numbers = new Int[] {1, 3, 4, 8, 9, 2, 5}; 

        int WindowSize = 3;

        for (int j = 0; j < Numbers.length - WindowSize + 1; j++) { // + 1 because the required times the window must move is 5, not 4
            for (int i = j; i < j + WindowSize; i++) { // j + WindowSize so that Window will be able to move from 3 to j+(1) = 4. this mean i(1) < 4. i(2) < 5
                System.out.print(Numbers[i] + " ");
            }
            System.err.println();
        }

    }
}
