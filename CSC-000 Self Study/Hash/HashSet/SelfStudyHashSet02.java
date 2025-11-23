//Oct 22, 2025
//Hashset does not have an index. 

import java.util.HashSet;

public class SelfStudyHashSet02 {
    public static void main (String[]args) {
        HashSet<Integer> NumbersIGuess = new HashSet<>();
        
        NumbersIGuess.add(1);
        NumbersIGuess.add(2);
        NumbersIGuess.add(3);
        NumbersIGuess.add(4);

        System.out.println(NumbersIGuess);

        NumbersIGuess.remove(0); // It is not found in the HashSet values.
        NumbersIGuess.remove(4); // If 4 is in the HashSet, then it is removed.

        System.out.println(NumbersIGuess);
    }
}
