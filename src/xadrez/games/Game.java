package xadrez.games;

import xadrez.board.Board;

public class Game {

	public static void main(String[] args) {
		
		Board board = new Board();
		
		board.generateParts();
		board.showParts();
		
		
	}
}
