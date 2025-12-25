public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String Original = "" + x;
        String ReverseOriginal = "";

        int ValueSize = Original.length();

        for (int i = ValueSize-1; i >= 0; i--) {
            ReverseOriginal += Original.charAt(i);
        }

        if (Original.equals(ReverseOriginal)) {
            return true;
        } else {
            return false;
        }
    }
}
