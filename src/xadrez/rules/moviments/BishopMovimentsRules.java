package xadrez.rules.moviments;

import static xadrez.piece.moves.GenerateMove.generateBishopsMovements;
import static xadrez.utils.Util.containsPiece;
import static xadrez.utils.Util.isSameColor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xadrez.enums.PieceColor;
import xadrez.piece.Piece;
import xadrez.piece.moves.MoveBishop;

public class BishopMovimentsRules {

	public Set<Integer> bishopMoviments(int source, PieceColor color, Set<Integer> possibleMoves, List<Piece> pieces, boolean validation) {
		if(possibleMoves == null) possibleMoves = new HashSet<>();
		List<MoveBishop> bishopsMovements = generateBishopsMovements();
		MoveBishop moveBishop = bishopsMovements.get(source);
		int moviment = source;
		
		for(int i = 0; i < moveBishop.getUpperLeftDiagonalMovements(); i++) {
			if (containsPiece(moviment - 9, pieces) && validation) {
				if(!isSameColor(color, pieces.get(moviment - 9).getPieceColor())) possibleMoves.add(moviment-=9);
				i = moveBishop.getUpperLeftDiagonalMovements();
			}
			else possibleMoves.add(moviment-=9);
		}
		
		moviment = source;
		
		for(int i = 0; i < moveBishop.getUpperRightDiagonalMovements(); i++) {
			if (containsPiece(moviment - 7, pieces) && validation) {
				if(!isSameColor(color, pieces.get(moviment - 7).getPieceColor())) possibleMoves.add(moviment-=7);
				i = moveBishop.getUpperRightDiagonalMovements();
			}
			else possibleMoves.add(moviment-=7);
		}
		
		moviment = source;
		
		for(int i = 0; i < moveBishop.getLowerLeftMovements(); i++) {
			if (containsPiece(moviment + 7, pieces) && validation) {
				if(!isSameColor(color, pieces.get(moviment + 7).getPieceColor())) possibleMoves.add(moviment+=7);
				i = moveBishop.getLowerLeftMovements();
			}
			else possibleMoves.add(moviment+=7);
		}
		
		moviment = source;
		
		for(int i = 0; i < moveBishop.getLowerRightMovements(); i++) {
			if (containsPiece(moviment + 9, pieces) && validation) {
				if(!isSameColor(color, pieces.get(moviment + 9).getPieceColor())) possibleMoves.add(moviment+=9);
				i = moveBishop.getLowerRightMovements();
			}
			else possibleMoves.add(moviment+=9);
		}
		
		return possibleMoves;
	}
}