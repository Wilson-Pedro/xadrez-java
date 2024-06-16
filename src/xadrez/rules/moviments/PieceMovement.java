package xadrez.rules.moviments;

import static xadrez.utils.Util.isSameColor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xadrez.board.Board;
import xadrez.enums.PieceColor;
import xadrez.interfaces.PossibleMoviments;
import xadrez.piece.Piece;
import xadrez.rules.check.CheckRules;

public class PieceMovement implements PossibleMoviments{
	
	CheckRules checkRules = new CheckRules();
	PawnMovimentsRules pawnRules = new PawnMovimentsRules();
	TowerMovimentsRules towerRules = new TowerMovimentsRules();
	HorseMovimentsRules horseRules = new HorseMovimentsRules();
	BishopMovimentsRules bishopRules = new BishopMovimentsRules();
	KingMovimentsRules kingRules = new KingMovimentsRules(checkRules);
	QueenMovimentsRules queenRules = new QueenMovimentsRules(towerRules, bishopRules);

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
