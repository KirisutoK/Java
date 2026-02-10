public class TicTacToe {
    public static void main(String[] args) {
        char[][] TicTacToeBoard = {
                {'x', 'o', 'x'},
                {'x', 'x', 'o'},
                {'x', 'o', 'o'}};

        // CONDITIONS

        // HORIZONTAL
        for (int i = 0; i < TicTacToeBoard.length; i++) { // checks each row
            for (int j = 0; j < TicTacToeBoard[i].length; j++) { // checks each index in the row(column)
                if (TicTacToeBoard[i][j] == 'x') {
                    System.out.println("X is the winner");
                } else if (TicTacToeBoard[i][j] == 'o') {
                    System.out.println("W is the winner");
                }
            }
        }

        // VERTICAL
        for (int i = 0; i < TicTacToeBoard[i].length; i++) { // checks each column
            for (int j = 0; j < TicTacToeBoard.length; j++) { // checks each index in the column(row)
                if (TicTacToeBoard[i][j] == 'x' ) {
                    System.out.println("X is the winner");
                } else if (TicTacToeBoard[i][j] == 'o') {
                    System.out.println("W is the winner");
                }
            }
        }

        // DIAGONAL
    }
}
