package xadrez.rules.moviments;

import static xadrez.rules.check.CheckRules.isCheck;
import static xadrez.utils.Util.containsPiece;
import static xadrez.utils.Util.isSameColor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xadrez.board.Board;
import xadrez.enums.PieceColor;
import xadrez.piece.moves.MoveBishop;

public class BishopMovimentsRules {

	public static Set<Integer> bishopMoviments(int source, PieceColor color, Set<Integer> possibleMoves, Board board, boolean validation) {
		if(possibleMoves == null) possibleMoves = new HashSet<>();
		List<MoveBishop> bishopsMovements = bishopsMoviments();
		MoveBishop moveBishop = bishopsMovements.get(source);
		var pieces = board.getPieces();
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
	
	public static Set<Integer> bishopMovimentsWithCheckValidation(int source, PieceColor color, Set<Integer> possibleMoves, Board board, boolean validation) {
		if(possibleMoves == null) possibleMoves = new HashSet<>();
		List<MoveBishop> bishopsMovements = bishopsMoviments();
		MoveBishop moveBishop = bishopsMovements.get(source);
		var pieces = board.getPieces();
		int moviment = source;
		
		for(int i = 0; i < moveBishop.getUpperLeftDiagonalMovements(); i++) {
			if (containsPiece(moviment - 9, pieces) && validation) {
				if(!isSameColor(color, pieces.get(moviment - 9).getPieceColor()) && !isCheck(source, moviment - 9, board, color)) possibleMoves.add(moviment-=9);
				i = moveBishop.getUpperLeftDiagonalMovements();
			}
			else if(!isCheck(source, moviment - 9, board, color)) {
				possibleMoves.add(moviment-=9);
			} else {
				moviment-=9;
			}
		}
		
		moviment = source;
		
		for(int i = 0; i < moveBishop.getUpperRightDiagonalMovements(); i++) {
			if (containsPiece(moviment - 7, pieces) && validation) {
				if(!isSameColor(color, pieces.get(moviment - 7).getPieceColor()) && !isCheck(source, moviment - 7, board, color)) possibleMoves.add(moviment-=7);
				i = moveBishop.getUpperRightDiagonalMovements();
			}
			else if(!isCheck(source, moviment - 7, board, color)) {
				possibleMoves.add(moviment-=7);
			}else {
				moviment-=7;
			}
		}
		
		moviment = source;
		
		for(int i = 0; i < moveBishop.getLowerLeftMovements(); i++) {
			if (containsPiece(moviment + 7, pieces) && validation) {
				if(!isSameColor(color, pieces.get(moviment + 7).getPieceColor()) && !isCheck(source, moviment + 7, board, color)) possibleMoves.add(moviment+=7);
				i = moveBishop.getLowerLeftMovements();
			}
			else if (!isCheck(source, moviment + 7, board, color)) {
				possibleMoves.add(moviment+=7);
			}else {
				moviment+=7;
			}
		}
		
		moviment = source;
		
		for(int i = 0; i < moveBishop.getLowerRightMovements(); i++) {
			if (containsPiece(moviment + 9, pieces) && validation) {
				if(!isSameColor(color, pieces.get(moviment + 9).getPieceColor()) && !isCheck(source, moviment + 9, board, color)) possibleMoves.add(moviment+=9);
				i = moveBishop.getLowerRightMovements();
			}
			else if (!isCheck(source, moviment + 9, board, color)) {
				possibleMoves.add(moviment+=9);
			}else {
				moviment+=9;
			}
		}
		
		return possibleMoves;
	}
	
	public static List<MoveBishop> bishopsMoviments() {
		List<MoveBishop> bishopMoves = new ArrayList<>();
		
		List<Integer> upperDiagonalMoviments =  upperDiagonalMoviments();
		List<Integer> lowerDiagonalMoviments =  lowerDiagonalMoviments();
		List<Integer> upperDiagonalMovimentsInversed = reverseList(upperDiagonalMoviments);
		List<Integer> lowerDiagonalmovimentsInversed = reverseList(lowerDiagonalMoviments);
		
		for(int i = 0; i <= 63; i++) {
			bishopMoves.add(new MoveBishop(i, 
					upperDiagonalMoviments.get(i), 
					upperDiagonalMovimentsInversed.get(i),  
					lowerDiagonalmovimentsInversed.get(i),
					lowerDiagonalMoviments.get(i)));
		}
		
		return bishopMoves;
	}
	
	public static List<Integer> upperDiagonalMoviments() {
		List<Integer> upperDiagonalMoviments = new ArrayList<>();
		int upperDiagonalMoviment = 0, count = 0, totalCount = 0, index = 0;
		for(int i = 0; i <= 63; i++) {
			
			if(i >= 9 && count < totalCount) upperDiagonalMoviment++;
			
			if(i == index) {
				upperDiagonalMoviment = 0;
				index += 8;
				totalCount++;
				count = 0;
			}
			
			upperDiagonalMoviments.add(upperDiagonalMoviment);
			count++;
		}
		
		return upperDiagonalMoviments;
	}
	
	public static List<Integer> lowerDiagonalMoviments() {
		List<Integer> bishopMoves = new ArrayList<>();
		int lowerDiagonalMoviment = 7, count = 0, totalCount = 0, aux = 1, index = 8;
		for(int i = 0; i <= 63; i++) {	
			if(i == index) {
				lowerDiagonalMoviment = 7 - aux;
				index += 8;
				totalCount++;
				count = 0;
				aux++;
			}
			
			if(count > totalCount) lowerDiagonalMoviment--;
			
			bishopMoves.add(lowerDiagonalMoviment);
			count++;
		}
		
		return bishopMoves;
	}
	
	public static List<Integer> reverseList(List<Integer> list) {
		int index=7, auxIndex = index, end = -1;
		List<Integer> movesInversed = new ArrayList<>();
		for(int i = 0; i <= 63; i++) {
			movesInversed.add(list.get(index));
			index--;
			if(index == end) {
				auxIndex += 8;
				end += 8;
				if(auxIndex == 64) {
					auxIndex--;
					end--;
				}
				index = auxIndex;
			}
		}
		return movesInversed;
	}
}
