package xadrez.game;

import static xadrez.rules.check.CheckRules.canGetTheKingOutOfCheck;
import static xadrez.rules.check.CheckRules.check;
import static xadrez.utils.Util.findPiecePosition;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import xadrez.board.Board;
import xadrez.board.Houses;
import xadrez.enums.PieceColor;
import xadrez.enums.PieceName;
import xadrez.rules.check.CheckRules;
import xadrez.rules.moviments.PieceMovement;
import xadrez.rules.roque.RoqueRules;

public class Game {
	
	public static PieceColor BLACK = PieceColor.BLACK;
	public static PieceColor WHITE = PieceColor.WHITE;

	public static void main(String[] args) {
		
		CheckRules checkRules = new CheckRules();
		RoqueRules roqueRules = new RoqueRules();
		PieceMovement pieceMoviment = new PieceMovement();
		
		Scanner sc  = new Scanner(System.in);
		
		Set<Integer> possibleMovements = new HashSet<>();
		Set<Integer> possibleKingMovements = new HashSet<>();
		
		Houses house = new Houses();
		Board board = new Board();
		String houseSorce="", houseTarget="";
		
		house.generateHouses();
		board.generatePieces();
		
		int source=0, target=0, 
				whiteKingPosition=findPiecePosition(board.getPieces(), PieceName.KING, WHITE), 
				blackKingPosition=findPiecePosition(board.getPieces(), PieceName.KING, BLACK);
		String press= "a";
		boolean invalidMoviment = false, checkmate = false, validation, once01 = true, once02= true;
		
		while(!checkmate) {

			board.showWhitePieces();
			validation = true;

			checkmate = checkRules.isCheckmate(whiteKingPosition, board, pieceMoviment.possibleMovements(whiteKingPosition, board));
			if(checkmate) break;
			
			if(roqueRules.isPossibleRoque(board, WHITE) && once01) {
				
				System.out.println("Roque is possible! Press 1 to confirm moviment or 0 to cancel");
				do {
					System.out.print("Press 1 or 0: ");
					press = sc.next();
					if(press.equals("1")) {
						roqueRules.roque(board, WHITE);
						validation = false;
						once01 = false;
						whiteKingPosition = findPiecePosition(board.getPieces(), PieceName.KING, WHITE);
						board.getPieces().get(whiteKingPosition).incrementMoveQuantity();
					}
				}while(!press.equals("1") && !press.equals("0"));
				
			} if(validation){
				do {
					do {
						System.out.print("Source: ");
						houseSorce = sc.next();
						source = house.houseForNumber(houseSorce.toUpperCase());
						possibleMovements = pieceMoviment.possibleMovements(source, board);
						
						possibleKingMovements = pieceMoviment.possibleMovements(whiteKingPosition, board);
					} while(check(whiteKingPosition, WHITE, board) && possibleKingMovements.isEmpty() && canGetTheKingOutOfCheck(possibleMovements, source, new Board(board), WHITE));
				
				} while(possibleMovements.isEmpty() || board.getPieces().get(source).isBlack());
				
				System.out.println("Possible Moviments: " + house.numbersToHouses(possibleMovements));
				
				do {
					System.out.print("Move To: ");
					houseTarget = sc.next();
					target = house.houseForNumber(houseTarget.toUpperCase());
					invalidMoviment = !possibleMovements.contains(target);
				} while(invalidMoviment);
				
				board.movePiece(source, target);
				board.getPieces().get(target).incrementMoveQuantity();
				
				whiteKingPosition = findPiecePosition(board.getPieces(), PieceName.KING, WHITE);
			}
			
			board.showBlackPieces();
			validation = true;
			
			checkmate = checkRules.isCheckmate(blackKingPosition, board, pieceMoviment.possibleMovements(whiteKingPosition, board));
			if(checkmate) break;
			
			if(roqueRules.isPossibleRoque(board, BLACK) && once02) {
				
				System.out.println("Roque is possible! Press 1 to confirm moviment or 0 to cancel");
				do {
					System.out.print("Press 1 or 0: ");
					press = sc.next();
					if(press.equals("1")) {
						roqueRules.roque(board, BLACK);
						validation = false;
						once02 = false;
						blackKingPosition = findPiecePosition(board.getPieces(), PieceName.KING, WHITE);
						board.getPieces().get(blackKingPosition).incrementMoveQuantity();
					}
				}while(!press.equals("1") && !press.equals("0"));
			} if(validation){
				do {
					
					do {
						System.out.print("Source: ");
						houseSorce = sc.next();
						source = house.houseForNumber(houseSorce.toUpperCase());
						possibleMovements = pieceMoviment.possibleMovements(source, board);
						possibleKingMovements = pieceMoviment.possibleMovements(blackKingPosition, board);
					} while(check(blackKingPosition, BLACK, board) && check(blackKingPosition, BLACK, board) && canGetTheKingOutOfCheck(possibleMovements, source, board, BLACK));
				
				} while(possibleMovements.isEmpty() || board.getPieces().get(source).isWhite());
				
				System.out.println("Possible Moviments: " + house.numbersToHouses(possibleMovements));
				
				do {
					System.out.print("Move To: ");
					houseTarget = sc.next();
					target = house.houseForNumber(houseTarget.toUpperCase());
					invalidMoviment = !possibleMovements.contains(target);
				} while(invalidMoviment);
				
				board.movePiece(source, target);
				board.getPieces().get(target).incrementMoveQuantity();
				
				blackKingPosition = findPiecePosition(board.getPieces(), PieceName.KING, BLACK);
				
			}
		}
		
		System.out.println("\nEND OF THE GAME");
		sc.close();
	}
}

