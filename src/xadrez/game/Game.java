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
	public static PieceMovementRules movementRules = new PieceMovementRules();

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		Set<Integer> possibleMovements = new HashSet<>();
		
		Houses house = new Houses();
		Board board = new Board();
		String houseSorce="", houseTarget="";
		
		int source=0, target=0, whiteKingPosition=60, blackKingPosition=4, press=0;
		boolean invalidMoviment = false, checkmate = false, validation;
		
		house.generateHouses();
		board.generatePieces();
		
		while(!checkmate) {
			System.out.println();
			System.out.println("=============================================");
			board.showWhitePieces();
			System.out.println("\n");
			validation = true;
			
			if(movementRules.isPossibleRoque(board, WHITE)) {
				
				System.out.println("Roque is possible! Press 1 to confirm moviment or 0 to cancel");
				do {
					System.out.print("Press 1 or 0: ");
					press = sc.nextInt();
					if(press == 1) {
						movementRules.roque(board, WHITE);
						validation = false;
					}
				}while(press != 1 && press != 0);
				
			} if(validation){
				do {
					
					do {
						System.out.print("Source: ");
						houseSorce = sc.next();
						source = house.houseForNumber(houseSorce.toUpperCase());
						possibleMovements = movementRules.possibleMovements(board.getPieces().get(source), source, board.getPieces());
					} while(movementRules.check(whiteKingPosition, WHITE, board.getPieces()) && movementRules.canGetTheKingOutOfCheck(possibleMovements, board.getPieces(), source, whiteKingPosition, board, WHITE));
				
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
			}
			
//			System.out.println("WK-Check: " + movementSetting.check(whiteKingPosition, PieceColor.WHITE, board.getPieces()));
			
			System.out.println();
			System.out.println("=============================================");
			board.showBlackPieces();
			System.out.println("\n");
			validation = true;
			
			if(movementRules.isPossibleRoque(board, BLACK)) {
				
				System.out.println("Roque is possible! Press 1 to confirm moviment or 0 to cancel");
				do {
					System.out.print("Press 1 or 0: ");
					press = sc.nextInt();
					if(press == 1) {
						movementRules.roque(board, BLACK);
						validation = false;
					}
				}while(press != 1 && press != 0);
				
			} if(validation){
				do {
					
					do {
						System.out.print("Source: ");
						houseSorce = sc.next();
						source = house.houseForNumber(houseSorce.toUpperCase());
						possibleMovements = movementRules.possibleMovements(board.getPieces().get(source), source, board.getPieces());
					} while(movementRules.check(blackKingPosition, BLACK, board.getPieces()) && movementRules.canGetTheKingOutOfCheck(possibleMovements, board.getPieces(), source, blackKingPosition, board, BLACK));
				
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
				
//				System.out.println("BK-Check: " + movementSetting.check(blackKingPosition, PieceColor.BLACK, board.getPieces()));
			}
		}
	}
}