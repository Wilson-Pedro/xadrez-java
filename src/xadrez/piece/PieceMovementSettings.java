package xadrez.piece;

import static xadrez.board.HousesFromBoard.generateDownHouses;
import static xadrez.board.HousesFromBoard.generateHousesAbove;
import static xadrez.board.HousesFromBoard.generateLeftSideHouses;
import static xadrez.board.HousesFromBoard.generateRightSideHouses;
import static xadrez.piece.moves.GenerateMove.generateBishopsMovements;
import static xadrez.utlis.Validations.containsPiece;
import static xadrez.utlis.Validations.containsPieceAndisDifferentColor;
import static xadrez.utlis.Validations.isSameColor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static xadrez.check.CheckRules.isCheckInPosition;
import static xadrez.check.CheckRules.isPawnTopCheck;
import static xadrez.check.CheckRules.isPawnTopRightCheck;
import static xadrez.check.CheckRules.isPawnTopLeftCheck;
import static xadrez.check.CheckRules.isPawnDawnCheck;
import static xadrez.check.CheckRules.isPawnDawnRightCheck;
import static xadrez.check.CheckRules.isPawnDawnLeftCheck;
import static xadrez.check.CheckRules.isPawnRightCheck;
import static xadrez.check.CheckRules.isPawnLeftCheck;

import xadrez.enums.PieceColor;
import xadrez.enums.PieceName;
import xadrez.piece.moves.MoveBishop;
import xadrez.piece.moves.MoveTower;

public class PieceMovementSettings {

	private Set<Integer> housesAbove = generateHousesAbove();
	private Set<Integer> rightSideHouses = generateRightSideHouses();
	private Set<Integer> leftSideHouses = generateLeftSideHouses();
	private Set<Integer> downHouses = generateDownHouses();
	
	private List<Piece> pieces = new ArrayList<>();

	public Set<Integer> possibleMovements(Piece piece, int source, List<Piece> pieces) {
		Set<Integer> moves = new HashSet<>();
		this.pieces = pieces;

		if (piece.isPawn()) {
			moves = pawnMoviments(source, piece.getMoveQuantity());
		} else if (piece.isTower()) {
			moves = towerMoviments(source, piece.getPieceColor());
		} else if (piece.isHorse()) {
			moves = horseMoviments(source);
		} else if (piece.isBishop()) {
			moves = bishopMoviments(source, piece.getPieceColor(), moves, true);
		} else if (piece.isKing()) {
			moves = kingMoviments(source, piece.getPieceColor());
		} else if (piece.isQueen()) {
			moves = queenMoviments(source, piece.getPieceColor());
		}

		piece.incrementMoveQuantity();

		return moves;
	}

	private Set<Integer> pawnMoviments(int source, int moveQuantity) {
		Set<Integer> possiblePawnMoves = new HashSet<>();
		int moviment = source - 8;
		var piece = this.pieces.get(source);
		if (piece.isBlack()) moviment = source + 8;
		if (!isSameColor(source, (moviment), pieces) && !containsPiece(moviment, pieces)) possiblePawnMoves.add(moviment);
		if (!isSameColor(source, (moviment + 1), pieces) && containsPiece(moviment + 1, pieces) && !leftSideHouses.contains(moviment + 1)) possiblePawnMoves.add(moviment + 1);
		if (!isSameColor(source, (moviment - 1), pieces) && containsPiece(moviment - 1, pieces) && !rightSideHouses.contains(moviment - 1)) possiblePawnMoves.add(moviment - 1);
		if (moveQuantity == 0 && !piece.isWhite() && !containsPiece(moviment, pieces) && !containsPiece(source + (8 * 2), pieces) && !isSameColor(source, (source + (8 * 2)), pieces)) possiblePawnMoves.add(source + (8 * 2));
		if (moveQuantity == 0 && !piece.isBlack() && !containsPiece(moviment, pieces) && !containsPiece(source - (8 * 2), pieces) && !isSameColor(source, (source - (8 * 2)), pieces)) possiblePawnMoves.add(source - (8 * 2));
		return possiblePawnMoves;
	}

	private Set<Integer> towerMoviments(int source, PieceColor color) {
		Set<Integer> possibleTowerMoves = new HashSet<>();
		List<MoveTower> moves = horizontalAndVerticalMovements();
		MoveTower move = moves.get(source);

		int moviment = source;

		// MOVER TORRE PARA CIMA
		if (!housesAbove.contains(source)) {
			for (int i = 0; i < move.getMovimentsToUp(); i++) {
				if (containsPiece(moviment - 8, pieces)) {
					if (!isSameColor(color, pieces.get(moviment - 8).getPieceColor())) possibleTowerMoves.add(moviment -= 8);
					i = move.getMovimentsToUp();
				}
				else possibleTowerMoves.add(moviment -= 8);
			}
		}

		moviment = source;

		// MOVER TORRE PARA DIREITA
		if (!rightSideHouses.contains(source)) {
			for (int i = 0; i < move.getMovimentsToRight(); i++) {
				if (containsPiece(moviment + 1, pieces)) {
					if(!isSameColor(color, pieces.get(moviment + 1).getPieceColor())) possibleTowerMoves.add(moviment += 1);
					i = move.getMovimentsToRight();
				}
				else possibleTowerMoves.add(moviment += 1);
			}
		}

		moviment = source;

		// MOVER TORRE PARA ESQUERDA
		if (!leftSideHouses.contains(source)) {
			for (int i = 0; i < move.getMovimentsToLeft(); i++) {
				if (containsPiece(moviment - 1, pieces)) {
					if(!isSameColor(color, pieces.get(moviment - 1).getPieceColor())) possibleTowerMoves.add(moviment -= 1);
					i = move.getMovimentsToLeft();
				}
				else possibleTowerMoves.add(moviment -= 1);
			}
		}

		moviment = source;

		// MOVER TORRE PARA BAIXO
		if (!downHouses.contains(source)) {
			for (int i = 0; i < move.getMovimentsToDown(); i++) {
				if (containsPiece(moviment + 8, pieces)) {
					if (!isSameColor(color, pieces.get(moviment + 8).getPieceColor())) possibleTowerMoves.add(moviment += 8);
					i = move.getMovimentsToDown();
				}
				else possibleTowerMoves.add(moviment += 8);
			}
		}

		return possibleTowerMoves;
	}

	private Set<Integer> horseMoviments(int source) {
		Set<Integer> possibleHorseMoves = new HashSet<>();
		int movimentValid01 = 0, movimentValid02 = 0;
		boolean movimentValid03 = false, movimentValid04 = false;

		// MOVER CAVALO PARA CIMA
		if (!housesAbove.contains(source)) {
			movimentValid01 = (source - 16) + 1;
			movimentValid02 = (source - 16) - 1;
			movimentValid03 = rightSideHouses.contains(movimentValid02);
			movimentValid04 = leftSideHouses.contains(movimentValid01);
			// && isSameColor(source, movimentValid01)
			if (movimentValid01 < 64 && movimentValid01 >= 0 && !movimentValid04 && !isSameColor(source, movimentValid01, pieces))
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03 && !isSameColor(source, movimentValid02, pieces))
				possibleHorseMoves.add(movimentValid02);
		}

		// MOVER CAVALO PARA DIREITA
		if (!rightSideHouses.contains(source)) {
			movimentValid01 = (source + 2) - 8;
			movimentValid02 = (source + 2) + 8;
			movimentValid03 = source + 1 == 63 || source + 1 == 7;
			movimentValid04 = leftSideHouses.contains(movimentValid01);
			if (movimentValid01 < 64 && movimentValid01 >= 0 && !movimentValid03 && !movimentValid04  && !isSameColor(source, movimentValid01, pieces))
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03 && !movimentValid04 && !isSameColor(source, movimentValid02, pieces))
				possibleHorseMoves.add(movimentValid02);
		}

		// MOVER CAVALO PARA ESQUERDA
		if (!leftSideHouses.contains(source)) {
			movimentValid01 = (source - 2) - 8;
			movimentValid02 = (source - 2) + 8;
			movimentValid03 = source - 1 == 56 || source - 1 == 0;
			movimentValid04 = rightSideHouses.contains(movimentValid01);
			if (movimentValid01 < 64 && movimentValid01 >= 0 && !movimentValid03 && !movimentValid04 && !isSameColor(source, movimentValid01, pieces))
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03 && !movimentValid04 && !isSameColor(source, movimentValid02, pieces))
				possibleHorseMoves.add(movimentValid02);
		}

		// MOVER CAVALO PARA BAIXO
		if (!downHouses.contains(source)) {
			movimentValid01 = (source + 16) + 1;
			movimentValid02 = (source + 16) - 1;
			movimentValid03 = rightSideHouses.contains(movimentValid02);
			if (movimentValid01 < 64 && movimentValid01 >= 0 && !isSameColor(source, movimentValid01, pieces))
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03 && !isSameColor(source, movimentValid02, pieces))
				possibleHorseMoves.add(movimentValid02);
		}

		return possibleHorseMoves;
	}

	private Set<Integer> bishopMoviments(int source, PieceColor color, Set<Integer> possibleMoves, boolean validation) {
		if(possibleMoves == null) possibleMoves = new HashSet<>();
		List<MoveBishop> bishopsMovements = generateBishopsMovements();
		MoveBishop moveBishop = bishopsMovements.get(source);
		int moviment = source;
		
		for(int i = 0; i < moveBishop.getUpperLeftDiagonalMovements(); i++) {
			if (containsPiece(moviment - 9, pieces) && validation) {
				if(!isSameColor(color, pieces.get(moviment - 9).getPieceColor())) possibleMoves.add(moviment-=9);
				i = moveBishop.getUpperLeftDiagonalMovements();
			}
			else possibleMoves.add(moviment-=9);
		}
		
		moviment = source;
		
		for(int i = 0; i < moveBishop.getUpperRightDiagonalMovements(); i++) {
			if (containsPiece(moviment - 7, pieces) && validation) {
				if(!isSameColor(color, pieces.get(moviment - 7).getPieceColor())) possibleMoves.add(moviment-=7);
				i = moveBishop.getUpperRightDiagonalMovements();
			}
			else possibleMoves.add(moviment-=7);
		}
		
		moviment = source;
		
		for(int i = 0; i < moveBishop.getLowerLeftMovements(); i++) {
			if (containsPiece(moviment + 7, pieces) && validation) {
				if(!isSameColor(color, pieces.get(moviment + 7).getPieceColor())) possibleMoves.add(moviment+=7);
				i = moveBishop.getLowerLeftMovements();
			}
			else possibleMoves.add(moviment+=7);
		}
		
		moviment = source;
		
		for(int i = 0; i < moveBishop.getLowerRightMovements(); i++) {
			if (containsPiece(moviment + 9, pieces) && validation) {
				if(!isSameColor(color, pieces.get(moviment + 9).getPieceColor())) possibleMoves.add(moviment+=9);
				i = moveBishop.getLowerRightMovements();
			}
			else possibleMoves.add(moviment+=9);
		}
		
		return possibleMoves;
	}
	
	private Set<Integer> kingMoviments(int source, PieceColor color) {
		Set<Integer> possibleKingMoves = new HashSet<>();
		
		if(!housesAbove.contains(source)) {
			if (!check(source, color, pieces) && !isPawnTopCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source - 8), pieces)) possibleKingMoves.add(source - 8);
			if (!check(source, color, pieces) && !isPawnTopRightCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source - 7), pieces) && !rightSideHouses.contains(source)) possibleKingMoves.add(source - 7);
			if (!check(source, color, pieces) && !isPawnTopLeftCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source - 9), pieces) && !leftSideHouses.contains(source)) possibleKingMoves.add(source - 9);
		}
		
		if(!leftSideHouses.contains(source)) {
			if (!check(source - 1, color, pieces) && !isPawnLeftCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source - 1), pieces)) possibleKingMoves.add(source - 1);
		}
		
		if (!rightSideHouses.contains(source)) {
			if (!check(source + 1, color, pieces) && !isPawnRightCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source + 1), pieces)) possibleKingMoves.add(source + 1);
		}
		
		if(!downHouses.contains(source)) {
			if (!check(source, color, pieces) && !isPawnDawnCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source + 8), pieces)) possibleKingMoves.add(source + 8);
			if (!check(source, color, pieces) && !isPawnDawnRightCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source + 9), pieces) && !rightSideHouses.contains(source)) possibleKingMoves.add(source + 9);
			if (!check(source , color, pieces) && !isPawnDawnLeftCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source + 7), pieces) && !leftSideHouses.contains(source)) possibleKingMoves.add(source + 7);
		}
		
		return possibleKingMoves;
	}
	
	private Set<Integer> queenMoviments(int source, PieceColor color) {
		Set<Integer> possibleQueenMoves = new HashSet<>();
		possibleQueenMoves = towerMoviments(source, color);
		possibleQueenMoves = bishopMoviments(source, color, possibleQueenMoves, true);
		
		return possibleQueenMoves;
	}
	
	public boolean check(int source, PieceColor color, List<Piece> pieces) {
		
		boolean horseCheck = isCheckInPosition(horseMoviments(source), source, PieceName.HORSE, color, pieces);
		boolean towerCheck = isCheckInPosition(towerMoviments(source, color), source, PieceName.TOWER, color, pieces);
		boolean bishopCheck = isCheckInPosition(bishopMoviments(source, color, null, true), source, PieceName.BISHOP, color, pieces);
		boolean queenCheck = isCheckInPosition(queenMoviments(source, color), source, PieceName.QUEEN, color, pieces);
		
		return horseCheck || towerCheck || bishopCheck || queenCheck;
	}

	private List<MoveTower> horizontalAndVerticalMovements() {
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
