package assignment2018;
import java.util.ArrayList;
import java.util.ListIterator;

import assignment2018.codeprovided.*;
import sheffield.EasyReader;

/**
 * Chess.java
 * 
 * Class to run the chess game
 * 
 * @author David Goddard
 *
 */
public class Chess {
	
	 public static void main (String[] args) {
		 
		 EasyReader keyboard = new EasyReader();
		 Board newBoard = new Board();
		 
		 Pieces white = new Pieces(newBoard, PieceCode.WHITE);
		 Pieces black = new Pieces(newBoard, PieceCode.BLACK);
		 
		 HumanPlayer playerOne = new HumanPlayer("player one", white, newBoard, null);
		 
		 //The different kinds of opponenets
		 HumanPlayer playerTwo = new HumanPlayer("player two", black, newBoard, playerOne);
		 RandomPlayer playerThree = new RandomPlayer("player three", black, newBoard, playerOne);
		 AggressivePlayer playerFour = new AggressivePlayer("player four", black, newBoard, playerOne);
		 
		 //Set to null in order to initialize it
		 GeneralPlayer opponent = null;
		 
		 boolean validOpponent = false;
		 
		 //Takes a char as input converting it into an opponent
		 do {
			 char opponentChoice = keyboard.readChar("What opponnent do you choose? Another Human (H/h) || RandomAi (R/r) || AggressiveAi(A/a)");
			 opponentChoice = Character.toLowerCase(opponentChoice);
			 
			 if (opponentChoice == 'h') {
				 playerOne.setOpponent(playerTwo);
				 opponent = playerTwo;
				 validOpponent = true;
			 }
			 else if (opponentChoice == 'r') {
				 playerOne.setOpponent(playerThree);
			 	 opponent = playerThree;
			 	 validOpponent = true;
			 }
			 else if (opponentChoice == 'a') {
				 playerOne.setOpponent(playerFour);
				 opponent = playerFour;
				 validOpponent = true;
			 }
			 else
				 validOpponent = false;
			 
		 } while (validOpponent==false);
		 
		 TextDisplay displayChess = new TextDisplay(newBoard);
		 displayChess.displayBoard(white);
		 
		 boolean kingNotTaken = true;
		 int player = 1;
		
		 //The actual chess game
		 do {
				if (player == 1) {
					System.out.println("IT'S PLAYER ONE'S TURN!");
					
					while (!playerOne.makeMove()) {
						System.out.println("Sorry this move is not valid, enter a valid move");
					}
					
					displayChess.displayBoard(white);
					
					if (opponent.checkKing()) {
						kingNotTaken=false;
						System.out.println("Player One Wins!");
						continue;
					}
					//set player to 2 to allow them to take next turn
					player = 2;	
				}
				
				if (player == 2) {
					System.out.println("IT'S PLAYER TWO'S TURN!");
					
					while (!opponent.makeMove()) {
						System.out.println("Sorry this move is not valid, enter a valid move");
					}
					
					displayChess.displayBoard(black);
					
					if (playerOne.checkKing()) {
						kingNotTaken=false;
						System.out.println("Player Two Wins!");
						continue;
					}
					player = 1;
				}
		 } while(kingNotTaken);
	 }
}
	 

