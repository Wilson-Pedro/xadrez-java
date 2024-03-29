package xadrez.piece;

import java.util.HashSet;
import java.util.Set;
import static xadrez.board.HousesFromBoard.*;

public class PieceMovementSettings {
	
	Set<Integer> housesAbove = generateHousesAbove();
	Set<Integer> rightSideHouses = generateRightSideHouses();
	Set<Integer> leftSideHouses = generateLeftSideHouses();
	Set<Integer> downHouses = generateDownHouses();

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
		boolean thereAreMoves = true;
		while(thereAreMoves) {
			if(moviment > 0)
				moviment -= 8;
			else
				thereAreMoves = false;
			possibleTowerMoves.add(moviment);
		}
		return possibleTowerMoves;
	}
}
