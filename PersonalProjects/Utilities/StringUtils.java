// Creation Date: August 14, 2026. at 7:33 PM
// Last Modified: September 18, 2026. at  9:04 PM

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StringUtils {
    // =========================== CLASS VARIABLES =========================== \\
    static Scanner input = new Scanner(System.in);

    // =========================== METHODS =========================== \\
    // [STRING MODIFICATION]
    // Uses: Formatting
    public static String camelCase(String s) {
        StringBuilder sb = new StringBuilder(s);

        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                sb.setCharAt(i+1, Character.toUpperCase(sb.charAt(i+1)));
            }
        }

        return sb.toString();
    }
    public static String reverseCamelCase(String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                sb.setCharAt(i-1, Character.toUpperCase(sb.charAt(i-1)));
            }
        }

        return sb.toString();
    }
    public static String removeSpaces(String s) {
        s = s.trim();
        String[] Lines = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String l:Lines) {
            sb.append(l);
        }

        return sb.toString();
    }
    public static String lineAutoSpacing(String line, int width) {
        // DISPLAY
        int totalWidth = width;
        int spacesNeeded = Math.max(0, totalWidth - line.length() - 1); // NOTE: (spacesNeeded = totalWidth - prefixLength - usernameLength - 1) <========= FORMULA BY CLAUDE
        String padding = " ".repeat(spacesNeeded);

        return line + padding + line.toCharArray()[0];
    }
    public static String softWrapping(String line, int width) {
        // NOTE: THIS IS METHOD IS ENTIRELY MADE BY CLAUADE
        // NOTE: `lineAutoSpacing()` is used in this method

        if (line.length() + 1 <= width) { // +1 for the closing ║
            return lineAutoSpacing(line, width);
        }

        StringBuilder result = new StringBuilder();
        String continuationPrefix = "║   "; // indent for wrapped lines

        // split at the threshold
        String firstChunk = line.substring(0, width - 2); // -2 for closing ║ and space
        String remainder = line.substring(width - 2).trim();

        result.append(lineAutoSpacing(firstChunk, width)).append("\n");

        // handle remainder in chunks
        while (!remainder.isEmpty()) {
            if (continuationPrefix.length() + remainder.length() + 1 <= width) {
                result.append(lineAutoSpacing(continuationPrefix + remainder, width));
                remainder = "";
            } else {
                int space = width - continuationPrefix.length() - 2;
                result.append(lineAutoSpacing(continuationPrefix + remainder.substring(0, space), width)).append("\n");
                remainder = remainder.substring(space).trim();
            }
        }

        return result.toString();
    }

    // [STRING GAMES]
    // Uses: Requirements
    public static boolean isPalindrome(String s) {
        String r = String.valueOf(new StringBuilder(s).reverse());

        return (r.equalsIgnoreCase(s));
    }
    public static boolean isAnagram(String s1, String s2) {
        HashMap<Character, Integer> CharacterCounts01 = new HashMap<>();
        HashMap<Character, Integer> CharacterCounts02 = new HashMap<>();

        // COUNTING EACH FOR S1
        for (char c:s1.toCharArray()) {
            if (c == ' ') {
                continue;
            }

            c = Character.toUpperCase(c);

            if (CharacterCounts01.containsKey(c)) {
                CharacterCounts01.put(c, CharacterCounts01.get(c)+1);
            } else {
                CharacterCounts01.put(c, 1);
            }
        }

        // COUNTING EACH FOR S2
        for (char c:s2.toCharArray()) {
            if (c == ' ') {
                continue;
            }

            c = Character.toUpperCase(c);

            if (CharacterCounts02.containsKey(c)) {
                CharacterCounts02.put(c, CharacterCounts02.get(c)+1);
            } else {
                CharacterCounts02.put(c, 1);
            }
        }

        return CharacterCounts01.equals(CharacterCounts02);
    }
    public static int getAnswer(int start, int end) {  // Note: i am planning to add a throw in this reuseable method so that we can reuse "e" to exit.
        boolean ValidAnswer = false; //... Placeholders
        int Answer = 0; //... Placeholders
        while (!ValidAnswer) {
            try {
                System.out.print("Answer: ");
                Answer = input.nextInt();
                input.nextLine(); // Refreshes buffer
                if (Answer < start || Answer > end) {
                    throw new InputMismatchException();
                }

                ValidAnswer = true;
            } catch (InputMismatchException e) {
                System.out.println("Please choose between "+start+" through "+end);
                input.nextLine(); // Refreshes buffer
            }
        }
        System.out.println();

        return Answer;
    }

    // [HIDE VALUE]
    // Uses: Password
    public static String hideValue(String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != ' ') {
                sb.setCharAt(i, '•');
            }
        }

        return sb.toString();
    }
    public static String hideValue(String s, char letters) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != ' ') {
                sb.setCharAt(i, letters);
            }
        }

        return sb.toString();
    }
    public static String hideValue(String s, char letters, int show) {
        StringBuilder sb = new StringBuilder(s);
        int limit = sb.length() - show;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != ' ' && i < limit) {
                sb.setCharAt(i, letters);
            }
        }

        return sb.toString();
    }
    public static String hideValue(String s, int show) {
        StringBuilder sb = new StringBuilder(s);
        int limit = sb.length() - show;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != ' ' && i < limit) {
                sb.setCharAt(i, '•');
            }
        }

        return sb.toString();
    }

    // [EFFECTS]
    // Uses: Game Development
    public static void Dialogue(String Dialogue, int DialogueSpeed) { // Prints each word by word with a delay making it look like a typing effect
        try {
            for (char c : Dialogue.toCharArray()) {
                System.out.print(c);
                Thread.sleep(DialogueSpeed);
            }
        } catch (InterruptedException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
    public static void Dialogue(String Dialogue) { // Prints each word by word with a delay making it look like a typing effect
        try {
            for (char c : Dialogue.toCharArray()) {
                System.out.print(c);
                Thread.sleep(250);
            }
        } catch (InterruptedException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
 }
