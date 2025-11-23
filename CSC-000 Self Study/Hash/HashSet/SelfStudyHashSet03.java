//Unfinished
//count how many times the char has duplicates
//counts how many times a value has added inside the hashset

import java.util.HashSet;

public class SelfStudyHashSet03 {
    public static void main(String[]args) {
        String Word = "avdcde";
        int Addedcount = 0;

        HashSet<Character> CharInStrings = new HashSet<>();
        for (int i = 0; i < Word.length(); i++) {
            boolean AddedConditions = CharInStrings.add(Word.charAt(i));

            if (AddedConditions == false) {
                Addedcount++;
            }
            
        }

    }
}
