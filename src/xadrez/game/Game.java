package xadrez.game;

import static xadrez.piece.PieceMovementSettings.possibleMovements;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import xadrez.board.Board;
import xadrez.piece.Piece;

public class Game {

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		Board board = new Board();
		Piece pieceSource = new Piece();
		Piece pieceDestination = new Piece();
		
		Set<Integer> possibleMovements = new HashSet<>();
		
		boolean samePiece = false, invalidMoviment = false;
		
		board.generatePieces();
		
		while(5 > 0) {
			System.out.println();
			System.out.println("=============================================");
			board.showPiecesWithIndex();
			
			System.out.print("\nSource: ");
			int source = sc.nextByte();
			
			System.out.print("Move To: ");
			int target = sc.nextByte();
			
			pieceSource = board.getParts().get(source);
			pieceDestination= board.getParts().get(target);
			possibleMovements = possibleMovements(pieceSource, source);
			samePiece = pieceSource.getPartColor().equals(pieceDestination.getPartColor());
			invalidMoviment = !possibleMovements.contains(target);
			
			if(samePiece) {
				System.out.println("\nVocê não pode pegar sua própria peça!\n");
			} else if(invalidMoviment) {
				System.out.println("\nMovimeno inválido!\n");
			} else {
				board.movePiece(board.getParts(), source, target);
			}
		}
	}
}
