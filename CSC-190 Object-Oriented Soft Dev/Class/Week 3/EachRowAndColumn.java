public class EachRowAndColumn {
    public static void main(String[] args) {
        int[][] arr = {
                {5, 1, 3},
                {9, 6, 10},
                {2, 3, 5},
        };

        System.out.println("Display 2D Array");
        DisplayArray(arr);
        System.out.println(" "); // Space for Readability
        System.out.println("Display Row: [2]");
        DisplayRow(arr, 2);
        System.out.println(" "); // Space for Readability
        System.out.println("Display Column: [1]");
        DisplayColumn(arr, 1);
        System.out.println(" "); // Space for Readability
        System.out.println("Display Each by Row");
        DisplayEachRow(arr);
        System.out.println(" "); // Space for Readability
        System.out.println("Display Each by Column");
        DisplayEachColumn(arr);
    }

    // ============== METHODS ================ \\
    public static void DisplayArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) { // each row
            for (int j = 0; j < arr.length; j++) { // each column
                System.out.print(arr[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    public static void DisplayRow(int[][] arr, int row) {
        for (int i = 0; i < arr.length; i++) { // checks each column
            System.out.print(arr[row][i]+" ");
        }
    }
    public static void DisplayColumn(int[][] arr, int column) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][column]+" ");
        }
    }
    public static void DisplayEachColumn(int[][] arr) {
        for (int i = 0; i < arr[0].length; i++) { // checks how many columns (y axis)
            for (int j = 0; j < arr.length; j++) { // checks how many rows (x axis)
                System.out.print(arr[j][i]+" ");
            }
            System.out.println(" ");
        }
    }
    public static void DisplayEachRow(int[][] arr) {
        for (int i = 0; i < arr.length; i++) { // checks each row (x axis)
            for (int j = 0; j < arr[i].length; j++) { // checks each column (y axis)
                System.out.print(arr[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}
