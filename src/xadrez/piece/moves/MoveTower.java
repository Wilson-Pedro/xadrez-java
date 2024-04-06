package xadrez.piece.moves;

public class MoveTower extends Move{
	
	private Integer movimentsToUp;
	
	private Integer movimentsToLeft;
	
	private Integer movimentsToRight;
	
	private Integer movimentsToDown;

	public MoveTower() {
		super();
	}

	public MoveTower(Integer index) {
		super(index);
	}

	public MoveTower(Integer index, Integer movimentsToUp, Integer movimentsToLeft, Integer movimentsToRight,
			Integer movimentsToDown) {
		super(index);
		this.movimentsToUp = movimentsToUp;
		this.movimentsToLeft = movimentsToLeft;
		this.movimentsToRight = movimentsToRight;
		this.movimentsToDown = movimentsToDown;
	}

	public Integer getMovimentsToUp() {
		return movimentsToUp;
	}

	public void setMovimentsToUp(Integer movimentsToUp) {
		this.movimentsToUp = movimentsToUp;
	}

	public Integer getMovimentsToLeft() {
		return movimentsToLeft;
	}

	public void setMovimentsToLeft(Integer movimentsToLeft) {
		this.movimentsToLeft = movimentsToLeft;
	}

	public Integer getMovimentsToRight() {
		return movimentsToRight;
	}

	public void setMovimentsToRight(Integer movimentsToRight) {
		this.movimentsToRight = movimentsToRight;
	}

	public Integer getMovimentsToDown() {
		return movimentsToDown;
	}

	public void setMovimentsToDown(Integer movimentsToDown) {
		this.movimentsToDown = movimentsToDown;
	}
}
