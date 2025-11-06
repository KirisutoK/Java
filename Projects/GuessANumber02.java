
/**
 * One of the quintessential programming exercises for aspiring software
 * engineers is the classic game, Guess A Number. The game secretly selects a
 * number and affords the user a chance to keep guessing a number. The game ends
 * when the user guesses the secret number.
 * 
 * Our version of the game will inform the user if their guess was too high or
 * too low, helping the user to hone in on the actual number.
 *
 * @author Christ Aerjil Dampog
 * @since October 5, 2025
 */
import java.util.Scanner;
import java.util.Random;

public class GuessANumber02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a seed:");
        int Seed = scanner.nextInt();
        Random random = new Random(Seed);

        int AnswerNumber = random.nextInt(100)+1;

        System.out.println("\nWelcome!");

        System.out.println("Please enter a number between 1 and 100:");
        int Number = scanner.nextInt();

        int Guesses = 1;

        while (Number != AnswerNumber) {
            if (Number > AnswerNumber) {
                System.out.println("\nToo high. Guess again: ");
                Number = scanner.nextInt();
            } else {
                System.out.println("\nToo low. Guess again: ");
                Number = scanner.nextInt();
            }
            Guesses++;
        }

        System.out.println("Congratulations. You guessed correctly! ");
        System.out.println("You needed " + Guesses + " guesses.");
    }
}
