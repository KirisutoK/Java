//Oct 17, 2025
import java.util.Scanner;
import java.util.ArrayList;

public class SelfStudyPractice02 {
    static Scanner scanner = new Scanner(System.in);

    static ArrayList<String> Products = new ArrayList<>();
    static ArrayList<Double> Prices = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("=== Personal Budget Tracker ===");

        AddValueArrayList();
        RecieptEditing();

        //============== Summary ==============\\
        Double TotalSpent = CalculateTotalSpent(Prices);
        Double MostExpensive = findMostExpensive(Prices);
        String MostExpensiveName = getMostExpensiveName(Products, Prices, MostExpensive);
        int ExpensiveItems = countExpensiveItem(Prices);
        double AverageExpense = getAverageExpense(Prices);

        System.out.println("\n=== Budget Summary ===");
        System.out.println("💰 Total Spent: $" + TotalSpent);
        System.out.println("💸 Most Expensive: " + MostExpensiveName + " ($" + MostExpensive + ")");
        System.out.println("⚠️ Expenses Over $50: " + ExpensiveItems + " Items" );
        System.out.println("📊 Average Expense: $" + AverageExpense);
    }

    //======================= INPUT GATHERING =======================\\
    public static void AddValueArrayList() {
        Boolean isRunning = true;
        while(isRunning == true) {
            System.out.print("\nEnter expense name (type DONE to stop adding): ");
            String ProductName = scanner.nextLine();
            if (ProductName.equalsIgnoreCase("Done")) {
                isRunning = false;
                break;
            } else {
                Products.add(ProductName);
            }

            System.out.print("Enter amount: $");
            Double PriceValue = scanner.nextDouble();
            scanner.nextLine();
            Prices.add(PriceValue);

            System.out.print("✓ Added: " + ProductName + " ($" + PriceValue + ")\n");

        }
    }
    public static void RecieptEditing() {
        boolean ConfirmationEdit = true;
        while(ConfirmationEdit == true) {
            System.out.println("\n=== Your Expenses ===");
            for (int i = 0; i < Products.size(); i++) {
                System.out.println(i + ". " + Products.get(i) + " - $" + Prices.get(i));
            }

            System.out.println("\nWould you like to make changes? (Yes or No)");
            String ChangesCondition = scanner.nextLine();

            if (ChangesCondition.equalsIgnoreCase("Yes")) {
                System.out.println("""
                        \nChoose an Option:?
                        1. Add
                        2. Remove
                        3. Change
                        4. Done Changing
                        """);
                int Choices = scanner.nextInt();

                switch(Choices) {
                    case 1:
                        scanner.nextLine();
                        AddValueArrayList();
                        break;
                    case 2:
                        System.out.println("What would you like to remove?");
                        int SlotPick2 = scanner.nextInt();

                        Products.remove(SlotPick2);
                        Prices.remove(SlotPick2);

                        String ProductName2 = Products.get(SlotPick2);
                        System.out.println(ProductName2 + " Has been removed");
                        break;
                    case 3:
                        
                        System.out.print("\nWhat would you like to change? ");
                        int SlotPick3 = scanner.nextInt();
                        scanner.nextLine();

                        boolean validSlotPick3 = false;
                        while (validSlotPick3 == false) {
                            if (SlotPick3 < 0 || SlotPick3 >= Prices.size()) {
                                System.out.print("\nThe Chosen number does not exist.");
                                System.out.print("\nPlease enter a valid number: (0-" + (Prices.size()-1) + ")");
                                SlotPick3 = scanner.nextInt();
                                scanner.nextLine();
                            } else {
                                validSlotPick3 = true;
                            }
                        }

                        System.out.print("\nChange Name: ");
                        String ProductName3 = scanner.nextLine();
                        System.out.print("Change Price: ");
                        Double ProductPrice = scanner.nextDouble();
                        scanner.nextLine();

                        Products.set(SlotPick3, ProductName3);
                        Prices.set(SlotPick3, ProductPrice);

                        System.out.println("\nNumber " + SlotPick3 + " Updated!.");
                        break;
                    case 4:
                        ConfirmationEdit = false;
                        break;
                }
            } else {
                ConfirmationEdit = false;
            }
        }
    }
    //======================= CALCULATION =======================\\
    public static double CalculateTotalSpent(ArrayList<Double> name) {
        Double TotalSpent = 0.00;

        for (Double value : name) {
            TotalSpent += value;
        }
        return TotalSpent;
    }
    public static double findMostExpensive(ArrayList<Double> name) {
        Double MostExpensive = 0.00;

        for (Double value : name) {
            if (value > MostExpensive) {
                MostExpensive = value;
            }
        }
        return MostExpensive;
    }
    public static String getMostExpensiveName(ArrayList<String> name1, ArrayList<Double> name2, double MaxAmount) {
        String MostExpensiveName = " ";

        for (int i = 0; i < name2.size(); i++) {
            if (name2.get(i) == MaxAmount) {
                MostExpensiveName = name1.get(i);
            }
        }

        return MostExpensiveName;
    }
    public static int countExpensiveItem(ArrayList<Double> name) {
        int ExpensiveItems = 0;

        for (Double value : name) {
            if (value > 50) {
                ExpensiveItems++;
            }
        }
        return ExpensiveItems;
    }
    public static double getAverageExpense(ArrayList<Double> name) {

        int Slots = 0;
        double TotalValue = 0.00;

        for (int i = 0; i < name.size(); i++) {
            TotalValue += name.get(i);
            Slots++;
        }

        double AverageExpense = TotalValue/Slots;

        return AverageExpense;
    }
}
