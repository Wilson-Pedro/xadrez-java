package xadrez.rules.moviments;

import static xadrez.rules.moviments.BishopMovimentsRules.bishopMoviments;
import static xadrez.rules.moviments.TowerMovimentsRules.towerMoviments;
import static xadrez.rules.moviments.BishopMovimentsRules.bishopMovimentsWithCheckValidation;
import static xadrez.rules.moviments.TowerMovimentsRules.towerMovimentsWithCheckValidation;
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
	
	public static Set<Integer> queenMovimentsWithCheckValidation(int source, PieceColor color, Board board) {
		Set<Integer> possibleQueenMoves = new HashSet<>();
		possibleQueenMoves = towerMovimentsWithCheckValidation(source, color, board);
		possibleQueenMoves = bishopMovimentsWithCheckValidation(source, color, possibleQueenMoves, board, true);
		
		return possibleQueenMoves;
	}
}
