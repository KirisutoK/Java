import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String [] args) {
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

        scanner.close();
    }
}
