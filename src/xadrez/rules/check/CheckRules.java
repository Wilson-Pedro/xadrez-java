package xadrez.rules.check;

import static xadrez.board.HousesFromBoard.generateLeftSideHouses;
import static xadrez.board.HousesFromBoard.generateRightSideHouses;
import static xadrez.utils.Util.containsPiece;
import static xadrez.utils.Util.containsPieceInPosition;
import static xadrez.utils.Util.isSameColor;
import static xadrez.utils.Util.pieceIs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xadrez.board.Board;
import xadrez.enums.PieceColor;
import xadrez.enums.PieceName;
import xadrez.interfaces.PossibleMoviments;
import xadrez.piece.Piece;
import xadrez.rules.moviments.BishopMovimentsRules;
import xadrez.rules.moviments.HorseMovimentsRules;
import xadrez.rules.moviments.PawnMovimentsRules;
import xadrez.rules.moviments.QueenMovimentsRules;
import xadrez.rules.moviments.TowerMovimentsRules;

public class CheckRules implements PossibleMoviments{
	
	private PawnMovimentsRules pawnRules;
	
	private TowerMovimentsRules towerRules;
	
	private HorseMovimentsRules horseRules;
	
	private BishopMovimentsRules bishopRules;
	
	private QueenMovimentsRules queenRules;
	
	public CheckRules(PawnMovimentsRules pawnRules, TowerMovimentsRules towerRules, HorseMovimentsRules horseRules,
			BishopMovimentsRules bishopRules, QueenMovimentsRules queenRules) {
		this.pawnRules = pawnRules;
		this.towerRules = towerRules;
		this.horseRules = horseRules;
		this.bishopRules = bishopRules;
		this.queenRules = queenRules;
	}

	@Override
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
		} else if (piece.isQueen()) {
			moves = queenRules.queenMoviments(source, piece.getPieceColor(), pieces);
		}

		if(autoincrement && !moves.isEmpty()) piece.incrementMoveQuantity();

		return moves;
	}
	
	public boolean isCheckmate(int kingPosition, Board board, PieceColor color, Set<Integer> possibleKingMovements) {
		boolean isCheckmate = false, stilInCheck=true;
		var pieces = board.getPieces();
		var piece = new Piece();
		Set<Integer> possibleMovements = new HashSet<>();
		for(int i = 0; i <= 63; i++) {
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

	public static boolean isCheckInPosition(Set<Integer> moviments, int source, PieceName pieceName, PieceColor color, List<Piece> pieces) {
		boolean check = false;
		var piece = new Piece();
		int count = 0;
		for(Integer x : moviments) {
			piece = pieces.get(x);
			if(count == 0) {
				if(containsPieceInPosition(source, pieces) && !isSameColor(color, piece.getPieceColor())) check = false;
				count++;
			}
			if(containsPiece(x, pieces) && !isSameColor(color, piece.getPieceColor()) && piece.getPieceName().equals(pieceName)) check = true;
		}
		return check;
	}
	
	public static boolean isPawnTopCheck(int source, List<Piece> pieces, PieceColor color) {
		boolean pawnCheck = false;
		int moviment2 = source - 16;
		if (isSameColor(color, PieceColor.BLACK)) moviment2 = source;
		if (containsPiece(moviment2 + 1, pieces) && !isSameColor(source, (moviment2 + 1), pieces) && !generateLeftSideHouses().contains(moviment2 + 1) && pieceIs(pieces, moviment2 + 1, PieceName.PAWN)) pawnCheck = true;
		if (containsPiece(moviment2 - 1, pieces) && !isSameColor(source, (moviment2 - 1), pieces) && !generateRightSideHouses().contains(moviment2 - 1) && pieceIs(pieces, moviment2 - 1, PieceName.PAWN)) pawnCheck = true;
		
		return pawnCheck;
	}
	
	public static boolean isPawnTopRightCheck(int source, List<Piece> pieces, PieceColor color) {
		boolean pawnCheck = false;
		int moviment2 = source - 16;
		if (isSameColor(color, PieceColor.BLACK)) moviment2 = source + 2;
		if (containsPiece(moviment2, pieces) && !isSameColor(source, (moviment2), pieces) && !generateRightSideHouses().contains(moviment2) && pieceIs(pieces, moviment2, PieceName.PAWN)) pawnCheck = true;
		if (containsPiece(moviment2 + 2, pieces) && !isSameColor(source, (moviment2 + 2), pieces) && !generateLeftSideHouses().contains(moviment2 + 2) && pieceIs(pieces, moviment2 + 2, PieceName.PAWN)) pawnCheck = true;
		
		return pawnCheck;
	}
	
	public static boolean isPawnTopLeftCheck(int source, List<Piece> pieces, PieceColor color) {
		boolean pawnCheck = false;
		int moviment2 = source - 16;
		if (isSameColor(color, PieceColor.BLACK)) moviment2 = source - 2;
		if (containsPiece(moviment2, pieces) && !isSameColor(source, (moviment2), pieces) && !generateRightSideHouses().contains(moviment2) && pieceIs(pieces, moviment2, PieceName.PAWN)) pawnCheck = true;
		if (containsPiece(moviment2 - 2, pieces) && !isSameColor(source, (moviment2 - 2), pieces) && !generateLeftSideHouses().contains(moviment2 - 2) && pieceIs(pieces, moviment2 - 2, PieceName.PAWN)) pawnCheck = true;
		
		return pawnCheck;
	}
	
	public static boolean isPawnDawnCheck(int source, List<Piece> pieces, PieceColor color) {
		boolean pawnCheck = false;
		int moviment1 = source;
		if (isSameColor(color, PieceColor.BLACK)) moviment1 = source + 16;
		if (containsPiece(moviment1 + 1, pieces) && !isSameColor(source, (moviment1 + 1), pieces) && !generateLeftSideHouses().contains(moviment1 + 1) && pieceIs(pieces, moviment1 + 1, PieceName.PAWN)) pawnCheck = true;
		if (containsPiece(moviment1 - 1, pieces) && !isSameColor(source, (moviment1 - 1), pieces) && !generateRightSideHouses().contains(moviment1 - 1) && pieceIs(pieces, moviment1 - 1, PieceName.PAWN)) pawnCheck = true;
		
		return pawnCheck;
	}
	
	public static boolean isPawnDawnRightCheck(int source, List<Piece> pieces, PieceColor color) {
		boolean pawnCheck = false;
		int moviment1 = source + 2;
		if (isSameColor(color, PieceColor.BLACK)) moviment1 = source + 18;
		if (containsPiece(moviment1, pieces) && !isSameColor(source, (moviment1), pieces) && !generateLeftSideHouses().contains(moviment1) && pieceIs(pieces, moviment1, PieceName.PAWN)) pawnCheck = true;
		
		return pawnCheck;
	}
	
	public static boolean isPawnDawnLeftCheck(int source, List<Piece> pieces, PieceColor color) {
		boolean pawnCheck = false;
		int moviment1 = source - 2;
		if (isSameColor(color, PieceColor.BLACK)) moviment1 = source + 14;
		if (containsPiece(moviment1, pieces) && !isSameColor(source, (moviment1), pieces) && !generateLeftSideHouses().contains(moviment1) && pieceIs(pieces, moviment1, PieceName.PAWN)) pawnCheck = true;
		
		return pawnCheck;
	}
	
	public static boolean isPawnRightCheck(int source, List<Piece> pieces, PieceColor color) {
		boolean pawnRightCheck = false;
		int moviment = source - 6;
		if (isSameColor(color, PieceColor.BLACK)) moviment = source + 6; 
		if (containsPiece(moviment, pieces) && !isSameColor(source, (moviment), pieces) && !generateLeftSideHouses().contains(moviment) && pieceIs(pieces, moviment, PieceName.PAWN)) pawnRightCheck = true;
		
		return pawnRightCheck;
	}
	
	public static boolean isPawnLeftCheck(int source, List<Piece> pieces, PieceColor color) {
		boolean pawnLeftCheck = false;
		int moviment = source - 10;
		if (isSameColor(color, PieceColor.BLACK)) moviment = source + 10; 
		if (containsPiece(moviment, pieces) && !isSameColor(source, (moviment), pieces) && !generateRightSideHouses().contains(moviment) && pieceIs(pieces, moviment, PieceName.PAWN)) pawnLeftCheck = true;
		
		return pawnLeftCheck;
	}
}
