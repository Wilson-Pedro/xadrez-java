package xadrez.rules.check;

import static xadrez.board.HousesFromBoard.generateLeftSideHouses;
import static xadrez.board.HousesFromBoard.generateRightSideHouses;
import static xadrez.rules.moviments.BishopMovimentsRules.bishopMoviments;
import static xadrez.rules.moviments.HorseMovimentsRules.horseMoviments;
import static xadrez.rules.moviments.PawnMovimentsRules.pawnMoviments;
import static xadrez.rules.moviments.QueenMovimentsRules.queenMoviments;
import static xadrez.rules.moviments.TowerMovimentsRules.towerMoviments;
import static xadrez.utils.Util.containsPiece;
import static xadrez.utils.Util.containsPieceInPosition;
import static xadrez.utils.Util.isSameColor;
import static xadrez.utils.Util.isSamePiece;
import static xadrez.utils.Util.pieceIs;
import static xadrez.utils.Util.findPiecePosition;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xadrez.board.Board;
import xadrez.enums.PieceColor;
import xadrez.enums.PieceName;
import xadrez.interfaces.PossibleMoviments;
import xadrez.piece.Piece;

public class CheckRules implements PossibleMoviments{

	@Override
	public Set<Integer> possibleMovements(int source, Board board) {
		Set<Integer> moves = new HashSet<>();
		var pieces = board.getPieces();
		Piece piece = pieces.get(source);
		
		moves = switch(piece.getPieceName()) {
			case PAWN -> moves = pawnMoviments(source, board);
			case TOWER -> moves = towerMoviments(source, board);
			case HORSE -> moves = horseMoviments(source, board);
			case BISHOP -> moves = bishopMoviments(source, moves, board, true);
			case QUEEN -> moves = queenMoviments(source, board);
			default -> moves;
		};

		return moves;
	}
	
	public boolean isCheckmate(int kingPosition, Board board, Set<Integer> possibleKingMovements) {
		boolean isCheckmate = false, stilInCheck=true;
		var pieces = board.getPieces();
		var piece = new Piece();
		var color = board.getPieces().get(kingPosition).getPieceColor();
		
		Set<Integer> possibleMovements = new HashSet<>();
		for(int i = 0; i <= 63; i++) {
			piece = pieces.get(i);
			if(!piece.isKing() && !piece.isUnnamed() && isSameColor(piece.getPieceColor(), color)) {
				possibleMovements = possibleMovements(i, board);
				stilInCheck = canGetTheKingOutOfCheck(possibleMovements, i, board, color);
				if(!stilInCheck) break;
			}
		}
		if(check(kingPosition, color, board) && possibleKingMovements.isEmpty() && stilInCheck) isCheckmate = true;
		
		return isCheckmate;
	}
	
	public static boolean check(int source, PieceColor color, Board board) {
		var pieces = board.getPieces();
		
		boolean horseCheck = isCheckInPosition(horseMoviments(source, board), source, PieceName.HORSE, color, pieces);
		boolean towerCheck = isCheckInPosition(towerMoviments(source, board), source, PieceName.TOWER, color, pieces);
		boolean bishopCheck = isCheckInPosition(bishopMoviments(source, null, board, true), source, PieceName.BISHOP, color, pieces);
		boolean queenCheck = isCheckInPosition(queenMoviments(source, board), source, PieceName.QUEEN, color, pieces);
		
		return horseCheck || towerCheck || bishopCheck || queenCheck;
	}
	
	public static boolean isCheck(int source, int moviment, Board board) {
		boolean isCheck = false;
		int totalPieces = board.getTotalPieces();
		var color = board.getPieces().get(source).getPieceColor();
		int kingPosition = findPiecePosition(board.getPieces(), PieceName.KING, color);
		var pieceDestination = board.getPieces().get(moviment);
		
		board.movePiece(source, moviment);	
		isCheck = check(kingPosition, color, board);
		board.movePiece(moviment, source);
		
		if(board.getTotalPieces() < totalPieces) board.setPieceInTheBoard(pieceDestination, moviment);
		
		return isCheck;
	}
	
	public static boolean canGetTheKingOutOfCheck(Set<Integer> possibleMovements, int source, Board board, PieceColor color) {
		
		boolean stilInCheck = true;
		int sourceAux = source;
		int totalPieces = board.getTotalPieces();
		int kingPosition = findPiecePosition(board.getPieces(), PieceName.KING, color);
		var pieceDestination = new Piece();
		var pieceSource = board.getPieces().get(source);
		for(Integer moviment : possibleMovements) {
			pieceDestination = board.getPieces().get(moviment);
			board.movePiece(source, moviment);
			
			stilInCheck = check(kingPosition, color, board);
			if(board.getTotalPieces() < totalPieces) {
				board.setPieceInTheBoard(pieceDestination, moviment);
				board.setPieceInTheBoard(pieceSource, sourceAux);
				source = sourceAux;
			} else {
				source = moviment;
			}
			
			if(!stilInCheck) break;
		}
		
		board.setPieceInTheBoard(pieceSource, sourceAux);
		if(board.getTotalPieces() > totalPieces) board.setNoPieceInTheBoard(source);
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
			if(containsPiece(x, pieces) && !isSameColor(color, piece.getPieceColor()) && isSamePiece(piece.getPieceName(), pieceName)) check = true;
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
