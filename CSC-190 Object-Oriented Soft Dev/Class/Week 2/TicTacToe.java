public class TicTacToe {
    static char[][] TicTacToeBoard = { // Global Variable
            {'o', 'x', 'x'},
            {'x', 'x', 'x'},
            {'x', 'o', 'o'}};

    public static void main(String[] args) {

        // =================== CONDITIONS =================== \\

        // HORIZONTAL
        HorizontalCondition();

        // VERTICAL
        VerticalCondition();

        // DIAGONAL
    }


    // ========================= METHODS ========================= \\
    public static void HorizontalCondition() {
        for (int i = 0; i < TicTacToeBoard.length; i++) { // checks each row
            if (TicTacToeBoard[i][0]=='x' && TicTacToeBoard[i][1]=='x' && TicTacToeBoard[i][2]=='x') {
                System.out.println("X is the winner! (HORIZONTAL)");
                break; // stops the for loop
            } else if (TicTacToeBoard[i][0]=='o' && TicTacToeBoard[i][1]=='o' && TicTacToeBoard[i][2]=='o') {
                System.out.println("O is the winner! (HORIZONTAL)");
                break; // stops the for loop
            }
        }
    }

    public static void VerticalCondition() {
        for (int i = 0; i < TicTacToeBoard.length; i++) { // checks each row
            if (TicTacToeBoard[0][i]=='x' && TicTacToeBoard[1][i]=='x' && TicTacToeBoard[2][i]=='x') {
                System.out.println("X is the winner! (VERTICAL)");
                break; // stops the for loop
            } else if (TicTacToeBoard[0][i]=='o' && TicTacToeBoard[1][i]=='o' && TicTacToeBoard[2][i]=='o') {
                System.out.println("O is the winner! (VERTICAL)");
                break; // stops the for loop
            }
        }
    }

    public static void DiagonalCondition() {
        // X
        if (TicTacToeBoard[0][0]=='x' && TicTacToeBoard[1][1]=='x' && TicTacToeBoard[2][2]=='x') {
            System.out.println("X is the winner! (DIAGONAL)");
        } else if (TicTacToeBoard[0][2]=='x' && TicTacToeBoard[1][1]=='x' && TicTacToeBoard[2][0]=='x') {
            System.out.println("X is the winner! (DIAGONAL)");
        }
        // O
        else if (TicTacToeBoard[0][0]=='o' && TicTacToeBoard[1][1]=='o' && TicTacToeBoard[2][2]=='o') {
            System.out.println("O is the winner! (DIAGONAL)");
        } else if (TicTacToeBoard[0][2]=='o' && TicTacToeBoard[1][1]=='o' && TicTacToeBoard[2][0]=='o') {
            System.out.println("O is the winner! (DIAGONAL)");
        }
    }
}
