package assignment2018;
import assignment2018.codeprovided.*;
import java.util.*;

/**
 * Rook.java
 * 
 * Concrete class to represent a rook
 * 
 * @author David Goddard
 *
 */
public class Rook extends Piece {
	
	/**
	 * Constructor for the rook piece
	 * @param ix	initial x coordinate
	 * @param iy	initial y coordinate
	 * @param c		colour of piece
	 * @param b		the board
	 */
	public Rook(int ix, int iy, int c, Board b) {
		super(PieceCode.ROOK, ix, iy, c, b);
	}
	
	/**
	 * Returns the available moves for the rook
	 * @return ArrayList<Move>		an arraylist of type Move of the allowed moves
	 */
	public ArrayList<Move> availableMoves() {
		return rook();
	}
	
	/**
	 * Method to determine the moves this piece can take this turn
	 * @return ArrayList<Move>		an array list of type Move the moves allowed
	 */
	private ArrayList<Move> rook() {
		
		int x = this.getX();
		int y = this.getY();
		
		ArrayList<Move> rookMoves = new ArrayList<Move>();
		
		Move theMove = null;
		
		//Moves up
		//y position starts 1 more than current y and is bounded by the bounds of board
		for (int i=y+1; i<PieceCode.YSIZE; i++) {
			//if its occupied by your colour then the piece can go no further in this direction so stop loop and dont add move
			if (getBoard().occupied(x, i) && getBoard().getPiece(x, i).getColour() == this.getColour()) 
				break;
			//if it takes a piece the loop also has to stop as it can move no further
			else if (getBoard().occupied(x, i)) {
				theMove = new Move(this, x, y, x, i, true);
				rookMoves.add(theMove);
				break;
			}
			else {
				theMove = new Move(this, x, y, x, i, false);
				rookMoves.add(theMove);
			}
		}
		
		//down
		for (int i=y-1; i>=0; i--) {
			if (getBoard().occupied(x, i) && getBoard().getPiece(x, i).getColour() == this.getColour()) 
				break;
			else if (getBoard().occupied(x, i)) {
				theMove = new Move(this, x, y, x, i, true);
				rookMoves.add(theMove);
				break;
			}
			else {
				theMove = new Move(this, x, y, x, i, false);
				rookMoves.add(theMove);
			}
		}
		
		//right
		for (int i=x+1; i<PieceCode.XSIZE; i++) {
			if (getBoard().occupied(i, y) && getBoard().getPiece(i, y).getColour() == this.getColour()) 
				break;
			else if (getBoard().occupied(i, y)) {
				theMove = new Move(this, x, y, i, y, true);
				rookMoves.add(theMove);
				break;
			}
			else {
				theMove = new Move(this, x, y, i, y, false);
				rookMoves.add(theMove);
			}
		}
		
		//left
		for (int i=x-1; i>=0; i--) {
			if (getBoard().occupied(i, y) && getBoard().getPiece(i, y).getColour() == this.getColour()) 
				break;
			else if (getBoard().occupied(i, y)) {
				theMove = new Move(this, x, y, i, y, true);
				rookMoves.add(theMove);
				break;
			}
			else {
				theMove = new Move(this, x, y, i, y, false);
				rookMoves.add(theMove);
			}
		}
		
		if (rookMoves.isEmpty())
            return null;
        return rookMoves;
	}
}
