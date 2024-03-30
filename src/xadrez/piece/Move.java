package xadrez.piece;

import java.util.Objects;

public class Move {

	private Integer index;
	
	private Integer movimentsToUp;
	
	private Integer movimentsToLeft;
	
	private Integer movimentsToRight;
	
	private Integer movimentsToDown;

	public Move(Integer index, Integer movimentsToUp, Integer movimentsToLeft, Integer movimentsToRight,
			Integer movimentsToDown) {
		this.index = index;
		this.movimentsToUp = movimentsToUp;
		this.movimentsToLeft = movimentsToLeft;
		this.movimentsToRight = movimentsToRight;
		this.movimentsToDown = movimentsToDown;
	}

	public Integer getIndex() {
		return index;
	}

	public Integer getMovimentsToUp() {
		return movimentsToUp;
	}

	public Integer getMovimentsToLeft() {
		return movimentsToLeft;
	}

	public Integer getMovimentsToRight() {
		return movimentsToRight;
	}

	public Integer getMovimentsToDown() {
		return movimentsToDown;
	}

	@Override
	public String toString() {
		return "Move [index=" + index + ", movimentsToUp=" + movimentsToUp + ", movimentsToLeft=" + movimentsToLeft
				+ ", movimentsToRight=" + movimentsToRight + ", movimentsToDown=" + movimentsToDown + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(index, movimentsToLeft, movimentsToRight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Move other = (Move) obj;
		return Objects.equals(index, other.index) && Objects.equals(movimentsToLeft, other.movimentsToLeft)
				&& Objects.equals(movimentsToRight, other.movimentsToRight);
	}
}
