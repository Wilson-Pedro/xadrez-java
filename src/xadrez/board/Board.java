package xadrez.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xadrez.parts.Part;

public class Board {

	Map<String, Part> houses = new HashMap<>();
	List<Part> parts = new ArrayList<>();
	
	public Map<String, Part> getHouses() {
		return houses;
	}
	
	public List<Part> getParts() {
		return parts;
	}
}
