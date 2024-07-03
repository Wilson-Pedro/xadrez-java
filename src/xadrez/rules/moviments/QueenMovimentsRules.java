package xadrez.rules.moviments;

import static xadrez.rules.moviments.BishopMovimentsRules.bishopMoviments;
import static xadrez.rules.moviments.BishopMovimentsRules.bishopMovimentsWithCheckValidation;
import static xadrez.rules.moviments.TowerMovimentsRules.towerMoviments;
import static xadrez.rules.moviments.TowerMovimentsRules.towerMovimentsWithCheckValidation;

import java.util.HashSet;
import java.util.Set;

import xadrez.board.Board;

public class QueenMovimentsRules {

	public static Set<Integer> queenMoviments(int source, Board board) {
		Set<Integer> possibleQueenMoves = new HashSet<>();
		possibleQueenMoves = towerMoviments(source, board);
		possibleQueenMoves = bishopMoviments(source, possibleQueenMoves, board, true);
		
		return possibleQueenMoves;
	}
	
	public static Set<Integer> queenMovimentsWithCheckValidation(int source, Board board) {
		Set<Integer> possibleQueenMoves = new HashSet<>();
		possibleQueenMoves = towerMovimentsWithCheckValidation(source, board);
		possibleQueenMoves = bishopMovimentsWithCheckValidation(source, possibleQueenMoves, board, true);
		
		return possibleQueenMoves;
	}
}
