// Oct 17, 2025
// This code ask a user for an input and stores the input to an Array

import java.util.Scanner;

public class Practice03
{
    public static void main(String[] args) {
        FavoriteFruits(); 
    }

    public static void FavoriteFruits() {
        Scanner scanner = new Scanner(System.in);

        String[] FavoriteFruitsV = new String[3];

        System.out.println("Enter your first favorite fruit: ");
        FavoriteFruitsV[0] = scanner.nextLine();

        System.out.println("Enter your second favorite fruit: ");
        FavoriteFruitsV[1] = scanner.nextLine();

        System.out.println("Enter your third favorite fruit: ");
        FavoriteFruitsV[2] = scanner.nextLine();

        System.out.println();
        System.out.println(FavoriteFruitsV[0]);
        System.out.println(FavoriteFruitsV[1]);
        System.out.println(FavoriteFruitsV[2]);
    }
}
