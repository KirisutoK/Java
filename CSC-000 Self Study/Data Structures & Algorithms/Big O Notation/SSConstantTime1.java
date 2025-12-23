/*
    NOTES

The Nanoseconds are not always exactly the same since each operations has unpredictable variables that slow down the operations of the code.
Although the type of Time is almost the same, just not exactly the same.

CONSTANT TIME
    o(1) → (always instant)
        ⁕ it takes
        ⁕ How Does it Works?
            1. Only has one Operation
            2. Grabs one specific value in an Array
            3. Does not loop the entire Array
            4. Can have a big Array and only pick one specific value inside the Array

*/

public class SSConstantTime1 {

//============================================= SAMPLES =============================================\\
    // This is O(1) - always takes the same time
    public static int getArray(int[] array) {
        return array[0];  // Returns the first slot in the array
    }

    public static void main(String[] args) {
        int[] LoadUpCompiler = {9999999};
        LoadUpCompiler[0] = 99999;
        int[] small = {1, 2, 3};
        int[] huge = new int[1000000];
        huge[0] = 42;
        int[] veryhuge = new int[999999999];
        veryhuge[0] = 5000;
        
        // Both have almost the same time it takes to run the code
        
        double StartTime = System.nanoTime(); // Measure the time it takes
        System.out.println(getArray(LoadUpCompiler));  // LoadUpCompiler[SIZE 9999999]
        double EndTime = System.nanoTime();
        double Duration = EndTime - StartTime;
        System.out.println("Duration: " + Duration);

        StartTime = System.nanoTime();
        System.out.println(getArray(small));   // small[SIZE 3 ARRAY]
        EndTime = System.nanoTime();
        Duration = EndTime - StartTime;
        System.out.println("Duration: " + Duration);

        StartTime = System.nanoTime();
        System.out.println(getArray(huge));   // huge[SIZE 1000000 ARRAY]
        EndTime = System.nanoTime();
        Duration = EndTime - StartTime;
        System.out.println("Duration: " + Duration);

        StartTime = System.nanoTime();
        System.out.println(getArray(veryhuge)); // veryhuge[SIZE 999999999 ARRAY]
        EndTime = System.nanoTime();
        Duration = EndTime - StartTime;
        System.out.println("Duration: " + Duration);
    }

    //==========================================================================================\\


}
