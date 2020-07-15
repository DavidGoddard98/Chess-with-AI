package assignment2018;
import assignment2018.codeprovided.*;

/**
 * Board.java
 * 
 * Class to represent an 8x8 chess board
 * 
 * @author David Goddard
 *
 */
public class Board {
	private Piece[][] board;
	
	/**
	 * Constructor which creates a 2x2 array of type Piece which represents the board
	 */
	public Board () {
		board = new Piece[8][8];
	}
	
	/**
	 * Method to determine if a square is occupied
	 * @param x		the x coordinate of the square
	 * @param y		the y coordinate of the square
	 * @return		true if position is occupied
	 */
	public boolean occupied(int x, int y) {
		if (this.board[y][x] != null)
			return true;
		else 
			return false;
	}
	
	/**
	 * Method to determine if a desired square is out of range of the 8x8 board
	 * @param x		the x coordinate of the square	
	 * @param y		the y coordinate of the square
	 * @return		true if the square is out of range
	 */
	public boolean outOfRange(int nX, int nY) {
		if (nY > 7 || nY < 0 || nX < 0 || nX > 7 )
			return true;
		else
			return false;
	}
	
	/**
	 * Method to set a piece to a desired square on the board
	 * @param x		the x position the piece is to be moved to
	 * @param y		the y position the piece is to be moved to
	 * @param p		the piece
	 */
	public void setPosition(int x, int y, Piece p) {
		this.board[y][x] = p;
		p.setPosition(x, y);
	}
	
	/**
	 * Method to removed a piece from a desired square on the board
	 * @param x		the x coordinate of the square
	 * @param y		the y coordinate of the square
	 */
	public void removePiece(int x, int y) {
		this.board[y][x] = null;
		
	}
	
	/**
	 * Accessor to find piece at specified square
	 * @param x		x coordinate of square
	 * @param y		y coordinate of square
	 * @return		the piece at square
	 */
	public Piece getPiece(int x, int y) {
		return this.board[y][x];
	}
	
	/**
	 * Accessor that returns the board
	 * @return		2x2 array of type piece
	 */
	public Piece[][] returnBoard() {
		return board;
	}
}
