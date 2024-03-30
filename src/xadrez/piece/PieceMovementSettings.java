package xadrez.piece;

import java.util.HashSet;
import java.util.Set;
import static xadrez.board.HousesFromBoard.*;

public class PieceMovementSettings {

	public Set<Integer> possibleMovements(Piece piece, int source) {
		Set<Integer> movements = new HashSet<>();
		
		if(piece.isPawn()) {
			movements = pawnMoviments(source, piece.getMoveQuantity());
			
		} else if (piece.isTower()) {
			movements = towerMoviments(source);
		}
		
		piece.incrementMoveQuantity();
		return movements;
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
}
