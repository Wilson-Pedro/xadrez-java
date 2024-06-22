package xadrez.rules.roque;

import static xadrez.rules.check.CheckRules.check;
import static xadrez.utils.Util.containsPiece;
import static xadrez.utils.Util.isSameColor;

import java.util.List;

import xadrez.board.Board;
import xadrez.enums.PieceColor;
import xadrez.piece.Piece;

public class RoqueRules {

	public void roque(Board board, PieceColor color) {
		var pieces = board.getPieces();
		int kingPosition = kingToRoquePosition(pieces, color);
		List<Integer> towersPosition = towerToRoquePosition(pieces, color);
		List<Integer> rockMoviments = roqueMoviments(color);
		var tower01 = pieces.get(towersPosition.get(0));
		var tower02 = pieces.get(towersPosition.get(1));
		
		if(!containsPiece(rockMoviments.get(0), pieces) && !containsPiece(rockMoviments.get(1), pieces) && !containsPiece(rockMoviments.get(2), pieces)) {
			board.movePiece(pieces, kingPosition, rockMoviments.get(1));
			board.movePiece(pieces, towersPosition.get(0), rockMoviments.get(2));
			tower01.incrementMoveQuantity();
			
		} else if (!containsPiece(rockMoviments.get(3), pieces) && !containsPiece(rockMoviments.get(4), pieces)) {
			board.movePiece(pieces, kingPosition, rockMoviments.get(4));
			board.movePiece(pieces, towersPosition.get(1), rockMoviments.get(3));
			tower02.incrementMoveQuantity();
		}
	}
	
	public boolean isPossibleRoque(Board board, PieceColor color) {
		var roqueMoviments = roqueMoviments(color);
		int kingPosition = kingToRoquePosition(board.getPieces(), color);
		var towerPositions = towerToRoquePosition(board.getPieces(), color);
		var pieces = board.getPieces();
		boolean isPossibleRook = false, 
				noMovimentFromKing = pieces.get(kingPosition).noMoviment(),
				noMovimentFromTower01 = pieces.get(towerPositions.get(0)).noMoviment(),
				noMovimentFromTower02 = pieces.get(towerPositions.get(1)).noMoviment(),
				isTower01 = pieces.get(towerPositions.get(0)).isTower(),
				isTower02 = pieces.get(towerPositions.get(1)).isTower();
		
		if(noMovimentFromKing && noMovimentFromTower01 && isTower01 && !containsPiece(roqueMoviments.get(0), pieces) && !containsPiece(roqueMoviments.get(1), pieces) && !containsPiece(roqueMoviments.get(2), pieces) && pieces.get(kingPosition).isKing() ) {
			if(!notInCheckForRoque(roqueMoviments, board, kingPosition, color, true)) isPossibleRook = true;
			
		} else if (noMovimentFromKing && noMovimentFromTower02 && isTower02 && !containsPiece(roqueMoviments.get(3), pieces) && !containsPiece(roqueMoviments.get(4), pieces) && pieces.get(kingPosition).isKing()) {
			if(!notInCheckForRoque(roqueMoviments, board, kingPosition, color, false)) isPossibleRook = true;
		}
		return isPossibleRook;
	}
	
	public boolean notInCheckForRoque(List<Integer> roqueMoviments, Board board, int kingPosition, PieceColor color, boolean validation) {
		
		boolean kingCheck = check(kingPosition, color, board);
		boolean roqueMovimentsCheck01 = check(roqueMoviments.get(0), color, board);
		boolean roqueMovimentsCheck02 = check(roqueMoviments.get(1), color, board);
		boolean roqueMovimentsCheck03 = check(roqueMoviments.get(2), color, board);
		boolean roqueMovimentsCheck04 = check(roqueMoviments.get(3), color, board);
		boolean roqueMovimentsCheck05 = check(roqueMoviments.get(4), color, board);
		
		if(validation) {
			return kingCheck || roqueMovimentsCheck01 || roqueMovimentsCheck02 || roqueMovimentsCheck03;
		} else {
			return kingCheck || roqueMovimentsCheck04 || roqueMovimentsCheck05;
		}
	}
	
	public int kingToRoquePosition(List<Piece> pieces, PieceColor color) {
		int kingPosition = 0;
		if (isSameColor(color, PieceColor.WHITE) && pieces.get(60).isKing()) {
			kingPosition = 60;
		} else if(isSameColor(color, PieceColor.BLACK) && pieces.get(4).isKing()) {
			kingPosition = 4;
		}
		
		return kingPosition;
	}
	
	public List<Integer> towerToRoquePosition(List<Piece> pieces, PieceColor color) {
		List<Integer> towersPosition = List.of(56, 63);
		if(isSameColor(color, PieceColor.BLACK)) towersPosition = List.of(0, 7);
		return towersPosition;
	}
	
	public List<Integer> roqueMoviments(PieceColor color) {
		List<Integer> rockMoviments = List.of(57, 58, 59, 61, 62);
		if(isSameColor(color, PieceColor.BLACK)) rockMoviments = List.of(1, 2, 3, 5, 6);
		return rockMoviments;
	}
}
