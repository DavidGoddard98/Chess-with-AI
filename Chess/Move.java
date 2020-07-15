package assignment2018;
import assignment2018.codeprovided.*;

/**
 * Move.java
 * 
 * Class to represent a move in a chess game
 * 
 * @author David Goddard
 *
 */
public class Move {
	
	private int oldX; 
	private int oldY;
	private int x;
	private int y;
	private boolean flag;
	private Piece piece;
	
	/**
	 * Constructor for a move
	 * @param thisP		the piece you wish to move
	 * @param ix		the initial x coordinate of this piece
	 * @param iy		the initial y coordinate of this piece
	 * @param nx		the new x coordinate of this piece
	 * @param ny		the new y coordinate of this piece
	 * @param f			the flag status of this piece
	 */
	public Move(Piece thisP, int ix, int iy, int nx, int ny, boolean f) {
		piece = thisP;
		oldX = ix;
		oldY = iy;
		x = nx;
		y = ny;
		flag = f;
	}
	
	/**
	 * Accessor to get the initial x coordinate before the move
	 * @return int		the x coordinate
	 */
	public int getOX() {
		return oldX;
	}
	
	/**
	 * Accessor to get the initial y coordinate before the move
	 * @return int		the y coordinate
	 */
	public int getOY() {
		return oldY;
	}
	
	/**
	 * Accessor to get the new x coordinate after the move
	 * @return int		the x coordinate
	 */
	public int getNX() {
		return x;
	}
	
	/**
	 * Accessor to get the new y coordinate after the move
	 * @return int		the y coordinate
	 */
	public int getNY() {
		return y;
	}
	
	/**
	 * Acessor to get the piece involved in the move
	 * @return	piece	the piece
	 */
	public Piece getPiece() {
		return piece;
	}
	
	/**
	 * Acessor to determine if this move will take a piece in the process
	 * @return	boolean	true if a piece is taken
	 */
	public boolean getFlagStatus() {
		return flag;
	}
	

}
