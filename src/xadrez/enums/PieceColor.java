package xadrez.enums;

public enum PieceColor {

	BLACK(0),
	WHITE(1),
	NO_COLOR(3);
	
	private Integer code;

	private PieceColor(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}


}
