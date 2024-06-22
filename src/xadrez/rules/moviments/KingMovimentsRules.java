package xadrez.rules.moviments;

import static xadrez.board.HousesFromBoard.generateDownHouses;
import static xadrez.board.HousesFromBoard.generateHousesAbove;
import static xadrez.board.HousesFromBoard.generateLeftSideHouses;
import static xadrez.board.HousesFromBoard.generateRightSideHouses;
import static xadrez.rules.check.CheckRules.check;
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
import java.util.Set;

import xadrez.board.Board;
import xadrez.enums.PieceColor;

public class KingMovimentsRules {

	public static Set<Integer> kingMoviments(int source, PieceColor color, Board board) {
		Set<Integer> possibleKingMoves = new HashSet<>();
		var pieces = board.getPieces();
		
		if(!generateHousesAbove().contains(source)) {
			if (check(source - 8, color, board) && isPawnTopCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source - 8), pieces)) possibleKingMoves.add(source - 8);
			if (check(source - 7, color, board) && isPawnTopRightCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source - 7), pieces) && !generateRightSideHouses().contains(source)) possibleKingMoves.add(source - 7);
			if (check(source - 9, color, board) && isPawnTopLeftCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source - 9), pieces) && !generateLeftSideHouses().contains(source)) possibleKingMoves.add(source - 9);
		}
		
		if(!generateLeftSideHouses().contains(source)) {
			if (check(source - 1, color, board) && !isPawnLeftCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source - 1), pieces)) possibleKingMoves.add(source - 1);
		}
		
		if (!generateRightSideHouses().contains(source)) {
			if (check(source + 1, color, board) && isPawnRightCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source + 1), pieces)) possibleKingMoves.add(source + 1);
		}
		
		if(!generateDownHouses().contains(source)) {
			if ((check(source, color, board) && check(source + 8, color, board)) && !isPawnDawnCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source + 8), pieces)) possibleKingMoves.add(source + 8);
			if (check(source + 9, color, board) && isPawnDawnRightCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source + 9), pieces) && !generateRightSideHouses().contains(source)) possibleKingMoves.add(source + 9);
			if (check(source + 7, color, board) && isPawnDawnLeftCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source + 7), pieces) && !generateLeftSideHouses().contains(source)) possibleKingMoves.add(source + 7);
		}
		
		return possibleKingMoves;
	}

}
