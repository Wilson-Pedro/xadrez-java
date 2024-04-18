package xadrez.piece;

import xadrez.enums.PieceColor;
import xadrez.enums.PieceName;

public class Piece {
	
	private PieceName pieceName;
	
	private PieceColor pieceColor;
	
	private String acronym;
	
	private Integer moveQuantity;
	

	public Piece() {
	}

	public Piece(PieceName pieceName, PieceColor pieceColor, String acronym, Integer moveQuantity) {
		this.pieceName = pieceName;
		this.pieceColor = pieceColor;
		this.acronym = acronym;
		this.moveQuantity = moveQuantity;
	}

	public PieceName getPieceName() {
		return pieceName;
	}

	public void setPieceName(PieceName pieceName) {
		this.pieceName = pieceName;
	}

	public PieceColor getPieceColor() {
		return pieceColor;
	}

	public void setPieceColor(PieceColor pieceColor) {
		this.pieceColor = pieceColor;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public Integer getMoveQuantity() {
		return moveQuantity;
	}

	public void setMoveQuantity(Integer moveQuantity) {
		this.moveQuantity = moveQuantity;
	}
	
	public void incrementMoveQuantity() {
		this.moveQuantity += 1;
	}
	
	public boolean isPawn() {
		return pieceName.equals(PieceName.PAWN);
	}
	
	public boolean isTower() {
		return pieceName.equals(PieceName.TOWER);
	}
	
	public boolean isHorse() {
		return pieceName.equals(PieceName.HORSE);
	}
	
	public boolean isBishop() {
		return pieceName.equals(PieceName.BISHOP);
	}
	
	public boolean isQueen() {
		return pieceName.equals(PieceName.QUEEN);
	}
	
	public boolean isKing() {
		return pieceName.equals(PieceName.KING);
	}
	
	public boolean isBlack() {
		return pieceColor.equals(PieceColor.BLACK);
	}
	
	public boolean isWhite() {
		return pieceColor.equals(PieceColor.WHITE);
	}

	@Override
	public String toString() {
		return "Piece [partName=" + pieceName + ", partColor=" + pieceColor + ", acronym=" + acronym + ", moveQuantity="
				+ moveQuantity + "]";
	}
}
