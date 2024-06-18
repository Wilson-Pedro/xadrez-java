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
		
		moves = switch(piece.getPieceName()) {
			case PAWN -> moves = pawnRules.pawnMoviments(source, pieces);
			case TOWER -> moves = towerRules.towerMoviments(source, piece.getPieceColor(), pieces);
			case HORSE -> moves = horseRules.horseMoviments(source, pieces);
			case BISHOP -> moves = bishopRules.bishopMoviments(source, piece.getPieceColor(), moves, pieces, true);
			case KING -> moves = kingRules.kingMoviments(source, piece.getPieceColor(), pieces);
			case QUEEN -> moves = queenRules.queenMoviments(source, piece.getPieceColor(), pieces);
			default -> moves;
		};
	
		if(autoincrement && !moves.isEmpty()) piece.incrementMoveQuantity();

		return moves;
	}
}
