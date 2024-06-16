package xadrez.rules.moviments;

import static xadrez.board.HousesFromBoard.generateLeftSideHouses;
import static xadrez.board.HousesFromBoard.generateRightSideHouses;
import static xadrez.utils.Util.containsPiece;
import static xadrez.utils.Util.isSameColor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xadrez.piece.Piece;

public class PawnMovimentsRules {

	public Set<Integer> pawnMoviments(int source, List<Piece> pieces) {
		
		Set<Integer> possiblePawnMoves = new HashSet<>();
		
		int moviment = source - 8;
		
		var piece = pieces.get(source);
		
		if (piece.isBlack()) moviment = source + 8;
		if (!isSameColor(source, (moviment), pieces) && !containsPiece(moviment, pieces)) possiblePawnMoves.add(moviment);
		if (!isSameColor(source, (moviment + 1), pieces) && containsPiece(moviment + 1, pieces) && !generateLeftSideHouses().contains(moviment + 1)) possiblePawnMoves.add(moviment + 1);
		if (!isSameColor(source, (moviment - 1), pieces) && containsPiece(moviment - 1, pieces) && !generateRightSideHouses().contains(moviment - 1)) possiblePawnMoves.add(moviment - 1);
		if (piece.getMoveQuantity() == 0 && !piece.isWhite() && !containsPiece(moviment, pieces) && !containsPiece(source + (8 * 2), pieces) && !isSameColor(source, (source + (8 * 2)), pieces)) possiblePawnMoves.add(source + (8 * 2));
		if (piece.getMoveQuantity() == 0 && !piece.isBlack() && !containsPiece(moviment, pieces) && !containsPiece(source - (8 * 2), pieces) && !isSameColor(source, (source - (8 * 2)), pieces)) possiblePawnMoves.add(source - (8 * 2));
		
		return possiblePawnMoves;
	}
}
