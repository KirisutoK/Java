// Oct 22, 2025
// Unfinished

import java.util.HashSet;
import java.util.Scanner;

import javax.xml.parsers.FactoryConfigurationError;

public class SelfStudyHashSetPractice01 {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> FavoriteFoods = new HashSet<>();

        System.out.println("Add three types of your favorite food: ");
        FavoriteFoods.add(scanner.nextLine());
        FavoriteFoods.add(scanner.nextLine());
        FavoriteFoods.add(scanner.nextLine());

        System.out.println("\nThis are you 3 Favorite Food: " + FavoriteFoods);
        System.out.println("\nWould you like to make changes? (Yes or No)");
        String Choice = scanner.nextLine();

        if (Choice.equalsIgnoreCase("Yes")) {
            System.out.println("""
                    1. Change
                    2. Remove
                    3. Done
                    """);
            int NumberChoices = scanner.nextInt();

            switch (NumberChoices) {
                case 1:
                    System.out.println("What would you like to change?");
                    int i1 = 0;
                    for (String value : FavoriteFoods) {
                        i1++;
                        System.out.println(i1 + ". " + value);
                    }

                    System.out.println("What would you like to replace it with?");
                    String ReplacedFood = scanner.nextLine();
                    
                    FavoriteFoods.add(ReplacedFood);
                    break;
                case 2:
                    System.out.println("What would you like to remove? (Type the word)");
                    int i2 = 0;
                    for (String value : FavoriteFoods) {
                        i2++;
                        System.out.println(i2 + ". " + value);
                    }

                    int RemoveChoice = scanner.nextInt();
                    FavoriteFoods.remove(FavoriteFoods.contains(RemoveChoice));
        }

        System.out.println("This is your current list: " + FavoriteFoods);
        } else {
            System.out.println("Bye");
        }
    }
}
