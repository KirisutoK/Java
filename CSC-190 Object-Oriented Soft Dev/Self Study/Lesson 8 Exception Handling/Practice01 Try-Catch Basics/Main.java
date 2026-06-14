// Creation Date: June 13, 2026. at 11:13 AM
// Last Modified: June 14, 2026. at  1:38 AM

public class Main {
    public static void main(String[] args) {
        //======= CREATING OBJECTS =======//
        SafeCalculator SCalculator01 = new SafeCalculator();

        //======= METHODS =======//
        // [Arithmetic  Exception]
        System.out.println(SCalculator01.divide(10, 2));
        System.out.println(SCalculator01.divide(10, 0));

        // [ArrayIndexOutOfBounds Exception]
        int[] arr = new int[3];
        System.out.println(SCalculator01.getArrayElement(arr, 2));
        System.out.println(SCalculator01.getArrayElement(arr, 3));

        // [NumberFormat Exception]
        System.out.println(SCalculator01.parseNumber("100"));
        System.out.println(SCalculator01.parseNumber("abc"));
    }
}
