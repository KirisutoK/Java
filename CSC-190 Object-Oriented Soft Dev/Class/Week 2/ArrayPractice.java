import java.util.Scanner;

public class ArrayPractice {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // CREATE THE ARRAY
        String[] Anime = {"Boku no Pico", "Yosuga no sora", "Overflow", "Redo of Healer"};


        // PRINT THE ARRAY
        for (String i:Anime) {
            System.out.print(i+" | ");
        }

        // OTHER ARRAY
        String[] Season = {"Summer", "Fall", "Winter", "Spring"};
    }
}
