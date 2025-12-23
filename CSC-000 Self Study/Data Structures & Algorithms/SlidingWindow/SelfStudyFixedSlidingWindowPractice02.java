// Oct 23, 2025

public class SelfStudyFixedSlidingWindowPractice02 {
    public static void main(String[]args) {
        int[] Numbers = {5, 2, 8, 1, 9, 3};
        int WindowSize = 3;

        int Sum = 0;
        int MaximumSum = 0;
        for (int j = 0; j < Numbers.length - WindowSize + 1; j++) {
            System.out.print("Window " + (j+1) + " sum:");

            for (int i = 0+j; i < j+WindowSize; i++) {
                Sum += Numbers[i];
                if (Sum > MaximumSum) {
                    MaximumSum = Sum;
                }
            }

            System.out.print(" " + Sum);
            Sum = 0;
            System.out.println();
        }

        System.out.println("Maximum sum:" + MaximumSum);
    }
}
