// Creation Date: October 20, 2026. at 1:31 PM
// Last Modified: October 20, 2026. at  2:06 PM

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class SubarraysDistinctElementSumofSquares1 {
    public static void main (String[] args) {
        int[] arr = {1,2,1};
        int totalSum = 0;

        for (int i = 0; i < arr.length; i++) {
            totalSum += CountTotalSumEachWindow(arr, i+1);
        }

        System.out.println("Sum: "+totalSum);
    }

    public static int CountTotalSumEachWindow (int[] arr, int WindowSize) {
        HashSet<Integer> UniqueNumbers = new HashSet();
        int totalSum = 0;

        for (int i = 0; i < (arr.length-WindowSize)+1; i++) { // right variable
            for (int j = i; j < i+WindowSize; j++) {
                UniqueNumbers.add(arr[j]);
            }
            System.out.println("Window Size: "+WindowSize);
            System.out.println("Total Unique Numbers: "+UniqueNumbers.size());
            totalSum += Math.pow(UniqueNumbers.size(), 2);
            UniqueNumbers.clear();
        }

        return totalSum;
    }
}
