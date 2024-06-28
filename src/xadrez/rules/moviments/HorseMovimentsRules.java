package xadrez.rules.moviments;

import static xadrez.board.HousesFromBoard.generateDownHouses;
import static xadrez.board.HousesFromBoard.generateHousesAbove;
import static xadrez.board.HousesFromBoard.generateLeftSideHouses;
import static xadrez.board.HousesFromBoard.generateRightSideHouses;
import static xadrez.rules.check.CheckRules.isCheck;
import static xadrez.utils.Util.isSameColor;

import java.util.HashSet;
import java.util.Set;

import xadrez.board.Board;

public class HorseMovimentsRules {

	public static Set<Integer> horseMoviments(int source, Board board) {
		Set<Integer> possibleHorseMoves = new HashSet<>();
		var pieces = board.getPieces();
		int movimentValid01 = 0, movimentValid02 = 0;
		boolean movimentValid03 = false, movimentValid04 = false;

		// MOVER CAVALO PARA CIMA
		if (!generateHousesAbove().contains(source)) {
			movimentValid01 = (source - 16) + 1;
			movimentValid02 = (source - 16) - 1;
			movimentValid03 = generateRightSideHouses().contains(movimentValid02);
			movimentValid04 = generateLeftSideHouses().contains(movimentValid01);
			if (movimentValid01 < 64 && movimentValid01 >= 0 && !movimentValid04 && !isSameColor(source, movimentValid01, pieces))
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03 && !isSameColor(source, movimentValid02, pieces))
				possibleHorseMoves.add(movimentValid02);
		}

		// MOVER CAVALO PARA DIREITA
		if (!generateRightSideHouses().contains(source)) {
			movimentValid01 = (source + 2) - 8;
			movimentValid02 = (source + 2) + 8;
			movimentValid03 = source + 1 == 63 || source + 1 == 7;
			movimentValid04 = generateLeftSideHouses().contains(movimentValid01);
			if (movimentValid01 < 64 && movimentValid01 >= 0 && !movimentValid03 && !movimentValid04  && !isSameColor(source, movimentValid01, pieces))
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03 && !movimentValid04 && !isSameColor(source, movimentValid02, pieces))
				possibleHorseMoves.add(movimentValid02);
		}

		// MOVER CAVALO PARA ESQUERDA
		if (!generateLeftSideHouses().contains(source)) {
			movimentValid01 = (source - 2) - 8;
			movimentValid02 = (source - 2) + 8;
			movimentValid03 = source - 1 == 56 || source - 1 == 0;
			movimentValid04 = generateRightSideHouses().contains(movimentValid01);
			if (movimentValid01 < 64 && movimentValid01 >= 0 && !movimentValid03 && !movimentValid04 && !isSameColor(source, movimentValid01, pieces))
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03 && !movimentValid04 && !isSameColor(source, movimentValid02, pieces))
				possibleHorseMoves.add(movimentValid02);
		}

		// MOVER CAVALO PARA BAIXO
		if (!generateDownHouses().contains(source)) {
			movimentValid01 = (source + 16) + 1;
			movimentValid02 = (source + 16) - 1;
			movimentValid03 = generateRightSideHouses().contains(movimentValid02);
			if (movimentValid01 < 64 && movimentValid01 >= 0 && !isSameColor(source, movimentValid01, pieces))
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03 && !isSameColor(source, movimentValid02, pieces))
				possibleHorseMoves.add(movimentValid02);
		}

		return possibleHorseMoves;
	}
	
	public static Set<Integer> horseMovimentsWithCheckValidation(int source, Board board) {
		Set<Integer> possibleHorseMoves = new HashSet<>();
		var pieces = board.getPieces();
		int movimentValid01 = 0, movimentValid02 = 0;
		boolean movimentValid03 = false, movimentValid04 = false;
		var color = board.getPieces().get(source).getPieceColor();

		// MOVER CAVALO PARA CIMA
		if (!generateHousesAbove().contains(source)) {
			movimentValid01 = (source - 16) + 1;
			movimentValid02 = (source - 16) - 1;
			movimentValid03 = generateRightSideHouses().contains(movimentValid02);
			movimentValid04 = generateLeftSideHouses().contains(movimentValid01);
			if (movimentValid01 < 64 && movimentValid01 >= 0 && !movimentValid04 && !isSameColor(source, movimentValid01, pieces) && !isCheck(source, movimentValid01, board, color))
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03 && !isSameColor(source, movimentValid02, pieces) && !isCheck(source, movimentValid02, board, color))
				possibleHorseMoves.add(movimentValid02);
		}

		// MOVER CAVALO PARA DIREITA
		if (!generateRightSideHouses().contains(source)) {
			movimentValid01 = (source + 2) - 8;
			movimentValid02 = (source + 2) + 8;
			movimentValid03 = source + 1 == 63 || source + 1 == 7;
			movimentValid04 = generateLeftSideHouses().contains(movimentValid01);
			if (movimentValid01 < 64 && movimentValid01 >= 0 && !movimentValid03 && !movimentValid04  && !isSameColor(source, movimentValid01, pieces) && !isCheck(source, movimentValid01, board, color))
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03 && !movimentValid04 && !isSameColor(source, movimentValid02, pieces) && !isCheck(source, movimentValid02, board, color))
				possibleHorseMoves.add(movimentValid02);
		}

		// MOVER CAVALO PARA ESQUERDA
		if (!generateLeftSideHouses().contains(source)) {
			movimentValid01 = (source - 2) - 8;
			movimentValid02 = (source - 2) + 8;
			movimentValid03 = source - 1 == 56 || source - 1 == 0;
			movimentValid04 = generateRightSideHouses().contains(movimentValid01);
			if (movimentValid01 < 64 && movimentValid01 >= 0 && !movimentValid03 && !movimentValid04 && !isSameColor(source, movimentValid01, pieces) && !isCheck(source, movimentValid01, board, color))
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03 && !movimentValid04 && !isSameColor(source, movimentValid02, pieces) && !isCheck(source, movimentValid02, board, color))
				possibleHorseMoves.add(movimentValid02);
		}

		// MOVER CAVALO PARA BAIXO
		if (!generateDownHouses().contains(source)) {
			movimentValid01 = (source + 16) + 1;
			movimentValid02 = (source + 16) - 1;
			movimentValid03 = generateRightSideHouses().contains(movimentValid02);
			if (movimentValid01 < 64 && movimentValid01 >= 0 && !isSameColor(source, movimentValid01, pieces) && !isCheck(source, movimentValid01, board, color))
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03 && !isSameColor(source, movimentValid02, pieces) && !isCheck(source, movimentValid02, board, color))
				possibleHorseMoves.add(movimentValid02);
		}

		return possibleHorseMoves;
	}
}
