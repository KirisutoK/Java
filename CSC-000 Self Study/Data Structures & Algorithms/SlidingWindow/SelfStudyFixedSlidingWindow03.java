// Oct 23, 2025

public class SelfStudyFixedSlidingWindow03 {
    public static void main(String[]args) {
        char[] Characters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'E'};
        int WindowSize = 4;

        for (int j = 0; j < Characters.length - WindowSize + 1; j++) {
            for (int i = 0+j; i < j+WindowSize; i++) {
                System.out.print(Characters[i] + " ");
            }
            System.out.println();
        }
    }
}
