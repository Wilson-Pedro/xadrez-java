package xadrez.game;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import xadrez.board.Board;
import xadrez.piece.PieceMovementSettings;

public class Game {

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		Set<Integer> possibleMovements = new HashSet<>();
		
		PieceMovementSettings movementSetting = new PieceMovementSettings();
		Board board = new Board();
		
		int source=0, target=0;
		
		boolean invalidMoviment = false;
		
		board.generatePieces();
		
		while(5 > 0) {
			System.out.println();
			System.out.println("=============================================");
			board.showWhitePiecesWithIndex();
			
			do {
				System.out.print("Source: ");
				source = sc.nextByte();
				possibleMovements = movementSetting.possibleMovements(board.getPieces().get(source), source, board.getPieces());
			} while(possibleMovements.isEmpty());
			
			System.out.println("Possible Moviments: " + possibleMovements);
			
			do {
				System.out.print("Move To: ");
				target = sc.nextByte();
				invalidMoviment = !possibleMovements.contains(target);
			} while(invalidMoviment);
			
			board.movePiece(board.getPieces(), source, target);
			
			System.out.println();
			System.out.println("=============================================");
			board.showBlackPiecesWithIndex();
			
			do {
				System.out.print("Source: ");
				source = sc.nextByte();
				possibleMovements = movementSetting.possibleMovements(board.getPieces().get(source), source, board.getPieces());
			} while(possibleMovements.isEmpty());
			
			System.out.println("Possible Moviments: " + possibleMovements);
			
			do {
				System.out.print("Move To: ");
				target = sc.nextByte();
				invalidMoviment = !possibleMovements.contains(target);
			} while(invalidMoviment);		
			
			board.movePiece(board.getPieces(), source, target);
		}
	}
}