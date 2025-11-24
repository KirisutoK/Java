//Oct 23, 2025
//count how many times the char has duplicates
//counts how many times a value has added inside the hashset

import java.util.HashSet;

public class SelfStudyHashSet03 {
    public static void main(String[]args) {
        String Word = "avdcde";
        int Addedcount = 0;
        int DidNotCount = 0;

        HashSet<Character> CharInStrings = new HashSet<>();
        for (int i = 0; i < Word.length(); i++) {
            boolean AddedConditions = CharInStrings.add(Word.charAt(i)); // checks if the value is added in the hashset and also adds a value in hashset

            if (AddedConditions == true) {
                Addedcount++;
            } else if (AddedConditions == false) {
                DidNotCount++;
            }

            System.out.println(CharInStrings);           
        }

        System.out.println();
        System.out.println(Addedcount);
        System.out.println(DidNotCount);
    }
}
