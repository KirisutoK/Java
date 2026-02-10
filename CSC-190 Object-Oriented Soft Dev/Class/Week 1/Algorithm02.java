public class Algorithm02 {
    public static void main(String[] args) {
        System.out.println(countLetter("Java", 'a'));
        System.out.println(countLetter("FLCC", 'C'));
        System.out.println(countLetter("FLCC", 'c'));
        System.out.println(countLetter("FLCC", 't'));
    }

    public static int countLetter(String word, char c) {
        word = word.toUpperCase();
        c = Character.toUpperCase(c);

        int RepeatingChar = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                RepeatingChar++;
            }
        }
        return RepeatingChar;
    }
}
