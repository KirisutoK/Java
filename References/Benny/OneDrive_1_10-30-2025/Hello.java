//imports needed files
import java.util.Scanner;

//The class
public class Hello {

    //Creates a main for the code to run on
    public static void main(String[] args) {

        //Scans wanted variables into existence, Word and char
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String word = scan.next();
        System.out.println("Enter the letter you are looking for: ");
        char ch = scan.next().charAt(0);

        //Method caller
        howManyLetters(word, ch);

    }

    //Tests the amount of letters in the word
    public static void howManyLetters(String w, char ch) {

    //makes sure the variables are not case sensitive
    w = w.toLowerCase();
    ch = Character.toLowerCase(ch);

    //initializes count variable
    int count = 0;

    //Go through word and checks each letter to see if it matches the char
    for (int i = 0; i < w.length(); i++)
    {
        if (ch == w.charAt(i))
        {
            count++;
        }
    }
        System.out.println(count);
    }
}
