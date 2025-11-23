/**
 * Cell.java
 *
 * Defines a cell for a simple tic tac toe game.  It extends a JButton
 * to provide event handling for button presses.  Cells instance
 * variables define it's placement (row, col), and the name on
 * the button.
 *
 * @author	Trudy Howles
 * Date		November, 2024
 * Rev.		1.1
 *
 **/


import javax.swing.*;

/** Class Cell
 *  extends JButton
 *
 **/


public class Cell extends JButton {

			
    private String name;	//  owner of this cell; OPEN=not yet claimed.
				//  At the start of the game, all Cells
				//  have the name OPEN; this is replaced
				//  by the player's name when claimed
    private int row;		//  row on the gameboard
    private int col;		//  col on the gameboard
    

    /**  Cell constructor
     *
     *   @param	name for this cell; initially OPEN when the cell is created
     *   @param	row current row assigned to this cell
     *   @param	col current column
     **/
    public Cell (String name, int row, int col) {
        super (name);
        this.name = name;
	this.row = row;
	this.col = col;
    }

    /**  getName() 
     *
     *   @return	the name assigned to this cell
     **/

    public String getName() {
        return name;
    }

    /**  setName() 
     *
     *   @param		name  the name to assign to this cell
     **/
    public void setName (String name) {
        this.name = name;  //  player has claimed
    }

    /**  toString() 
     *
     *   @return	String representation of this cell consisting of
     *			the name, row and column
     **/
    public String toString() {
        return name + " at [" + row + "," + col + "]";
    }
}