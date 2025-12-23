// Oct 23, 2025

public class SelfStudyFixedSlidingWindowPractice03 {
    public static void main(String[] args) {
        int[] NumberArray = { 4, 2, 1, 7, 8, 1, 2, 8, 1, 0 };
        int WindowSize = 3;

        int sum = 0;
        Double Average = 0.0;
        Double MinimumAverage = Double.MAX_VALUE;

        for (int k = 0; k < NumberArray.length - WindowSize + 1; k++) {
            sum = 0;
            System.out.print("Window " + (k + 1) + ": ");
            for (int i = 0 + k; i < k + WindowSize; i++) {
                sum += NumberArray[i];
            }

            Average = (double) sum / WindowSize;
            if (Average < MinimumAverage) {
                MinimumAverage = Average;
            }

            System.out.print("sum=" + sum + ", ");
            System.out.printf("average=%.2f", Average);

            System.out.println();
        }
        System.out.printf("Minimum average: %.2f \n", MinimumAverage);
    }
}
