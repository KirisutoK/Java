
// Creation Date: June 02, 2026. at 12:15 AM
// Last Modified: June 10, 2026. at  9:09 PM

public class ArrayUtils {
    //=======VARIABLES=======//

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    // +[INT/DOUBLE/FLOAT]+
    public static int[] ReverseArray(int[] arr) {
        int[] ReversedArray = new int[arr.length];

        int counter = 0;
        for (int i = arr.length-1; i >= 0; i--) { // from the top to 0
            ReversedArray[counter] = arr[i];
            counter++;
        }
        
        return ReversedArray;
    }


    // +[STRING]+
    // [FOR SMALLER DATAS]
    public static String toStringArrayNoZero(double[] arr) { // FOR SMALLER DATA
        String printedGrades = "[";
        boolean first = true;
        for (int i = 0; i < arr.length; i++) { // from 0 to grades.length-1
            if (arr[i] != 0) { // if the grades content is not 0
                if (!first) { // if first is false (if it's not first)
                    printedGrades += ", ";
                }
                printedGrades += (arr[i]);
                first = false;
            }
        }
        printedGrades += "]";

        return printedGrades;
    }
    public static String toStringArrayNoZero(int[] arr) { // FOR SMALLER DATA
        String printedGrades = "[";
        boolean first = true;
        for (int i = 0; i < arr.length; i++) { // from 0 to grades.length-1
            if (arr[i] != 0) { // if the grades content is not 0
                if (!first) { // if first is false (if it's not first)
                    printedGrades += ", ";
                }
                printedGrades += (arr[i]);
                first = false;
            }
        }
        printedGrades += "]";

        return printedGrades;
    }
    // [FOR BIGGER DATAS]
    public static String toStringSBArrayNoZero(double[] arr) { // FOR BIGGER DATA
        StringBuilder sb = new StringBuilder();

        boolean first = true;
        sb.append("[");
        for (int i = 0; i < arr.length; i++) { // From 0 to how big the array is
            if (arr[i] != 0) { // IF THE VALUE IS NOT 0
                if (!first) { // if it's not first (if first is false)
                    sb.append(", ");
                }
                sb.append(arr[i]);
                first = false;
            }
        }
        sb.append("]");

        return sb.toString();
    }
    public static String toStringSBArrayNoZero(int[] arr) { // FOR BIGGER DATA
        StringBuilder sb = new StringBuilder();

        boolean first = true;
        sb.append("[");
        for (int i = 0; i < arr.length; i++) { // From 0 to how big the array is
            if (arr[i] != 0) { // IF THE VALUE IS NOT 0
                if (!first) { // if it's not first (if first is false)
                    sb.append(", ");
                }
                sb.append(arr[i]);
                first = false;
            }
        }
        sb.append("]");

        return sb.toString();
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
