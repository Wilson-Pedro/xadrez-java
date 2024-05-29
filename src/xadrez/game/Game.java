package xadrez.game;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import xadrez.board.Board;
import xadrez.board.Houses;
import xadrez.enums.PieceColor;
import xadrez.enums.PieceName;
import xadrez.rules.PieceMovementRules;

public class Game {
	
	public static PieceColor BLACK = PieceColor.BLACK;
	public static PieceColor WHITE = PieceColor.WHITE;
	public static PieceMovementRules movementRules = new PieceMovementRules();

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		Set<Integer> possibleMovements = new HashSet<>();
		Set<Integer> possibleKingMovements = new HashSet<>();
		
		Houses house = new Houses();
		Board board = new Board();
		String houseSorce="", houseTarget="";
		
		int source=0, target=0, whiteKingPosition=60, blackKingPosition=4;
		String press= "a";
		boolean invalidMoviment = false, checkmate = false, validation, once01 = true, once02= true;
		
		house.generateHouses();
		board.generatePieces();
		
		while(!checkmate) {
			System.out.println();
			System.out.println("=============================================");
			board.showWhitePieces();
			System.out.println("\n");
			validation = true;

			checkmate = movementRules.isCheckmate(whiteKingPosition, board, WHITE);
			if(checkmate) break;
			
			if(movementRules.isPossibleRoque(board, WHITE) && once01) {
				
				System.out.println("Roque is possible! Press 1 to confirm moviment or 0 to cancel");
				do {
					System.out.print("Press 1 or 0: ");
					press = sc.next();
					if(press.equals("1")) {
						movementRules.roque(board, WHITE);
						validation = false;
						once01 = false;
						whiteKingPosition = movementRules.findPiecePosition(board.getPieces(), PieceName.KING, WHITE);
						board.getPieces().get(whiteKingPosition).incrementMoveQuantity();
					}
				}while(!press.equals("1") && !press.equals("0"));
				
			} if(validation){
				do {
					do {
						System.out.print("Source: ");
						houseSorce = sc.next();
						source = house.houseForNumber(houseSorce.toUpperCase());
						possibleMovements = movementRules.possibleMovements(source, true, board.getPieces());
						
						possibleKingMovements = movementRules.possibleMovements(whiteKingPosition, false, board.getPieces());
					} while(movementRules.check(whiteKingPosition, WHITE, board.getPieces()) && possibleKingMovements.isEmpty() && movementRules.canGetTheKingOutOfCheck(possibleMovements, source, whiteKingPosition, new Board(board), WHITE));
				
				} while(possibleMovements.isEmpty() || board.getPieces().get(source).isBlack());
				
				System.out.println("Possible Moviments: " + house.numbersToHouses(possibleMovements));
				
				do {
					System.out.print("Move To: ");
					houseTarget = sc.next();
					target = house.houseForNumber(houseTarget.toUpperCase());
					invalidMoviment = !possibleMovements.contains(target);
				} while(invalidMoviment);
				
				board.movePiece(board.getPieces(), source, target);
				
				whiteKingPosition = movementRules.findPiecePosition(board.getPieces(), PieceName.KING, WHITE);
			}
			
			System.out.println();
			System.out.println("=============================================");
			board.showBlackPieces();
			System.out.println("\n");
			validation = true;
			
			checkmate = movementRules.isCheckmate(blackKingPosition, board, BLACK);
			if(checkmate) break;
			
			if(movementRules.isPossibleRoque(board, BLACK) && once02) {
				
				System.out.println("Roque is possible! Press 1 to confirm moviment or 0 to cancel");
				do {
					System.out.print("Press 1 or 0: ");
					press = sc.next();
					if(press.equals("1")) {
						movementRules.roque(board, BLACK);
						validation = false;
						once02 = false;
						blackKingPosition = movementRules.findPiecePosition(board.getPieces(), PieceName.KING, WHITE);
						board.getPieces().get(blackKingPosition).incrementMoveQuantity();
					}
				}while(!press.equals("1") && !press.equals("0"));
			} if(validation){
				do {
					
					do {
						System.out.print("Source: ");
						houseSorce = sc.next();
						source = house.houseForNumber(houseSorce.toUpperCase());
						possibleMovements = movementRules.possibleMovements(source, true, board.getPieces());
						possibleKingMovements = movementRules.possibleMovements(blackKingPosition, false, board.getPieces());
					} while(movementRules.check(blackKingPosition, BLACK, board.getPieces()) && movementRules.check(blackKingPosition, BLACK, board.getPieces()) && movementRules.canGetTheKingOutOfCheck(possibleMovements, source, blackKingPosition, board, BLACK));
				
				} while(possibleMovements.isEmpty() || board.getPieces().get(source).isWhite());
				
				System.out.println("Possible Moviments: " + house.numbersToHouses(possibleMovements));
				
				do {
					System.out.print("Move To: ");
					houseTarget = sc.next();
					target = house.houseForNumber(houseTarget.toUpperCase());
					invalidMoviment = !possibleMovements.contains(target);
				} while(invalidMoviment);
				
				board.movePiece(board.getPieces(), source, target);
				
				blackKingPosition = movementRules.findPiecePosition(board.getPieces(), PieceName.KING, BLACK);
				
			}
		}
		
		System.out.println("\n\nEND OF THE GAME");
	}
}

