package xadrez.piece;

import static xadrez.board.HousesFromBoard.generateDownHouses;
import static xadrez.board.HousesFromBoard.generateHousesAbove;
import static xadrez.board.HousesFromBoard.generateLeftSideHouses;
import static xadrez.board.HousesFromBoard.generateRightSideHouses;
import static xadrez.piece.moves.GenerateMove.generateBishopsMovements;
import static xadrez.piece.GeneratePiece.Unnamed;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xadrez.enums.PieceColor;
import xadrez.enums.PieceName;
import xadrez.piece.moves.MoveBishop;
import xadrez.piece.moves.MoveTower;

public class PieceMovementSettings {

	private Set<Integer> housesAbove = generateHousesAbove();
	private Set<Integer> rightSideHouses = generateRightSideHouses();
	private Set<Integer> leftSideHouses = generateLeftSideHouses();
	private Set<Integer> downHouses = generateDownHouses();
	
	private List<Piece> piecesInTheBoard = new ArrayList<>();

	public Set<Integer> possibleMovements(Piece piece, int source, List<Piece> pieces) {
		Set<Integer> moves = new HashSet<>();
		this.piecesInTheBoard = pieces;

		if (piece.isPawn()) {
			moves = pawnMoviments(source, piece.getMoveQuantity());
		} else if (piece.isTower()) {
			moves = towerMoviments(source);
		} else if (piece.isHorse()) {
			moves = horseMoviments(source);
		} else if (piece.isBishop()) {
			moves = bishopMoviments(source, moves, true);
		} else if (piece.isKing()) {
			moves = kingMoviments(source, piece.getPieceColor());
		} else if (piece.isQueen()) {
			moves = queenMoviments(source);
		}

		piece.incrementMoveQuantity();

		return moves;
	}

	private Set<Integer> pawnMoviments(int source, int moveQuantity) {
		Set<Integer> possiblePawnMoves = new HashSet<>();
		int moviment = source - 8;
		var piece = this.piecesInTheBoard.get(source);
		if (piece.isBlack()) moviment = source + 8;
		if (!isSameColor(source, (moviment)) && !containsPiece(moviment)) possiblePawnMoves.add(moviment);
		if (!isSameColor(source, (moviment + 1)) && containsPiece(moviment + 1) && !leftSideHouses.contains(moviment + 1)) possiblePawnMoves.add(moviment + 1);
		if (!isSameColor(source, (moviment - 1)) && containsPiece(moviment - 1) && !rightSideHouses.contains(moviment - 1)) possiblePawnMoves.add(moviment - 1);
		if (moveQuantity == 0 && !piece.isWhite() && !containsPiece(moviment) && !containsPiece(source + (8 * 2)) && !isSameColor(source, (source + (8 * 2)))) possiblePawnMoves.add(source + (8 * 2));
		if (moveQuantity == 0 && !piece.isBlack() && !containsPiece(moviment) && !containsPiece(source - (8 * 2)) && !isSameColor(source, (source - (8 * 2)))) possiblePawnMoves.add(source - (8 * 2));
		return possiblePawnMoves;
	}

	private Set<Integer> towerMoviments(int source) {
		Set<Integer> possibleTowerMoves = new HashSet<>();
		List<MoveTower> moves = horizontalAndVerticalMovements();
		MoveTower move = moves.get(source);

		int moviment = source;

		// MOVER TORRE PARA CIMA
		if (!housesAbove.contains(source)) {
			for (int i = 0; i < move.getMovimentsToUp(); i++) {
				if (containsPiece(moviment - 8)) {
					if (!isSameColor(source, (moviment - 8))) possibleTowerMoves.add(moviment -= 8);
					i = move.getMovimentsToUp();
				}
				else possibleTowerMoves.add(moviment -= 8);
			}
		}

		moviment = source;

		// MOVER TORRE PARA DIREITA
		if (!rightSideHouses.contains(source)) {
			for (int i = 0; i < move.getMovimentsToRight(); i++) {
				if (containsPiece(moviment + 1)) {
					if(!isSameColor(source, (moviment + 1))) possibleTowerMoves.add(moviment += 1);
					i = move.getMovimentsToRight();
				}
				else possibleTowerMoves.add(moviment += 1);
			}
		}

		moviment = source;

		// MOVER TORRE PARA ESQUERDA
		if (!leftSideHouses.contains(source)) {
			for (int i = 0; i < move.getMovimentsToLeft(); i++) {
				if (containsPiece(moviment - 1)) {
					if(!isSameColor(source, (moviment - 1))) possibleTowerMoves.add(moviment -= 1);
					i = move.getMovimentsToLeft();
				}
				else possibleTowerMoves.add(moviment -= 1);
			}
		}

		moviment = source;

		// MOVER TORRE PARA BAIXO
		if (!downHouses.contains(source)) {
			for (int i = 0; i < move.getMovimentsToDown(); i++) {
				if (containsPiece((moviment + 8))) {
					if (!isSameColor(source, (moviment + 8))) possibleTowerMoves.add(moviment += 8);
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
			if (movimentValid01 < 64 && movimentValid01 >= 0 && !movimentValid04 && !isSameColor(source, movimentValid01))
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03 && !isSameColor(source, movimentValid02))
				possibleHorseMoves.add(movimentValid02);
		}

		// MOVER CAVALO PARA DIREITA
		if (!rightSideHouses.contains(source)) {
			movimentValid01 = (source + 2) - 8;
			movimentValid02 = (source + 2) + 8;
			movimentValid03 = source + 1 == 63 || source + 1 == 7;
			movimentValid04 = leftSideHouses.contains(movimentValid01);
			if (movimentValid01 < 64 && movimentValid01 >= 0 && !movimentValid03 && !movimentValid04  && !isSameColor(source, movimentValid01))
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03 && !movimentValid04 && !isSameColor(source, movimentValid02))
				possibleHorseMoves.add(movimentValid02);
		}

		// MOVER CAVALO PARA ESQUERDA
		if (!leftSideHouses.contains(source)) {
			movimentValid01 = (source - 2) - 8;
			movimentValid02 = (source - 2) + 8;
			movimentValid03 = source - 1 == 56 || source - 1 == 0;
			movimentValid04 = rightSideHouses.contains(movimentValid01);
			if (movimentValid01 < 64 && movimentValid01 >= 0 && !movimentValid03 && !movimentValid04 && !isSameColor(source, movimentValid01))
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03 && !movimentValid04 && !isSameColor(source, movimentValid02))
				possibleHorseMoves.add(movimentValid02);
		}

		// MOVER CAVALO PARA BAIXO
		if (!downHouses.contains(source)) {
			movimentValid01 = (source + 16) + 1;
			movimentValid02 = (source + 16) - 1;
			movimentValid03 = rightSideHouses.contains(movimentValid02);
			if (movimentValid01 < 64 && movimentValid01 >= 0 && !isSameColor(source, movimentValid01))
				possibleHorseMoves.add(movimentValid01);
			if (movimentValid02 < 64 && movimentValid02 >= 0 && !movimentValid03 && !isSameColor(source, movimentValid02))
				possibleHorseMoves.add(movimentValid02);
		}

		return possibleHorseMoves;
	}

	private Set<Integer> bishopMoviments(int source, Set<Integer> possibleMoves, boolean validation) {
		if(possibleMoves == null) possibleMoves = new HashSet<>();
		List<MoveBishop> bishopsMovements = generateBishopsMovements();
		MoveBishop moveBishop = bishopsMovements.get(source);
		int moviment = source;
		
		for(int i = 0; i < moveBishop.getUpperLeftDiagonalMovements(); i++) {
			if (containsPiece((moviment - 9)) && validation) {
				if(!isSameColor(source, (moviment - 9))) possibleMoves.add(moviment-=9);
				i = moveBishop.getUpperLeftDiagonalMovements();
			}
			else possibleMoves.add(moviment-=9);
		}
		
		moviment = source;
		
		for(int i = 0; i < moveBishop.getUpperRightDiagonalMovements(); i++) {
			if (containsPiece((moviment - 7)) && validation) {
				if(!isSameColor(source, (moviment - 7))) possibleMoves.add(moviment-=7);
				i = moveBishop.getUpperRightDiagonalMovements();
			}
			else possibleMoves.add(moviment-=7);
		}
		
		moviment = source;
		
		for(int i = 0; i < moveBishop.getLowerLeftMovements(); i++) {
			if (containsPiece((moviment + 7)) && validation) {
				if(!isSameColor(source, (moviment + 7))) possibleMoves.add(moviment+=7);
				i = moveBishop.getLowerLeftMovements();
			}
			else possibleMoves.add(moviment+=7);
		}
		
		moviment = source;
		
		for(int i = 0; i < moveBishop.getLowerRightMovements(); i++) {
			if (containsPiece((moviment + 9)) && validation) {
				if(!isSameColor(source, (moviment + 9))) possibleMoves.add(moviment+=9);
				i = moveBishop.getLowerRightMovements();
			}
			else possibleMoves.add(moviment+=9);
		}
		
		return possibleMoves;
	}
	
	private Set<Integer> kingMoviments(int source, PieceColor color) {
		Set<Integer> possibleKingMoves = new HashSet<>();
		boolean pawnCheck = false;
		
		if(isSameColor(color, PieceColor.WHITE)) pawnCheck = isPawnTopOrDownCheck(source, piecesInTheBoard, color);
		
		if(!housesAbove.contains(source)) {
			if (!check(source - 8, color, piecesInTheBoard) && !pawnCheck && !containsPiece(source - 8) && !isSameColor(source, (source - 8))) possibleKingMoves.add(source - 8);
			if (!check(source - 7, color, piecesInTheBoard) && !pawnCheck && !containsPiece(source - 7) && !isSameColor(source, (source - 7)) && !rightSideHouses.contains(source)) possibleKingMoves.add(source - 7);
			if (!check(source - 9, color, piecesInTheBoard) && !pawnCheck && !containsPiece(source - 9) && !isSameColor(source, (source - 9)) && !leftSideHouses.contains(source)) possibleKingMoves.add(source - 9);
		}
		
		if(!leftSideHouses.contains(source)) {
			if (!check(source - 1, color, piecesInTheBoard) && !isPawnRightCheck(source, piecesInTheBoard, color) && !containsPiece(source - 1) && !isSameColor(source, source - 1)) possibleKingMoves.add(source - 1);
		}
		
		if (!rightSideHouses.contains(source)) {
			if (!check(source + 1, color, piecesInTheBoard) && !isPawnLeftCheck(source, piecesInTheBoard, color) && !containsPiece(source + 1) && !isSameColor(source, source + 1)) possibleKingMoves.add(source + 1);
		}
		
		if(isSameColor(color, PieceColor.BLACK)) pawnCheck = isPawnTopOrDownCheck(source, piecesInTheBoard, color);
		else pawnCheck = false;
		
		if(!downHouses.contains(source)) {
			if (!check(source + 8, color, piecesInTheBoard) && !pawnCheck && !containsPiece(source + 8) && !isSameColor(source, (source + 8))) possibleKingMoves.add(source + 8);
			if (!check(source + 9, color, piecesInTheBoard) && !pawnCheck && !containsPiece(source + 9) && !isSameColor(source, (source + 9)) && !rightSideHouses.contains(source)) possibleKingMoves.add(source + 9);
			if (!check(source + 7, color, piecesInTheBoard) && !pawnCheck && !containsPiece(source + 7) && !isSameColor(source, (source + 7)) && !leftSideHouses.contains(source)) possibleKingMoves.add(source + 7);
		}
		
		return possibleKingMoves;
	}
	
	private Set<Integer> queenMoviments(int source) {
		Set<Integer> possibleQueenMoves = new HashSet<>();
		possibleQueenMoves = towerMoviments(source);
		possibleQueenMoves = bishopMoviments(source, possibleQueenMoves, true);
		
		return possibleQueenMoves;
	}
	
	public boolean check(int source, PieceColor color, List<Piece> pieces) {
		
		boolean horseCheck = isCheck(horseMoviments(source), source, PieceName.HORSE, color, pieces);
		boolean towerCheck = isCheck(towerMoviments(source), source, PieceName.TOWER, color, pieces);
		boolean bishopCheck = isCheck(bishopMoviments(source, null, true), source, PieceName.BISHOP, color, pieces);
		boolean queenCheck = isCheck(queenMoviments(source), source, PieceName.QUEEN, color, pieces);
		
		return horseCheck || towerCheck || bishopCheck || queenCheck;
	}

	private boolean isCheck(Set<Integer> moviments, int source, PieceName pieceName, PieceColor color, List<Piece> pieces) {
		boolean check = false;
		var piece = new Piece();
		for(Integer x : moviments) {
			piece = pieces.get(x);
			if(containsPieceInPosition(source, pieces) && !isSameColor(color, piece.getPieceColor())) check = false;
			if(containsPiece(x) && !isSameColor(color, piece.getPieceColor()) && piece.getPieceName().equals(pieceName)) check = true;
		}
		return check;
	}
	
	private boolean isPawnTopOrDownCheck(int source, List<Piece> pieces, PieceColor color) {
		boolean pawnTopCheck = false;
		int moviment = source - 8, moviment2 = source - 16;
		if (isSameColor(color, PieceColor.BLACK)) {
			moviment = source + 8; 
			moviment2 = source + 16;
		}

		if (containsPiece(moviment + 1) && !isSameColor(source, (moviment + 1)) && !leftSideHouses.contains(moviment + 1) && pieceIs(pieces, moviment + 1, PieceName.PAWN)) pawnTopCheck = false;
		if (containsPiece(moviment - 1) && !isSameColor(source, (moviment - 1)) && !rightSideHouses.contains(moviment - 1) && pieceIs(pieces, moviment - 1, PieceName.PAWN)) pawnTopCheck = false;
		
		if (containsPiece(moviment2 + 1) && !isSameColor(source, (moviment2 + 1)) && !leftSideHouses.contains(moviment2 + 1) && pieceIs(pieces, moviment2 + 1, PieceName.PAWN)) pawnTopCheck = true;
		if (containsPiece(moviment2 - 1) && !isSameColor(source, (moviment2 - 1)) && !rightSideHouses.contains(moviment2 - 1) && pieceIs(pieces, moviment2 - 1, PieceName.PAWN)) pawnTopCheck = true;
		
		if (containsPiece(moviment2 + 2) && !isSameColor(source, (moviment2 + 2)) && !leftSideHouses.contains(moviment2 + 2) && pieceIs(pieces, moviment2 + 2, PieceName.PAWN)) pawnTopCheck = true;
		if (containsPiece(moviment2 - 2) && !isSameColor(source, (moviment2 - 2)) && !rightSideHouses.contains(moviment2 - 2) && pieceIs(pieces, moviment2 - 2, PieceName.PAWN)) pawnTopCheck = true;
		
		return pawnTopCheck;
	}
	
	private boolean isPawnRightCheck(int source, List<Piece> pieces, PieceColor color) {
		boolean pawnRightCheck = false;
		int moviment = source - 6;
		if (isSameColor(color, PieceColor.BLACK)) moviment = source + 6; 
		if (containsPiece(moviment) && !isSameColor(source, (moviment)) && !leftSideHouses.contains(moviment) && pieceIs(pieces, moviment, PieceName.PAWN)) pawnRightCheck = true;
		
		return pawnRightCheck;
	}
	
	private boolean isPawnLeftCheck(int source, List<Piece> pieces, PieceColor color) {
		boolean pawnLeftCheck = false;
		int moviment = source - 10;
		if (isSameColor(color, PieceColor.BLACK)) moviment = source + 10; 
		if (containsPiece(moviment) && !isSameColor(source, (moviment)) && !rightSideHouses.contains(moviment) && pieceIs(pieces, moviment, PieceName.PAWN)) pawnLeftCheck = true;
		
		return pawnLeftCheck;
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
	
	private boolean isSameColor(int source, int destination) {
		return piecesInTheBoard.get(source).getPieceColor().equals(piecesInTheBoard.get(destination).getPieceColor());
	}
	
	private boolean isSameColor(PieceColor color1, PieceColor color2) {
		return color1.equals(color2);
	}
	
	private boolean containsPiece(int destination) {
		var piece = piecesInTheBoard.get(destination);
		return piece.isWhite() || piece.isBlack();
	}
	
	private boolean containsPieceInPosition(int position, List<Piece> pieces) {
		return pieces.contains(pieces.get(position)) && !pieces.get(position).equals(Unnamed);
	}
	
	private boolean pieceIs(List<Piece> pieces, int source, PieceName pieceName) {
		return pieces.get(source).getPieceName().equals(pieceName);
	}
}
