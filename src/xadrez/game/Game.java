package xadrez.game;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import xadrez.board.Board;
import xadrez.board.Houses;
import xadrez.piece.PieceMovementSettings;

public class Game {

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		Set<Integer> possibleMovements = new HashSet<>();
		
		PieceMovementSettings movementSetting = new PieceMovementSettings();
		Houses house = new Houses();
		house.generateHouses();
		Board board = new Board();
		
		String houseSorce="", houseTarget="";
		int source=0, target=0, whiteKingPosition=60, blackKingPosition=4;
		boolean invalidMoviment = false, checkmate = false;
		
		board.generatePieces();
		
		while(!checkmate) {
			System.out.println();
			System.out.println("=============================================");
			board.showWhitePieces();
			System.out.println("\n");
			
			do {
				System.out.print("Source: ");
				houseSorce = sc.next();
				source = house.houseForNumber(houseSorce.toUpperCase());
				possibleMovements = movementSetting.possibleMovements(board.getPieces().get(source), source, board.getPieces());
			} while(possibleMovements.isEmpty());
			
			System.out.println("Possible Moviments: " + house.numbersToHouses(possibleMovements));
			
			do {
				System.out.print("Move To: ");
				houseTarget = sc.next();
				target = house.houseForNumber(houseTarget.toUpperCase());
				invalidMoviment = !possibleMovements.contains(target);
			} while(invalidMoviment);
			
			board.movePiece(board.getPieces(), source, target);
			
			if (board.getPieces().get(source).isKing()) whiteKingPosition = target;
			
			//System.out.println("WK-Check: " + movementSetting.check(whiteKing, board.getPieces()));
			
			System.out.println();
			System.out.println("=============================================");
			board.showBlackPieces();
			System.out.println("\n");
			
			do {
				System.out.print("Source: ");
				houseSorce = sc.next();
				source = house.houseForNumber(houseSorce.toUpperCase());
				possibleMovements = movementSetting.possibleMovements(board.getPieces().get(source), source, board.getPieces());
			} while(possibleMovements.isEmpty());
			
			System.out.println("Possible Moviments: " + house.numbersToHouses(possibleMovements));
			
			do {
				System.out.print("Move To: ");
				houseTarget = sc.next();
				target = house.houseForNumber(houseTarget.toUpperCase());
				invalidMoviment = !possibleMovements.contains(target);
			} while(invalidMoviment);	
			
			board.movePiece(board.getPieces(), source, target);
			
			if (board.getPieces().get(source).isKing()) blackKingPosition = target;
			
			//System.out.println("BK-Check: " + movementSetting.check(blackKing, board.getPieces()));
		}
	}
}