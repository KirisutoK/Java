// Creation Date: March 31, 2026. at 10:34 AM
// Last Modified: March 31, 2026. at 10:37 AM

public class ExceptionHandling01 {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30};
        try {
            System.out.println(nums[3]); // index 3 doesn't exist
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Oops! That index doesn't exist in the array.");
            System.out.println("Error details: " + e.getMessage());
        }
        finally {
            System.out.println("This line prints no matter what.");
        }
    }
}
