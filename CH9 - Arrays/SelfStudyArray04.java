//Oct 17, 2025
//This code ask for input on how many values should the array have.

import java.util.Scanner;

public class SelfStudyArray04 {
    public static void main(String[] args) {
        CustomizeableArray();
    }

    public static void CustomizeableArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name your list");
        String ArrayName = scanner.nextLine();

        System.out.println("How many values will there be in your list?"); //Gathers how many spots are in the array
        int ListMaximum = scanner.nextInt();
        scanner.nextLine();

        String[] ArrayValues = new String[ListMaximum]; // Creates an array

        for (int i = 0; i < ListMaximum; i++) {
            System.out.println("Enter Value " + (i+1) + ":");
            ArrayValues[i] = scanner.nextLine();
        }

        scanner.close();
        
        System.out.println();

        //============================ Display ============================//

        System.out.println("==========" + ArrayName + "==========");
        System.out.println();
        for (int i = 0; i < ArrayValues.length; i++) {
            System.out.println((i+1) + "." + " " +ArrayValues[i]);
        }
    }
}
