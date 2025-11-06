import java.util.Scanner;

public class MultiplicationGuessingGame {
    public static void main(String[] args) {

        for(int i = 1; i <= 10; i++) {
            for(int j = 1; j <=10; j++) {
                System.out.print(i*j + "\t");
            }
        }

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("What number would you like to practice?");
        int PracticeNumber = scanner.nextInt();

        int Questions = 0;
        int CorrectAnswers = 0;
        int WrongAnswers = 0;

        for (int i = Questions; i <= 10; i++) {
            System.out.println("What is" + PracticeNumber + " multiplied by " + Questions + " ?");
            int AnswerNumber = scanner.nextInt();

            if (AnswerNumber == PracticeNumber + Questions) {
                AnswerNumber++;
            } else {
                WrongAnswers++;
            }
        }
    }
}
