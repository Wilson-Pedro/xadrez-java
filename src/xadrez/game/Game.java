package xadrez.game;

import static xadrez.utils.Util.findPiecePosition;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import xadrez.board.Board;
import xadrez.board.Houses;
import xadrez.enums.PieceColor;
import xadrez.enums.PieceName;
import xadrez.rules.check.CheckRules;
import xadrez.rules.moviments.BishopMovimentsRules;
import xadrez.rules.moviments.HorseMovimentsRules;
import xadrez.rules.moviments.KingMovimentsRules;
import xadrez.rules.moviments.PawnMovimentsRules;
import xadrez.rules.moviments.PieceMovement;
import xadrez.rules.moviments.QueenMovimentsRules;
import xadrez.rules.moviments.TowerMovimentsRules;
import xadrez.rules.roque.RoqueRules;

public class Game {
	
	public static PieceColor BLACK = PieceColor.BLACK;
	public static PieceColor WHITE = PieceColor.WHITE;

	public static void main(String[] args) {
		
		PawnMovimentsRules pawnRules = new PawnMovimentsRules();
		TowerMovimentsRules towerRules = new TowerMovimentsRules();
		HorseMovimentsRules horseRules = new HorseMovimentsRules();
		BishopMovimentsRules bishopRules = new BishopMovimentsRules();
		QueenMovimentsRules queenRules = new QueenMovimentsRules(towerRules, bishopRules);
		CheckRules checkRules = new CheckRules(pawnRules, towerRules, horseRules, bishopRules, queenRules);
		RoqueRules roqueRules = new RoqueRules(checkRules);
		KingMovimentsRules kingRules = new KingMovimentsRules(checkRules);
		PieceMovement pieceMoviment = new PieceMovement(pawnRules, towerRules, horseRules, bishopRules, kingRules, queenRules);
		
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

			checkmate = checkRules.isCheckmate(whiteKingPosition, board, WHITE, pieceMoviment.possibleMovements(whiteKingPosition, false, board.getPieces()));
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
						possibleMovements = pieceMoviment.possibleMovements(source, true, board.getPieces());
						
						possibleKingMovements = pieceMoviment.possibleMovements(whiteKingPosition, false, board.getPieces());
					} while(checkRules.check(whiteKingPosition, WHITE, board.getPieces()) && possibleKingMovements.isEmpty() && checkRules.canGetTheKingOutOfCheck(possibleMovements, source, whiteKingPosition, new Board(board), WHITE));
				
				} while(possibleMovements.isEmpty() || board.getPieces().get(source).isBlack());
				
				System.out.println("Possible Moviments: " + house.numbersToHouses(possibleMovements));
				
				do {
					System.out.print("Move To: ");
					houseTarget = sc.next();
					target = house.houseForNumber(houseTarget.toUpperCase());
					invalidMoviment = !possibleMovements.contains(target);
				} while(invalidMoviment);
				
				board.movePiece(board.getPieces(), source, target);
				
				whiteKingPosition = findPiecePosition(board.getPieces(), PieceName.KING, WHITE);
			}
			
			System.out.println();
			System.out.println("=============================================");
			board.showBlackPieces();
			System.out.println("\n");
			validation = true;
			
			checkmate = checkRules.isCheckmate(blackKingPosition, board, BLACK, pieceMoviment.possibleMovements(whiteKingPosition, false, board.getPieces()));
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
						possibleMovements = pieceMoviment.possibleMovements(source, true, board.getPieces());
						possibleKingMovements = pieceMoviment.possibleMovements(blackKingPosition, false, board.getPieces());
					} while(checkRules.check(blackKingPosition, BLACK, board.getPieces()) && checkRules.check(blackKingPosition, BLACK, board.getPieces()) && checkRules.canGetTheKingOutOfCheck(possibleMovements, source, blackKingPosition, board, BLACK));
				
				} while(possibleMovements.isEmpty() || board.getPieces().get(source).isWhite());
				
				System.out.println("Possible Moviments: " + house.numbersToHouses(possibleMovements));
				
				do {
					System.out.print("Move To: ");
					houseTarget = sc.next();
					target = house.houseForNumber(houseTarget.toUpperCase());
					invalidMoviment = !possibleMovements.contains(target);
				} while(invalidMoviment);
				
				board.movePiece(board.getPieces(), source, target);
				
				blackKingPosition = findPiecePosition(board.getPieces(), PieceName.KING, BLACK);
				
			}
		}
		
		System.out.println("\n\nEND OF THE GAME");
		sc.close();
	}
}

