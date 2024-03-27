package xadrez.parts;

import java.util.ArrayList;
import java.util.List;

import xadrez.enums.PartColor;
import xadrez.enums.PartName;

public class GenerateParts {
	
	// WHITE PARTS

	// white Pawns
	public static Part whitePawn01 = new Part(PartName.PAWN, null, PartColor.WHITE, "WP");
	
	public static Part whitePawn02 = new Part(PartName.PAWN, null, PartColor.WHITE, "WP");
	
	public static Part whitePawn03 = new Part(PartName.PAWN, null, PartColor.WHITE, "WP");
	
	public static Part whitePawn04 = new Part(PartName.PAWN, null, PartColor.WHITE, "WP");
	
	public static Part whitePawn05 = new Part(PartName.PAWN, null, PartColor.WHITE, "WP");
	
	public static Part whitePawn06 = new Part(PartName.PAWN, null, PartColor.WHITE, "WP");
	
	public static Part whitePawn07 = new Part(PartName.PAWN, null, PartColor.WHITE, "WP");
	
	public static Part whitePawn08 = new Part(PartName.PAWN, null, PartColor.WHITE, "WP");
	
	// white Towers
	public static Part whiteTower01 = new Part(PartName.TOWER, null, PartColor.WHITE, "WT");
	
	public static Part whiteTower02 = new Part(PartName.TOWER, null, PartColor.WHITE, "WT");
	
	// white Horses
	public static Part whiteHorse01 = new Part(PartName.HORSE, null, PartColor.WHITE, "WH");
	
	public static Part whiteHorse02 = new Part(PartName.HORSE, null, PartColor.WHITE, "WH");
	
	// white Bishops
	public static Part whiteBisp01 = new Part(PartName.BISHOP, null, PartColor.WHITE, "WB");
	
	public static Part whiteBisp02 = new Part(PartName.BISHOP, null, PartColor.WHITE, "WB");
	
	// white Queen
	public static Part whiteQueen01 = new Part(PartName.QUEEN, null, PartColor.WHITE, "WQ");
	
	// white King
	public static Part whiteKing01 = new Part(PartName.KING, null, PartColor.WHITE, "WK");
	
	
	// BLACK PARTS

	// Black Pawns
	public static Part BlackPawn01 = new Part(PartName.PAWN, null, PartColor.BLACK, "BP");
	
	public static Part BlackPawn02 = new Part(PartName.PAWN, null, PartColor.BLACK, "BP");
	
	public static Part BlackPawn03 = new Part(PartName.PAWN, null, PartColor.BLACK, "BP");
	
	public static Part BlackPawn04 = new Part(PartName.PAWN, null, PartColor.BLACK, "BP");
	
	public static Part BlackPawn05 = new Part(PartName.PAWN, null, PartColor.BLACK, "BP");
	
	public static Part BlackPawn06 = new Part(PartName.PAWN, null, PartColor.BLACK, "BP");
	
	public static Part BlackPawn07 = new Part(PartName.PAWN, null, PartColor.BLACK, "BP");
	
	public static Part BlackPawn08 = new Part(PartName.PAWN, null, PartColor.BLACK, "BP");
	
	// Black Towers
	public static Part BlackTower01 = new Part(PartName.TOWER, null, PartColor.BLACK, "BT");
	
	public static Part BlackTower02 = new Part(PartName.TOWER, null, PartColor.BLACK, "BT");
	
	// Black Horses
	public static Part BlackHorse01 = new Part(PartName.HORSE, null, PartColor.BLACK, "BH");
	
	public static Part BlackHorse02 = new Part(PartName.HORSE, null, PartColor.BLACK, "BH");
	
	// Black Bishops
	public static Part BlackBisp01 = new Part(PartName.BISHOP, null, PartColor.WHITE, "BB");
	
	public static Part BlackBisp02 = new Part(PartName.BISHOP, null, PartColor.WHITE, "BB");
	
	// Black Queen
	public static Part BlackQueen01 = new Part(PartName.QUEEN, null, PartColor.WHITE, "BQ");
	
	// Black King
	public static Part BlackKing01 = new Part(PartName.KING, null, PartColor.WHITE, "BK");
	
	public static Part Unnamed = new Part(PartName.UNNAMED, null, PartColor.NO_COLOR, "- ");
	
	public static List<Part> generateParts() {
		
		List<Part> parts = new ArrayList<>();
		
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
