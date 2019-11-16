package nekrocode.chessgame.chess.chessboard;

import nekrocode.chessgame.chess.ChessColor;

// TODO May want to change the name to ChessboardSquare?
public class Square {
	
	private final char letter;
	private final int number;
	private final ChessColor color;
	
	public Square(char letter, int number, ChessColor color) {
		this.letter = letter;
		this.number = number;
		this.color = color;
	}
	
	public String toString() {
		return letter + "" + number;
	}
	
//	public String toString() {
//		return letter + "" + number + " : color: " + color;
//	}
	
	public ChessColor getColor() {
		return color;
	}
	
}
