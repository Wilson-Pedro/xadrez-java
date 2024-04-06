package xadrez.piece.moves;

import java.util.List;

public class GenerateMove {

	public static List<MoveBishop> generateBishopsMovements() {
		
		List<MoveBishop> bishopsMovements = List.of(
				// 0 a 7
				new MoveBishop(0, 0, 0, 0, 7),
				new MoveBishop(1, 0, 0, 1, 6),
				new MoveBishop(2, 0, 0, 2, 5),
				new MoveBishop(3, 0, 0, 3, 4),
				new MoveBishop(4, 0, 0, 4, 3),
				new MoveBishop(5, 0, 0, 5, 2),
				new MoveBishop(6, 0, 0, 6, 1),
				new MoveBishop(7, 0, 0, 7, 0)
		);
		
		return bishopsMovements;
	}
}
