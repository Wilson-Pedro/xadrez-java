package xadrez.rules;

import static xadrez.board.HousesFromBoard.generateDownHouses;
import static xadrez.board.HousesFromBoard.generateHousesAbove;
import static xadrez.board.HousesFromBoard.generateLeftSideHouses;
import static xadrez.board.HousesFromBoard.generateRightSideHouses;
import static xadrez.utlis.Validations.containsPiece;
import static xadrez.utlis.Validations.isSameColor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xadrez.enums.PieceColor;
import xadrez.piece.Piece;
import xadrez.piece.moves.MoveTower;

public class TowerMovimentsRules {

	//TOWER MOVIMENT
	public Set<Integer> towerMoviments(int source, PieceColor color, List<Piece> pieces) {
		Set<Integer> possibleTowerMoves = new HashSet<>();
		List<MoveTower> moves = horizontalAndVerticalMovements();
		MoveTower move = moves.get(source);

		int moviment = source;

		// MOVER TORRE PARA CIMA
		if (!generateHousesAbove().contains(source)) {
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
		if (!generateRightSideHouses().contains(source)) {
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
		if (!generateLeftSideHouses().contains(source)) {
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
		if (!generateDownHouses().contains(source)) {
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
