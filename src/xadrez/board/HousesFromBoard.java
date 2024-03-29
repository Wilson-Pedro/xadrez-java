package xadrez.board;

import java.util.HashSet;
import java.util.Set;
//right side houses
public class HousesFromBoard {

	private static final Set<Integer> housesAbove = new HashSet<>();
	private static final Set<Integer> rightSideHouses = new HashSet<>();
	private static final Set<Integer> leftSideHouses = new HashSet<>();
	private static final Set<Integer> downHouses = new HashSet<>();
	
	
	public static Set<Integer> generateHousesAbove() {
		for(int i = 0; i <= 7; i++) {
			housesAbove.add(i);
		}
		return housesAbove;
	}

	public static Set<Integer> generateRightSideHouses() {
		for(int i = 7; i <= 63; i += 8) {
			rightSideHouses.add(i);
		}
		return rightSideHouses;
	}
	
	public static Set<Integer> generateLeftSideHouses() {
		for(int i = 0; i <= 56; i += 8) {
			leftSideHouses.add(i);
		}
		return leftSideHouses;
	}
	
	public static Set<Integer> generateDownHouses() {
		for(int i = 56; i <= 63; i ++) {
			downHouses.add(i);
		}
		return downHouses;
	}
}
