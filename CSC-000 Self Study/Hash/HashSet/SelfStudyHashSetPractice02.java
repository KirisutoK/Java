// Oct 22, 2025
// This is for LeetCode Substring Quiz
// 3. Longest Substring Without Repeating Characters

// Ideas:
// String is abcdabcd: if there is already a in the hashset, it replaces with a
//

import java.util.Scanner;
import java.util.HashSet;

public class SelfStudyHashSetPractice02 {
   public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("s = ");
        String Word = scanner.nextLine();
        
        System.out.println(lengthOfLongestSubstring(Word));
    }

    public static int lengthOfLongestSubstring(String s) { //Finds the Substring
        HashSet HashSetWordsIGuess = new HashSet<>();

        int StartingPoint = 0;
        int ConsecutiveAdds = 0;
        int HighestConsecutiveAdds = 0;

        for (int i = 0; i < s.length(); i++) {
            Boolean DetectAdded = HashSetWordsIGuess.add(s.charAt(i));

            if (DetectAdded == true) {
                if (HashSetWordsIGuess.contains(s.charAt(i))) {
                    HashSetWordsIGuess.clear();
                    HashSetWordsIGuess.add(s.charAt(i));
                    ConsecutiveAdds++;
                }
            } else if (DetectAdded == false) {
                if (ConsecutiveAdds > HighestConsecutiveAdds) {
                    HighestConsecutiveAdds = ConsecutiveAdds;
                    StartingPoint = i;
                }
            }
        }

        int EndingPoint = StartingPoint+HighestConsecutiveAdds;
        
        s.substring(StartingPoint, EndingPoint);

        return;
    }  
}
   
    
