package xadrez.piece;

import xadrez.enums.PartColor;
import xadrez.enums.PartName;

public class Piece {
	
	private PartName partName;
	
	private String movement;
	
	private PartColor partColor;
	
	private String acronym;
	
	private Integer moveQuantity;
	

	public Piece() {
	}

	public Piece(PartName partName, String movement, PartColor partColor, String acronym, Integer moveQuantity) {
		super();
		this.partName = partName;
		this.movement = movement;
		this.partColor = partColor;
		this.acronym = acronym;
		this.moveQuantity = moveQuantity;
	}

	public PartName getPartName() {
		return partName;
	}

	public void setPartName(PartName partName) {
		this.partName = partName;
	}

	public String getMovement() {
		return movement;
	}

	public void setMovement(String movement) {
		this.movement = movement;
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

	@Override
	public String toString() {
		return "Part [partName=" + partName + ", movement=" + movement + ", partColor=" + partColor + ", acronym="
				+ acronym + "]";
	}
}
