package nekrocode.chessgame.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import nekrocode.chessgame.chess.game.enums.ChessColor;

/**
 * Abstract class representing the general purpose of a chess piece
 * 
 * @author ~
 *
 */
public abstract class ChessPiece {
	
	protected final String NAME;
	protected final char LETTER;
	protected final ChessColor COLOR;
	// TODO The following two variables should be final but as a result,
	// the size of the constructor increases.
	// - Research the Builder Pattern
	// - Better way of passing the move increment and move set values from sub class
	protected final byte[][] MOVE_SETS;
	protected final int MOVE_INCREMENT;
	protected List<byte[]> legalMoves;
	
	public ChessPiece(String name, char letter, ChessColor color, int moveIncrement, byte[][] moveSet) {
		NAME = name;
		LETTER = letter;
		COLOR = color;
		MOVE_SETS = moveSet;
		MOVE_INCREMENT = moveIncrement;
		legalMoves = new ArrayList<byte[]>();
	}
	
	public char getLetter() {
		return LETTER;
	}
	
	public ChessColor getColor() {
		return COLOR;
	}
	
	public String toString() {
		return NAME;
	}
	
	public byte[][] getMoveSets() {
		return MOVE_SETS;
	}
	
	public int getMoveIncrement() {
		return MOVE_INCREMENT;
	}
	
	public void setLegalMoves(List<byte[]> legalMoves) {
		this.legalMoves = legalMoves;
	}
	
	public List<byte[]> getLegalMoves() {
		return legalMoves;
	}
	
}
