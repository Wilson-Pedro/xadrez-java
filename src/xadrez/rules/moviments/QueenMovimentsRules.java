package xadrez.rules.moviments;

import static xadrez.rules.moviments.BishopMovimentsRules.bishopMoviments;
import static xadrez.rules.moviments.TowerMovimentsRules.towerMoviments;
import java.util.HashSet;
import java.util.Set;

import xadrez.board.Board;
import xadrez.enums.PieceColor;

public class QueenMovimentsRules {

	public static Set<Integer> queenMoviments(int source, PieceColor color, Board board) {
		Set<Integer> possibleQueenMoves = new HashSet<>();
		possibleQueenMoves = towerMoviments(source, color, board);
		possibleQueenMoves = bishopMoviments(source, color, possibleQueenMoves, board, true);
		
		return possibleQueenMoves;
	}
}
