package assignment2018;
import assignment2018.codeprovided.*;
import java.util.*;

/**
 * Bishop.java
 * 
 * Concrete class to represent a bishop
 * 
 * @author David Goddard
 *
 */
public class Bishop extends Piece {
	
	/**
	 * Constructor for the bishop class
	 * @param ix	initial x coordinate
	 * @param iy	initial y coordinate
	 * @param c		colour of piece
	 * @param b		the board
	 */
	public Bishop(int ix, int iy, int c, Board b) {
		super(PieceCode.BISHOP, ix, iy, c, b);
	}
	
	/**
	 * Returns the available moves for the bishop
	 * @return ArrayList<Move>		an arraylist of type Move of the allowed moves
	 */
	public ArrayList<Move> availableMoves() {
		return bishop();
	}
	
	/**
	 * Method to determine the moves this piece can take this turn
	 * @return ArrayList<Move>		an array list of type Move the moves allowed
	 */
	private ArrayList<Move> bishop() {
			
		int x = this.getX();
		int y = this.getY();
			
		ArrayList<Move> bishopMoves = new ArrayList<Move>();
			
		Move theMove = null;
		
		/*
		 * Incoorperated an adaptation of an enhanced for-loop, as method requires both x and y to 
		 * increase by 1 each loop.
		 * In each situation, depending on the direction, x and y are initialised to one below/above
		 * current x and y and are bounded by the limits of the board
		 */
		
		//move up right diagonal
		int j = y +1;
		for (int i=x+1; i<PieceCode.XSIZE; i++) {
			if (j<PieceCode.YSIZE) {
				//if its occupied by your colour then the piece can go no further in this direction so stop loop
				if (getBoard().occupied(i, j) && getBoard().getPiece(i, j).getColour() == this.getColour()) 
					break;
				//if it takes a piece the loop also has to stop as it can move no further
				else if (getBoard().occupied(i, j)) {
					theMove = new Move(this, x, y, i, j, true);
					bishopMoves.add(theMove);
					break;
				}
				else {
					theMove = new Move(this, x, y, i, j, false);
					bishopMoves.add(theMove);
				}
			}
			j =j + 1;
		}
		
		//move up left
		int h = y + 1;
		for (int i=x-1; i>=0; i--) {
			if (h<PieceCode.YSIZE) {
				if (getBoard().occupied(i, h) && getBoard().getPiece(i, h).getColour() == this.getColour()) 
					break;
				else if (getBoard().occupied(i, h)) {
					theMove = new Move(this, x, y, i, h, true);
					bishopMoves.add(theMove);
					break;
				}
				else {
					theMove = new Move(this, x, y, i, h, false);
					bishopMoves.add(theMove);
				}
			}
			h = h + 1;
		}
		
		int k = y - 1;
		//move down right
		for (int i=x+1; i<PieceCode.XSIZE; i++) {
			if (k >= 0) {
				if (getBoard().occupied(i, k) && getBoard().getPiece(i, k).getColour() == this.getColour()) 
					break;
				else if (getBoard().occupied(i, k)) {
					theMove = new Move(this, x, y, i, k, true);
					bishopMoves.add(theMove);
					break;
				}
				else {
					theMove = new Move(this, x, y, i, k, false);
					bishopMoves.add(theMove);
				}
			}
			k = k - 1;
		}
		
		//move down left
		int l = y - 1;
		for (int i=x-1; i>=0; i--) {
			if (l>=0) {
				if (getBoard().occupied(i, l) && getBoard().getPiece(i, l).getColour() == this.getColour()) 
					break;
				else if (getBoard().occupied(i, l)) {
					theMove = new Move(this, x, y, i, l, true);
					bishopMoves.add(theMove);
					break;
				}
				else {
					theMove = new Move(this, x, y, i, l, false);
					bishopMoves.add(theMove);
				}
			}
			l = l - 1;
		}
		
		if (bishopMoves.isEmpty())
			return null;
		return bishopMoves;
	}
}
