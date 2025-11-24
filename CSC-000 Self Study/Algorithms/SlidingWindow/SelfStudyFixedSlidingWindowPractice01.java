// Oct 23, 2025
// Print what is inside the window(2) inside an array

public class SelfStudyFixedSlidingWindowPractice01 {
    public static void main(String[]args) {
        int[] Numbers = {10, 20, 30, 40, 50};
        int WindowSize = 2;

        for (int j = 0; j < Numbers.length - WindowSize + 1; j++) {
            System.out.print("Window " + (j+1) + ":");
            for (int i = 0+j; i < j+WindowSize; i++) {
                System.out.print(" " + Numbers[i]);
            }
            System.out.println();
        }
    }
}
