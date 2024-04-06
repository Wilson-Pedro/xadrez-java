package xadrez.piece.moves;

import java.util.Objects;

public class Move {

	private Integer index;

	public Move() {
	}

	public Move(Integer index) {
		super();
		this.index = index;
	}

	public Integer getIndex() {
		return index;
	}

	@Override
	public int hashCode() {
		return Objects.hash(index);
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
		return Objects.equals(index, other.index);
	}
}
