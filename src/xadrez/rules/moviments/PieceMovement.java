package xadrez.rules.moviments;

import static xadrez.rules.moviments.BishopMovimentsRules.bishopMoviments;
import static xadrez.rules.moviments.HorseMovimentsRules.horseMoviments;
import static xadrez.rules.moviments.KingMovimentsRules.kingMoviments;
import static xadrez.rules.moviments.PawnMovimentsRules.pawnMoviments;
import static xadrez.rules.moviments.QueenMovimentsRules.queenMoviments;
import static xadrez.rules.moviments.TowerMovimentsRules.towerMoviments;

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
			case PAWN -> moves = pawnMoviments(source, board);
			case TOWER -> moves = towerMoviments(source, piece.getPieceColor(), board);
			case HORSE -> moves = horseMoviments(source, board);
			case BISHOP -> moves = bishopMoviments(source, piece.getPieceColor(), moves, board, true);
			case KING -> moves = kingMoviments(source, piece.getPieceColor(), board);
			case QUEEN -> moves = queenMoviments(source, piece.getPieceColor(), board);
			default -> moves;
		};
	
		if(autoincrement && !moves.isEmpty()) piece.incrementMoveQuantity();

		return moves;
	}
}
