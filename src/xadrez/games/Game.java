package xadrez.games;

import java.util.Scanner;

import xadrez.board.Board;

public class Game {

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		Board board = new Board();
		board.generateParts();
		while(5 > 0) {
			System.out.println("=============================================");
			board.showParts();
			
			System.out.print("Part: ");
			byte source = sc.nextByte();
			System.out.print("Move To: ");
			byte target = sc.nextByte();
			
			boolean samePiece = board.getParts().get(source).getPartColor().equals(board.getParts().get(target).getPartColor());
			
			if(samePiece) {
				System.out.println("Você não pode pegar sua própria peça!\n");
			} else {
				board.move(board.getParts(), source, target);
			}
			
		}
	}
}
