//  FOR STUDENTS  May 2025 V2 2

/**
 * Minesweeper.java
 * This program simulates a simple Minesweeper game. Note that the
 * actionPerfomed() method does not check for other GUI widgets
 * since the UI consists only of JButtons.  This must be expanded if
 * other components are added.  
 * 
 * Students will complete the game as instructed in the project writeup.
 *
 * Do not modify any other provided code or your game may not run!
 *
 * @author	Trudy Howles  tmhowles@gmail.com
 * @author 	<Your name here>
 * date		<date>
 *
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class Minesweeper implements ActionListener {

    /*  Constants */
    // value that Minesweeper returns for a tile if it is a mine tile
    private final int MINE = 9;

    // value that Minesweeper returns for a tile if it is a blank tile   
    private final int BLANK = 0;

    /*  Instance variables */

    // the gameboard 
    private Tile board[][];

    // main game window
    private JFrame mainWin;

    // variables to track the number of mines, and the number hit (exposed)
    private int mines;              //  # of mines set on the board
    private int hit;                //  # of mines hit so far
 
    // variable to track -- is the game over?
    private boolean gameDone;

    //  current row, col of selected Tile
    private int row;
    private int col;

    // label that displays the number of lives remaining 
    private JLabel gameStatus;

    // font style for all the tiles (bold, font size 15)
    private Font buttonFont = new Font( null, 1, 15 );

    /**
     * Constructor.  Sets up the main GUI to play the game.
     * Associates buttons with events.  This constructor
     * does not return; it waits for GUI events to drive the action
     * in the game.
     *
     * @param	size		the size of the game board (a square)
     * @param   numMines	the number of mines to place on the board
     * 				//  When you add the logic to support
     *				//  the number of lives, be sure to
     *				//  update this constructor documentation.
     *
     **/

    public Minesweeper (int size, int numMines) {

        // Initialize data members        
        row = size;
        col = size;
        mines = numMines;
	hit = 0;			//  number mines hit so far
        gameDone = false;

        // Create main window
        mainWin = new JFrame ("MINESWEEPER ");
        mainWin.getContentPane().setLayout (new BorderLayout());
        mainWin.setSize (col * 60 , row * 60);
        mainWin.setLocation (0, 0);
        mainWin.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        //
        // CREATE ALL PANELS:
        //
        // holds the main cells 
        JPanel panel1 = new JPanel (new GridLayout (row, col));

        // holds the game status label
        JPanel statusPanel = new JPanel (new FlowLayout (FlowLayout.CENTER) );

        // create a customized game label and add it to the status panel

        gameStatus = new JLabel ("You have X lives remaining");
        statusPanel.add (gameStatus );

        // create button arrays for main and diagnostic windows
        board = new Tile [row][col];

        // set up gameboard 
        for (int row = 0; row < board.length; row++ ) {
            for (int col = 0; col < board[row].length; col++ ) {

                // create tiles with custom font
                board [row][col] = new Tile (BLANK, row, col);
                board [row][col].setFont (buttonFont);

                // Associate an ActionListener with each tile on the gameboard
                board[row][col].addActionListener (this);

                // add this tile to the panel
                panel1.add (board [row][col]);
		
            }
        }

	placeMines (mines, board.length);

        //  For debugging - displays the board in text format to System.out
	debugPrintBoard (board);

        // add each panel to the appropriate window in the appropriate location
        mainWin.getContentPane().add (panel1, BorderLayout.CENTER );
	mainWin.getContentPane().add (statusPanel, BorderLayout.NORTH);

        // show the main game window
        mainWin.setVisible (true);
    }


    /**  
      * placeMines() 	       Randomly places the mines on
      *                        the board.
      * 
      * @param                 minNumes    Number of mines to place
      * @param                 size        Size of this board
      **/

    private void placeMines (int numMines, int size) {

 	/*  This method generates the locations (Row and Column) mines will be hidden on the board.  

	I use an ArrayList to save the (R,C) pairs of each placed mine in order to count the
	adjoining neighbors (the 'for' loop).

	As we know, the random number generator is a pseudo-random generator and not 
	always very random. It is common to see duplicates generated, and
 	this may happen when placing the mines on the board.  

	If the same [row,col] pair is generated (and not detected) the program will 
	"add" a mine to the same location.   This explains why you may have too few mines 
	than expected.  It's a defect in the code that you will fix in Step 4 of the
	project.  */

	    ArrayList <String> mineLocations =  new ArrayList <String> ();

	    int row = 0;
 	    int col = 0;
	    int created = 0;

	    while (created < numMines) {
	      row = (int) (Math.random() * size);
              col = (int) (Math.random() * size);
              created++;
	      board [row] [col].setType(MINE);
              board [row] [col].setMine();
	      mineLocations.add (row + "," + col);
	    }


	/*  DO NOT MODIFY THE CODE BELOW */
	//  need to count adjoining neighbors only after all mines are 
	//  placed
	    for (int loop = 0; loop < mineLocations.size(); loop++) {
	        String loc = mineLocations.get (loop);
	        int comma = loc.indexOf (",");
	        row = Integer.parseInt (loc.substring (0,comma));
	        col = Integer.parseInt (loc.substring (comma + 1));
	        setNeighborCounts (row, col);
 	    }

     }

    /**  
      * setNeighborCounts() 	     For each tile, counts and stores the 
      *                              number of adjacent minds on the board.
      * 
      * @param                 row	   Row of current tile
      * @param                 col         Column of current tile
      **/

    private void setNeighborCounts (int row, int col) {
	    /*  DO NOT MODIFY THIS METHOD */

	  // for all: be sure in bounds and not a mine 

	  //  tile is directly above  [r-1] [c]
	  if ((row - 1 >= 0) && (board [row - 1] [col].getType() != MINE)) {
	    board [row - 1] [col].incAdjoiningMines();
	  }

	  //  tile is upper diag to the right [r-1] [c+1]
	  if ((row - 1 >= 0) && (col + 1 < board.length) && 
   	    (board [row - 1] [col +1].getType() != MINE)) {
	    board [row - 1] [col + 1].incAdjoiningMines();
	  }

	  //  tile is directly to the right [r] [c+1]
	  if ((col + 1 < board.length) && (board [row] [col + 1].getType() != MINE)) {
	    board [row] [col + 1].incAdjoiningMines();
	  }

	  //  tile is lower right diag [r+1] [c+1]
	  if ((row + 1 < board.length) &&  (col + 1 < board.length) 
	    &&  (board [row + 1] [col + 1].getType() != MINE)) {
	    board [row + 1] [col + 1].incAdjoiningMines();
	  }

	  //  tile is directly below  [r+1] [c]
	  if ((row + 1 < board.length) && (board [row + 1] [col].getType() != MINE)) {
	    board [row + 1] [col].incAdjoiningMines();
	  }

	  //  tile is on lower left diag [r+1] [c-1]

	  if ((row + 1 < board.length) &&  (col - 1 >= 0) 
	    &&  (board [row + 1] [col - 1].getType() != MINE)) {
	     board [row + 1] [col - 1].incAdjoiningMines();
	  }

	  //  tile is directly to the left [r] [c-1]

	  if ((col - 1 >= 0) && (board [row] [col - 1].getType() != MINE)) {
	    board [row] [col - 1].incAdjoiningMines();
  	  }

	  //  tile is on upper left diag [r-1] [c-1]
	  if ((row - 1 >= 0) &&  (col - 1 >= 0 )
	    &&  (board [row - 1] [col - 1].getType() != MINE)) {
	    board [row - 1] [col - 1].incAdjoiningMines();
	  }
	    
    }  //  end set neighbor counts


   public void actionPerformed( ActionEvent event ) {

/*  DO NOT MODIFY THE CODE IN THIS METHOD UNLESS INSTRUCTED TO DO SO */
       String msg = "";
        JButton clicked = (JButton) event.getSource();
        Tile curr = (Tile) clicked;
        int type = curr.getType ();

        if (curr.isAlreadySelected()) {
            msg = "You already selected this tile.";
            JOptionPane.showMessageDialog (mainWin, msg,
                "Minesweeper", JOptionPane.INFORMATION_MESSAGE);

        } else {
	        if (type == MINE) {
                curr.setText ("MINE");
		curr.setForeground (Color.RED);
                curr.setSelected();

        /*  <<  ADD YOUR CODE FOR PART 5 HERE

         Add your code to track the number of lives remaining here
         Do not modify any other code in this method.
       
		     // Has the player reached the number of allowed lives?
		     // If so, inform the user. You may want to use a dialog box:
                JOptionPane.showMessageDialog (mainWin, msg,
                    "Minesweeper", JOptionPane.INFORMATION_MESSAGE);
             // Finally, enable the mainWin.dispose() method below by
	         //  removing the comment from the dispose() method call below.
		     //  mainWin.dispose();  // close and dispose of window
		*/
		    } else {  //  player selected an empty tile
                curr.setSelected();
	            curr.setText ("" + type);
            }
        }  //  end if not already selected
    }  // end actionPerformed

    /**
      *  debugPrintBoard()
      *   
      *  Displays a text representation of the board to System.out
      *  Helpful because it's difficult to otherwise know the location
      *  of the mines for debugging purposes.
      **/

    private void debugPrintBoard (Tile [][] board) {
	    System.out.println ("Debug:  Text representation of the board ");

        /*  <<  ADD YOUR CODE FOR PART 3 HERE  */

    }


    /**
     * The main program.  It gets use inputs for the board size and number
     * of mines, then creates the board.  
     *
     * @param  args  command line arguments (ignored)
     */

    public static void main( String args[] ) {

//  instruction below used only for basic operation of the game for initial demo.
//  remove the instruction after you complete the main() method
Minesweeper m = new Minesweeper(8, 9);

	/*  <<  ADD YOUR CODE FOR PART 3 HERE  
	
	1.  Create a Scanner.
	2.  Prompt the user to read in the size of the board and
	    number of mines (both integers).  Read in and store
	    the values.
	3.  Create a Minesweeper object using the two user inputs.
	    Check the constructor signature for details.
        */

    }

}