package xadrez.rules.moviments;

import static xadrez.rules.moviments.BishopMovimentsRules.bishopMovimentsWithCheckValidation;
import static xadrez.rules.moviments.HorseMovimentsRules.horseMovimentsWithCheckValidation;
import static xadrez.rules.moviments.KingMovimentsRules.kingMoviments;
import static xadrez.rules.moviments.PawnMovimentsRules.pawnMovimentsWithCheckValidation;
import static xadrez.rules.moviments.QueenMovimentsRules.queenMovimentsWithCheckValidation;
import static xadrez.rules.moviments.TowerMovimentsRules.towerMovimentsWithCheckValidation;

import java.util.HashSet;
import java.util.Set;

import xadrez.board.Board;
import xadrez.interfaces.PossibleMoviments;
import xadrez.piece.Piece;

public class PieceMovement implements PossibleMoviments{

	@Override
	public Set<Integer> possibleMovements(int source, Board board) {
		Set<Integer> moves = new HashSet<>();
		var pieces = board.getPieces();
		Piece piece = pieces.get(source);
		
		moves = switch(piece.getPieceName()) {
			case PAWN -> moves = pawnMovimentsWithCheckValidation(source, board);
			case TOWER -> moves = towerMovimentsWithCheckValidation(source, board);
			case HORSE -> moves = horseMovimentsWithCheckValidation(source, board);
			case BISHOP -> moves = bishopMovimentsWithCheckValidation(source, moves, board, true);
			case KING -> moves = kingMoviments(source, board);
			case QUEEN -> moves = queenMovimentsWithCheckValidation(source, board);
			default -> moves;
		};

		return moves;
	}
}
