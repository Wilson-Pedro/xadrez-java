package xadrez.parts;

import xadrez.enums.PartColor;
import xadrez.enums.PartName;

public class Part {
	
	private PartName partName;
	private String move;
	private PartColor partColor;

	public Part(PartName partName, String move, PartColor partColor) {
		this.partName = partName;
		this.move = move;
		this.partColor = partColor;
	}

	public PartName getPartName() {
		return partName;
	}

	public void setPartName(PartName partName) {
		this.partName = partName;
	}

	public String getMove() {
		return move;
	}

	public void setMove(String move) {
		this.move = move;
	}

	public PartColor getPartColor() {
		return partColor;
	}

	public void setPartColor(PartColor partColor) {
		this.partColor = partColor;
	}
}
