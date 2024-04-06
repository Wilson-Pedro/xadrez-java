package xadrez.piece.moves;

public class MoveBishop extends Move{
	
	private Integer upperLeftDiagonalMovements;

	private Integer upperRightDiagonalMovements;
	
	private Integer lowerLeftMovements;
	
	private Integer lowerRightMovements;

	public MoveBishop() {
		super();
	}

	public MoveBishop(Integer index) {
		super(index);
	}

	public MoveBishop(Integer index, Integer upperLeftDiagonalMovements, Integer upperRightDiagonalMovements,
			Integer lowerLeftMovements, Integer lowerRightMovements) {
		super(index);
		this.upperLeftDiagonalMovements = upperLeftDiagonalMovements;
		this.upperRightDiagonalMovements = upperRightDiagonalMovements;
		this.lowerLeftMovements = lowerLeftMovements;
		this.lowerRightMovements = lowerRightMovements;
	}

	public Integer getUpperRightDiagonalMovements() {
		return upperRightDiagonalMovements;
	}

	public Integer getUpperLeftDiagonalMovements() {
		return upperLeftDiagonalMovements;
	}

	public Integer getLowerRightMovements() {
		return lowerRightMovements;
	}

	public Integer getLowerLeftMovements() {
		return lowerLeftMovements;
	}

	@Override
	public String toString() {
		return "[index = " + getIndex() + " upperLeft=" + upperLeftDiagonalMovements + ", upperRight="
				+ upperRightDiagonalMovements + ", lowerLeft=" + lowerLeftMovements + ", lowerRight="
				+ lowerRightMovements + "]";
	}
}
