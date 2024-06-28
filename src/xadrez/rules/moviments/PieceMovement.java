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
	public Set<Integer> possibleMovements(int source, boolean autoincrement, Board board) {
		Set<Integer> moves = new HashSet<>();
		var pieces = board.getPieces();
		Piece piece = pieces.get(source);
		
		moves = switch(piece.getPieceName()) {
			case PAWN -> moves = pawnMovimentsWithCheckValidation(source, board);
			case TOWER -> moves = towerMovimentsWithCheckValidation(source, piece.getPieceColor(), board);
			case HORSE -> moves = horseMovimentsWithCheckValidation(source, board);
			case BISHOP -> moves = bishopMovimentsWithCheckValidation(source, piece.getPieceColor(), moves, board, true);
			case KING -> moves = kingMoviments(source, piece.getPieceColor(), board);
			case QUEEN -> moves = queenMovimentsWithCheckValidation(source, piece.getPieceColor(), board);
			default -> moves;
		};
	
		if(autoincrement && !moves.isEmpty()) piece.incrementMoveQuantity();

		return moves;
	}
}
