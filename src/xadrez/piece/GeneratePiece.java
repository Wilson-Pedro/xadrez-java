package xadrez.piece;

import java.util.ArrayList;
import java.util.List;

import xadrez.enums.PartColor;
import xadrez.enums.PieceName;

public class GeneratePiece {
	
	// WHITE PARTS

	// white Pawns
	public static Piece whitePawn01 = new Piece(PieceName.PAWN, PartColor.WHITE, "WP", 0);
	
	public static Piece whitePawn02 = new Piece(PieceName.PAWN, PartColor.WHITE, "WP", 0);
	
	public static Piece whitePawn03 = new Piece(PieceName.PAWN, PartColor.WHITE, "WP", 0);
	
	public static Piece whitePawn04 = new Piece(PieceName.PAWN, PartColor.WHITE, "WP", 0);
	
	public static Piece whitePawn05 = new Piece(PieceName.PAWN, PartColor.WHITE, "WP", 0);
	
	public static Piece whitePawn06 = new Piece(PieceName.PAWN, PartColor.WHITE, "WP", 0);
	
	public static Piece whitePawn07 = new Piece(PieceName.PAWN, PartColor.WHITE, "WP", 0);
	
	public static Piece whitePawn08 = new Piece(PieceName.PAWN, PartColor.WHITE, "WP", 0);
	
	// white Towers
	public static Piece whiteTower01 = new Piece(PieceName.TOWER, PartColor.WHITE, "WT", 0);
	
	public static Piece whiteTower02 = new Piece(PieceName.TOWER, PartColor.WHITE, "WT", 0);
	
	// white Horses
	public static Piece whiteHorse01 = new Piece(PieceName.HORSE, PartColor.WHITE, "WH", 0);
	
	public static Piece whiteHorse02 = new Piece(PieceName.HORSE, PartColor.WHITE, "WH", 0);
	
	// white Bishops
	public static Piece whiteBisp01 = new Piece(PieceName.BISHOP, PartColor.WHITE, "WB", 0);
	
	public static Piece whiteBisp02 = new Piece(PieceName.BISHOP, PartColor.WHITE, "WB", 0);
	
	// white Queen
	public static Piece whiteQueen01 = new Piece(PieceName.QUEEN, PartColor.WHITE, "WQ", 0);
	
	// white King
	public static Piece whiteKing01 = new Piece(PieceName.KING, PartColor.WHITE, "WK", 0);
	
	
	// BLACK PARTS

	// Black Pawns
	public static Piece BlackPawn01 = new Piece(PieceName.PAWN, PartColor.BLACK, "BP", 0);
	
	public static Piece BlackPawn02 = new Piece(PieceName.PAWN, PartColor.BLACK, "BP", 0);
	
	public static Piece BlackPawn03 = new Piece(PieceName.PAWN, PartColor.BLACK, "BP", 0);
	
	public static Piece BlackPawn04 = new Piece(PieceName.PAWN, PartColor.BLACK, "BP", 0);
	
	public static Piece BlackPawn05 = new Piece(PieceName.PAWN, PartColor.BLACK, "BP", 0);
	
	public static Piece BlackPawn06 = new Piece(PieceName.PAWN, PartColor.BLACK, "BP", 0);
	
	public static Piece BlackPawn07 = new Piece(PieceName.PAWN, PartColor.BLACK, "BP", 0);
	
	public static Piece BlackPawn08 = new Piece(PieceName.PAWN, PartColor.BLACK, "BP", 0);
	
	// Black Towers
	public static Piece BlackTower01 = new Piece(PieceName.TOWER, PartColor.BLACK, "BT", 0);
	
	public static Piece BlackTower02 = new Piece(PieceName.TOWER, PartColor.BLACK, "BT", 0);
	
	// Black Horses
	public static Piece BlackHorse01 = new Piece(PieceName.HORSE, PartColor.BLACK, "BH", 0);
	
	public static Piece BlackHorse02 = new Piece(PieceName.HORSE, PartColor.BLACK, "BH", 0);
	
	// Black Bishops
	public static Piece BlackBisp01 = new Piece(PieceName.BISHOP, PartColor.BLACK, "BB", 0);
	
	public static Piece BlackBisp02 = new Piece(PieceName.BISHOP, PartColor.BLACK, "BB", 0);
	
	// Black Queen
	public static Piece BlackQueen01 = new Piece(PieceName.QUEEN, PartColor.BLACK, "BQ", 0);
	
	// Black King
	public static Piece BlackKing01 = new Piece(PieceName.KING, PartColor.BLACK, "BK", 0);
	
	public static Piece Unnamed = new Piece(PieceName.UNNAMED, PartColor.NO_COLOR, "- ", 0);
	
	public static List<Piece> generatePieces() {
		
		List<Piece> pieces = new ArrayList<>();
		
		pieces.add(BlackTower01);
		pieces.add(BlackHorse01);
		pieces.add(BlackBisp01);
		pieces.add(BlackQueen01);
		pieces.add(BlackKing01);
		pieces.add(BlackBisp02);
		pieces.add(BlackHorse02);
		pieces.add(BlackTower02);
		
		pieces.add(BlackPawn01);
		pieces.add(BlackPawn02);
		pieces.add(BlackPawn03);
		pieces.add(BlackPawn04);
		pieces.add(BlackPawn05);
		pieces.add(BlackPawn06);
		pieces.add(BlackPawn07);
		pieces.add(BlackPawn08);
		
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		pieces.add(Unnamed);
		
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
