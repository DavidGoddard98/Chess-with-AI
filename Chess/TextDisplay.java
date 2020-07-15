package assignment2018;
import assignment2018.codeprovided.*;
import java.util.*;

/**
 * TextDisplay.java
 * 
 * Class to display the chess board to the console
 * 
 * @author David Goddard
 *
 */
public class TextDisplay implements Display {
	
	private Board theBoard;
	
	/**
	 * Constructor for the text display
	 * @param b		the board
	 */
	public TextDisplay(Board b) {
		theBoard = b;
	}
	
	/**
	 *Method to display the board to the console
	 *@param myPieces	the pieces of this player
	 */
	public void displayBoard(Pieces myPieces) {
		Board theBoard = getBoard();
		
		char temp;
		char[][]grid = new char[8][8];
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				//cycles through the 2d array board and copies the values to another array of type char
				//If a index is null it will set this as a '.'
				if (theBoard.getPiece(j, i) == null) 
					temp = '.';
				else
					temp = theBoard.getPiece(j,i).getChar();
				grid[i][j] = temp;
			}
		}
		System.out.println("\n" + "   " + "| A B C D E F G H");
		System.out.println("--------------------");
		int k = 0;
		for (int i=0; i<8; i++) {
			System.out.print(" " + k + " | ");
			for (int j=0; j<8; j++) {
				System.out.print(grid[i][j]);
				System.out.print(" ");
			}
			k++;
			System.out.println();
		}
	}
	
	/**
	 * Accessor to get the state of the board
	 * @return Board		the board
	 */
	public Board getBoard() {
		return theBoard;
	}
	 
}
