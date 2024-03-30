package xadrez.piece;

import static xadrez.board.HousesFromBoard.generateDownHouses;
import static xadrez.board.HousesFromBoard.generateHousesAbove;
import static xadrez.board.HousesFromBoard.generateLeftSideHouses;
import static xadrez.board.HousesFromBoard.generateRightSideHouses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PieceMovementSettings {

	public Set<Integer> possibleMovements(Piece piece, int source) {
		Set<Integer> moves = new HashSet<>();
		
		if(piece.isPawn()) {
			moves = pawnMoviments(source, piece.getMoveQuantity());
			
		} else if (piece.isTower()) {
			moves = towerMoviments(source);
		}
		
		piece.incrementMoveQuantity();
		return moves;
	}
	
	public Set<Integer> pawnMoviments(int source, int moveQuantity) {
		Set<Integer> possiblePawnMoves = new HashSet<>();
		possiblePawnMoves.add(source - 8);
		if(moveQuantity == 0)
			possiblePawnMoves.add(source - (8*2));
		return possiblePawnMoves;
	}
	
	public Set<Integer> towerMoviments(int source) {
		Set<Integer> possibleTowerMoves = new HashSet<>();
		
		int moviment = source;
		boolean[] NoPiceOnTheEdge = piceOnTheEdge(source);
		
		// MOVER TORRE PARA CIMA
		while(!NoPiceOnTheEdge[0]) {
			
			if(moviment > 0)
				moviment -= 8;
			else
				NoPiceOnTheEdge[0] = true;
			possibleTowerMoves.add(moviment);
		}
		
		return possibleTowerMoves;
	}
	
	public boolean[] piceOnTheEdge(int source) {
		
		boolean[] piceOnTheEdge = new boolean[4];
		
		Set<Integer> housesAbove = generateHousesAbove();
		Set<Integer> rightSideHouses = generateRightSideHouses();
		Set<Integer> leftSideHouses = generateLeftSideHouses();
		Set<Integer> downHouses = generateDownHouses();
		
		piceOnTheEdge[0] = housesAbove.contains(source);
		piceOnTheEdge[1] = rightSideHouses.contains(source);
		piceOnTheEdge[2] = leftSideHouses.contains(source);
		piceOnTheEdge[3] = downHouses.contains(source);

		return piceOnTheEdge;
	}
	
	public List<Move> movesPossibleToLeftAndRight() {
		
		List<Move> moves = new ArrayList<>();
		int movimentsToUp = 0, movimentsToLeft = 0, movimentsToRight = 7, movimentsToDown = 7;
		
		for(int i = 0; i <= 63; i++) {
			moves.add(new Move(i, movimentsToUp, movimentsToLeft, movimentsToRight, movimentsToDown));
			movimentsToLeft++;
			movimentsToRight--;
			if(movimentsToLeft == 8 && movimentsToRight == -1) {
				movimentsToLeft = 0;
				movimentsToRight = 7;
				movimentsToUp++;
				movimentsToDown--;
			}
		}
		
		return moves;
	}
}