package xadrez.piece;

import java.util.ArrayList;
import java.util.List;

public class PieceMovementSettings {

	public static List<Integer> possibleMovements(Piece piece, int source) {
		
		List<Integer> movements = new ArrayList<>();
		
		if(piece.isPawn()) {
			movements.add(source - 8);
			if(piece.getMoveQuantity() == 0)
				movements.add(source - (8*2));
		}
		
		piece.incrementMoveQuantity();
		return movements;
	}
}
