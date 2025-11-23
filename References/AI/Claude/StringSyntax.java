public class StringSyntax {
    public static void main(String[] args) {
        
        // ========== DECLARING AND INITIALIZING STRINGS ==========
        
        // A String stores TEXT (multiple characters)
        // Always use DOUBLE quotes " " for String
        String greeting = "Hello";
        String name = "John";
        String sentence = "This is a complete sentence!";
        
        // You can also store numbers as text (but can't do math with them)
        String phoneNumber = "555-1234";
        
        System.out.println(greeting);
        System.out.println(name);
        System.out.println(sentence);
        System.out.println();
        
        
        // ========== STRING CONCATENATION (JOINING STRINGS) ==========
        
        // Use the + operator to combine Strings
        String firstName = "Jane";
        String lastName = "Doe";
        String fullName = firstName + " " + lastName;  // Adds a space between
        System.out.println("Full name: " + fullName);
        
        // You can combine Strings with numbers
        int age = 25;
        String message = "I am " + age + " years old";
        System.out.println(message);
        System.out.println();
        
        
        // ========== STRING LENGTH ==========
        
        // Find out how many characters are in a String
        String word = "Programming";
        int length = word.length();  // Counts all characters including spaces
        System.out.println("The word '" + word + "' has " + length + " letters");
        
        String withSpaces = "Hello World";
        System.out.println("Length with spaces: " + withSpaces.length());
        System.out.println();
        
        
        // ========== ACCESSING CHARACTERS IN A STRING ==========
        
        // Get a single character at a specific position (starts at 0)
        String text = "Java";
        char firstChar = text.charAt(0);   // Gets 'J' (position 0)
        char secondChar = text.charAt(1);  // Gets 'a' (position 1)
        char lastChar = text.charAt(3);    // Gets 'a' (position 3)
        
        System.out.println("First character: " + firstChar);
        System.out.println("Second character: " + secondChar);
        System.out.println("Last character: " + lastChar);
        System.out.println();
        
        
        // ========== COMPARING STRINGS ==========
        
        String word1 = "apple";
        String word2 = "apple";
        String word3 = "orange";
        
        // CORRECT way: Use .equals() method
        if (word1.equals(word2)) {
            System.out.println("word1 and word2 are the same");
        }
        
        // Check if NOT equal
        if (!word1.equals(word3)) {
            System.out.println("word1 and word3 are different");
        }
        
        // Compare ignoring uppercase/lowercase
        String upper = "HELLO";
        String lower = "hello";
        if (upper.equalsIgnoreCase(lower)) {
            System.out.println("They're the same (ignoring case)");
        }
        System.out.println();
        
        
        // ========== CHANGING CASE ==========
        
        String original = "Hello World";
        
        // Convert to all uppercase
        String upperCase = original.toUpperCase();
        System.out.println("Uppercase: " + upperCase);
        
        // Convert to all lowercase
        String lowerCase = original.toLowerCase();
        System.out.println("Lowercase: " + lowerCase);
        System.out.println();
        
        
        // ========== FINDING TEXT WITHIN A STRING ==========
        
        String sentence2 = "The quick brown fox";
        
        // Check if String contains specific text
        boolean hasWord = sentence2.contains("brown");
        System.out.println("Contains 'brown'? " + hasWord);
        
        // Check if String starts with specific text
        boolean startsWithThe = sentence2.startsWith("The");
        System.out.println("Starts with 'The'? " + startsWithThe);
        
        // Check if String ends with specific text
        boolean endsWithFox = sentence2.endsWith("fox");
        System.out.println("Ends with 'fox'? " + endsWithFox);
        
        // Find the position of a word (returns -1 if not found)
        int position = sentence2.indexOf("quick");
        System.out.println("Position of 'quick': " + position);
        System.out.println();
        
        
        // ========== EXTRACTING PARTS OF A STRING ==========
        
        String fullText = "Hello World";
        
        // Get a piece of the String (substring)
        // substring(start, end) - end position is NOT included
        String part1 = fullText.substring(0, 5);  // Gets "Hello"
        String part2 = fullText.substring(6);     // Gets "World" (from position 6 to end)
        
        System.out.println("First part: " + part1);
        System.out.println("Second part: " + part2);
        System.out.println();
        
        
        // ========== REPLACING TEXT ==========
        
        String original2 = "I like cats";
        
        // Replace a word with another word
        String replaced = original2.replace("cats", "dogs");
        System.out.println("Original: " + original2);
        System.out.println("Replaced: " + replaced);
        
        // Replace a single character
        String text2 = "Hello";
        String changed = text2.replace('l', 'p');
        System.out.println("Changed: " + changed);  // Outputs: "Heppo"
        System.out.println();
        
        
        // ========== REMOVING SPACES ==========
        
        String withSpaces2 = "   Hello World   ";
        
        // Remove spaces from beginning and end
        String trimmed = withSpaces2.trim();
        System.out.println("Original: '" + withSpaces2 + "'");
        System.out.println("Trimmed: '" + trimmed + "'");
        System.out.println();
        
        
        // ========== SPLITTING STRINGS ==========
        
        // Break a String into multiple pieces
        String fruits = "apple,banana,orange";
        String[] fruitArray = fruits.split(",");  // Split at each comma
        
        System.out.println("First fruit: " + fruitArray[0]);
        System.out.println("Second fruit: " + fruitArray[1]);
        System.out.println("Third fruit: " + fruitArray[2]);
        System.out.println();
        
        
        // ========== CHECKING IF STRING IS EMPTY ==========
        
        String empty = "";
        String notEmpty = "Hello";
        
        // Check if String has no characters
        System.out.println("Is empty? " + empty.isEmpty());
        System.out.println("Is not empty? " + notEmpty.isEmpty());
        System.out.println();
        
        
        // ========== CONVERTING TO STRING ==========
        
        // Convert numbers to String
        int number = 42;
        String numAsString = String.valueOf(number);
        System.out.println("Number as String: " + numAsString);
        
        // Convert String to number
        String numberText = "100";
        int convertedNumber = Integer.parseInt(numberText);
        System.out.println("String as number: " + convertedNumber);
        System.out.println("Now we can do math: " + (convertedNumber + 50));
        System.out.println();
        
        
        // ========== SPECIAL CHARACTERS IN STRINGS ==========
        
        // Use escape sequences for special characters
        String withQuote = "He said \"Hello\"";  // Use \" for quotes inside String
        String withNewLine = "Line 1\nLine 2";    // \n for new line
        String withTab = "Name:\tJohn";           // \t for tab
        String withBackslash = "C:\\Users\\John"; // \\ for backslash
        
        System.out.println(withQuote);
        System.out.println(withNewLine);
        System.out.println(withTab);
        System.out.println(withBackslash);
        System.out.println();
        
        
        // ========== IMPORTANT: STRINGS ARE IMMUTABLE ==========
        
        // Strings CANNOT be changed after they're created
        // Methods like replace(), toUpperCase() create NEW Strings
        String original3 = "Hello";
        original3.toUpperCase();  // This doesn't change original3!
        System.out.println("Still lowercase: " + original3);
        
        // You must assign the result to a variable
        String modified = original3.toUpperCase();
        System.out.println("Now uppercase: " + modified);
        System.out.println();
        
        
        // ========== COMMON MISTAKES TO AVOID ==========
        
        // WRONG: Don't use == to compare Strings
        String a = "hello";
        String b = "hello";
        // if (a == b) { }  // DON'T DO THIS! Use .equals() instead
        
        // CORRECT: Use .equals() method
        if (a.equals(b)) {
            System.out.println("Correct way to compare Strings!");
        }
        
        // WRONG: Single quotes are for char, not String
        // String wrong = 'Hello';  // This causes an error!
        
        // CORRECT: Use double quotes for String
        String correct = "Hello";
        System.out.println("Correct way: " + correct);
    }
}