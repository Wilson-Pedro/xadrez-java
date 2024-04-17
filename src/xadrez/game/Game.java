package xadrez.game;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import xadrez.board.Board;
import xadrez.piece.Piece;
import xadrez.piece.PieceMovementSettings;

public class Game {

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		Board board = new Board();
		PieceMovementSettings movementSetting = new PieceMovementSettings();
		Piece pieceSource = new Piece();
		Piece pieceDestination = new Piece();
		int source=0, target=0;
		
		Set<Integer> possibleMovements = new HashSet<>();
		
		boolean samePiece = false, invalidMoviment = false;
		
		board.generatePieces();
		
		while(5 > 0) {
			System.out.println();
			System.out.println("=============================================");
			board.showWhitePiecesWithIndex();
			
			System.out.print("\n\nSource: ");
			source = sc.nextByte();
			
			pieceSource = board.getPieces().get(source);
			possibleMovements = movementSetting.possibleMovements(pieceSource, source, board.getPieces());
			System.out.println("Possible Moviments: " + possibleMovements);
			
			System.out.print("Move To: ");
			target = sc.nextByte();
			
			pieceDestination= board.getPieces().get(target);
			samePiece = pieceSource.getPartColor().equals(pieceDestination.getPartColor());
			invalidMoviment = !possibleMovements.contains(target);
			
			
			if(samePiece) {
				System.out.println("\nVocê não pode pegar sua própria peça!\n");
			} else if(invalidMoviment) {
				System.out.println("\nMovimeno inválido!\n");
			} else {
				board.movePiece(board.getPieces(), source, target);
			}
			
			System.out.println();
			System.out.println("=============================================");
			board.showBlackPiecesWithIndex();
			
			System.out.print("\n\nSource: ");
			source = sc.nextByte();
			
			pieceSource = board.getPieces().get(source);
			possibleMovements = movementSetting.possibleMovements(pieceSource, source, board.getPieces());
			System.out.println("Possible Moviments: " + possibleMovements);
			
			System.out.print("Move To: ");
			target = sc.nextByte();
			
			pieceDestination= board.getPieces().get(target);
			samePiece = pieceSource.getPartColor().equals(pieceDestination.getPartColor());
			invalidMoviment = !possibleMovements.contains(target);
			
			
			if(samePiece) {
				System.out.println("\nVocê não pode pegar sua própria peça!\n");
			} else if(invalidMoviment) {
				System.out.println("\nMovimeno inválido!\n");
			} else {
				board.movePiece(board.getPieces(), source, target);
			}
		}
	}
}
