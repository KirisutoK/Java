// Creation Date: June 13, 2026. at 11:14 AM
// Last Modified: June 14, 2026. at  1:38 AM

public class SafeCalculator {
    //=======VARIABLES=======//

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public int divide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
            return 0;
        }
    }
    public int getArrayElement(int[] arr, int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index: "+index);
            return -1;
        }
    }
    public int parseNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println(text+" is not a valid number");
            return -1;
        }
    }


    // ================================================== OTHER CLASSES ================================================== \\
}

// Requirements:
//
// ✅ Public method: divide(int a, int b) — returns int
//      • Use a try-catch to handle ArithmeticException (division by zero)
//      • If an error occurs, print "Cannot divide by zero!" and return 0
//      • Otherwise return a / b
//
// ✅ Public method: getArrayElement(int[] arr, int index) — returns int
//      • Use a try-catch to handle ArrayIndexOutOfBoundsException
//      • If an error occurs, print "Invalid index: [index]" and return -1
//      • Otherwise return arr[index]
//
// ✅ Public method: parseNumber(String text) — returns int
//      • Use a try-catch to handle NumberFormatException
//      • If an error occurs, print "'[text]' is not a valid number" and return -1
//      • Otherwise return the parsed integer using Integer.parseInt(text)
