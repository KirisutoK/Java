package ProfessorPaige;

import java.util.Scanner;

/**
 * @author Paige LaBarr
 * @version 4/2/2026
 * Divide numerator by denominator
 * Handle exceptions
 */

public class DivisionExampleUpdated {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numerator = 0;
        int denominator = 0;
        System.out.println("➗➗➗ Welcome to the Division Program. ➗➗➗");
        System.out.println("The numerator and denominator should both be whole numbers.");

        // Get numerator
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Enter the numerator: ");
            String numInput = scanner.nextLine();
            try {
                numerator = Integer.parseInt(numInput);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: \"" + numInput + "\" is not a whole number. Please try again.");
            }
        }

        // Get denominator
        validInput = false;
        while (!validInput) {
            System.out.print("Enter the denominator: ");
            String denomInput = scanner.nextLine();
            try {
                denominator = Integer.parseInt(denomInput);

                if (denominator == 0) {
                    throw new ArithmeticException("Denominator cannot be zero.");
                }

                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: \"" + denomInput + "\" is not a whole number. Please try again.");
            } catch (ArithmeticException e) {
                System.out.println("Math error: " + e.getMessage() + " Please try again.");
            }
        }

        // Divide and display
        try {
            int quotient = numerator / denominator;
            double precise = (double) numerator / denominator;
            System.out.println("\n--- Result ---");
            System.out.println(numerator + " / " + denominator + " = " + quotient + " (integer division)");
            // Formatted print to 4 decimal places
            System.out.printf("%d / %d = %.4f (decimal division)%n", numerator, denominator, precise);
        } catch (ArithmeticException e) {
            System.out.println("Unexpected math error: " + e.getMessage());
        }

        scanner.close();
    }
}