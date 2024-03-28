package xadrez.games;

import java.util.Scanner;

import xadrez.board.Board;
import xadrez.piece.Piece;

public class Game {

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		Board board = new Board();
		Piece pieceSource = new Piece();
		Piece pieceDestination = new Piece();
		board.generatePieces();
		while(5 > 0) {
			System.out.println("=============================================");
			board.showPieces();
			
			System.out.print("Part: ");
			byte source = sc.nextByte();
			
			System.out.print("Move To: ");
			byte target = sc.nextByte();
			
			pieceSource = board.getParts().get(source);
			pieceDestination= board.getParts().get(target);
			
			boolean samePiece = pieceSource.getPartColor().equals(pieceDestination.getPartColor());
			
			if(samePiece) {
				System.out.println("\nVocê não pode pegar sua própria peça!\n");
			} else {
				board.movePiece(board.getParts(), source, target);
			}
			
		}
	}
}
