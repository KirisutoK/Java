// Creation Date: June 19, 2026. at 12:21 PM
// Last Modified: June 19, 2026. at 12:31 PM

public class Main {
    public static void main(String[] args) {
        System.out.println(safeDivide(10, 2) );
        System.out.println(safeDivide(7, 0) );
    }

    public static double safeDivide(int a, int b) {
        try {
            int result = a / b;      //... integer division - THROWS ArithmeticException when b=0
            return (double) result;  //... then convert to double
            // return (double) a/b; <========== THIS DOESNT TRIGGER AN ERROR BECAUSE IT RETURNS IMMEDIATELY (TURNS INTO INFINITY)
        } catch (ArithmeticException e) {
            return 0.0;
        }
    }
}
