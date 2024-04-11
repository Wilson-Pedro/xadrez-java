package xadrez.board;

import static xadrez.piece.GeneratePiece.Unnamed;

import java.util.ArrayList;
import java.util.List;

import xadrez.piece.GeneratePiece;
import xadrez.piece.Piece;

public class Board {
	
	private List<Piece> pieces = new ArrayList<>();

	public Board() {
	}
	
	public List<Piece> getPieces() {
		return pieces;
	}
	
	public void generatePieces() {
		this.pieces = GeneratePiece.generatePieces();
	}
	
	public void showPieces() {
		byte i = 1;
		for(Piece part : pieces) {
			System.out.print(" " + part.getAcronym() + " ");
			if(i == 8) {
				System.out.println("\n");
				i = 0;
			}
			i += 1;
		}
	}
	
	public void showPiecesWithIndex() {
		byte i = 1;
		byte index = 0;
		for(Piece part : pieces) {
			System.out.print(" " + part.getAcronym() + "(" + index + ")" + " ");
			if(i == 8) {
				System.out.println("\n");
				i = 0;
			}
			i += 1;
			index += 1;
		}
	}
	
	public void movePiece (List<Piece> parts, int source, int target) {
		parts.set(target, parts.get(source));
		parts.set(source, Unnamed);
	}

	@Override
	public String toString() {
		return "Board [parts=" + pieces + "]";
	}
}
