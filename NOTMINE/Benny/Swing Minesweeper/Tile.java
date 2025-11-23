// V2 May 2025

/*  This program is provided for you.  Do not make any changes to this code */

/**
 * Tile.java
 *
 * Defines a tile for a Minesweeper game.  It extends a JButton
 * to provide event handling for button presses.  Tile instance
 * variables define it's placement (row, col), and the type of
 * tile (open, mine, or count of adjacent mines).
 *
 * @author	Trudy Howles tmhowles@gmail.com
 * date		November, 2024
 * Rev.		1.1
 *
 **/



import javax.swing.*;

/** Class Tile 
 *  extends JButton and uses the JButton events to control the game
 *
 **/


public class Tile extends JButton {

    /*  type:  0 = open; 9 = mine; otherwise count of adjoining mines 
    */


    private int type;	// open, a mine, or containing a count of adjacent mines 
    private int row;                            //  row location on board
    private int col;                            //  col location on board
    private int neighborMines;                  //  if not a mine, # of mines
                                                //  in adjacent tiles
    private boolean isMine;                     //  true if a mine tile 
    private boolean alreadySelected;            //  set to true when selected

    /**  Tile constructor
     *
     *   @param	type for this tile ; initially OPEN when the tile is created
     *   @param	row current row assigned to this tile 
     *   @param	col current column
     **/
    public Tile (int type, int row, int col) {
	    super ("");
        this.type= type;
	    this.row = row;
	    this.col = col;
	    neighborMines = 0;
	    isMine = false;
        boolean alreadySelected = false;
    }


    /**  getRow()
     *
     *   Returns the row assigned to this tile object.
     *   @return 	row current row assigned to this tile 
     **/

    public int getRow() {
	    return row;
    }

    /**  isAlreadySelected()
     *
     *   Returns true if this is a tile already selected otherwise return false.
     *   @return 	true or false indicating if the player has selected
     *                  this tile.
     **/

    public boolean isAlreadySelected () {
	    return alreadySelected;
    }

    /**  isAMine()
     *
     *   Returns true if this is a mine; otherwise return false.
     *   @return 	true or false indicating if a mine
     **/

    public boolean isAMine () {
	    return isMine;
    }

    /**  getCol()
     *
     *   Returns the column assigned to this tile object.
     *   @return 	row current column assigned to this tile 
     **/

    public int getCol() {
   	    return col;
    }


    /**  getType() 
     *  Returns the current type of game tile - open or a  mine
     *  If not open or a mine, it must indicate the number of
     *  neighboring mines so the count is returned. 
     *
     *   @return	the type assigned to this tile 
     **/

    public int getType() {

        if (neighborMines != 0) {
	        return neighborMines;
	    } else {
            return type;
        }
    }


    /**  setMine() 
     *   Set to true to indicate this tile is a mine.
     *
     **/

    public void setMine() {
        isMine = true;
    }

    /**  setSelected() 
     *   Set to true to indicate this tile was already selected.
     *
     **/

    public void setSelected() {
        alreadySelected = true;
    }

    /**  setType() 
     *
     *   Sets the type of tile to the value in the param passed to this method
     *   @param		type the type assign to this tile 
     **/

    public void setType (int type) {
        this.type = type;  
    }

    /**  incAdjoiningMines () 
     *
     *   When called, increments the count of neighboring mines 
     **/
    public void incAdjoiningMines () {
	    neighborMines++;
    }

    /**  toString() 
     *
     *   Overrides the default toString() from the Object class.
     * 
     *   @return	String representation of this tile consisting of
     *			the type, row and column
     **/
    public String toString() {
        return type + " at [" + row + "," + col + "]";
    }
}