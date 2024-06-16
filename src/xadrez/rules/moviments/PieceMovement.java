package xadrez.rules.moviments;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xadrez.interfaces.PossibleMoviments;
import xadrez.piece.Piece;

public class PieceMovement implements PossibleMoviments{
	
	private PawnMovimentsRules pawnRules;
	
	private TowerMovimentsRules towerRules;
	
	private HorseMovimentsRules horseRules;
	
	private BishopMovimentsRules bishopRules;
	
	private KingMovimentsRules kingRules;
	
	private QueenMovimentsRules queenRules;
	
	public PieceMovement(PawnMovimentsRules pawnRules, TowerMovimentsRules towerRules,
			HorseMovimentsRules horseRules, BishopMovimentsRules bishopRules, KingMovimentsRules kingRules, QueenMovimentsRules queenRules) {
		this.pawnRules = pawnRules;
		this.towerRules = towerRules;
		this.horseRules = horseRules;
		this.bishopRules = bishopRules;
		this.kingRules = kingRules;
		this.queenRules = queenRules;
	}

	@Override
	public Set<Integer> possibleMovements(int source, boolean autoincrement, List<Piece> pieces) {
		Set<Integer> moves = new HashSet<>();
		Piece piece = pieces.get(source);

		if (piece.isPawn()) {
			moves = pawnRules.pawnMoviments(source, pieces);
		} else if (piece.isTower()) {
			moves = towerRules.towerMoviments(source, piece.getPieceColor(), pieces);
		} else if (piece.isHorse()) {
			moves = horseRules.horseMoviments(source, pieces);
		} else if (piece.isBishop()) {
			moves = bishopRules.bishopMoviments(source, piece.getPieceColor(), moves, pieces, true);
		} else if (piece.isKing()) {
			moves = kingRules.kingMoviments(source, piece.getPieceColor(), pieces);
		} else if (piece.isQueen()) {
			moves = queenRules.queenMoviments(source, piece.getPieceColor(), pieces);
		}

		if(autoincrement && !moves.isEmpty()) piece.incrementMoveQuantity();

		return moves;
	}
}
