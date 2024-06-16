package xadrez.rules.moviments;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xadrez.enums.PieceColor;
import xadrez.piece.Piece;

public class QueenMovimentsRules {
	
	private TowerMovimentsRules towerRules;
	private BishopMovimentsRules bishopRules;

	public QueenMovimentsRules(TowerMovimentsRules towerRules, BishopMovimentsRules bishopRules) {
		this.towerRules = towerRules;
		this.bishopRules = bishopRules;
	}

	public Set<Integer> queenMoviments(int source, PieceColor color, List<Piece> pieces) {
		Set<Integer> possibleQueenMoves = new HashSet<>();
		possibleQueenMoves = towerRules.towerMoviments(source, color, pieces);
		possibleQueenMoves = bishopRules.bishopMoviments(source, color, possibleQueenMoves, pieces, true);
		
		return possibleQueenMoves;
	}
}
