package xadrez.game;

import java.util.ArrayList;
import java.util.List;

import xadrez.piece.moves.MoveBishop;

public class TesteBishopMoves {

	public static void main(String[] args) {
		int count = 0;
		
//		List<MoveBishop> bishopMoves = lowerDiagonalMoviments();
//		List<MoveBishop> bishopMovesInversed = reverseList(bishopMoves);
//		for(MoveBishop move : bishopMovesInversed) {
//			System.out.println(move);
//			count++;
//			if(count == 8) {
//				System.out.println();
//				count = 0;
//			}
//		}
		
		List<Integer> upperDiagonalMoviments =  upperDiagonalMoviments();
		List<Integer> upperDiagonalMovimentsInversed = reverseList(upperDiagonalMoviments);
		for(Integer move : upperDiagonalMovimentsInversed) {
			System.out.println(move);
			count++;
				if(count == 8) {
					System.out.println();
					count = 0;
				}
		}
		
		
	}
	
	public static List<Integer> upperDiagonalMoviments() {
		List<Integer> upperDiagonalMoviments = new ArrayList<>();
		int upperDiagonalMoviment = 0, count = 0, totalCount = 0, index = 0;
		for(int i = 0; i <= 63; i++) {
			
			if(i >= 9 && count < totalCount) upperDiagonalMoviment++;
			
			if(i == index) {
				upperDiagonalMoviment = 0;
				index += 8;
				totalCount++;
				count = 0;
			}
			
			upperDiagonalMoviments.add(upperDiagonalMoviment);
			count++;
		}
		
		return upperDiagonalMoviments;
	}
	
	public static List<Integer> lowerDiagonalMoviments() {
		List<Integer> bishopMoves = new ArrayList<>();
		int lowerDiagonalMoviment = 7, count = 0, totalCount = 0, aux = 1, index = 8;
		for(int i = 0; i <= 63; i++) {	
			if(i == index) {
				lowerDiagonalMoviment = 7 - aux;
				index += 8;
				totalCount++;
				count = 0;
				aux++;
			}
			
			if(count > totalCount) lowerDiagonalMoviment--;
			
			bishopMoves.add(lowerDiagonalMoviment);
			count++;
		}
		
		return bishopMoves;
	}
	
//	public static List<MoveBishop> lowerDiagonalMoviments() {
//		List<MoveBishop> bishopMoves = new ArrayList<>();
//		int lowerRight = 7, count = 0, totalCount = 0, aux = 1, index = 8;
//		for(int i = 0; i <= 63; i++) {	
//			if(i == index) {
//				lowerRight = 7 - aux;
//				index += 8;
//				totalCount++;
//				count = 0;
//				aux++;
//			}
//			
//			if(count > totalCount) {
//				lowerRight--;
//			}
//			
//			bishopMoves.add(new MoveBishop(i, 0, 0, 0, lowerRight));
//			count++;
//		}
//		
//		return bishopMoves;
//	}
	
//	public static List<MoveBishop> reverseList(List<MoveBishop> list) {
//		int index=7, auxIndex = index, end = -1;
//		List<MoveBishop> movesInversed = new ArrayList<>();
//		for(int i = 0; i <= 63; i++) {
//			movesInversed.add(new MoveBishop(i, 0, list.get(index).getUpperLeftDiagonalMovements(), 0, 0));
//			index--;
//			if(index == end) {
//				auxIndex += 8;
//				end += 8;
//				if(auxIndex == 64) {
//					auxIndex--;
//					end--;
//				}
//				index = auxIndex;
//			}
//		}
//		return movesInversed;
//	}
	
	public static List<Integer> reverseList(List<Integer> list) {
		int index=7, auxIndex = index, end = -1;
		List<Integer> movesInversed = new ArrayList<>();
		for(int i = 0; i <= 63; i++) {
			movesInversed.add(list.get(index));
			index--;
			if(index == end) {
				auxIndex += 8;
				end += 8;
				if(auxIndex == 64) {
					auxIndex--;
					end--;
				}
				index = auxIndex;
			}
		}
		return movesInversed;
	}
	
	public static List<MoveBishop> movesBishop01() {
		List<MoveBishop> bishopMoves = new ArrayList<>();
		int upperLeft = 0, count = 0, totalCount = 0, index = 0;
		for(int i = 0; i <= 63; i++) {
			
			if(i >= 9 && count < totalCount) {
				upperLeft++;
			}
			
			if(i == index) {
				upperLeft = 0;
				index += 8;
				totalCount++;
				count = 0;
			}
			
			bishopMoves.add(new MoveBishop(i, upperLeft, 0, 0, 0));
			count++;
		}
		
		return bishopMoves;
	}
	
	public static List<MoveBishop> movesBishop02() {
		List<MoveBishop> bishopMoves = new ArrayList<>();
		int lowerRight = 7, count = 0, totalCount = 0, aux = 1, index = 8;
		for(int i = 0; i <= 63; i++) {	
			if(i == index) {
				lowerRight = 7 - aux;
				index += 8;
				totalCount++;
				count = 0;
				aux++;
			}
			
			if(count > totalCount) {
				lowerRight--;
			}
			
			bishopMoves.add(new MoveBishop(i, 0, 0, 0, lowerRight));
			count++;
		}
		
		return bishopMoves;
	}
}
