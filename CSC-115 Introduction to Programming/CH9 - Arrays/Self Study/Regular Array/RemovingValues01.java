
public class RemovingValues01 {
    public static void main(String[] ags) {
        int[] RandomNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // This is the array4

        for (int values : RandomNumbers) { // Enhanced For Loops
            System.out.println(values);
        }
        System.out.println(" ");

        removeValues(5, RandomNumbers);

        for (int values : RandomNumbers) { // Enhanced For Loops
            System.out.println(values);
        }
    }

    public static void removeValues(int value ,int[] Array) { // Method to remove values

        int PositionToBeRemoved = -1; // To locate what part of the array needs to be removed

        for (int i = 0; i < Array.length; i++) { // Enhanced For Loops
            if (Array[i] == value) { // If the value of Array[i] is equal to the value given then
                PositionToBeRemoved = i;
                break; // so that it will save up memory and run as fast (immedietaly stops the code and move on to the next one)
            }
        }

        for (int i = PositionToBeRemoved; i < Array.length; i++) { // Starting point is i to the maximum length of the array
            if (i != Array.length - 1) { // If they are not equal then do this
                Array[i] = Array[i+1];
            }
        }
    }
}
