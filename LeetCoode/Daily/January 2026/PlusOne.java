// January 13, 2026

// NOT FINISHED YET

public class PlusOne {
    public static void main(String[] args) {

        int[] RandomIntArray = {9,8,7,6,5,4,3,2,1,0};

       int[] Result = plusOne(RandomIntArray);

        for (int num : Result) { // Enhanced For Loops
            System.out.print(num);
            System.out.print(" ");
        }


        // =============================  TEST ================================ \\
        System.out.println("TEST");

        // CONCATENATING FROM INT[] TO STRING
        String WordDigits = "";
        for (int i = 0; i < RandomIntArray.length; i++) {
            WordDigits += RandomIntArray[i];
        }

        // CONCATENATING FROM STRING TO INT AND INCREMENTING
        int NumDigits = Integer.parseInt(WordDigits);
        NumDigits++;

        // CONCATENATING FROM INT TO STRING
        WordDigits = NumDigits + "";

        // CONCATENATING FROM STRING TO INT[]
        int[] DigitsResult = new int[WordDigits.length()];

        for (int i = 0; i < WordDigits.length(); i++) {
            DigitsResult[i] = Integer.parseInt("" + WordDigits.charAt(i));
        }

        System.out.println(NumDigits);
    }

    public static int[] plusOne(int[] digits) {
        // CONCATENATING FROM INT[] TO STRING
        String WordDigits = "";
        for (int i = 0; i < digits.length; i++) {
            WordDigits += digits[i];
        }

        // CONCATENATING FROM STRING TO INT AND INCREMENTING
        int IntDigit = Integer.parseInt(WordDigits);
        IntDigit++;

        // CONCATENATING FROM INT TO STRING
        WordDigits = IntDigit + "";

        // CONCATENATING FROM INT TO A INT[]
        int[] Result = new int[WordDigits.length()];

        for (int i = 0; i < Result.length; i++) {
            Result[i] = Integer.parseInt("" + WordDigits.charAt(i));
        }

        return Result;
    }
}


        /* OLD ANSWERS
        int LastPosition = digits.length - 1;

        digits[LastPosition] = digits[LastPosition] + 1;

        if (digits[LastPosition] == 10) {
            digits[LastPosition] = 0;

            int[] NewDigits = new int[digits.length+1];
            NewDigits[NewDigits.length-1] = 0;

            for (int i = 0; i < digits.length; i++) {
                NewDigits[i] = digits[i];
            }

            NewDigits[NewDigits.length-2] = NewDigits[NewDigits.length-2] + 1;

            return NewDigits;
        }
        */