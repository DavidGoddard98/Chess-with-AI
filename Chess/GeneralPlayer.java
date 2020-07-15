package assignment2018;
import java.util.*;
import assignment2018.codeprovided.*;

/**
 * GeneralPlayer.java
 * 
 * Abstract class to provide shared methods for the different types of player
 * 
 * @author David Goddard
 *
 */
public abstract class GeneralPlayer extends Player {
	
	/**
	 * Constructor for the GeneralPlayer
	 * @param n		name of the player
	 * @param p		set of Pieces of the player
	 * @param b		the board
	 * @param o		the players opponnent
	 */
	public GeneralPlayer(String n, Pieces p, Board b, Player o) {
		super(n, p, b, o);
	}
	
	/**
	 * Method to check wether an opponents king has been taken
	 * @return boolean		true if opponents king has been taken
	 */
	public boolean checkKing() {
		boolean kingFound = false;
    	Pieces opponnentsPieces = getPieces();
    	int piecesNumber = opponnentsPieces.getNumPieces();
    	
    	//cycle through each of the pieces in the collection to check if their char is k/K, if not found clearly king is taken
		for (int i=0; i<piecesNumber; i++) {
			Piece aPiece = opponnentsPieces.getPiece(i);
			if (aPiece.getChar() == 'k' || aPiece.getChar() == 'K')
				kingFound = true;
		}
		
		if (kingFound == true)
			return false;
	    return true;
    }
	
	/**
	 * Method to determine the current players colour
	 * @return int		the integer value of their colour
	 */
	public int getColour() {
		//aim is to grab a piece from players collection and determine its colour
		Pieces myPieces = getPieces();
		//while the game is running there will always be at least one piece in your collection
		Piece aPiece = myPieces.getPiece(0);
		int colour = aPiece.getColour();
		return colour;
	}
	
	/**
	 * Method to collect every available move for the AI players
	 * @return ArrayList<Move> 	a list of all available moves
	 */
	public ArrayList<Move> allMoves() {
		ArrayList<Move> allAllowedMoves = new ArrayList<Move>();
		
		Pieces myPieces = getPieces();
		int numPieces = myPieces.getNumPieces();
		
		//cycle through every single piece in this players collection
		for (int i=0; i<numPieces; i++) {
			Piece aPiece = myPieces.getPiece(i);
			try {
				//a temp list to store all moves this current piece can make
				ArrayList<Move> temporaryMoveList = new ArrayList<Move>();
				temporaryMoveList = aPiece.availableMoves();
				ListIterator<Move> moveIterator = temporaryMoveList.listIterator();
				
				//cycle through all the moves this piece can make and add it to an arrayList of all moves
				while (moveIterator.hasNext()) {
					Move aMove = moveIterator.next();
					allAllowedMoves.add(aMove);
				}
				
			//If the piece has no available moves then a nullpointerexception will be thrown when trying to navigate the empty move list
			//This catch statement continues to the next piece if this is so.
			} catch (NullPointerException e) {
				continue;
			}	
		}
		return allAllowedMoves;
	}
	
}
