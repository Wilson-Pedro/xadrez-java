package xadrez.rules;

import static xadrez.board.HousesFromBoard.generateLeftSideHouses;
import static xadrez.board.HousesFromBoard.generateRightSideHouses;
import static xadrez.utlis.Validations.containsPiece;
import static xadrez.utlis.Validations.containsPieceInPosition;
import static xadrez.utlis.Validations.isSameColor;
import static xadrez.utlis.Validations.pieceIs;

import java.util.List;
import java.util.Set;

import xadrez.enums.PieceColor;
import xadrez.enums.PieceName;
import xadrez.piece.Piece;

public class CheckRules {

	public static boolean isCheckInPosition(Set<Integer> moviments, int source, PieceName pieceName, PieceColor color, List<Piece> pieces) {
		boolean check = false;
		var piece = new Piece();
		int count = 0;
		for(Integer x : moviments) {
			piece = pieces.get(x);
			if(count == 0) {
				if(containsPieceInPosition(source, pieces) && !isSameColor(color, piece.getPieceColor())) check = false;
				count++;
			}
			if(containsPiece(x, pieces) && !isSameColor(color, piece.getPieceColor()) && piece.getPieceName().equals(pieceName)) check = true;
		}
		return check;
	}
	
	public static boolean isPawnTopCheck(int source, List<Piece> pieces, PieceColor color) {
		boolean pawnCheck = false;
		int moviment2 = source - 16;
		if (isSameColor(color, PieceColor.BLACK)) moviment2 = source;
		if (containsPiece(moviment2 + 1, pieces) && !isSameColor(source, (moviment2 + 1), pieces) && !generateLeftSideHouses().contains(moviment2 + 1) && pieceIs(pieces, moviment2 + 1, PieceName.PAWN)) pawnCheck = true;
		if (containsPiece(moviment2 - 1, pieces) && !isSameColor(source, (moviment2 - 1), pieces) && !generateRightSideHouses().contains(moviment2 - 1) && pieceIs(pieces, moviment2 - 1, PieceName.PAWN)) pawnCheck = true;
		
		return pawnCheck;
	}
	
	public static boolean isPawnTopRightCheck(int source, List<Piece> pieces, PieceColor color) {
		boolean pawnCheck = false;
		int moviment2 = source - 16;
		if (isSameColor(color, PieceColor.BLACK)) moviment2 = source + 2;
		if (containsPiece(moviment2, pieces) && !isSameColor(source, (moviment2), pieces) && !generateRightSideHouses().contains(moviment2) && pieceIs(pieces, moviment2, PieceName.PAWN)) pawnCheck = true;
		if (containsPiece(moviment2 + 2, pieces) && !isSameColor(source, (moviment2 + 2), pieces) && !generateLeftSideHouses().contains(moviment2 + 2) && pieceIs(pieces, moviment2 + 2, PieceName.PAWN)) pawnCheck = true;
		
		return pawnCheck;
	}
	
	public static boolean isPawnTopLeftCheck(int source, List<Piece> pieces, PieceColor color) {
		boolean pawnCheck = false;
		int moviment2 = source - 16;
		if (isSameColor(color, PieceColor.BLACK)) moviment2 = source - 2;
		if (containsPiece(moviment2, pieces) && !isSameColor(source, (moviment2), pieces) && !generateRightSideHouses().contains(moviment2) && pieceIs(pieces, moviment2, PieceName.PAWN)) pawnCheck = true;
		if (containsPiece(moviment2 - 2, pieces) && !isSameColor(source, (moviment2 - 2), pieces) && !generateLeftSideHouses().contains(moviment2 - 2) && pieceIs(pieces, moviment2 - 2, PieceName.PAWN)) pawnCheck = true;
		
		return pawnCheck;
	}
	
	public static boolean isPawnDawnCheck(int source, List<Piece> pieces, PieceColor color) {
		boolean pawnCheck = false;
		int moviment1 = source;
		if (isSameColor(color, PieceColor.BLACK)) moviment1 = source + 16;
		if (containsPiece(moviment1 + 1, pieces) && !isSameColor(source, (moviment1 + 1), pieces) && !generateLeftSideHouses().contains(moviment1 + 1) && pieceIs(pieces, moviment1 + 1, PieceName.PAWN)) pawnCheck = true;
		if (containsPiece(moviment1 - 1, pieces) && !isSameColor(source, (moviment1 - 1), pieces) && !generateRightSideHouses().contains(moviment1 - 1) && pieceIs(pieces, moviment1 - 1, PieceName.PAWN)) pawnCheck = true;
		
		return pawnCheck;
	}
	
	public static boolean isPawnDawnRightCheck(int source, List<Piece> pieces, PieceColor color) {
		boolean pawnCheck = false;
		int moviment1 = source + 2;
		if (isSameColor(color, PieceColor.BLACK)) moviment1 = source + 18;
		if (containsPiece(moviment1, pieces) && !isSameColor(source, (moviment1), pieces) && !generateLeftSideHouses().contains(moviment1) && pieceIs(pieces, moviment1, PieceName.PAWN)) pawnCheck = true;
		
		return pawnCheck;
	}
	
	public static boolean isPawnDawnLeftCheck(int source, List<Piece> pieces, PieceColor color) {
		boolean pawnCheck = false;
		int moviment1 = source - 2;
		if (isSameColor(color, PieceColor.BLACK)) moviment1 = source + 14;
		if (containsPiece(moviment1, pieces) && !isSameColor(source, (moviment1), pieces) && !generateLeftSideHouses().contains(moviment1) && pieceIs(pieces, moviment1, PieceName.PAWN)) pawnCheck = true;
		
		return pawnCheck;
	}
	
	public static boolean isPawnRightCheck(int source, List<Piece> pieces, PieceColor color) {
		boolean pawnRightCheck = false;
		int moviment = source - 6;
		if (isSameColor(color, PieceColor.BLACK)) moviment = source + 6; 
		if (containsPiece(moviment, pieces) && !isSameColor(source, (moviment), pieces) && !generateLeftSideHouses().contains(moviment) && pieceIs(pieces, moviment, PieceName.PAWN)) pawnRightCheck = true;
		
		return pawnRightCheck;
	}
	
	public static boolean isPawnLeftCheck(int source, List<Piece> pieces, PieceColor color) {
		boolean pawnLeftCheck = false;
		int moviment = source - 10;
		if (isSameColor(color, PieceColor.BLACK)) moviment = source + 10; 
		if (containsPiece(moviment, pieces) && !isSameColor(source, (moviment), pieces) && !generateRightSideHouses().contains(moviment) && pieceIs(pieces, moviment, PieceName.PAWN)) pawnLeftCheck = true;
		
		return pawnLeftCheck;
	}
}
