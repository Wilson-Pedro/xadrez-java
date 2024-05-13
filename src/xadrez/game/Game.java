package xadrez.game;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import xadrez.board.Board;
import xadrez.board.Houses;
import xadrez.enums.PieceColor;
import xadrez.rules.PieceMovementRules;

public class Game {
	
	public static PieceColor BLACK = PieceColor.BLACK;
	public static PieceColor WHITE = PieceColor.WHITE;

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		Set<Integer> possibleMovements = new HashSet<>();
		
		PieceMovementRules movementRules = new PieceMovementRules();
		Houses house = new Houses();
		Board board = new Board();
		String houseSorce="", houseTarget="";
		
		int source=0, target=0, whiteKingPosition=60, blackKingPosition=4;
		boolean invalidMoviment = false, checkmate = false;
		
		house.generateHouses();
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
				possibleMovements = movementRules.possibleMovements(board.getPieces().get(source), source, board.getPieces());
			} while(possibleMovements.isEmpty());
			
			System.out.println("Possible Moviments: " + house.numbersToHouses(possibleMovements));
			
			do {
				System.out.print("Move To: ");
				houseTarget = sc.next();
				target = house.houseForNumber(houseTarget.toUpperCase());
				invalidMoviment = !possibleMovements.contains(target);
			} while(invalidMoviment);
			
			if (board.getPieces().get(source).isKing()) whiteKingPosition = target;
			
			board.movePiece(board.getPieces(), source, target);
			
//			System.out.println("WK-Check: " + movementSetting.check(whiteKingPosition, PieceColor.WHITE, board.getPieces()));
			
			System.out.println();
			System.out.println("=============================================");
			board.showBlackPieces();
			System.out.println("\n");
			
			do {
				System.out.print("Source: ");
				houseSorce = sc.next();
				source = house.houseForNumber(houseSorce.toUpperCase());
				possibleMovements = movementRules.possibleMovements(board.getPieces().get(source), source, board.getPieces());
			} while(possibleMovements.isEmpty());
			
			System.out.println("Possible Moviments: " + house.numbersToHouses(possibleMovements));
			
			do {
				System.out.print("Move To: ");
				houseTarget = sc.next();
				target = house.houseForNumber(houseTarget.toUpperCase());
				invalidMoviment = !possibleMovements.contains(target);
			} while(invalidMoviment);
			
			if (board.getPieces().get(source).isKing()) blackKingPosition = target;
			
			board.movePiece(board.getPieces(), source, target);
			
//			System.out.println("BK-Check: " + movementSetting.check(blackKingPosition, PieceColor.BLACK, board.getPieces()));
		}
	}
}