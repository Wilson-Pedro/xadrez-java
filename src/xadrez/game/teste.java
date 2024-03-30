package xadrez.game;

import java.util.List;

import xadrez.piece.Move;
import xadrez.piece.PieceMovementSettings;

public class teste {

	public static void main(String[] args) {
		
		PieceMovementSettings movementSetting = new PieceMovementSettings();
		
		List<Move> moves = movementSetting.movesPossibleToLeftAndRight();
		
		moves.stream().forEach(System.out::println);

	}

}
