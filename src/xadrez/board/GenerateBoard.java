package xadrez.board;

import static xadrez.parts.GenerateParts.BlackBisp01;
import static xadrez.parts.GenerateParts.BlackBisp02;
import static xadrez.parts.GenerateParts.BlackHorse01;
import static xadrez.parts.GenerateParts.BlackHorse02;
import static xadrez.parts.GenerateParts.BlackKing01;
import static xadrez.parts.GenerateParts.BlackPawn01;
import static xadrez.parts.GenerateParts.BlackPawn02;
import static xadrez.parts.GenerateParts.BlackPawn03;
import static xadrez.parts.GenerateParts.BlackPawn04;
import static xadrez.parts.GenerateParts.BlackPawn05;
import static xadrez.parts.GenerateParts.BlackPawn06;
import static xadrez.parts.GenerateParts.BlackPawn07;
import static xadrez.parts.GenerateParts.BlackPawn08;
import static xadrez.parts.GenerateParts.BlackQueen01;
import static xadrez.parts.GenerateParts.BlackTower01;
import static xadrez.parts.GenerateParts.BlackTower02;
import static xadrez.parts.GenerateParts.Unnamed;
import static xadrez.parts.GenerateParts.whiteBisp01;
import static xadrez.parts.GenerateParts.whiteBisp02;
import static xadrez.parts.GenerateParts.whiteHorse01;
import static xadrez.parts.GenerateParts.whiteKing01;
import static xadrez.parts.GenerateParts.whitePawn01;
import static xadrez.parts.GenerateParts.whitePawn02;
import static xadrez.parts.GenerateParts.whitePawn03;
import static xadrez.parts.GenerateParts.whitePawn04;
import static xadrez.parts.GenerateParts.whitePawn05;
import static xadrez.parts.GenerateParts.whitePawn06;
import static xadrez.parts.GenerateParts.whitePawn07;
import static xadrez.parts.GenerateParts.whitePawn08;
import static xadrez.parts.GenerateParts.whiteQueen01;
import static xadrez.parts.GenerateParts.whiteTower01;

import java.util.Map;
import java.util.TreeMap;

import xadrez.parts.Part;

public class GenerateBoard {

	private static Map<String, Part> housesGenerated = new TreeMap<String, Part>();

	public static Map<String, Part> generateBoard() {
		
			housesGenerated.put("A1", whiteTower01);
			housesGenerated.put("A2", whitePawn01);
			housesGenerated.put("A3", Unnamed);
			housesGenerated.put("A4", Unnamed);
			housesGenerated.put("A5", Unnamed);
			housesGenerated.put("A6", Unnamed);
			housesGenerated.put("A7", BlackPawn01);
			housesGenerated.put("A8", BlackTower01);
			
			housesGenerated.put("B1", whiteHorse01);
			housesGenerated.put("B2", whitePawn02);
			housesGenerated.put("B3", Unnamed);
			housesGenerated.put("B4", Unnamed);
			housesGenerated.put("B5", Unnamed);
			housesGenerated.put("B6", Unnamed);
			housesGenerated.put("B7", BlackPawn02);
			housesGenerated.put("B8", BlackHorse01);
			
			housesGenerated.put("C1", whiteBisp01);
			housesGenerated.put("C2", whitePawn03);
			housesGenerated.put("C3", Unnamed);
			housesGenerated.put("C4", Unnamed);
			housesGenerated.put("C5", Unnamed);
			housesGenerated.put("C6", Unnamed);
			housesGenerated.put("C7", BlackPawn03);
			housesGenerated.put("C8", BlackBisp01);
			
			housesGenerated.put("D1", whiteQueen01);
			housesGenerated.put("D2", whitePawn04);
			housesGenerated.put("D3", Unnamed);
			housesGenerated.put("D4", Unnamed);
			housesGenerated.put("D5", Unnamed);
			housesGenerated.put("D6", Unnamed);
			housesGenerated.put("D7", BlackPawn04);
			housesGenerated.put("D8", BlackQueen01);
			
			housesGenerated.put("E1", whiteKing01);
			housesGenerated.put("E2", whitePawn05);
			housesGenerated.put("E3", Unnamed);
			housesGenerated.put("E4", Unnamed);
			housesGenerated.put("E5", Unnamed);
			housesGenerated.put("E6", Unnamed);
			housesGenerated.put("E7", BlackPawn05);
			housesGenerated.put("E8", BlackKing01);
			
			housesGenerated.put("F1", whiteBisp02);
			housesGenerated.put("F2", whitePawn06);
			housesGenerated.put("F3", Unnamed);
			housesGenerated.put("F4", Unnamed);
			housesGenerated.put("F5", Unnamed);
			housesGenerated.put("F6", Unnamed);
			housesGenerated.put("F7", BlackPawn06);
			housesGenerated.put("F8", BlackBisp02);
			
			housesGenerated.put("H1", BlackHorse02);
			housesGenerated.put("H2", whitePawn07);
			housesGenerated.put("H3", Unnamed);
			housesGenerated.put("H4", Unnamed);
			housesGenerated.put("H5", Unnamed);
			housesGenerated.put("H6", Unnamed);
			housesGenerated.put("H7", BlackPawn07);
			housesGenerated.put("H8", BlackHorse02);
			
			housesGenerated.put("A8", BlackTower02);
			housesGenerated.put("B8", whitePawn08);
			housesGenerated.put("C8", Unnamed);
			housesGenerated.put("D8", Unnamed);
			housesGenerated.put("E8", Unnamed);
			housesGenerated.put("F8", Unnamed);
			housesGenerated.put("G8", BlackPawn08);
			housesGenerated.put("H8", BlackTower02);
			
			return housesGenerated;
		}
	
/*	
		housesGenerated.put("A1", whiteTower01);
		housesGenerated.put("B1", whiteHorse01);
		housesGenerated.put("C1", whiteBisp01);
		housesGenerated.put("D1", whiteQueen01);
		housesGenerated.put("E1", whiteKing01);
		housesGenerated.put("F1", whiteBisp02);
		housesGenerated.put("G1", whiteHorse02);
		housesGenerated.put("H1", whiteTower02);
		
		housesGenerated.put("A2", whitePawn01);
		housesGenerated.put("B2", whitePawn02);
		housesGenerated.put("C2", whitePawn03);
		housesGenerated.put("D2", whitePawn04);
		housesGenerated.put("E2", whitePawn05);
		housesGenerated.put("F2", whitePawn06);
		housesGenerated.put("G2", whitePawn07);
		housesGenerated.put("H2", whitePawn08);
		
		housesGenerated.put("A3", Unnamed);
		housesGenerated.put("B3", Unnamed);
		housesGenerated.put("C3", Unnamed);
		housesGenerated.put("D3", Unnamed);
		housesGenerated.put("E3", Unnamed);
		housesGenerated.put("F3", Unnamed);
		housesGenerated.put("G3", Unnamed);
		housesGenerated.put("H3", Unnamed);
		
		housesGenerated.put("A4", Unnamed);
		housesGenerated.put("B4", Unnamed);
		housesGenerated.put("C4", Unnamed);
		housesGenerated.put("D4", Unnamed);
		housesGenerated.put("E4", Unnamed);
		housesGenerated.put("F4", Unnamed);
		housesGenerated.put("G4", Unnamed);
		housesGenerated.put("H4", Unnamed);
		
		housesGenerated.put("A5", Unnamed);
		housesGenerated.put("B5", Unnamed);
		housesGenerated.put("C5", Unnamed);
		housesGenerated.put("D5", Unnamed);
		housesGenerated.put("E5", Unnamed);
		housesGenerated.put("F5", Unnamed);
		housesGenerated.put("G5", Unnamed);
		housesGenerated.put("H5", Unnamed);
		
		housesGenerated.put("A6", Unnamed);
		housesGenerated.put("B6", Unnamed);
		housesGenerated.put("C6", Unnamed);
		housesGenerated.put("D6", Unnamed);
		housesGenerated.put("E6", Unnamed);
		housesGenerated.put("F6", Unnamed);
		housesGenerated.put("G6", Unnamed);
		housesGenerated.put("H6", Unnamed);
		
		housesGenerated.put("A7", BlackPawn01);
		housesGenerated.put("B7", BlackPawn02);
		housesGenerated.put("C7", BlackPawn03);
		housesGenerated.put("D7", BlackPawn04);
		housesGenerated.put("E7", BlackPawn05);
		housesGenerated.put("F7", BlackPawn06);
		housesGenerated.put("G7", BlackPawn07);
		housesGenerated.put("H7", BlackPawn08);
		
		housesGenerated.put("A8", BlackTower01);
		housesGenerated.put("B8", BlackHorse01);
		housesGenerated.put("C8", BlackHorse01);
		housesGenerated.put("D8", BlackKing01);
		housesGenerated.put("E8", BlackQueen01);
		housesGenerated.put("F8", BlackHorse02);
		housesGenerated.put("G8", BlackHorse02);
		housesGenerated.put("H8", BlackTower02);
*/
}
