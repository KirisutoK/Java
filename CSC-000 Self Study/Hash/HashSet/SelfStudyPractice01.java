import java.util.Scanner;
import java.util.HashSet;

public class SelfStudyPractice01 {
   public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("s = \"");
        String Word = scanner.nextLine();
        System.out.print("\"");
        
        lengthOfLongestSubstring(Word);
    }

    public int lengthOfLongestSubstring(String s) { //Finds the Substring
        set HashSetWordIGuess = new HashSet<>();
        
        for (int i = 0; i < s.length; i++) {
            HashSetWordIGuess.add(s.CharAt(i));
        }

    }  
}
   
    
