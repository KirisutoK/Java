package Note;// Creation Date: March 31, 2026. at 10:17 AM
// Last Modified: March 31, 2026. at 10:35 AM

//| String Index Out of Bounds Exception => Similar to the array out of bounds but with a string - trying to access a character that doesn’t exist

public class StringIndexOutOfBoundsException {
   public static void main(String[] args) {
       String RandomLetters = "FUSDFHUSHFUS";

       System.out.println(RandomLetters.charAt(67));
   }
}
