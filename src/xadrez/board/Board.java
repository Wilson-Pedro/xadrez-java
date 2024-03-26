package xadrez.board;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import xadrez.parts.GenerateParts;
import xadrez.parts.Part;

public class Board {

	private Map<String, Part> houses = new Hashtable<>();
	
	private List<Part> parts = new ArrayList<>();

	public Board() {
	}

	public Map<String, Part> getHouses() {
		return houses;
	}
	
	public List<Part> getParts() {
		return parts;
	}
	
	public void generateBoard() {
		this.houses = GenerateBoard.generateBoard();
	}
	
	public void generateParts() {
		this.parts = GenerateParts.generateBoard();
	}
	

//	public void showBoard() {
//		int i = 1;
//		for(Map.Entry<String, Part> house : houses.entrySet()) {
//			//System.out.print(" " + house.getValue().getAcronym() + "(" + house.getKey() + ")"  + " ");
//			System.out.print(" " + house.getKey() + " ");
//			if(i == 8) {
//				System.out.println("\n");
//				i = 0;
//			}
//			i += 1;
//		}
//	}
	
	public void showParts() {
		int i = 1;
		for(Part part : parts) {
			System.out.print(" " + part.getAcronym() + " ");
			if(i == 8) {
				System.out.println("\n");
				i = 0;
			}
			i += 1;
		}
	}

	@Override
	public String toString() {
		return "Board [houses=" + houses + ", parts=" + parts + "]";
	}
}
