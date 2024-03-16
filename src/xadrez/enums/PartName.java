package xadrez.enums;

public enum PartName {
	
	PAWN(0),
	TOWER(1),
	HORSE(2),
	BISP(3),
	QUEEN(4),
	KING(5);
	
	private Integer code;
	
	private PartName(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
