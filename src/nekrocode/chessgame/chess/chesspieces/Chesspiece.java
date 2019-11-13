package nekrocode.chessgame.chess.chesspieces;

import java.util.ArrayList;

import nekrocode.chessgame.chess.ChessColors;
import nekrocode.chessgame.chess.chessboard.Square;

public abstract class Chesspiece {
	
	protected final String name;
	protected final char letter;
	protected final ChessColors color;
	protected boolean isPinned, isAttacked;
	protected Square position;
	protected ArrayList<Square> legalSquares;
	
	public Chesspiece(String name, char letter, ChessColors color) {
		this.name = name;
		this.letter = letter;
		this.color = color;
	}
	
	protected char getLetter() {
		return letter;
	}
	
	protected ChessColors getColor() {
		return color;
	}
	
	protected boolean isPinned() {
		return isPinned;
	}
	
	protected boolean isAttacked() {
		return isAttacked;
	}
	
	protected Square getPosition() {
		return position;
	}
	
	protected ArrayList<Square> getLegalSquares() {
		return legalSquares;
	}
}
