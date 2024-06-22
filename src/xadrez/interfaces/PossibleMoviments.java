package xadrez.interfaces;

import java.util.Set;

import xadrez.board.Board;

public interface PossibleMoviments {

	Set<Integer> possibleMovements(int source, boolean autoincrement, Board board);
}
