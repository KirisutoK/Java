// Creation Date: March 31, 2026. at 10:37 AM
// Last Modified: March 31, 2026. at 10:40 AM

public class ExceptionHandling02 {
    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;
        try {
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        }
        catch (ArithmeticException e) {
            System.out.println("Can't divide by zero!");
        }
        finally {
            System.out.println("Finally");
        }
    }
}
