public class CenteredAverage {
    public static void main(String[] args) {
        int[] Numbers = {1, 2, 3, 4 ,5};

        centeredAverage(Numbers);
    }

    public static int centeredAverage(int[] nums) {
        int smallest = nums[0];
        int smallestposition = 0;
        int highest = nums[0];
        int highestposition = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < smallest) {
                smallest = nums[i];
                smallestposition = i;
            }
            if (nums[i] > highest) {
                highest = nums[i];
                highestposition = i;
            }
        }

        int sumtotal = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!(i == smallestposition || i == highestposition)) {
                sumtotal += nums[i];
            }
        }

        if (smallestposition == highestposition) {
            return nums[smallestposition];
        }

        int average = sumtotal / (nums.length - 2);

        return average;
    }
}
