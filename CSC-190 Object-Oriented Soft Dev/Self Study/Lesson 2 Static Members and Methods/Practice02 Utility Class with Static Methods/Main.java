public class Main {
    public static void main(String[] args) {

        // CALLING THE CLASS(MathHelper) METHOD'S
        System.out.println(MathHelper.calculateCircleArea(5)); // Calculates the Circle Area.
        System.out.println(MathHelper.calculateCirclePerimeter(5)); // Calculates Circle perimeter.
        System.out.println(MathHelper.findMax(45, 23, 67)); // Finds maximum(highest) number between the three numbers.
        System.out.println(MathHelper.findMin(45, 23, 67)); // Finds minimum(lowest) number between the three numbers.
        System.out.println(MathHelper.isEven(10)); // Checks if the number is even (can be divided by 2)
        System.out.println(MathHelper.isEven(15)); // Checks if the number is even (can be divided by 2)

        // CREATING MATH HELPER(MathHelper) OBJECT
        /*
        MathHelper Test = new MathHelper();                 <------------ DOES NOT WORK BECAUSE THE CONSTRUCTOR IS SET TO PRIVATE
        Why do we have a constructor in the MathHelper class and set it to private if we are not going to use it?
        A: It is to prevent the class from being able to create an object. encoding private constructor makes the class unable to create an object outside from other files
        */

        // CREATING CALCULATOR(Calculator) OBJECT
        Calculator Device1 = new Calculator();

        Device1.add(100); // Adds 100 to calc                --------> 100 Total Now
        System.out.println(Device1.getResult()); // Prints
        Device1.add(50); // Adds 50                           -------> 150 Total Now
        System.out.println(Device1.getResult()); // Prints
        Device1.multiply(2); // Multiplies 150 by 2    --------> 300 Total Now
        System.out.println(Device1.getResult()); // Prints
        Device1.subtract(75); // Substracts 300 by 75  --------> 225 Total Now
        System.out.println(Device1.getResult()); // Prints
        Device1.divide(5); // Divides 225 by 5       --------> 45 Total Now
        System.out.println(Device1.getResult()); // Prints
        Device1.reset(); // Resets the numbers                -------> 0 Total Now
        System.out.println(Device1.getResult()); // Prints

    }
}
