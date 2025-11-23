//Oct 22, 2025
//Unfinished 

import java.util.Scanner;
import java.util.HashSet;

public class SelfStudyHashSetPractice02 {
   public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("s = \"");
        String Word = scanner.nextLine();
        System.out.print("\"");
        
        lengthOfLongestSubstring(Word);
    }

    public static int lengthOfLongestSubstring(String s) { //Finds the Substring
        HashSet HashSetWordsIGuess = new HashSet<>();
        int LongestNoRepeatingWordLength = 0;
        for (int i = 0; i < s.length(); i++) {
            HashSetWordsIGuess.add(s.charAt(i));
        }

        return LongestNoRepeatingWordLength;
    }  
}
   
    
