package nekrocode.chessgame.chess.pieces;

import nekrocode.chessgame.chess.game.ChessColor;

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
	
	public ChessPiece(String name, char letter, ChessColor color) {
		NAME = name;
		LETTER = letter;
		COLOR = color;
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

}
