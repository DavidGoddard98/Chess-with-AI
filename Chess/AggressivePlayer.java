package assignment2018;
import java.util.*;
import java.util.ListIterator;
import java.util.concurrent.ThreadLocalRandom;

import assignment2018.codeprovided.*;

/**
 * AggressivePlayer.java
 * 
 * Class which acts as an aggressive player when playing chess which aims to take the highest value piece 
 * it can each move
 * 
 * @author David Goddard
 *
 */
public class AggressivePlayer extends GeneralPlayer {
	
	/**
	 * Constructor for the aggressive player
	 * @param n		the name of the player
	 * @param p		the set of pieces of the player
	 * @param b		the board
	 * @param o		the players opponent
	 */
	public AggressivePlayer(String n, Pieces p, Board b, Player o) {
		super(n, p, b, o);
	}
	
	/**
	 * Method to choose the move out of all available moves which will take the highest value piece of the opponent
	 * if it can in that turn, else it chooses a random move out of all available moves
	 * @return boolean		true if the move is valid
	 */
	public boolean makeMove() {
		
		Piece opponentsPiece;
		Board theBoard = getBoard();
		
		ArrayList<Move> allowedMoves = new ArrayList<Move>();
		HashMap<Integer, Move> piecesToTakeMap = new HashMap<Integer, Move>();
		//stores in an array every single move available
		allowedMoves = allMoves();
		ListIterator<Move> moveIterator = allowedMoves.listIterator();
		
		//cycles through all the available moves finding the ones which take an opponents piece
		while (moveIterator.hasNext()) {
			Move theMove = moveIterator.next();
			if (theMove.getFlagStatus()) {
				int x2 = theMove.getNX();
				int y2 = theMove.getNY();
				Piece pieceToBeTaken = theBoard.getPiece(x2,y2);
				//gets the value of the piece it will take and stores the move in a hashmap with this value as the index
				int pieceValue = pieceToBeTaken.getValue();
				piecesToTakeMap.put(pieceValue, theMove);
			}
		}
		
		//if the hashmap is empty then there are no moves available which will take an opponents piece, therefore
		//it will choose a random move out of the ones available
		if (piecesToTakeMap.isEmpty()) {
			int k = allowedMoves.size();
			//chooses a random number between 0 and the number of moves available
			int randomNum = ThreadLocalRandom.current().nextInt(0, k);
			Move theMove = allowedMoves.get(randomNum);
			int x1 = theMove.getOX();
			int y1 = theMove.getOY();
			int x2 = theMove.getNX();
			int y2 = theMove.getNY();
			
			//move players piece to new position on board
			theBoard.setPosition(x2, y2, theMove.getPiece());
			//remove players piece from old position on board
			theBoard.removePiece(x1, y1);
		}
		
		//else there is a move available which will take a piece
		else {
			//starting with 6 (value of king) it will cycle down through all possible indexes in the hashmap
			//finding the highest index which references a move
			int k = 6;
			while (piecesToTakeMap.get(k)==null) {
				k--;
			}
			Move aggMove = piecesToTakeMap.get(k);
			int x1 = aggMove.getOX();
			int y1 = aggMove.getOY();
			int x2 = aggMove.getNX();
			int y2 = aggMove.getNY();
			//must remove opponents piece from collection and from position on board
			opponentsPiece = theBoard.getPiece(x2, y2);
			Pieces oppPiecesColl = getOpponent().getPieces();
			oppPiecesColl.delete(opponentsPiece);
			theBoard.removePiece(x1, y1);
			
			//move players piece to new position on board
			theBoard.setPosition(x2, y2, aggMove.getPiece());
			//remove players piece from old position on board
			theBoard.removePiece(x1, y1);
		}
		return true;
	}
}
