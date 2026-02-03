import java.util.Scanner;

public class Algorithm01 {
    public static void main(String[] args) {
        // UTILITIES
        Scanner scanner = new Scanner(System.in);

        // OTHERS
        System.out.print("What is your word? ");
        String Word = scanner.nextLine();

        System.out.print("What is your Character? ");
        char C = scanner.next().charAt(0);

        // COUNTING REPEATING CHARACTERS
        int RepeatingChar = CalculateCharinWord(Word, C);

        System.out.println("There are "+RepeatingChar+" Repeating Characters in "+Word+". ");
    }

    public static int CalculateCharinWord(String word, char c) {
        // UPPERCASE CONVERSION TO IGNORE CAPITALIZATION
        word = word.toUpperCase();
        c = Character.toUpperCase(c);

        // Calculation
        int RepeatingChar = 0;
        for (int i = 0; i < word.length(); i++) {
            if (c == word.charAt(i)) {
                RepeatingChar++;
            }
        }
        return RepeatingChar;
    }
}
