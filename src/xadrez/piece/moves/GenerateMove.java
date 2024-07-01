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
				new MoveBishop(7, 0, 0, 7, 0),
				
				// 8 a 15
				new MoveBishop(8, 0, 1, 0, 6),
				new MoveBishop(9, 1, 1, 1, 6),
				new MoveBishop(10, 1, 1, 2, 5),
				new MoveBishop(11, 1, 1, 3, 4),
				new MoveBishop(12, 1, 1, 4, 3),
				new MoveBishop(13, 1, 1, 5, 2),
				new MoveBishop(14, 1, 1, 6, 1),
				new MoveBishop(15, 1, 0, 6, 0),
				
				// 16 a 23
				new MoveBishop(16, 0, 2, 0, 5),
				new MoveBishop(17, 1, 2, 1, 5),
				new MoveBishop(18, 2, 2, 2, 5),
				new MoveBishop(19, 2, 2, 3, 4),
				new MoveBishop(20, 2, 2, 4, 3),
				new MoveBishop(21, 2, 2, 5, 2),
				new MoveBishop(22, 2, 1, 5, 1),
				new MoveBishop(23, 2, 0, 5, 0),
				
				// 24 a 31
				new MoveBishop(24, 0, 3, 0, 4),
				new MoveBishop(25, 1, 3, 1, 4),
				new MoveBishop(26, 2, 3, 2, 4),
				new MoveBishop(27, 3, 3, 3, 4),
				new MoveBishop(28, 3, 3, 4, 3),
				new MoveBishop(29, 3, 2, 4, 2),
				new MoveBishop(30, 3, 1, 4, 1),
				new MoveBishop(31, 3, 0, 4, 0),
				
				// 32 a 39
				new MoveBishop(32, 0, 4, 0, 3),
				new MoveBishop(33, 1, 4, 1, 3),
				new MoveBishop(34, 2, 4, 2, 3),
				new MoveBishop(35, 3, 4, 3, 3),
				new MoveBishop(36, 4, 3, 3, 3),
				new MoveBishop(37, 4, 2, 3, 2),
				new MoveBishop(38, 4, 1, 3, 1),
				new MoveBishop(39, 4, 0, 3, 0),
				
				// 40 a 47
				new MoveBishop(40, 0, 5, 0, 2),
				new MoveBishop(41, 1, 5, 1, 2),
				new MoveBishop(42, 2, 5, 2, 2),
				new MoveBishop(43, 3, 4, 2, 2),
				new MoveBishop(44, 4, 3, 2, 2),
				new MoveBishop(45, 5, 2, 2, 2),
				new MoveBishop(46, 5, 1, 2, 1),
				new MoveBishop(47, 5, 0, 2, 0),
				
				// 48 a 55
				new MoveBishop(48, 0, 6, 0, 1),
				new MoveBishop(49, 1, 6, 1, 1),
				new MoveBishop(50, 2, 5, 1, 1),
				new MoveBishop(51, 3, 4, 1, 1),
				new MoveBishop(52, 4, 3, 1, 1),
				new MoveBishop(53, 5, 2, 1, 1),
				new MoveBishop(54, 6, 1, 2, 1),
				new MoveBishop(55, 6, 0, 1, 0),
				
				// 56 a 63
				new MoveBishop(56, 0, 7, 0, 0),
				new MoveBishop(57, 1, 6, 0, 0),
				new MoveBishop(58, 2, 5, 0, 0),
				new MoveBishop(59, 3, 4, 0, 0),
				new MoveBishop(60, 4, 3, 0, 0),
				new MoveBishop(61, 5, 2, 0, 0),
				new MoveBishop(62, 6, 1, 0, 0),
				new MoveBishop(63, 7, 0, 0, 0)
		);
		
		return bishopsMovements;
	}
}
