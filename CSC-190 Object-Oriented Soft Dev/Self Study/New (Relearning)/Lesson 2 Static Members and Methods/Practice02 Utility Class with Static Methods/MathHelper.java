public class MathHelper {
    //=======VARIABLES=======//
    private static final double PI = Math.PI;

    // NOTE: final means the variable will not be able to change

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    private MathHelper() {

    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public static double calculateCircleArea(double radius) { // A = πr2
        return PI * radius * radius;
    }
    public static double calculateCirclePerimeter(double radius) { // 𝐶 = 2𝜋𝑟
        return 2 * PI * radius;
    }
    public static double calculateRectangleArea(double length, double width) { // 𝐴 = length × width
        return length *  width;
    }
    public static double calculateRectanglePerimeter(double length, double width) { // 𝑃 = 2(length+width)
        return 2 * (length + width);
    }
    public static int findMax(int a, int b, int c) {
        int MaximumNumber = a; // Default Max is 0
        int[] array = {a, b, c}; // Creates an array

        for (int i = 0; i < array.length; i++) { // 0-2 (Array is 3)
            if (array[i] > MaximumNumber) { // If Value is greater than Max then replace
                MaximumNumber = array[i];
            }
        }

        return MaximumNumber;
    }
    public static int findMin(int a, int b, int c) {
        int MinimumNumber = a;

        int[] array = {a, b, c};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < MinimumNumber) {
                MinimumNumber = array[i];
            }
        }

        return MinimumNumber;
    }
    public static boolean isEven(int a) {
        if (a % 2 == 0)
            return true;
        else {
            return false;
        }
    }


    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
