// Creation Date: June 14, 2026. at 1:41 AM
// Last Modified: June 14, 2026. at  2:29 AM

public class Main {
    public static void main(String[] args) {
        //======= CREATING OBJECTS =======//
        FileProcessor FProcessor01 = new FileProcessor();

        //======= METHODS =======//
        // [FIRST METHOD]
        int[] somethingArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        FProcessor01.processFile("Sam Olay Files", somethingArr, 9); // <=== NO EXCEPTIONS
        System.out.println();
        FProcessor01.processFile(null, somethingArr, 9); // <=== NullPointer Exception
        System.out.println();
        FProcessor01.processFile("SOMETHING FILE", somethingArr, 10); // <=== ArrayIndexOutOfBounds Exception
        System.out.println();
        
        // [SECOND METHOD]
        try {
            System.out.println(FProcessor01.validateAge(10));
            System.out.println(FProcessor01.validateAge(-1)); // <=== IllegalArgument Exception
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
