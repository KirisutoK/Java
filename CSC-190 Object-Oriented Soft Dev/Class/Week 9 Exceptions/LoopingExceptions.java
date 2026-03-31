// Creation Date: March 31, 2026. at 12:09 PM
// Last Modified: March 31, 2026. at 12:16 PM

import java.util.Scanner;

public class LoopingExceptions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean NotValidNumber = true;

        do {
            try {
                System.out.println("Insert a Number: ");
                int Number = input.nextInt();
                System.out.println("The input is correct: "+Number);
                NotValidNumber = false;
            } catch (Exception e) {
                System.out.print("The input was not a number, try again.");
                input.nextLine(); // this clears the bad input (IF THIS WAS NOT PUT, THE NEXT LOOP WILL AUTOMATICALLY KEEP USING THE OLD INPUT)
            }
        } while (NotValidNumber);
    }
}
