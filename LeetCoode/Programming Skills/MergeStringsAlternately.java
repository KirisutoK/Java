/*
     1768. Merge Strings Alternately

    You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, 
    starting with word1. If a string is longer than the other, append the additional letters onto the end 
    of the merged string.

    Return the merged string.
*/

public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        int Word1Size = word1.length();
        int Word2Size = word2.length();

        String mergedWords = "";

        int minLength = Math.min(Word1Size, Word2Size); 

        for (int i = 0; i < minLength; i++) {
            mergedWords += word1.charAt(i);
            mergedWords += word2.charAt(i);
        }

        if (Word1Size > Word2Size) {
            mergedWords += word1.substring(minLength);
        } else if (Word1Size < Word2Size) {
            mergedWords += word2.substring(minLength);
        }
        return mergedWords;
    }
}
