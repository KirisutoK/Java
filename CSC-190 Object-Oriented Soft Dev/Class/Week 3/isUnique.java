public class isUnique {
    public static void main(String[] args) {
        int[][] matrix = {{3, 8, 12}, {2, 9, 17}, {43, -8, 46}, {203, 14, 97}};
        int[][] matrix2 = {{4, 7, 2}, {3, 9, 12}, {-47, -19, 308}, {3, 74, 15}};

        System.out.println(isUnique(matrix));
        System.out.println(isUnique(matrix2));



    }

    // ========== METHODS ============= \\

    public static boolean isUnique(int[][] arr) {
        int[] FlattendArray = flatten(arr); // Changes the 2D Array into 1D Array

        for (int i = 0; i < FlattendArray.length; i++) { // Start
            for (int j = i+1; j < FlattendArray.length; j++) { // til the last num
                if (FlattendArray[i] == FlattendArray[j]) {
                    return false;
                }
            }
        }

        return true;
    }
    public static int[] flatten(int[][] arr) {
        // COUNT HOW MANY INDEXES ARE THERE
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                size++;
            }
        }

        // CONVERTING THE 2D ARRAY INTO 1 ARRAY
        int[] result = new int[size];
        int OneD_index = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[OneD_index] = arr[i][j];
                OneD_index++;
            }
        }

        return result;
    }
}
