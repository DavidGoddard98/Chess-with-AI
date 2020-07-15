package assignment2018;
import assignment2018.codeprovided.*;
import java.util.*;

/**
 * Queen.java
 * 
 * Concrete class to represent queen
 * 
 * @author David Goddard
 *
 */
public class Queen extends Piece {
	
	/**
	 * Constructor for the queen piece
	 * @param ix	initial x coordinate
	 * @param iy	initial y coordinate
	 * @param c		colour of piece
	 * @param b		the board
	 */
	public Queen(int ix, int iy, int c, Board b) {
		super(PieceCode.QUEEN, ix, iy, c, b);
	}
	
	/**
	 * Returns the available moves for the queen
	 * @return ArrayList<Move>		an arraylist of type Move of the allowed moves
	 */
	public ArrayList<Move> availableMoves() {
		return queen();
	}
	
	/**
	 * Method to determine the moves this piece can take this turn
	 * @return ArrayList<Move>		an array list of type Move the moves allowed
	 */
	private ArrayList<Move> queen() {
		
		int x = this.getX();
		int y = this.getY();
		
		ArrayList<Move> queenMoves = new ArrayList<Move>();
		
		Move theMove = null;
		
		//All moves relating to moving up, similar to rook
		//y position starts 1 more than current y and is bounded by the bounds of board
		for (int i=y+1; i<PieceCode.YSIZE; i++) {
			//if its occupied by your colour then the piece can go no further in this direction so stop loop
			if (getBoard().occupied(x, i) && getBoard().getPiece(x, i).getColour() == this.getColour()) 
				break;
			//if it takes a piece the loop also has to stop as it can move no further
			else if (getBoard().occupied(x, i)) {
				theMove = new Move(this, x, y, x, i, true);
				queenMoves.add(theMove);
				break;
			}
			else {
				theMove = new Move(this, x, y, x, i, false);
				queenMoves.add(theMove);
			}
		}
		
		//down
		for (int i=y-1; i>=0; i--) {
			if (getBoard().occupied(x, i) && getBoard().getPiece(x, i).getColour() == this.getColour()) 
				break;
			else if (getBoard().occupied(x, i)) {
				theMove = new Move(this, x, y, x, i, true);
				queenMoves.add(theMove);
				break;
			}
			else {
				theMove = new Move(this, x, y, x, i, false);
				queenMoves.add(theMove);
			}
		}
		
		//right
		for (int i=x+1; i<PieceCode.XSIZE; i++) {
			if (getBoard().occupied(i, y) && getBoard().getPiece(i, y).getColour() == this.getColour()) 
				break;
			else if (getBoard().occupied(i, y)) {
				theMove = new Move(this, x, y, i, y, true);
				queenMoves.add(theMove);
				break;
			}
			else {
				theMove = new Move(this, x, y, i, y, false);
				queenMoves.add(theMove);
			}
		}
		
		//left
		for (int i=x-1; i>=0; i--) {
			if (getBoard().occupied(i, y) && getBoard().getPiece(i, y).getColour() == this.getColour()) 
				break;
			else if (getBoard().occupied(i, y)) {
				theMove = new Move(this, x, y, i, y, true);
				queenMoves.add(theMove);
				break;
			}
			else {
				theMove = new Move(this, x, y, i, y, false);
				queenMoves.add(theMove);
			}
		}
		
		//--------------------Below are diagonal moves------------------------------------------
		/*
		 * Incoorperated an adaptation of an enhanced for-loop, as method requires both x and y to 
		 * increase by 1 each loop.
		 * In each situation, depending on the direction, x and y are initialised to one below/above
		 * current x and y and are bounded by the limits of the board
		 */
		
		//north east
		int j = y +1;
		for (int i=x+1; i<PieceCode.XSIZE; i++) {
			if (j<PieceCode.YSIZE) {
				if (getBoard().occupied(i, j) && getBoard().getPiece(i, j).getColour() == this.getColour()) 
					break;
				else if (getBoard().occupied(i, j)) {
					theMove = new Move(this, x, y, i, j, true);
					queenMoves.add(theMove);
					break;
				}
				else {
					theMove = new Move(this, x, y, i, j, false);
					queenMoves.add(theMove);
				}
				
			}
			j =j + 1;
		}
		
		//north west
		int h = y + 1;
		for (int i=x-1; i>=0; i--) {
			if (h<PieceCode.YSIZE) {
				if (getBoard().occupied(i, h) && getBoard().getPiece(i, h).getColour() == this.getColour()) 
					break;
				else if (getBoard().occupied(i, h)) {
					theMove = new Move(this, x, y, i, h, true);
					queenMoves.add(theMove);
					break;
				}
				else {
					theMove = new Move(this, x, y, i, h, false);
					queenMoves.add(theMove);
				}
			}
			h = h + 1;
		}
		
		int k = y - 1;
		//south east
		for (int i=x+1; i<PieceCode.XSIZE; i++) {
			if (k >= 0) {
				if (getBoard().occupied(i, k) && getBoard().getPiece(i, k).getColour() == this.getColour()) 
					break;
				else if (getBoard().occupied(i, k)) {
					theMove = new Move(this, x, y, i, k, true);
					queenMoves.add(theMove);
					break;
				}
				else {
					theMove = new Move(this, x, y, i, k, false);
					queenMoves.add(theMove);
				}
			}
			k = k - 1;
		}
		
		//south west
		int l = y  - 1;
		for (int i=x-1; i>=0; i--) {
			if (l>=0) {
				if (getBoard().occupied(i, l) && getBoard().getPiece(i, l).getColour() == this.getColour()) 
					break;
				else if (getBoard().occupied(i, l)) {
					theMove = new Move(this, x, y, i, l, true);
					queenMoves.add(theMove);
					break;
				}
				else {
					theMove = new Move(this, x, y, i, l, false);
					queenMoves.add(theMove);
				}
			}
			l = l - 1;
		}
		
		if (queenMoves.isEmpty())
			return null;
		return queenMoves;
	}
}
