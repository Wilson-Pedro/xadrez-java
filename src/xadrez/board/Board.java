package xadrez.board;

import static xadrez.parts.GenerateParts.Unnamed;

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
	
	public void generateParts() {
		this.parts = GenerateParts.generateParts();
	}
	
	public void showParts() {
		int i = 1;
		int index = 0;
		for(Part part : parts) {
			System.out.print(" " + part.getAcronym() + " ");
			//System.out.print(" " + part.getAcronym() + "(" + index + ")" + " ");
			if(i == 8) {
				System.out.println("\n");
				i = 0;
			}
			i += 1;
			index += 1;
		}
	}
	
	public void move (List<Part> parts, byte idx1, byte idx2) {
		parts.set(idx2, parts.get(idx1));
		parts.set(idx1, Unnamed);
	}

	@Override
	public String toString() {
		return "Board [houses=" + houses + ", parts=" + parts + "]";
	}
}
