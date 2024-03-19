package xadrez.board;

import java.util.HashMap;
import java.util.Map;
import static xadrez.parts.GenerateParts.*;

import xadrez.parts.Part;

public class GenerateBoard {
	
	public static void main (String args[]){
		Map<String, Part> houses = new HashMap<String, Part>();
		
		houses.put("A1", whiteTower01);
		houses.put("B1", whiteHorse01);
		houses.put("C1", whiteBisp01);
		houses.put("D1", whiteQueen01);
		houses.put("E1", whiteKing01);
		houses.put("F1", whiteBisp02);
		houses.put("G1", whiteHorse02);
		houses.put("H1", whiteTower02);
		
		houses.put("A2", whitePawn01);
		houses.put("B2", whitePawn02);
		houses.put("C2", whitePawn03);
		houses.put("D2", whitePawn04);
		houses.put("E2", whitePawn05);
		houses.put("F2", whitePawn06);
		houses.put("G2", whitePawn07);
		houses.put("H2", whitePawn08);
		
		houses.put("A3", null);
		houses.put("B3", null);
		houses.put("C3", null);
		houses.put("D3", null);
		houses.put("E3", null);
		houses.put("F3", null);
		houses.put("G3", null);
		houses.put("H3", null);
		
		houses.put("A4", null);
		houses.put("B4", null);
		houses.put("C4", null);
		houses.put("D4", null);
		houses.put("E4", null);
		houses.put("F4", null);
		houses.put("G4", null);
		houses.put("H4", null);
		
		houses.put("A5", null);
		houses.put("B5", null);
		houses.put("C5", null);
		houses.put("D5", null);
		houses.put("E5", null);
		houses.put("F5", null);
		houses.put("G5", null);
		houses.put("H5", null);
		
		houses.put("A6", null);
		houses.put("B6", null);
		houses.put("C6", null);
		houses.put("D6", null);
		houses.put("E6", null);
		houses.put("F6", null);
		houses.put("G6", null);
		houses.put("H6", null);
		
		houses.put("A7", BlackPawn01);
		houses.put("B7", BlackPawn02);
		houses.put("C7", BlackPawn03);
		houses.put("D7", BlackPawn04);
		houses.put("E7", BlackPawn05);
		houses.put("F7", BlackPawn06);
		houses.put("G7", BlackPawn07);
		houses.put("H7", BlackPawn08);
		
		houses.put("A8", BlackTower01);
		houses.put("B8", BlackHorse01);
		houses.put("C8", BlackHorse01);
		houses.put("D8", BlackKing01);
		houses.put("E8", BlackQueen01);
		houses.put("F8", BlackHorse02);
		houses.put("G8", BlackHorse02);
		houses.put("H8", BlackTower02);
	}
}
