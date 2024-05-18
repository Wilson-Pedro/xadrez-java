package xadrez.utlis;

import static xadrez.piece.GeneratePiece.Unnamed;

import java.util.List;

import xadrez.enums.PieceColor;
import xadrez.enums.PieceName;
import xadrez.piece.Piece;

public class Validations {

	public static boolean containsPieceAndisDifferentColor(int source, int destination, List<Piece> pieces) {
		return (containsPiece(destination, pieces) || !containsPiece(destination, pieces)) && !isSameColor(source, destination, pieces);
	}
	
	public static boolean isSameColor(int source, int destination, List<Piece> pieces) {
		return pieces.get(source).getPieceColor().equals(pieces.get(destination).getPieceColor());
	}
	
	public static boolean isSameColor(PieceColor color1, PieceColor color2) {
		return color1.equals(color2);
	}
	
	public static boolean containsPiece(int destination, List<Piece> pieces) {
		var piece = pieces.get(destination);
		return piece.isWhite() || piece.isBlack();
	}
	
	public static boolean containsPieceInPosition(int position, List<Piece> pieces) {
		return pieces.contains(pieces.get(position)) && !pieces.get(position).equals(Unnamed);
	}
	
	public static boolean pieceIs(List<Piece> pieces, int source, PieceName pieceName) {
		return pieces.get(source).getPieceName().equals(pieceName);
	}
}