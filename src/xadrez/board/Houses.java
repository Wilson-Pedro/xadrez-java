package xadrez.board;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Houses {
	
	private Map<String, Integer> houses = new HashMap<>();

	public Map<String, Integer> generateHouses() {
		
		houses.put("A1", 56);
		houses.put("A2", 48);
		houses.put("A3", 40);
		houses.put("A4", 32);
		houses.put("A5", 24);
		houses.put("A6", 16);
		houses.put("A7", 8);
		houses.put("A8", 0);
		
		houses.put("B1", 57);
		houses.put("B2", 49);
		houses.put("B3", 41);
		houses.put("B4", 33);
		houses.put("B5", 25);
		houses.put("B6", 17);
		houses.put("B7", 9);
		houses.put("B8", 1);
		
		houses.put("C1", 58);
		houses.put("C2", 50);
		houses.put("C3", 42);
		houses.put("C4", 34);
		houses.put("C5", 26);
		houses.put("C6", 18);
		houses.put("C7", 10);
		houses.put("C8", 2);
		
		houses.put("D1", 59);
		houses.put("D2", 51);
		houses.put("D3", 43);
		houses.put("D4", 35);
		houses.put("D5", 27);
		houses.put("D6", 19);
		houses.put("D7", 11);
		houses.put("D8", 3);
		
		houses.put("E1", 60);
		houses.put("E2", 52);
		houses.put("E3", 44);
		houses.put("E4", 36);
		houses.put("E5", 28);
		houses.put("E6", 20);
		houses.put("E7", 12);
		houses.put("E8", 4);
		
		houses.put("F1", 61);
		houses.put("F2", 53);
		houses.put("F3", 45);
		houses.put("F4", 37);
		houses.put("F5", 29);
		houses.put("F6", 21);
		houses.put("F7", 13);
		houses.put("F8", 5);
		
		houses.put("G1", 62);
		houses.put("G2", 54);
		houses.put("G3", 46);
		houses.put("G4", 38);
		houses.put("G5", 30);
		houses.put("G6", 22);
		houses.put("G7", 14);
		houses.put("G8", 6);
		
		houses.put("H1", 63);
		houses.put("H2", 55);
		houses.put("H3", 47);
		houses.put("H4", 39);
		houses.put("H5", 31);
		houses.put("H6", 23);
		houses.put("H7", 15);
		houses.put("H8", 7);
		
		return houses;
	}
	
	public int houseForNumber(String house) {
		int houseNumber = 0;
		for(Map.Entry<String, Integer> x : houses.entrySet()) {
			if(x.getKey().equals(house)) houseNumber = x.getValue();
		}
		return houseNumber;
	}
	
	public Set<String> numbersToHouses(Set<Integer> listNumber) {
		Set<String> onlyHouses = new HashSet<>();
		for(Map.Entry<String, Integer> x : houses.entrySet()) {
			for(Integer number : listNumber) {
				if(x.getValue().equals(number)) onlyHouses.add(x.getKey());
			}
		}
		return onlyHouses;
	}
}
