public class SlidingWindowBasics {
    public static void main(String[] args) {
        
        // ========== WHAT IS SLIDING WINDOW? ==========
        
        // Sliding Window is a technique to solve problems involving arrays or strings
        // 
        // IMAGINE: You have a long fence with many boards
        // Instead of checking ALL boards every time, you:
        // 1. Look at a small "window" (a few boards at a time)
        // 2. Slide the window one step to the right
        // 3. Adjust what you're tracking (remove old, add new)
        //
        // This makes your code MUCH FASTER!
        
        System.out.println("=== UNDERSTANDING SLIDING WINDOW ===");
        System.out.println("Array: [1, 2, 3, 4, 5, 6]");
        System.out.println("Window size: 3");
        System.out.println();
        System.out.println("Step 1: [1, 2, 3] 4, 5, 6");
        System.out.println("Step 2:  1, [2, 3, 4] 5, 6");
        System.out.println("Step 3:  1, 2, [3, 4, 5] 6");
        System.out.println("Step 4:  1, 2, 3, [4, 5, 6]");
        System.out.println();
        System.out.println("The window 'slides' through the array!");
        System.out.println();
        System.out.println("=".repeat(50));
        System.out.println();
        
        
        // ========== EXAMPLE 1: FIXED SIZE WINDOW ==========
        // Problem: Find the maximum sum of 3 consecutive numbers
        
        System.out.println("=== EXAMPLE 1: Maximum Sum of 3 Consecutive Numbers ===");
        
        int[] numbers = {2, 1, 5, 1, 3, 2, 7, 4};
        int windowSize = 3;
        
        System.out.println("Array: [2, 1, 5, 1, 3, 2, 7, 4]");
        System.out.println("Window size: " + windowSize);
        System.out.println();
        
        // STEP 1: Calculate sum of first window
        int currentSum = 0;
        for (int i = 0; i < windowSize; i++) {
            currentSum += numbers[i];  // Sum of first 3: 2 + 1 + 5 = 8
        }
        
        int maxSum = currentSum;  // Track the maximum sum
        System.out.println("First window [2, 1, 5] sum: " + currentSum);
        
        // STEP 2: Slide the window
        // Start from position 3 (4th element) and go to the end
        for (int i = windowSize; i < numbers.length; i++) {
            // Remove the element that's leaving the window (left side)
            currentSum -= numbers[i - windowSize];
            
            // Add the new element entering the window (right side)
            currentSum += numbers[i];
            
            // Update maximum if current sum is bigger
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            
            // Show what's happening
            System.out.println("Window [" + numbers[i-2] + ", " + numbers[i-1] + 
                             ", " + numbers[i] + "] sum: " + currentSum);
        }
        
        System.out.println("\nMaximum sum: " + maxSum);
        System.out.println();
        System.out.println("=".repeat(50));
        System.out.println();
        
        
        // ========== EXAMPLE 2: AVERAGE OF SUBARRAYS ==========
        // Problem: Find average of every 4 consecutive numbers
        
        System.out.println("=== EXAMPLE 2: Average of Every 4 Numbers ===");
        
        int[] data = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int size = 4;
        
        System.out.println("Array: [1, 3, 2, 6, -1, 4, 1, 8, 2]");
        System.out.println("Window size: " + size);
        System.out.println();
        
        // Calculate first window sum
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += data[i];
        }
        
        // Print first average
        double average = (double) sum / size;
        System.out.println("Window 1: Average = " + average);
        
        // Slide the window and calculate averages
        for (int i = size; i < data.length; i++) {
            sum -= data[i - size];  // Remove old element
            sum += data[i];         // Add new element
            average = (double) sum / size;
            System.out.println("Window " + (i - size + 2) + ": Average = " + average);
        }
        
        System.out.println();
        System.out.println("=".repeat(50));
        System.out.println();
        
        
        // ========== EXAMPLE 3: VARIABLE SIZE WINDOW ==========
        // Problem: Find smallest subarray with sum >= target
        
        System.out.println("=== EXAMPLE 3: Smallest Subarray with Sum >= Target ===");
        
        int[] arr = {2, 3, 1, 2, 4, 3};
        int target = 7;
        
        System.out.println("Array: [2, 3, 1, 2, 4, 3]");
        System.out.println("Target sum: " + target);
        System.out.println("Find: Smallest subarray with sum >= " + target);
        System.out.println();
        
        int left = 0;           // Left pointer of window
        int windowSum = 0;      // Current window sum
        int minLength = Integer.MAX_VALUE;  // Track minimum length
        
        // Right pointer expands the window
        for (int right = 0; right < arr.length; right++) {
            windowSum += arr[right];  // Add element to window
            
            // While sum is >= target, try to shrink window from left
            while (windowSum >= target) {
                // Calculate current window length
                int currentLength = right - left + 1;
                
                // Update minimum length
                if (currentLength < minLength) {
                    minLength = currentLength;
                    
                    // Show the window
                    System.out.print("Found window: [");
                    for (int i = left; i <= right; i++) {
                        System.out.print(arr[i]);
                        if (i < right) System.out.print(", ");
                    }
                    System.out.println("] - Length: " + currentLength + ", Sum: " + windowSum);
                }
                
                // Shrink window from left
                windowSum -= arr[left];
                left++;
            }
        }
        
        System.out.println("\nSmallest length: " + minLength);
        System.out.println();
        System.out.println("=".repeat(50));
        System.out.println();
        
        
        // ========== EXAMPLE 4: LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS ==========
        
        System.out.println("=== EXAMPLE 4: Longest Substring Without Repeating Characters ===");
        
        String text = "abcabcbb";
        System.out.println("String: \"" + text + "\"");
        System.out.println("Find: Longest substring without repeating characters");
        System.out.println();
        
        // Track which characters we've seen and their positions
        int[] charIndex = new int[128];  // For all ASCII characters
        for (int i = 0; i < 128; i++) {
            charIndex[i] = -1;  // -1 means character not seen yet
        }
        
        int leftPointer = 0;
        int maxLength = 0;
        String longestSubstring = "";
        
        for (int rightPointer = 0; rightPointer < text.length(); rightPointer++) {
            char currentChar = text.charAt(rightPointer);
            
            // If character was seen before and is in current window
            if (charIndex[currentChar] >= leftPointer) {
                // Move left pointer to after the repeated character
                leftPointer = charIndex[currentChar] + 1;
            }
            
            // Update the character's position
            charIndex[currentChar] = rightPointer;
            
            // Calculate current window length
            int currentLength = rightPointer - leftPointer + 1;
            
            // Update maximum length if current is longer
            if (currentLength > maxLength) {
                maxLength = currentLength;
                longestSubstring = text.substring(leftPointer, rightPointer + 1);
                System.out.println("Found: \"" + longestSubstring + 
                                 "\" (length: " + maxLength + ")");
            }
        }
        
        System.out.println("\nLongest substring: \"" + longestSubstring + "\"");
        System.out.println("Length: " + maxLength);
        System.out.println();
        System.out.println("=".repeat(50));
        System.out.println();
        
        
        // ========== EXAMPLE 5: CONTAINS DUPLICATE WITHIN K DISTANCE ==========
        
        System.out.println("=== EXAMPLE 5: Contains Duplicate Within K Distance ===");
        
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        
        System.out.println("Array: [1, 2, 3, 1, 2, 3]");
        System.out.println("K distance: " + k);
        System.out.println("Check: Are there duplicate numbers within " + k + " positions?");
        System.out.println();
        
        boolean foundDuplicate = false;
        
        // Create a simple way to track numbers in current window
        // We'll use an array as a simple set (for small numbers)
        boolean[] seen = new boolean[10];  // Assuming numbers 0-9
        
        for (int i = 0; i < nums.length; i++) {
            // If number was seen before in current window
            if (seen[nums[i]]) {
                System.out.println("Found duplicate " + nums[i] + " at position " + i);
                foundDuplicate = true;
                break;
            }
            
            // Mark this number as seen
            seen[nums[i]] = true;
            
            // If window size exceeds k, remove the oldest element
            if (i >= k) {
                seen[nums[i - k]] = false;
            }
        }
        
        System.out.println("\nContains duplicate within distance " + k + ": " + foundDuplicate);
        System.out.println();
        System.out.println("=".repeat(50));
        System.out.println();
        
        
        // ========== EXAMPLE 6: MAXIMUM OF ALL SUBARRAYS ==========
        
        System.out.println("=== EXAMPLE 6: Maximum of All Subarrays of Size K ===");
        
        int[] values = {1, 3, -1, -3, 5, 3, 6, 7};
        int k2 = 3;
        
        System.out.println("Array: [1, 3, -1, -3, 5, 3, 6, 7]");
        System.out.println("Window size: " + k2);
        System.out.println("Find: Maximum in each window of size " + k2);
        System.out.println();
        
        for (int i = 0; i <= values.length - k2; i++) {
            // Find maximum in current window
            int max = values[i];
            
            System.out.print("Window [");
            for (int j = i; j < i + k2; j++) {
                if (values[j] > max) {
                    max = values[j];
                }
                System.out.print(values[j]);
                if (j < i + k2 - 1) System.out.print(", ");
            }
            System.out.println("] -> Max: " + max);
        }
        
        System.out.println();
        System.out.println("=".repeat(50));
        System.out.println();
        
        
        // ========== KEY CONCEPTS SUMMARY ==========
        
        System.out.println("=== KEY CONCEPTS ===");
        System.out.println();
        System.out.println("1. FIXED SIZE WINDOW:");
        System.out.println("   - Window size stays the same");
        System.out.println("   - Add new element, remove old element");
        System.out.println("   - Example: Max sum of K consecutive elements");
        System.out.println();
        
        System.out.println("2. VARIABLE SIZE WINDOW:");
        System.out.println("   - Window size grows and shrinks");
        System.out.println("   - Use two pointers (left and right)");
        System.out.println("   - Example: Smallest subarray with sum >= target");
        System.out.println();
        
        System.out.println("3. WHY USE SLIDING WINDOW?");
        System.out.println("   - MUCH FASTER than checking all possible subarrays");
        System.out.println("   - Reduces time complexity from O(n²) to O(n)");
        System.out.println("   - Saves time by reusing previous calculations");
        System.out.println();
        
        System.out.println("4. WHEN TO USE SLIDING WINDOW?");
        System.out.println("   - Problems about CONSECUTIVE elements");
        System.out.println("   - Finding SUBARRAYS or SUBSTRINGS");
        System.out.println("   - Questions with words like: 'maximum', 'minimum', 'longest', 'shortest'");
        System.out.println("   - Working with SEQUENCES in arrays or strings");
        System.out.println();
        
        System.out.println("5. BASIC PATTERN:");
        System.out.println("   Fixed Size: for (i = k; i < length; i++) {");
        System.out.println("                 remove arr[i-k]");
        System.out.println("                 add arr[i]");
        System.out.println("               }");
        System.out.println();
        System.out.println("   Variable Size: while (condition not met) {");
        System.out.println("                    expand window (right++)");
        System.out.println("                  }");
        System.out.println("                  while (condition met) {");
        System.out.println("                    shrink window (left++)");
        System.out.println("                  }");
        System.out.println();
        
        System.out.println("=".repeat(50));
    }
}