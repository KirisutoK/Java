import java.util.Arrays; // Importing the Arrays class for Tip #5

public class ArrayTopFiveThings {

    public static void main(String[] args) {

        System.out.println("JAVA ARRAYS - 5 THINGS TO REMEMBER!\n");

        // 1. fixed size - declare & initialize
        // once an array is created --> its size cannot change
        // this array will hold 4 String objects
        String[] professorNames = new String[4];
        
        // you can also initialize with values directly:
        // int[] numbers = {33, 72, 58, 14}; 

        System.out.println("1. Created an array of size: " + professorNames.length);

        // 2. indexing begins at zero
        // the first element is at index zero
        // the last element is at the length minus 1
        professorNames[0] = "Brewer";
        professorNames[1] = "McLaughlin";
        professorNames[2] = "Dixon";
        
        System.out.println("\n2. The first element (index 0) is: " + professorNames[0]);

        // 3. default values
        // Java automatically fills empty array slots with default values 
        // 0 for numbers, false for boolean, null for Objects (Strings)
        // we never assigned index 3, so it should be null
        System.out.println("\n3. Value at unassigned index 3 is: " + professorNames[3]);

        // 4. length is a property
        // arrays use a property .length (no parentheses)
        // this is NOT a method like .size() or .length()
        // helps to avoid an ArrayIndexOutOfBoundsException
        System.out.println("\n4. Iterating through the array:");
        
        for (int i = 0; i < professorNames.length; i++) {
            // We verify the data isn't null before printing to avoid errors
            if (professorNames[i] != null) {
                System.out.println("   index: " + i + ", last name: " + professorNames[i]);
            }
        }

        // 5. printing arrays
        // If you try to print an array directly, you get a memory address such as [Ljava.lang.String;@15db9742
        // use Arrays.toString() or a loop to see the contents
        System.out.println("\n5. Printing array directly vs. using helper vs. for-each loop:");
        System.out.println("\t\tDirect print: " + professorNames); 
        System.out.println("\t\tHelper print: " + Arrays.toString(professorNames));
        
        // 5b. printing with a for-each loop
        System.out.print("\t\tLoop print: ");
        for (String lastName : professorNames) {
            System.out.print(lastName + " ");
        }
    }
}
