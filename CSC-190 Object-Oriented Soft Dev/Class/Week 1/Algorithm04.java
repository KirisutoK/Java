public class Algorithm04 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("mom"));
        System.out.println(isPalindrome("dad"));
        System.out.println(isPalindrome("brother"));
        System.out.println(isPalindrome("palindrome"));
    }

    public static boolean isPalindrome(String word) {
        char FirstLetter = Character.toLowerCase(word.charAt(0));
        char LastLetter = Character.toLowerCase(word.charAt(word.length()-1));

        return FirstLetter == LastLetter;
    }
}
