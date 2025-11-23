/* GUIBoard.java
 *
 * Defines a simple game board for a tic tac toe game.  It implements
 * the ActionListener interface to provide event driven actions.
 * The board is 3 X 3, the standard tic tac toe game size.  
 * 
 * Students will complete several methods and customize the game.
 *
 * Students:  Only modify the code as indicated to avoid making
 * changes that will result in nonworking code.
 *
 * @author      Trudy Howles
 * @author      Bennett Rundt
 * Date         01/15/25
 * Rev.         2.0
 *
 **/


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class GUIBoard implements ActionListener {

    //  Constants
    private final int BOARD_SIZE = 3;
    private final String OPEN = "Open";

/*
<EDIT HERE >
Change GAME_NAME to your name
*/

    private final String GAME_NAME = "YourNameHere's TicTacToe Game";

    private Cell [][] board;   		// the game board

    private JFrame mainWin; 		//the window components
    private JButton exitButton;
    private JLabel gameStatus;

    // font style for all the tiles (bold, font size 15)
    private Font buttonFont = new Font( null, 1, 15 );

    String player1 = "";
    String player2 = "";
    String currentPlayer; 

    /**  GUIBoard Cell constructor
     *
     *   Creates the main JFrame and all JPanels.  Creates the buttons,
     *   and text components, adds action listeners, and waits for
     *   events.
     *
     *   As with a pen and paper tic tac toe game, it checks the game
     *   status after each move to determine if a player has won, or if
     *   the game is not winnable.
     **/

    public GUIBoard () {

        // Create main window

        mainWin = new JFrame (GAME_NAME);
        mainWin.getContentPane().setLayout (new BorderLayout());
        mainWin.setSize (BOARD_SIZE * 140 , BOARD_SIZE * 140);
        mainWin.setLocation (100, 100);
        mainWin.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);


	//  Using JOptionPane, get player names

        player1 = JOptionPane.showInputDialog( mainWin, "Enter Player 1 Name");
        player2 = JOptionPane.showInputDialog (mainWin, "Enter Player 2 Name ");

	//  first player starts
        currentPlayer = player1;

        //
        // Create the GUI Panels
        
        // holds the main cells
        JPanel panel1 = new JPanel( new GridLayout( BOARD_SIZE, BOARD_SIZE ) );


        // holds the new game panel and the game status panel
        JPanel panel3 = new JPanel( new BorderLayout() );

        // holds the exit game button
        JPanel gameControlPanel = new JPanel( new FlowLayout( FlowLayout.CENTER) );

        // holds the game status label showing whose turn
        JPanel statusPanel = new JPanel( new FlowLayout( FlowLayout.CENTER ) );

        // create a new game game button, associate it with an event,
        // and add it to the new game panel
        exitButton = new JButton( "Quit Game" );
        exitButton.addActionListener ( new ActionListener() {
            public void actionPerformed( ActionEvent event ) {
		mainWin.dispose();
            }
        } );

        gameControlPanel.add (exitButton);


        // create a game status label and add it to the status panel
        // NOTE that this changes as the game is played, showing the
        // current game status

        gameStatus = new JLabel( player1 + " - your turn");
        statusPanel.add (gameStatus );

        // add the new game and status panels to panel 3
        panel3.add (gameControlPanel, BorderLayout.SOUTH);
        panel3.add (statusPanel, BorderLayout.NORTH);

        // create button arrays for main window
        board = new Cell [ BOARD_SIZE][ BOARD_SIZE ];

/*
<<  Your code here >>
Complete the two for loop headers, then add the instructions to 
create the Cell object and store it in the board array.
*/
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) 
            { 
            Cell bcell = new Cell(OPEN, row, col);
            board[row][col] = bcell;
		//  create a new 'Open' Cell object with
		//  the current row and column, then store it
		//  in the board array
		    

		//  Do not change the 3 instructions below.

                board[row][col].setFont (buttonFont);
                board[row][col].addActionListener (this);
                panel1.add (board [row][col]);
            }   //  end col for loop
        }  //  end row for loop

       // add each panel to the appropriate window in the appropriate location
        mainWin.getContentPane().add (panel1, BorderLayout.CENTER );
        mainWin.getContentPane().add (panel3, BorderLayout.SOUTH);

        // show the main game window
        mainWin.setVisible( true );

    }


    /**
      *  actionPerformed()
      *  
      *  DO NOT MODIFY THIS METHOD
      *
      *  @param event	the ActionEvent created when the GUI component
      *                 was accessed.
      **/

    public void actionPerformed( ActionEvent event ) {
                
        //  determine which button was pressed and
        //  take the appropriate action
        
        if (event.getSource() instanceof JButton) {
            
            JButton clicked = (JButton) event.getSource();
            Cell curr = (Cell) clicked;
            String name  = curr.getName();

	    //  if name is still OPEN, this cell is unclaimed; else player loses turn
            if (!name.equals (OPEN)) {

                String msg = currentPlayer + " lose turn - cell already selected";
                JOptionPane.showMessageDialog (mainWin, msg,
			"TicTacToe Warning" , JOptionPane.ERROR_MESSAGE);
                gameStatus.setText ("Cell already selected. Lose turn.");
            } else {
		//  player can claim this cell
		curr.setName (currentPlayer);     	//  updates instance variable in cell
		curr.setText (currentPlayer);		//  updates button text
            }

	    boolean fullBoard = isBoardFull();
	    boolean haveAWinner = checkWin (currentPlayer);
	    String msg = "";

	    if (fullBoard || haveAWinner) {

	        //  if a winner, we display message and quit the game
                //  otherwise, play continues
                if (haveAWinner) {
	            gameStatus.setText ("Winner is " + currentPlayer);
                    msg = currentPlayer + ", you win!  ";
                } else {
	            gameStatus.setText ("No Winner - Draw" );
                    msg = "No winner - draw ";
		}
                JOptionPane.showMessageDialog (mainWin, msg,
		    GAME_NAME, JOptionPane.INFORMATION_MESSAGE);

                mainWin.dispose();  // dispose of JFrame - game over
	    } else{      //  switch players and play continues
                if (currentPlayer.equals (player1)) {
	  	    currentPlayer = player2;
		    gameStatus.setText (player2 + " - your turn");
	        } else {
		    currentPlayer = player1;
		    gameStatus.setText (player1 + " - your turn");
	        }
            }
        } 
    }

    public boolean isBoardFull()
    {
        int count = 0;
     for (int row = 0; row < board.length; row++) 
     {
        for (int col = 0; col < board[row].length; col++) 
        {
            if (board[row][col].getName().equals(OPEN))
            {
                count++;
            }
        }
     }
     if (count > 0)
     {
         return false;
     }
     else
     {
         return true;
     }
    }
     /**
     *
     *   Counts all cells with the name OPEN, indicating
     *   the cell has not yet been claimed by either player.
     *   if the count of open cells is 0, returns true; otherwise
     *   returns false.
     *
     *   @return        true if no more cells are available be assigned; 
     *			otherwise return false.
     **/


    


    /**  rowCheck ()
      *  
      *
      *  Called by checkWin() to look at all 3 rows to see if 
      *  we have a winner.
      *
      * @param		player	name of the current player
      * @param		row     row currently being checked
      * @return		true if this player owns all cells in any row
      */

    public boolean rowCheck (String player, int row) {
/*	<<  DO NOT MODIFY THIS METHOD >>  */


	boolean winner = false;

            if ( (board [row][0].getName().equals (player)) &&
		( board [row][1].getName().equals (player)) &&
		( board [row][2].getName().equals (player))) { 
               winner = true;
            }
       
       return winner;
    }
    
    public boolean colCheck (String player, int col) {
/*	<<  DO NOT MODIFY THIS METHOD >>  */


	boolean winner = false;

            if ( (board [0][col].getName().equals (player)) &&
		( board [1][col].getName().equals (player)) &&
		( board [2][col].getName().equals (player))) { 
               winner = true;
            }
       
       return winner;
    }

    /**  checkWin()
      * 
      *  Called after each player completes a turn to determine if
      *  this player has won (row, column, diagonally).
      *
      * @param          player  name of the current player
      * @return         true if this player has won the game in any direction
      */

    public boolean checkWin (String player) {
	boolean winner = false;

	//  check all rows
	//  I check only the first row.  You check the rest!
        winner = rowCheck (player, 0);
        if (winner == false)
        {
            winner = rowCheck(player, 1);
        }
        if (winner == false)
        {
            winner = rowCheck(player, 2);
        }
        if (winner == false)
        {
            winner = colCheck(player, 0);
        }
        if (winner == false)
        {
            winner = colCheck(player, 1);
        }
        if (winner == false)
        {
            winner = colCheck(player, 2);
        }
        if ( (board [0][0].getName().equals (player)) &&
		( board [1][1].getName().equals (player)) &&
		( board [2][2].getName().equals (player)) && winner == false)
		{
		    winner = true;
		}
		if ( (board [2][0].getName().equals (player)) &&
		( board [1][1].getName().equals (player)) &&
		( board [0][2].getName().equals (player)) && winner == false)
		{
		    winner = true;
		}
		
              
/*
Add the code to check the other two rows UNLESS you found a winner
in a previous row. 

	<< Your code here >>
*/

	
        
	return winner;
    }

    /**  main()
      * 
      *
      *  main method.  Notice we call the constructor and nothing else
      *  because this is all event driven.
      *
      * @param          args  	not used
      */

    public static void main (String args[] ) {

	GUIBoard gameBoard = new GUIBoard();
        
    }  // end main

}  //  End Class GUIBoard