package xadrez.piece;

import xadrez.enums.PartColor;
import xadrez.enums.PieceName;

public class Piece {
	
	private PieceName pieceName;
	
	private PartColor partColor;
	
	private String acronym;
	
	private Integer moveQuantity;
	

	public Piece() {
	}

	public Piece(PieceName pieceName, PartColor partColor, String acronym, Integer moveQuantity) {
		this.pieceName = pieceName;
		this.partColor = partColor;
		this.acronym = acronym;
		this.moveQuantity = moveQuantity;
	}

	public PieceName getPieceName() {
		return pieceName;
	}

	public void setPieceName(PieceName pieceName) {
		this.pieceName = pieceName;
	}

	public PartColor getPartColor() {
		return partColor;
	}

	public void setPartColor(PartColor partColor) {
		this.partColor = partColor;
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

	@Override
	public String toString() {
		return "Piece [partName=" + pieceName + ", partColor=" + partColor + ", acronym=" + acronym + ", moveQuantity="
				+ moveQuantity + "]";
	}
}
