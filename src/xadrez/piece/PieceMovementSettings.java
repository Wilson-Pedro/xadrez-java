package xadrez.piece;

import static xadrez.board.HousesFromBoard.generateDownHouses;
import static xadrez.board.HousesFromBoard.generateHousesAbove;
import static xadrez.board.HousesFromBoard.generateLeftSideHouses;
import static xadrez.board.HousesFromBoard.generateRightSideHouses;
import static xadrez.piece.moves.GenerateMove.generateBishopsMovements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xadrez.piece.moves.MoveBishop;
import xadrez.piece.moves.MoveTower;

public class PieceMovementSettings {

	Set<Integer> housesAbove = generateHousesAbove();
	Set<Integer> rightSideHouses = generateRightSideHouses();
	Set<Integer> leftSideHouses = generateLeftSideHouses();
	Set<Integer> downHouses = generateDownHouses();

	public Set<Integer> possibleMovements(Piece piece, int source) {
		Set<Integer> moves = new HashSet<>();

		if (piece.isPawn()) {
			moves = pawnMoviments(source, piece.getMoveQuantity());
		} else if (piece.isTower()) {
			moves = towerMoviments(source);
		} else if (piece.isHorse()) {
			moves = horseMoviments(source);
		} else if (piece.isBishop()) {
			moves = bishopMoviments(source, moves);
		} else if (piece.isKing()) {
			moves = kingMoviments(source);
		} else if (piece.isQueen()) {
			moves = queenMoviments(source);
		}

		piece.incrementMoveQuantity();

		return moves;
	}

	public Set<Integer> pawnMoviments(int source, int moveQuantity) {
		Set<Integer> possiblePawnMoves = new HashSet<>();
		possiblePawnMoves.add(source - 8);
		if (moveQuantity == 0)
			possiblePawnMoves.add(source - (8 * 2));
		return possiblePawnMoves;
	}

	public Set<Integer> towerMoviments(int source) {
		Set<Integer> possibleTowerMoves = new HashSet<>();
		List<MoveTower> moves = horizontalAndVerticalMovements();
		MoveTower move = moves.get(source);

		int moviment = source;

		// MOVER TORRE PARA CIMA
		if (!housesAbove.contains(source)) {
			for (int i = 0; i < move.getMovimentsToUp(); i++) {
				possibleTowerMoves.add(moviment -= 8);
			}
		}

		moviment = source;

		// MOVER TORRE PARA DIREITA
		if (!rightSideHouses.contains(source)) {
			for (int i = 0; i < move.getMovimentsToRight(); i++) {
				possibleTowerMoves.add(moviment += 1);
			}
		}

		moviment = source;

		// MOVER TORRE PARA ESQUERDA
		if (!leftSideHouses.contains(source)) {
			for (int i = 0; i < move.getMovimentsToLeft(); i++) {
				possibleTowerMoves.add(moviment -= 1);
			}
		}

		moviment = source;

		// MOVER TORRE PARA BAIXO
		if (!downHouses.contains(source)) {
			for (int i = 0; i < move.getMovimentsToDown(); i++) {
				possibleTowerMoves.add(moviment += 8);
			}
		}

		return possibleTowerMoves;
	}

	public Set<Integer> horseMoviments(int source) {
		Set<Integer> possibleHorseMoves = new HashSet<>();
		int movimentValid01 = 0, movimentValid02 = 0;
		boolean movimentValid03 = false, movimentValid04 = false;

		// MOVER CAVALO PARA CIMA
		if (!housesAbove.contains(source)) {
			movimentValid01 = (source - 16) + 1;
			movimentValid02 = (source - 16) - 1;
			movimentValid03 = rightSideHouses.contains(movimentValid02);
			movimentValid04 = leftSideHouses.contains(movimentValid01);
			if (movimentValid01 < 64 && movimentValid01 >= 0 && !movimentValid04)
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03)
				possibleHorseMoves.add(movimentValid02);
		}

		// MOVER CAVALO PARA DIREITA
		if (!rightSideHouses.contains(source)) {
			movimentValid01 = (source + 2) - 8;
			movimentValid02 = (source + 2) + 8;
			movimentValid03 = source + 1 == 63 || source + 1 == 7;
			movimentValid04 = leftSideHouses.contains(movimentValid01);
			if (movimentValid01 < 64 && movimentValid01 >= 0 && !movimentValid03 && !movimentValid04)
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03 && !movimentValid04)
				possibleHorseMoves.add(movimentValid02);
		}

		// MOVER CAVALO PARA ESQUERDA
		if (!leftSideHouses.contains(source)) {
			movimentValid01 = (source - 2) - 8;
			movimentValid02 = (source - 2) + 8;
			movimentValid03 = source - 1 == 56 || source - 1 == 0;
			movimentValid04 = rightSideHouses.contains(movimentValid01);
			if (movimentValid01 < 64 && movimentValid01 >= 0 && !movimentValid03 && !movimentValid04)
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03 && !movimentValid04)
				possibleHorseMoves.add(movimentValid02);
		}

		// MOVER CAVALO PARA BAIXO
		if (!downHouses.contains(source)) {
			movimentValid01 = (source + 16) + 1;
			movimentValid02 = (source + 16) - 1;
			movimentValid03 = rightSideHouses.contains(movimentValid02);
			if (movimentValid01 < 64 && movimentValid01 >= 0)
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03)
				possibleHorseMoves.add(movimentValid02);
		}

		return possibleHorseMoves;
	}

	public Set<Integer> bishopMoviments(int source, Set<Integer> possibleMoves) {
		List<MoveBishop> bishopsMovements = generateBishopsMovements();
		MoveBishop moveBishop = bishopsMovements.get(source);
		int moviment = source;
		
		for(int i = 0; i < moveBishop.getUpperLeftDiagonalMovements(); i++) {
			possibleMoves.add(moviment-=9);
		}
		
		moviment = source;
		
		for(int i = 0; i < moveBishop.getUpperRightDiagonalMovements(); i++) {
			possibleMoves.add(moviment-=7);
		}
		
		moviment = source;
		
		for(int i = 0; i < moveBishop.getLowerLeftMovements(); i++) {
			possibleMoves.add(moviment+=7);
		}
		
		moviment = source;
		
		for(int i = 0; i < moveBishop.getLowerRightMovements(); i++) {
			possibleMoves.add(moviment+=9);
		}
		
		return possibleMoves;
	}
	
	public Set<Integer> kingMoviments(int source) {
		Set<Integer> possibleKingMoves = new HashSet<>();
		
		if(!housesAbove.contains(source)) {
			possibleKingMoves.add(source - 8);
			possibleKingMoves.add((source - 8) + 1);
			possibleKingMoves.add((source - 8) - 1);
		}
		
		if(!leftSideHouses.contains(source)) {
			possibleKingMoves.add(source - 1);
		}
		
		if (!rightSideHouses.contains(source)) {
			possibleKingMoves.add(source + 1);
		}
		
		if(!downHouses.contains(source)) {
			possibleKingMoves.add(source + 8);
			possibleKingMoves.add((source + 8) + 1);
			possibleKingMoves.add((source + 8) - 1);
		}
		
		return possibleKingMoves;
	}
	
	public Set<Integer> queenMoviments(int source) {
		Set<Integer> possibleQueenMoves = new HashSet<>();
		possibleQueenMoves = towerMoviments(source);
		possibleQueenMoves = bishopMoviments(source, possibleQueenMoves);
		
		return possibleQueenMoves;
	}

	public List<MoveTower> horizontalAndVerticalMovements() {
		List<MoveTower> moves = new ArrayList<>();
		int movimentsToUp = 0, movimentsToLeft = 0, movimentsToRight = 7, movimentsToDown = 7;

		for (int i = 0; i <= 63; i++) {
			moves.add(new MoveTower(i, movimentsToUp, movimentsToLeft, movimentsToRight, movimentsToDown));
			movimentsToLeft++;
			movimentsToRight--;
			if (movimentsToLeft == 8 && movimentsToRight == -1) {
				movimentsToLeft = 0;
				movimentsToRight = 7;
				movimentsToUp++;
				movimentsToDown--;
			}
		}

		return moves;
	}
}
