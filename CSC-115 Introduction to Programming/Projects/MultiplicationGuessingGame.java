import java.net.Socket;
import java.util.Scanner;

public class MultiplicationGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type your height for the Multiplication Table: ");
        int MultiplicationTableHeight = scanner.nextInt();

        System.out.println("\nType your weight for the Multiplication Table: ");
        int MultiplicationTableWeight = scanner.nextInt();

        System.out.println(" ");

        for(int i = 1; i <= MultiplicationTableHeight; i++) {
            for(int j = 1; j <= MultiplicationTableWeight; j++) {
                System.out.print(i*j + "\t");
            }
            System.out.println();
        }

        System.out.println("\nWhat number would you like to practice?");
        int PracticeNumber = scanner.nextInt();

        int Questions = 1;
        int CorrectAnswers = 0;
        int WrongAnswers = 0;

        for (int i = Questions; i <= 10; i++) {
            System.out.println("\nWhat is " + PracticeNumber + " multiplied by " + Questions + " ?");
            int AnswerNumber = scanner.nextInt();

            if (AnswerNumber == PracticeNumber * Questions) {
                CorrectAnswers++;
            } else {
                WrongAnswers++;
            }

            Questions++;
        }

        System.out.println("\nYour score is " + CorrectAnswers + "/10 ");
        System.out.println("\nYou got " + WrongAnswers + " wrong answers.");

        if (CorrectAnswers > 5 || CorrectAnswers < 8) {
            System.out.println("Not bad! 😎");
        } else if (CorrectAnswers >= 8 || CorrectAnswers <= 10) {
            System.out.println("You're so tuff ngl 🔥");
        } else {
            System.out.println("Please try harder 😭");
        }
    }
}
