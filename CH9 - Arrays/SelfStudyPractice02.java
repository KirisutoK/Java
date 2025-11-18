//Oct 17, 2025
import java.util.Scanner;
import java.util.ArrayList;

public class SelfStudyPractice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> Products = new ArrayList<>();
        ArrayList<Double> Prices = new ArrayList<>();

        System.out.println("=== Personal Budget Tracker ===");

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
        scanner.close();

        //============== Reciept ==============\\
        System.out.println("\n=== Your Expenses ===");
        for (int i = 0; i < Products.size(); i++) {
            System.out.println((i+1) + ". " + Products.get(i) + " - $" + Prices.get(i));
        }

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

    public static double CalculateTotalSpent(ArrayList<Double> name) {
        Double TotalSpent = 0.0;

        for (Double value : name) {
            TotalSpent += value;
        }
        return TotalSpent;
    }
    public static double findMostExpensive(ArrayList<Double> name) {
        Double MostExpensive = 0.0;

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
        double TotalValue = 0;

        for (int i = 0; i < name.size(); i++) {
            TotalValue += name.get(i);
            Slots++;
        }

        double AverageExpense = TotalValue/Slots;

        return AverageExpense;
    }
}
