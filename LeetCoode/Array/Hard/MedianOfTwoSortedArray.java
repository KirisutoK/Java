// Creation Date: June 14, 2026. at 11:46 PM
// Last Modified: June 14, 2026. at 11:50 PM

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //? MERGE ALL THE ARRAYS
        int[] mergedArr = new int[nums1.length + nums2.length];

        if (nums1.length != 0) { // SECURITY MEASURES (IF IT'S NOT EMPTY)
            for (int i = 0; i < nums1.length; i++) {  // <======== ADDING NUMS1[]
                mergedArr[i] = nums1[i];
            }
        }
        if (nums2.length != 0) { // SECURITY MEASURES (IF IT'S NOT EMPTY)
            for (int i = 0; i < nums2.length; i++ ) { // <======== ADDING NUMS2[]
                mergedArr[nums1.length+i] = nums2[i];
            }
        }

        //? ARRANGE THE MERGED ARRAY IN ORDER
        // -> First Selection
        for (int i = 0; i < mergedArr.length; i++) {
            // -> Second Selection
            for (int j = i; j < mergedArr.length; j++) {
                if (mergedArr[i] > mergedArr[j]) {
                    int Temp = mergedArr[i];
                    mergedArr[i] = mergedArr[j];
                    mergedArr[j] = Temp;
                }
            }
        }

        //? CALCULATE MEDIAN (From 2nd Array into 2nd to the last Array)
        double numerator = 0;
        double denominator = 0;
        if (mergedArr.length < 2) { // SAFETY MEASURES!
            return mergedArr[0];
        }
        for (int i = 1; i < mergedArr.length-1; i++) {
            numerator += mergedArr[i];
            denominator++;
        }

        //? OUTPUT
        System.out.println("ARRAY");
        for (int i = 0; i < mergedArr.length; i++) {
            System.out.println(mergedArr[i]);
        }
        System.out.println("NUMERATOR/DENOMINATOR");
        System.out.println(numerator);
        System.out.println(denominator);
        return numerator/denominator;
    }
}

// NOTES: I AM STUCK ON A TEST CASE WHERE
// Nums1 = {2,2,4,4}
// Nums2 = {2,2,2,4,4}
//
// I HAVE FOUND A SOLUTION
// The problem was that my calculation was wrong on how to find the median:
//      → In order to find the median, I have to pick the middle (if the array.length is odd)
//      → In order to find the median, I have to pick the middle and add next to it and divide by 2
//
// SUGGESTION: REWRITE THE WHOLE ENTIRE THING
// LINK: https://leetcode.com/problems/median-of-two-sorted-arrays