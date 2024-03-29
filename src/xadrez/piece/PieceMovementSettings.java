package xadrez.piece;

import java.util.HashSet;
import java.util.Set;

public class PieceMovementSettings {

	public static Set<Integer> possibleMovements(Piece piece, int source) {
		
		Set<Integer> movements = new HashSet<>();
		
		int moviment = 0;
		boolean thereAreMoves = true;
		
		if(piece.isPawn()) {
			movements.add(source - 8);
			if(piece.getMoveQuantity() == 0)
				movements.add(source - (8*2));
		
		} else if (piece.isTower()) {
			moviment = source;
			while(thereAreMoves) {
				if(moviment > 0)
					moviment -= 8;
				else
					thereAreMoves = false;
				movements.add(moviment);
				
			}
		}
		
		piece.incrementMoveQuantity();
		return movements;
	}
}
