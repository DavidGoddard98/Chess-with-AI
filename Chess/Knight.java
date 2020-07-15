package assignment2018;
import assignment2018.codeprovided.*;
import java.util.*;

/**
 * Knight.java
 * 
 * Concrete class to represent a knight
 * 
 * @author David Goddard
 *
 */
public class Knight extends Piece {
	
	/**
	 * Constructor for the knight piece
	 * @param ix	initial x coordinate
	 * @param iy	initial y coordinate
	 * @param c		colour of piece	
	 * @param b		the board
	 */
	public Knight(int ix, int iy, int c, Board b) {
		super(PieceCode.KNIGHT, ix, iy, c, b);
	}
	
	/**
	 * Returns the available moves for the knight
	 * @return ArrayList<Move>		an arraylist of type Move of the allowed moves
	 */
	public ArrayList<Move> availableMoves() {
		return knight();
	}
	
	/**
	 * Method to determine the moves this piece can take this turn
	 * @return ArrayList<Move>		an array list of type Move the moves allowed
	 */
	private ArrayList<Move> knight() {
		
		int x = this.getX();
		int y = this.getY();
		
		ArrayList<Move> knightMoves = new ArrayList<Move>();
		
		Move theMove = null; 
		
		//set of if statements for all generals moves of knight
		
		//Takes a potential move as parameter - see below for method explanation
		if (knightMove(x+2, y+1) == 1) {
			theMove = new Move(this, x, y, x+2, y+1, true);
			knightMoves.add(theMove);
		}
		else if (knightMove(x+2, y+1) == 2) {
			theMove = new Move(this, x, y, x+2, y+1, false);
			knightMoves.add(theMove);
		}
		
		if (knightMove(x+1, y+2) == 1) {
			theMove = new Move(this, x, y, x+1, y+2, true);
			knightMoves.add(theMove);
		}
		else if (knightMove(x+1, y+2) == 2) {
			theMove = new Move(this, x, y, x+1, y+2, false);
			knightMoves.add(theMove);
		}
		
		if (knightMove(x-2, y+1) == 1) {
			theMove = new Move(this, x, y, x-2, y+1, true);
			knightMoves.add(theMove);
		}
		else if (knightMove(x-2, y+1) == 2) {
			theMove = new Move(this, x, y, x-2, y+1, false);
			knightMoves.add(theMove);
		}
		
		if (knightMove(x-1, y+2) == 1) {
			theMove = new Move(this, x, y, x-1, y+2, true);
			knightMoves.add(theMove);
		}
		else if (knightMove(x-1, y+2) == 2) {
			theMove = new Move(this, x, y, x-1, y+2, false);
			knightMoves.add(theMove);
		}
		
		if (knightMove(x+2, y-1) == 1) {
			theMove = new Move(this, x, y, x+2, y-1, true);
			knightMoves.add(theMove);
		}
		else if (knightMove(x+2, y-1) == 2) {
			theMove = new Move(this, x, y, x+2, y-1, false);
			knightMoves.add(theMove);
		}
		
		if (knightMove(x+1, y-2) == 1) {
			theMove = new Move(this, x, y, x+1, y-2, true);
			knightMoves.add(theMove);
		}
		else if (knightMove(x+1, y-2) == 2) {
			theMove = new Move(this, x, y, x+1, y-2, false);
			knightMoves.add(theMove);
		}
		
		if (knightMove(x-2, y-1) == 1) {
			theMove = new Move(this, x, y, x-2, y-1, true);
			knightMoves.add(theMove);
		}
		else if (knightMove(x-2, y-1) == 2) {
			theMove = new Move(this, x, y, x-2, y-1, false);
			knightMoves.add(theMove);
		}
		
		if (knightMove(x-1, y-2) == 1) {
			theMove = new Move(this, x, y, x-1, y-2, true);
			knightMoves.add(theMove);
		}
		else if (knightMove(x-1, y-2) == 2) {
			theMove = new Move(this, x, y, x-1, y-2, false);
			knightMoves.add(theMove);
		}

		if (knightMoves.isEmpty())
			return null;
		return knightMoves;
		
	}
	
	//similar to method in king.java
	/**
	 * method that determines if this position is occupied by opponnent or not
	 * @param newX	the x-coord of the move
	 * @param newY	the y-coord of the move
	 * @return int	a value (1-3) notifying the status of the move position
	 */
	private int knightMove(int newX, int newY) {
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
