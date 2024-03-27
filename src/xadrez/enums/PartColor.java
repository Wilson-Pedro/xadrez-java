package xadrez.enums;

public enum PartColor {

	BLACK(0),
	WHITE(1),
	NO_COLOR(3);
	
	private Integer code;

	private PartColor(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}


}
