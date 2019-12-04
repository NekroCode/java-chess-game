package nekrocode.chessgame.chess.pieces;

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
	protected final byte[][] MOVE_SET;
	protected final int MOVE_INCREMENT;
	
	public ChessPiece(String name, char letter, ChessColor color, int moveIncrement, byte[][] moveSet) {
		NAME = name;
		LETTER = letter;
		COLOR = color;
		MOVE_SET = moveSet;
		MOVE_INCREMENT = moveIncrement;
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
	
	public byte[][] getMoveSet() {
		return MOVE_SET;
	}
	
	public int getMoveIncrement() {
		return MOVE_INCREMENT;
	}
	
}
