package OtherWays;

// Creation Date: March 31, 2026. at 11:14 AM
// Last Modified: March 31, 2026. at 11:14 AM

import java.util.Scanner;

public class FixWithIfStatement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter two integers
        System.out.print("Enter two integers: ");
        int number1 = input.nextInt();
        int number2 = input.nextInt();

        if (number2 != 0)
            System.out.println(number1 + " / " + number2 + " is " +
                    (number1 / number2));
        else
            System.out.println("Divisor cannot be zero");
    }
}
