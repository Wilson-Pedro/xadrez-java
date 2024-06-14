package xadrez.rules;

import static xadrez.board.HousesFromBoard.generateDownHouses;
import static xadrez.board.HousesFromBoard.generateHousesAbove;
import static xadrez.board.HousesFromBoard.generateLeftSideHouses;
import static xadrez.board.HousesFromBoard.generateRightSideHouses;
import static xadrez.rules.CheckRules.isCheckInPosition;
import static xadrez.rules.CheckRules.isPawnDawnCheck;
import static xadrez.rules.CheckRules.isPawnDawnLeftCheck;
import static xadrez.rules.CheckRules.isPawnDawnRightCheck;
import static xadrez.rules.CheckRules.isPawnLeftCheck;
import static xadrez.rules.CheckRules.isPawnRightCheck;
import static xadrez.rules.CheckRules.isPawnTopCheck;
import static xadrez.rules.CheckRules.isPawnTopLeftCheck;
import static xadrez.rules.CheckRules.isPawnTopRightCheck;
import static xadrez.utlis.Validations.containsPiece;
import static xadrez.utlis.Validations.containsPieceAndisDifferentColor;
import static xadrez.utlis.Validations.isSameColor;
import static xadrez.utlis.Validations.isSamePiece;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xadrez.board.Board;
import xadrez.enums.PieceColor;
import xadrez.enums.PieceName;
import xadrez.piece.Piece;

public class PieceMovementRules {
	
	CheckRules checkRules = new CheckRules();
	PawnMovimentsRules pawnRules = new PawnMovimentsRules();
	TowerMovimentsRules towerRules = new TowerMovimentsRules();
	HorseMovimentsRules horseRules = new HorseMovimentsRules();
	BishopMovimentsRules bishopRules = new BishopMovimentsRules();
	QueenMovimentsRules queenRules = new QueenMovimentsRules(towerRules, bishopRules);

	public Set<Integer> possibleMovements(int source, boolean autoincrement, List<Piece> pieces) {
		Set<Integer> moves = new HashSet<>();
		Piece piece = pieces.get(source);

		if (piece.isPawn()) {
			moves = pawnRules.pawnMoviments(source, pieces);
		} else if (piece.isTower()) {
			moves = towerRules.towerMoviments(source, piece.getPieceColor(), pieces);
		} else if (piece.isHorse()) {
			moves = horseRules.horseMoviments(source, pieces);
		} else if (piece.isBishop()) {
			moves = bishopRules.bishopMoviments(source, piece.getPieceColor(), moves, pieces, true);
		} else if (piece.isKing()) {
			moves = kingMoviments(source, piece.getPieceColor(), pieces);
		} else if (piece.isQueen()) {
			moves = queenRules.queenMoviments(source, piece.getPieceColor(), pieces);
		}

		if(autoincrement && !moves.isEmpty()) piece.incrementMoveQuantity();

		return moves;
	}
	
	//KING MOVIMENT
	private Set<Integer> kingMoviments(int source, PieceColor color, List<Piece> pieces) {
		Set<Integer> possibleKingMoves = new HashSet<>();

		
		if(!generateHousesAbove().contains(source)) {
			if (!check(source - 8, color, pieces) && !isPawnTopCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source - 8), pieces)) possibleKingMoves.add(source - 8);
			if (!check(source - 7, color, pieces) && !isPawnTopRightCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source - 7), pieces) && !generateRightSideHouses().contains(source)) possibleKingMoves.add(source - 7);
			if (!check(source - 9, color, pieces) && !isPawnTopLeftCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source - 9), pieces) && !generateLeftSideHouses().contains(source)) possibleKingMoves.add(source - 9);
		}
		
		if(!generateLeftSideHouses().contains(source)) {
			if (!check(source - 1, color, pieces) && !isPawnLeftCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source - 1), pieces)) possibleKingMoves.add(source - 1);
		}
		
		if (!generateRightSideHouses().contains(source)) {
			if (!check(source + 1, color, pieces) && !isPawnRightCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source + 1), pieces)) possibleKingMoves.add(source + 1);
		}
		
		if(!generateDownHouses().contains(source)) {
			if ((!check(source, color, pieces) && !check(source + 8, color, pieces)) && !isPawnDawnCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source + 8), pieces)) possibleKingMoves.add(source + 8);
			if (!check(source + 9, color, pieces) && !isPawnDawnRightCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source + 9), pieces) && !generateRightSideHouses().contains(source)) possibleKingMoves.add(source + 9);
			if (!check(source + 7, color, pieces) && !isPawnDawnLeftCheck(source, pieces, color) && containsPieceAndisDifferentColor(source, (source + 7), pieces) && !generateLeftSideHouses().contains(source)) possibleKingMoves.add(source + 7);
		}
		
		return possibleKingMoves;
	}
	
	//ROQUE MOVIMENT
	public void roque(Board board, PieceColor color) {
		var pieces = board.getPieces();
		int kingPosition = kingToRoquePosition(pieces, color);
		List<Integer> towersPosition = towerToRoquePosition(pieces, color);
		List<Integer> rockMoviments = roqueMoviments(color);
		var tower01 = pieces.get(towersPosition.get(0));
		var tower02 = pieces.get(towersPosition.get(1));
		
		if(!containsPiece(rockMoviments.get(0), pieces) && !containsPiece(rockMoviments.get(1), pieces) && !containsPiece(rockMoviments.get(2), pieces)) {
			board.movePiece(pieces, kingPosition, rockMoviments.get(1));
			board.movePiece(pieces, towersPosition.get(0), rockMoviments.get(2));
			tower01.incrementMoveQuantity();
			
		} else if (!containsPiece(rockMoviments.get(3), pieces) && !containsPiece(rockMoviments.get(4), pieces)) {
			board.movePiece(pieces, kingPosition, rockMoviments.get(4));
			board.movePiece(pieces, towersPosition.get(1), rockMoviments.get(3));
			tower02.incrementMoveQuantity();
		}
	}
	
	public boolean isPossibleRoque(Board board, PieceColor color) {
		var roqueMoviments = roqueMoviments(color);
		int kingPosition = kingToRoquePosition(board.getPieces(), color);
		var towerPositions = towerToRoquePosition(board.getPieces(), color);
		var pieces = board.getPieces();
		boolean isPossibleRook = false, 
				noMovimentFromKing = pieces.get(kingPosition).noMoviment(),
				noMovimentFromTower01 = pieces.get(towerPositions.get(0)).noMoviment(),
				noMovimentFromTower02 = pieces.get(towerPositions.get(1)).noMoviment(),
				isTower01 = pieces.get(towerPositions.get(0)).isTower(),
				isTower02 = pieces.get(towerPositions.get(1)).isTower();
		
		if(noMovimentFromKing && noMovimentFromTower01 && isTower01 && !containsPiece(roqueMoviments.get(0), pieces) && !containsPiece(roqueMoviments.get(1), pieces) && !containsPiece(roqueMoviments.get(2), pieces) && pieces.get(kingPosition).isKing() ) {
			if(!notInCheckForRoque(roqueMoviments, pieces, kingPosition, color, true)) isPossibleRook = true;
			
		} else if (noMovimentFromKing && noMovimentFromTower02 && isTower02 && !containsPiece(roqueMoviments.get(3), pieces) && !containsPiece(roqueMoviments.get(4), pieces) && pieces.get(kingPosition).isKing()) {
			if(!notInCheckForRoque(roqueMoviments, pieces, kingPosition, color, false)) isPossibleRook = true;
		}
		return isPossibleRook;
	}
	
	public boolean notInCheckForRoque(List<Integer> roqueMoviments, List<Piece> pieces, int kingPosition, PieceColor color, boolean validation) {
		
		boolean kingCheck = check(kingPosition, color, pieces);
		boolean roqueMovimentsCheck01 = check(roqueMoviments.get(0), color, pieces);
		boolean roqueMovimentsCheck02 = check(roqueMoviments.get(1), color, pieces);
		boolean roqueMovimentsCheck03 = check(roqueMoviments.get(2), color, pieces);
		boolean roqueMovimentsCheck04 = check(roqueMoviments.get(3), color, pieces);
		boolean roqueMovimentsCheck05 = check(roqueMoviments.get(4), color, pieces);
		
		if(validation) {
			return kingCheck || roqueMovimentsCheck01 || roqueMovimentsCheck02 || roqueMovimentsCheck03;
		} else {
			return kingCheck || roqueMovimentsCheck04 || roqueMovimentsCheck05;
		}
	}
	
	public int kingToRoquePosition(List<Piece> pieces, PieceColor color) {
		int kingPosition = 0;
		if (isSameColor(color, PieceColor.WHITE) && pieces.get(60).isKing()) {
			kingPosition = 60;
		} else if(isSameColor(color, PieceColor.BLACK) && pieces.get(4).isKing()) {
			kingPosition = 4;
		}
		
		return kingPosition;
	}
	
	public int findPiecePosition(List<Piece> pieces, PieceName pieceName, PieceColor color) {
		int kingPosition = 0;
		var piece = new Piece();
		for(int i = 0; i <= 63; i++) {
			piece = pieces.get(i);
			if(isSamePiece(piece.getPieceName(), pieceName) && isSameColor(piece.getPieceColor(), color)) kingPosition = i;
		}
		
		return kingPosition;
	}
	
	public List<Integer> towerToRoquePosition(List<Piece> pieces, PieceColor color) {
		List<Integer> towersPosition = List.of(56, 63);
		if(isSameColor(color, PieceColor.BLACK)) towersPosition = List.of(0, 7);
		return towersPosition;
	}
	
	public List<Integer> roqueMoviments(PieceColor color) {
		List<Integer> rockMoviments = List.of(57, 58, 59, 61, 62);
		if(isSameColor(color, PieceColor.BLACK)) rockMoviments = List.of(1, 2, 3, 5, 6);
		return rockMoviments;
	}
	
	public boolean check(int source, PieceColor color, List<Piece> pieces) {
		
		boolean horseCheck = isCheckInPosition(horseRules.horseMoviments(source, pieces), source, PieceName.HORSE, color, pieces);
		boolean towerCheck = isCheckInPosition(towerRules.towerMoviments(source, color, pieces), source, PieceName.TOWER, color, pieces);
		boolean bishopCheck = isCheckInPosition(bishopRules.bishopMoviments(source, color, null, pieces, true), source, PieceName.BISHOP, color, pieces);
		boolean queenCheck = isCheckInPosition(queenRules.queenMoviments(source, color, pieces), source, PieceName.QUEEN, color, pieces);
		
		return horseCheck || towerCheck || bishopCheck || queenCheck;
	}
	
	public boolean canGetTheKingOutOfCheck(Set<Integer> possibleMovements, int source, int kingPosition, Board board, PieceColor color) {
		boolean stilInCheck = true;
		var pieces = board.getPieces();
		var picesAux = pieces;
		int sourceAux = source;
		for(Integer moviment : possibleMovements) {
			board.movePiece(picesAux, source, moviment);
			if(!check(kingPosition, color, picesAux)) stilInCheck = false;
			source = moviment;
			if(stilInCheck == false) break;
		}
		if(!possibleMovements.isEmpty()) board.movePiece(picesAux, source, sourceAux);
		return stilInCheck;
	}
	
	public boolean isCheckmate(int kingPosition, Board board, PieceColor color) {
		boolean isCheckmate = false, stilInCheck=true;
		var pieces = board.getPieces();
		var piece = new Piece();
		Set<Integer> possibleMovements = new HashSet<>();
		Set<Integer> possibleKingMovements = new HashSet<>();
		possibleKingMovements = possibleMovements(kingPosition, false, board.getPieces());
		for(int i = 56; i <= 63; i++) {
			piece = pieces.get(i);
			if(!piece.isKing() && !piece.isUnnamed() && isSameColor(piece.getPieceColor(), color)) {
				possibleMovements = possibleMovements(i, false, board.getPieces());
				stilInCheck = canGetTheKingOutOfCheck(possibleMovements, i, kingPosition, board, color);
				if(!stilInCheck) break;
			}
		}
		if(check(kingPosition, color, board.getPieces()) && possibleKingMovements.isEmpty() && stilInCheck) isCheckmate = true;
		return isCheckmate;
	}
}
