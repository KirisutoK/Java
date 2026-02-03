public class Algorithm03 {
    public static void main(String[] args) {
        System.out.println(countVowels("Java"));
        System.out.println(countVowels("FLCC")); // supposed to be 2???
        System.out.println(countVowels("apple"));
        System.out.println(countVowels("Will"));
    }

    public static int countVowels(String word) {
        word = word.toLowerCase(); // Converts into Lowercase

        int VowelChar = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u') {
                VowelChar++;
            }
        }

        return VowelChar;
    }
}
