package xadrez.piece;

import java.util.ArrayList;
import java.util.List;

import xadrez.enums.PartColor;
import xadrez.enums.PartName;

public class GenerateParts {
	
	// WHITE PARTS

	// white Pawns
	public static Piece whitePawn01 = new Piece(PartName.PAWN, null, PartColor.WHITE, "WP", 0);
	
	public static Piece whitePawn02 = new Piece(PartName.PAWN, null, PartColor.WHITE, "WP", 0);
	
	public static Piece whitePawn03 = new Piece(PartName.PAWN, null, PartColor.WHITE, "WP", 0);
	
	public static Piece whitePawn04 = new Piece(PartName.PAWN, null, PartColor.WHITE, "WP", 0);
	
	public static Piece whitePawn05 = new Piece(PartName.PAWN, null, PartColor.WHITE, "WP", 0);
	
	public static Piece whitePawn06 = new Piece(PartName.PAWN, null, PartColor.WHITE, "WP", 0);
	
	public static Piece whitePawn07 = new Piece(PartName.PAWN, null, PartColor.WHITE, "WP", 0);
	
	public static Piece whitePawn08 = new Piece(PartName.PAWN, null, PartColor.WHITE, "WP", 0);
	
	// white Towers
	public static Piece whiteTower01 = new Piece(PartName.TOWER, null, PartColor.WHITE, "WT", 0);
	
	public static Piece whiteTower02 = new Piece(PartName.TOWER, null, PartColor.WHITE, "WT", 0);
	
	// white Horses
	public static Piece whiteHorse01 = new Piece(PartName.HORSE, null, PartColor.WHITE, "WH", 0);
	
	public static Piece whiteHorse02 = new Piece(PartName.HORSE, null, PartColor.WHITE, "WH", 0);
	
	// white Bishops
	public static Piece whiteBisp01 = new Piece(PartName.BISHOP, null, PartColor.WHITE, "WB", 0);
	
	public static Piece whiteBisp02 = new Piece(PartName.BISHOP, null, PartColor.WHITE, "WB", 0);
	
	// white Queen
	public static Piece whiteQueen01 = new Piece(PartName.QUEEN, null, PartColor.WHITE, "WQ", 0);
	
	// white King
	public static Piece whiteKing01 = new Piece(PartName.KING, null, PartColor.WHITE, "WK", 0);
	
	
	// BLACK PARTS

	// Black Pawns
	public static Piece BlackPawn01 = new Piece(PartName.PAWN, null, PartColor.BLACK, "BP", 0);
	
	public static Piece BlackPawn02 = new Piece(PartName.PAWN, null, PartColor.BLACK, "BP", 0);
	
	public static Piece BlackPawn03 = new Piece(PartName.PAWN, null, PartColor.BLACK, "BP", 0);
	
	public static Piece BlackPawn04 = new Piece(PartName.PAWN, null, PartColor.BLACK, "BP", 0);
	
	public static Piece BlackPawn05 = new Piece(PartName.PAWN, null, PartColor.BLACK, "BP", 0);
	
	public static Piece BlackPawn06 = new Piece(PartName.PAWN, null, PartColor.BLACK, "BP", 0);
	
	public static Piece BlackPawn07 = new Piece(PartName.PAWN, null, PartColor.BLACK, "BP", 0);
	
	public static Piece BlackPawn08 = new Piece(PartName.PAWN, null, PartColor.BLACK, "BP", 0);
	
	// Black Towers
	public static Piece BlackTower01 = new Piece(PartName.TOWER, null, PartColor.BLACK, "BT", 0);
	
	public static Piece BlackTower02 = new Piece(PartName.TOWER, null, PartColor.BLACK, "BT", 0);
	
	// Black Horses
	public static Piece BlackHorse01 = new Piece(PartName.HORSE, null, PartColor.BLACK, "BH", 0);
	
	public static Piece BlackHorse02 = new Piece(PartName.HORSE, null, PartColor.BLACK, "BH", 0);
	
	// Black Bishops
	public static Piece BlackBisp01 = new Piece(PartName.BISHOP, null, PartColor.WHITE, "BB", 0);
	
	public static Piece BlackBisp02 = new Piece(PartName.BISHOP, null, PartColor.WHITE, "BB", 0);
	
	// Black Queen
	public static Piece BlackQueen01 = new Piece(PartName.QUEEN, null, PartColor.WHITE, "BQ", 0);
	
	// Black King
	public static Piece BlackKing01 = new Piece(PartName.KING, null, PartColor.WHITE, "BK", 0);
	
	public static Piece Unnamed = new Piece(PartName.UNNAMED, null, PartColor.NO_COLOR, "- ", 0);
	
	public static List<Piece> generatePieces() {
		
		List<Piece> parts = new ArrayList<>();
		
		parts.add(BlackTower01);
		parts.add(BlackTower02);
		parts.add(BlackHorse01);
		parts.add(BlackHorse02);
		parts.add(BlackBisp01);
		parts.add(BlackBisp02);
		parts.add(BlackQueen01);
		parts.add(BlackKing01);
		
		parts.add(BlackPawn01);
		parts.add(BlackPawn02);
		parts.add(BlackPawn03);
		parts.add(BlackPawn04);
		parts.add(BlackPawn05);
		parts.add(BlackPawn06);
		parts.add(BlackPawn07);
		parts.add(BlackPawn08);
		
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		parts.add(Unnamed);
		
		parts.add(whitePawn01);
		parts.add(whitePawn02);
		parts.add(whitePawn03);
		parts.add(whitePawn04);
		parts.add(whitePawn05);
		parts.add(whitePawn06);
		parts.add(whitePawn07);
		parts.add(whitePawn08);
		
		parts.add(whiteTower01);
		parts.add(whiteTower02);
		parts.add(whiteHorse01);
		parts.add(whiteHorse02);
		parts.add(whiteBisp01);
		parts.add(whiteBisp02);
		parts.add(whiteQueen01);
		parts.add(whiteKing01);
		
		return parts;
		
	}
}
