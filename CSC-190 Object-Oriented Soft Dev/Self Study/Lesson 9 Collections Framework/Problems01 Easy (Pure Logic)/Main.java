// Creation Date: June 28, 2026. at 4:02 AM
// Last Modified: June 30, 2026. at  1:42 AM

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> Arr01 = new ArrayList<>();
        Arr01.add(1);
        Arr01.add(2);
        Arr01.add(3);
        Arr01.add(4);
        Arr01.add(5);

        System.out.println(evenSum(Arr01));

    }

    public static int evenSum(ArrayList<Integer> arr) {
        int result = 0;

        for (Integer i:arr) {
            if (i%2 == 0) { // If dividing 2 leaves 0 remainder, then do this (This means that if a number is divided by 2 returns a whole number, then it's even) NOTE: in order to get that decimal point, we must convert the data type into float, long, or double in order to store decimal numbers
                result += i;
            }
        }

        return result;
    }
}


// Problem 1 — Easy (Pure Logic)
// Given an ArrayList<Integer>, return the sum of all even numbers in the list.
//
// Input:  [1, 2, 3, 4, 5, 6]
// Output: 12  (2 + 4 + 6)
//
// Input:  [1, 3, 5, 7]
// Output: 0  (no even numbers)