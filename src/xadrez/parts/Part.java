package xadrez.parts;

import xadrez.enums.PartColor;
import xadrez.enums.PartName;

public class Part {
	
	private PartName partName;
	
	private String movement;
	
	private PartColor partColor;

	public Part(PartName partName, String movement, PartColor partColor) {
		this.partName = partName;
		this.movement = movement;
		this.partColor = partColor;
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
}
