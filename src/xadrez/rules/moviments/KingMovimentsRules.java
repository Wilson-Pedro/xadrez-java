package xadrez.rules.moviments;

import static xadrez.board.HousesFromBoard.generateDownHouses;
import static xadrez.board.HousesFromBoard.generateHousesAbove;
import static xadrez.board.HousesFromBoard.generateLeftSideHouses;
import static xadrez.board.HousesFromBoard.generateRightSideHouses;
import static xadrez.rules.check.CheckRules.isPawnDawnCheck;
import static xadrez.rules.check.CheckRules.isPawnDawnLeftCheck;
import static xadrez.rules.check.CheckRules.isPawnDawnRightCheck;
import static xadrez.rules.check.CheckRules.isPawnLeftCheck;
import static xadrez.rules.check.CheckRules.isPawnRightCheck;
import static xadrez.rules.check.CheckRules.isPawnTopCheck;
import static xadrez.rules.check.CheckRules.isPawnTopLeftCheck;
import static xadrez.rules.check.CheckRules.isPawnTopRightCheck;
import static xadrez.utils.Util.containsPieceAndisDifferentColor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xadrez.enums.PieceColor;
import xadrez.piece.Piece;
import xadrez.rules.check.CheckRules;

public class KingMovimentsRules {
	
	private CheckRules checkRules;
	
	public KingMovimentsRules(CheckRules checkRules) {
		this.checkRules = checkRules;
	}

	public Set<Integer> kingMoviments(int source, PieceColor color, List<Piece> pieces) {
		Set<Integer> possibleKingMoves = new HashSet<>();

		
		if(!generateHousesAbove().contains(source)) {
			if (!checkRules.check(source - 8, color, pieces) && !isPawnTopCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source - 8), pieces)) possibleKingMoves.add(source - 8);
			if (!checkRules.check(source - 7, color, pieces) && !isPawnTopRightCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source - 7), pieces) && !generateRightSideHouses().contains(source)) possibleKingMoves.add(source - 7);
			if (!checkRules.check(source - 9, color, pieces) && !isPawnTopLeftCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source - 9), pieces) && !generateLeftSideHouses().contains(source)) possibleKingMoves.add(source - 9);
		}
		
		if(!generateLeftSideHouses().contains(source)) {
			if (!checkRules.check(source - 1, color, pieces) && !isPawnLeftCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source - 1), pieces)) possibleKingMoves.add(source - 1);
		}
		
		if (!generateRightSideHouses().contains(source)) {
			if (!checkRules.check(source + 1, color, pieces) && !isPawnRightCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source + 1), pieces)) possibleKingMoves.add(source + 1);
		}
		
		if(!generateDownHouses().contains(source)) {
			if ((!checkRules.check(source, color, pieces) && !checkRules.check(source + 8, color, pieces)) && !isPawnDawnCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source + 8), pieces)) possibleKingMoves.add(source + 8);
			if (!checkRules.check(source + 9, color, pieces) && !isPawnDawnRightCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source + 9), pieces) && !generateRightSideHouses().contains(source)) possibleKingMoves.add(source + 9);
			if (!checkRules.check(source + 7, color, pieces) && !isPawnDawnLeftCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source + 7), pieces) && !generateLeftSideHouses().contains(source)) possibleKingMoves.add(source + 7);
		}
		
		return possibleKingMoves;
	}

}
