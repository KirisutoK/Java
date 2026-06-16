// Creation Date: June 14, 2026. at 11:46 PM
// Last Modified: June 16, 2026. at 12:20 AM

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {9, 9, 9, 1, 2, 3};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //? MERGE ALL THE ARRAYS
        int[] mergedArr = new int[nums1.length + nums2.length];

        if (nums1.length != 0) { // SECURITY MEASURES (IF ITS NOT EMPTY)
            for (int i = 0; i < nums1.length; i++) {  // <======== ADDING NUMS1[]
                mergedArr[i] = nums1[i];
            }
        }
        if (nums2.length != 0) { // SECURITY MEASURES (IF ITS NOT EMPTY)
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

        //? CALCULATE MEDIAN
        if (mergedArr.length < 2) { // if it is less than 2
            return mergedArr[0];
        }
        if (mergedArr.length % 2 == 0) { // if it is even
            return (double)(mergedArr[(mergedArr.length/2)-1] + mergedArr[((mergedArr.length/2)+1)-1]) /2;
        }

        //? OUTPUT
        return mergedArr[mergedArr.length/2];
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
// POST-NOTES: This was a fun leetcode problem. I am thinking of how to improve its runtime into 1ms (hopefully i can achieve it.)
// LINK: https://leetcode.com/problems/median-of-two-sorted-arrays/