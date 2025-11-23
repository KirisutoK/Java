public class CharSyntax {
    public static void main(String[] args) {
        
        // ========== DECLARING AND INITIALIZING CHARS ==========
        
        // A char stores a SINGLE character (letter, number, or symbol)
        // Always use SINGLE quotes ' ' for char
        char letter = 'A';
        char digit = '5';
        char symbol = '$';
        
        System.out.println("Letter: " + letter);
        System.out.println("Digit: " + digit);
        System.out.println("Symbol: " + symbol);
        System.out.println();
        
        
        // ========== UNICODE VALUES ==========
        
        // Every char is stored as a number (Unicode value)
        // You can assign a number directly to a char
        char letterFromNumber = 65;  // 65 is the Unicode for 'A'
        System.out.println("Char from number 65: " + letterFromNumber);
        
        // You can also use Unicode escape sequence
        char heart = '\u2764';  // Unicode for heart symbol
        System.out.println("Heart symbol: " + heart);
        System.out.println();
        
        
        // ========== CONVERTING CHAR TO NUMBER ==========
        
        // You can get the numeric (Unicode) value of a char
        char myChar = 'B';
        int numericValue = (int) myChar;  // Cast (convert) char to int
        System.out.println("The number value of 'B' is: " + numericValue);
        System.out.println();
        
        
        // ========== SPECIAL CHARACTERS (ESCAPE SEQUENCES) ==========
        
        // Some characters need a backslash \ before them
        char newLine = '\n';      // Moves to a new line
        char tab = '\t';          // Creates a tab space
        char backslash = '\\';    // The backslash character itself
        char singleQuote = '\'';  // Single quote character
        
        System.out.println("Line 1" + newLine + "Line 2");
        System.out.println("Column1" + tab + "Column2");
        System.out.println("This is a backslash: " + backslash);
        System.out.println();
        
        
        // ========== COMPARING CHARS ==========
        
        // You can compare chars using comparison operators
        char first = 'A';
        char second = 'B';
        
        // Check if two chars are equal
        if (first == second) {
            System.out.println("Chars are the same");
        } else {
            System.out.println("Chars are different");
        }
        
        // Check which char comes first alphabetically
        if (first < second) {
            System.out.println(first + " comes before " + second);
        }
        System.out.println();
        
        
        // ========== CHAR ARITHMETIC ==========
        
        // You can do math with chars (adds their Unicode values)
        char a = 'A';  // Unicode value 65
        char nextChar = (char) (a + 1);  // Add 1 to get 'B'
        System.out.println("Next char after A: " + nextChar);
        
        // Get the difference between two chars
        char c1 = 'Z';
        char c2 = 'A';
        int difference = c1 - c2;  // Subtracts Unicode values
        System.out.println("Difference between Z and A: " + difference);
        System.out.println();
        
        
        // ========== CHECKING CHAR PROPERTIES ==========
        
        // Java has built-in methods to check what type of char it is
        char testChar = 'g';
        
        // Check if it's a letter
        System.out.println("Is '" + testChar + "' a letter? " + 
                           Character.isLetter(testChar));
        
        // Check if it's a digit (0-9)
        System.out.println("Is '" + testChar + "' a digit? " + 
                           Character.isDigit(testChar));
        
        // Check if it's uppercase
        System.out.println("Is '" + testChar + "' uppercase? " + 
                           Character.isUpperCase(testChar));
        
        // Check if it's lowercase
        System.out.println("Is '" + testChar + "' lowercase? " + 
                           Character.isLowerCase(testChar));
        System.out.println();
        
        
        // ========== CONVERTING CASE ==========
        
        // Convert to uppercase
        char lower = 'h';
        char upper = Character.toUpperCase(lower);
        System.out.println("Uppercase: " + upper);
        
        // Convert to lowercase
        char upperCase = 'M';
        char lowerCase = Character.toLowerCase(upperCase);
        System.out.println("Lowercase: " + lowerCase);
        System.out.println();
        
        
        // ========== COMMON MISTAKES TO AVOID ==========
        
        // WRONG: Don't use double quotes (that's for String)
        // char wrong = "A";  // This causes an error!
        
        // WRONG: Can only hold ONE character
        // char tooMany = 'AB';  // This causes an error!
        
        // CORRECT: Use single quotes for one character
        char correct = 'A';
        System.out.println("Correct way: " + correct);
    }
}