package xadrez.piece;

import java.util.ArrayList;
import java.util.List;

import xadrez.enums.PieceColor;
import xadrez.enums.PieceName;

public class GeneratePiece {
	
	// WHITE PARTS

	// white Pawns
	public static Piece whitePawn01 = new Piece(PieceName.PAWN, PieceColor.WHITE, "WP", 0);
	
	public static Piece whitePawn02 = new Piece(PieceName.PAWN, PieceColor.WHITE, "WP", 0);
	
	public static Piece whitePawn03 = new Piece(PieceName.PAWN, PieceColor.WHITE, "WP", 0);
	
	public static Piece whitePawn04 = new Piece(PieceName.PAWN, PieceColor.WHITE, "WP", 0);
	
	public static Piece whitePawn05 = new Piece(PieceName.PAWN, PieceColor.WHITE, "WP", 0);
	
	public static Piece whitePawn06 = new Piece(PieceName.PAWN, PieceColor.WHITE, "WP", 0);
	
	public static Piece whitePawn07 = new Piece(PieceName.PAWN, PieceColor.WHITE, "WP", 0);
	
	public static Piece whitePawn08 = new Piece(PieceName.PAWN, PieceColor.WHITE, "WP", 0);
	
	// white Towers
	public static Piece whiteTower01 = new Piece(PieceName.TOWER, PieceColor.WHITE, "WT", 0);
	
	public static Piece whiteTower02 = new Piece(PieceName.TOWER, PieceColor.WHITE, "WT", 0);
	
	// white Horses
	public static Piece whiteHorse01 = new Piece(PieceName.HORSE, PieceColor.WHITE, "WH", 0);
	
	public static Piece whiteHorse02 = new Piece(PieceName.HORSE, PieceColor.WHITE, "WH", 0);
	
	// white Bishops
	public static Piece whiteBisp01 = new Piece(PieceName.BISHOP, PieceColor.WHITE, "WB", 0);
	
	public static Piece whiteBisp02 = new Piece(PieceName.BISHOP, PieceColor.WHITE, "WB", 0);
	
	// white Queen
	public static Piece whiteQueen01 = new Piece(PieceName.QUEEN, PieceColor.WHITE, "WQ", 0);
	
	// white King
	public static Piece whiteKing01 = new Piece(PieceName.KING, PieceColor.WHITE, "WK", 0);
	
	
	// BLACK PARTS

	// Black Pawns
	public static Piece blackPawn01 = new Piece(PieceName.PAWN, PieceColor.BLACK, "BP", 0);
	
	public static Piece blackPawn02 = new Piece(PieceName.PAWN, PieceColor.BLACK, "BP", 0);
	
	public static Piece blackPawn03 = new Piece(PieceName.PAWN, PieceColor.BLACK, "BP", 0);
	
	public static Piece blackPawn04 = new Piece(PieceName.PAWN, PieceColor.BLACK, "BP", 0);
	
	public static Piece blackPawn05 = new Piece(PieceName.PAWN, PieceColor.BLACK, "BP", 0);
	
	public static Piece blackPawn06 = new Piece(PieceName.PAWN, PieceColor.BLACK, "BP", 0);
	
	public static Piece blackPawn07 = new Piece(PieceName.PAWN, PieceColor.BLACK, "BP", 0);
	
	public static Piece blackPawn08 = new Piece(PieceName.PAWN, PieceColor.BLACK, "BP", 0);
	
	// Black Tower
	public static Piece blackTower01 = new Piece(PieceName.TOWER, PieceColor.BLACK, "BT", 0);
	
	public static Piece blackTower02 = new Piece(PieceName.TOWER, PieceColor.BLACK, "BT", 0);
	
	// Black Horses
	public static Piece blackHorse01 = new Piece(PieceName.HORSE, PieceColor.BLACK, "BH", 0);
	
	public static Piece blackHorse02 = new Piece(PieceName.HORSE, PieceColor.BLACK, "BH", 0);
	
	// Black Bishops
	public static Piece blackBisp01 = new Piece(PieceName.BISHOP, PieceColor.BLACK, "BB", 0);
	
	public static Piece blackBisp02 = new Piece(PieceName.BISHOP, PieceColor.BLACK, "BB", 0);
	
	// Black Queen
	public static Piece blackQueen01 = new Piece(PieceName.QUEEN, PieceColor.BLACK, "BQ", 0);
	
	// Black King
	public static Piece blackKing01 = new Piece(PieceName.KING, PieceColor.BLACK, "BK", 0);
	
	public static Piece noPiece = new Piece(PieceName.UNNAMED, PieceColor.NO_COLOR, "- ", 0);
	
	public static List<Piece> generatePieces() {
		
		List<Piece> pieces = new ArrayList<>();
		
		pieces.add(blackTower01);
		pieces.add(blackHorse01);
		pieces.add(blackBisp01);
		pieces.add(blackQueen01);
		pieces.add(blackKing01);
		pieces.add(blackBisp02);
		pieces.add(blackHorse02);
		pieces.add(blackTower02);
		
		pieces.add(blackPawn01);
		pieces.add(blackPawn02);
		pieces.add(blackPawn03);
		pieces.add(blackPawn04);
		pieces.add(blackPawn05);
		pieces.add(blackPawn06);
		pieces.add(blackPawn07);
		pieces.add(blackPawn08);
		
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		pieces.add(noPiece);
		
		pieces.add(whitePawn01);
		pieces.add(whitePawn02);
		pieces.add(whitePawn03);
		pieces.add(whitePawn04);
		pieces.add(whitePawn05);
		pieces.add(whitePawn06);
		pieces.add(whitePawn07);
		pieces.add(whitePawn08);
		
		pieces.add(whiteTower01);
		pieces.add(whiteHorse01);
		pieces.add(whiteBisp01);
		pieces.add(whiteQueen01);
		pieces.add(whiteKing01);
		pieces.add(whiteBisp02);
		pieces.add(whiteHorse02);
		pieces.add(whiteTower02);
		
		return pieces;
	}
}
