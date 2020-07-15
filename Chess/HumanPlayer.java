package assignment2018;
import java.util.ArrayList;
import java.util.ListIterator;

import assignment2018.codeprovided.*;
import sheffield.*;

/**
 * HumanPlayer.java
 * 
 * A class which allows you to interact with the chess game
 * 
 * @author David Goddard
 *
 */
public class HumanPlayer extends GeneralPlayer {
	
	/**
	 * Constructor for the humanPlayer
	 * @param n		the name of the player
	 * @param p		the set of pieces of the player
	 * @param b		the board
	 * @param o		the players opponnent
	 */
	public HumanPlayer(String n, Pieces p, Board b, Player o) {
		super(n, p, b, o);
	}
	
	/**
	 * Method to take input from the user and make the move if it is valid
	 * @return boolean		true if the move is valid
	 */
	public boolean makeMove() {
		boolean moveAllowed = false;
		Piece opponentsPiece;
		
		EasyReader keyboard = new EasyReader();
		String playerMove = keyboard.readString("What is your desired move?");
		try {
		    //reads in the input and substrings each character, charToInt converts the horizonal ABCDEFGH to valid move ints
			int xPosFrom = charToInt(playerMove.substring(0, 1));
			int yPosFrom = Integer.parseInt(playerMove.substring(1, 2));
			int xPosMove =  charToInt(playerMove.substring(3, 4));
		    int yPosMove = Integer.parseInt(playerMove.substring(4, 5));
		
			Board theBoard = getBoard();
		    //the piece the user is reffering to
			Piece pieceToBeMoved = theBoard.getPiece(xPosFrom, yPosFrom);
			
			//checks that this piece is correct colour and therefore valid to move
			int thisColour = getColour();
			int pieceColour = pieceToBeMoved.getColour();
			if (pieceColour != thisColour)
				return false;
		
			ArrayList<Move> movesAllowed = new ArrayList<Move>();
			//creates a list of all available moves of the piece selected
			movesAllowed = pieceToBeMoved.availableMoves();
			ListIterator<Move> moveIterator = movesAllowed.listIterator();
			
			while (moveIterator.hasNext()) {
				Move potentialMove = moveIterator.next();
				
				int x = potentialMove.getNX();
				int y = potentialMove.getNY();
				//while cycling through the list if a move has the same x and y as the users desired move then the move is valid
				if (x==xPosMove && y==yPosMove) {
					
					moveAllowed = true;
					//checks to see if this move will take an opponents piece
					if (potentialMove.getFlagStatus()) {
						//if opp has piece there then must remove it from collection and from position on board
						opponentsPiece = theBoard.getPiece(xPosMove, yPosMove);
						Pieces oppPiecesColl = getOpponent().getPieces();
						oppPiecesColl.delete(opponentsPiece);
						theBoard.removePiece(xPosMove, yPosMove);
					}
					//move players piece to new position on board
					theBoard.setPosition(xPosMove, yPosMove, potentialMove.getPiece());
					//remove players piece from old position on board
					theBoard.removePiece(xPosFrom, yPosFrom);
				}
			}
			
		//If the piece has no available moves then a nullpointerexception will be thrown when trying to navigate the empty move list
		//This catch statement continues to the next piece if this is so. The NumberFormat and StringIndexOutOfBounds exceptions is to catch
		//incorrect user input.
		} catch (StringIndexOutOfBoundsException | NumberFormatException | NullPointerException e) {
			return false;
		}    
		
		if (moveAllowed)
			return true;
		return false;
	}
	
	/**
	 * Method to convert the users char input to valid integer coordinates
	 * @param move		the char the user entered
	 * @return int 		the respective integer coordinate
	 */
	public int charToInt(String move) {
		int i;
		switch (move) {
		case "A" : case "a" :i = 0; break;
		case "B" : case "b" :i = 1; break;
		case "C" : case "c" :i = 2; break;
		case "D" : case "d" :i = 3; break;
		case "E" : case "e" :i = 4; break;
		case "F" : case "f" :i = 5; break;
		case "G" : case "g" :i = 6; break;
		case "H" : case "h" :i = 7; break;
		default : i = 8;
		}
		return i;
	}
}
