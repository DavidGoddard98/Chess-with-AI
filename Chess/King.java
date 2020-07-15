package assignment2018;
import assignment2018.codeprovided.*;
import java.util.*;

/**
 * King.java
 * 
 * Concrete class to represent a king
 * 
 * @author David Goddad
 *
 */
public class King extends Piece {
	
	/**
	 * Constructor for the king piece
	 * @param ix	initial x coordinate
	 * @param iy	initial y coordinate
	 * @param c		colour of piece
	 * @param b		the board
	 */
	public King(int ix, int iy, int c, Board b) {
        super(PieceCode.KING, ix, iy, c, b);
    }

	/**
	 * Returns the available moves for the king
	 * @return ArrayList<Move>	an arraylist of type Move of the allowed moves
	 */
    public ArrayList<Move> availableMoves() {
        return king();
    }
    
    /**
	 * Method to determine the moves this piece can take this turn
	 * @return ArrayList<Move>		an array list of type Move the moves allowed
	 */
    private ArrayList<Move> king() {
    	
    	int x = this.getX();
    	int y = this.getY();
    	
    	ArrayList<Move> kingMoves = new ArrayList<Move>();
    	
    	Move theMove = null;
    	
    	//set of if statements for all generals moves of king
		
    	//Takes a potential move as parameter - see below for method explanation
    	//move one up
    	if (kingMove(x, y+1) == 1) {
			theMove = new Move(this, x, y, x, y+1, true);
			kingMoves.add(theMove);
    	}
		else if (kingMove(x, y+1) == 2) {
			theMove = new Move(this, x, y, x, y+1, false);
			kingMoves.add(theMove);
		}
		
        //move one right
        if (kingMove(x+1, y) == 1) {
            theMove = new Move(this, x, y, x+1, y, true);
            kingMoves.add(theMove);
        }
        else if (kingMove(x+1, y) == 2) {
            theMove = new Move(this, x, y, x+1, y, false);
            kingMoves.add(theMove);
        }

        //move one down
        if (kingMove(x, y-1) == 1) {
            theMove = new Move(this, x, y, x, y-1, true);
            kingMoves.add(theMove);
        }
        else if (kingMove(x, y-1) == 2) {
            theMove = new Move(this, x, y, x, y-1, false);
            kingMoves.add(theMove);
        }
    	
        //move one left
        if (kingMove(x-1, y) == 1) {
            theMove = new Move(this, x, y, x-1, y, true);
            kingMoves.add(theMove);
        }
        else if (kingMove(x-1, y) == 2) {
            theMove = new Move(this, x, y, x-1, y, false);
            kingMoves.add(theMove);
        }

        //north east
        if (kingMove(x+1, y+1) == 1) {
            theMove = new Move(this, x, y, x+1, y+1, true);
            kingMoves.add(theMove);
        }
        else if (kingMove(x+1, y+1) == 2) {
            theMove = new Move(this, x, y, x+1, y+1, false);
            kingMoves.add(theMove);
        }
        
        //south east
        if (kingMove(x+1, y-1) == 1) {
            theMove = new Move(this, x, y, x+1, y-1, true);
            kingMoves.add(theMove);
        }
        else if (kingMove(x+1, y-1) == 2) {
            theMove = new Move(this, x, y, x+1, y-1, false);
            kingMoves.add(theMove);
        }

        //south west
        if (kingMove(x-1, y-1) == 1) {
            theMove = new Move(this, x, y, x-1, y-1, true);
            kingMoves.add(theMove);
        }
        else if (kingMove(x-1, y-1) == 2) {
            theMove = new Move(this, x, y, x-1, y-1, false);
            kingMoves.add(theMove);
        }

        //north west
        if (kingMove(x-1, y+1) == 1) {
            theMove = new Move(this, x, y, x-1, y+1, true);
            kingMoves.add(theMove);
        }
        else if (kingMove(x-1, y+1) == 2) {
            theMove = new Move(this, x, y, x-1, y+1, false);
            kingMoves.add(theMove);
        }
        
        if (kingMoves.isEmpty())
        	return null;
        return kingMoves;

    }
    
    //similar to method in knight.java
    /**
	 * method that determines if this position is occupied by opponnent or not
	 * @param newX	the x-coord of the move
	 * @param newY	the y-coord of the move
	 * @return int	a value (1-3) notifying the status of the move position
	 */
    private int kingMove(int newX, int newY) {
		int x;
		//if it returns 1 then we know that the flag status should be set to true
		if (!getBoard().outOfRange(newX, newY) && getBoard().occupied(newX, newY)
                && (getBoard().getPiece(newX, newY).getColour() != this.getColour()))
            return x=1;
		//else if its not occupied then it should be set to false
        else if (!getBoard().outOfRange(newX, newY) && !getBoard().occupied(newX, newY))
            return x=2;
		//else its either not a valid move or its occupied by yourself.
        else
        	return x=3;
	}
}
