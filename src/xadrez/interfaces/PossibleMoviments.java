package xadrez.interfaces;

import java.util.List;
import java.util.Set;

import xadrez.piece.Piece;

public interface PossibleMoviments {

	Set<Integer> possibleMovements(int source, boolean autoincrement, List<Piece> pieces);
}
