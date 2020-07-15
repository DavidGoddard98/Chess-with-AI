package assignment2018;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.ThreadLocalRandom;

import assignment2018.codeprovided.*;

/**
 * RandomPlayer.java
 * 
 * Class which acts as a random player when playing chess and chooses its move entirely randomly
 * 
 * @author David Goddard
 *
 */
public class RandomPlayer extends GeneralPlayer {
	
	/**
	 * Constructor for the random player
	 * @param n		the name of the player
	 * @param p		the set of pieces for the player
	 * @param b		the board
	 * @param o		the players opponent
	 */
	public RandomPlayer(String n, Pieces p, Board b, Player o) {
		super(n, p, b, o);
	}
	
	/**
	 * Method to choose a random move out of all available moves for a player
	 * @return boolean		true if the move is valid
	 */
	public boolean makeMove() {
		Piece opponentsPiece;
		
		Board theBoard = getBoard();
		
		ArrayList<Move> allowedMoves = new ArrayList<Move>();
		//stores in an array every single move available
		allowedMoves = allMoves();
		int k = allowedMoves.size();
		
		//chooses a random number between 0 and the number of moves available
		int randomNum = ThreadLocalRandom.current().nextInt(0, k);
		//chooses the move with this random index from all available moves
		Move theMove = allowedMoves.get(randomNum);
		int x1 = theMove.getOX();
		int y1 = theMove.getOY();
		int x2 = theMove.getNX();
		int y2 = theMove.getNY();
					
		if (theMove.getFlagStatus()) {
			//if opp has piece in this position then must remove it from collection and from position on board
			opponentsPiece = theBoard.getPiece(x2, y2);
			Pieces oppPiecesColl = getOpponent().getPieces();
			oppPiecesColl.delete(opponentsPiece);
			theBoard.removePiece(x1, y1);
		}
		
		//move players piece to new position on board
		theBoard.setPosition(x2, y2, theMove.getPiece());
		//remove players piece from old position on board
		theBoard.removePiece(x1, y1);
		
	    return true;
	}
}
