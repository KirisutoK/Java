import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Player player1 = new Player("John", 100, 50);

        System.out.println("Enter your name: ");
        player1.setName(scanner.nextLine());

        player1.displayUserStats();
    }
}