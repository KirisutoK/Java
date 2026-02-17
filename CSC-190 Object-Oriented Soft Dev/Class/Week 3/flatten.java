public class flatten {
    public static void main(String[] args) {
        int[][] matrix = {
                {  3,   8,  12},
                {  2,   9,  17},
                { 43,  -8,  46},
                {203,  14,  97}
        };

        int[] ConvertedArray = flatten(matrix);
        for (int i:ConvertedArray) {
            System.out.print(i+", ");
        }
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

        for (int i = 0; i < arr.length; i++) { // for row
            for (int j = 0; j < arr[i].length; j++) { // for column
                result[OneD_index] = arr[i][j];
                OneD_index++;
            }
        }

        return result;
    }
}
