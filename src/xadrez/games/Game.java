package xadrez.games;

import static xadrez.piece.PieceMovementSettings.possibleMovements;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import xadrez.board.Board;
import xadrez.piece.Piece;

public class Game {

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		Board board = new Board();
		Piece pieceSource = new Piece();
		Piece pieceDestination = new Piece();
		List<Integer> movements = new ArrayList<>();
		boolean samePiece = false;
		boolean invalidMoviment = false;
		board.generatePieces();
		while(5 > 0) {
			System.out.println("=============================================");
			board.showPieces();
			
			System.out.print("Source: ");
			int source = sc.nextByte();
			
			System.out.print("Move To: ");
			int target = sc.nextByte();
			
			pieceSource = board.getParts().get(source);
			pieceDestination= board.getParts().get(target);
			movements = possibleMovements(pieceSource, source);
			samePiece = pieceSource.getPartColor().equals(pieceDestination.getPartColor());
			invalidMoviment = !movements.contains(target);
			
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
