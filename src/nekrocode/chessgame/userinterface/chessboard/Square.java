package nekrocode.chessgame.userinterface.chessboard;

import nekrocode.chessgame.chess.game.enums.ChessColor;

/**
 * A model representing a chessboard square
 * 
 * @author ~
 *
 */
public final class Square {
	
	private final char file;
	private final int fileIndex;
	private final int rank;
	private final ChessColor color;
	
	public Square(char file, int fileIndex, int rank, ChessColor color) {
		this.file = file;
		this.fileIndex = fileIndex;
		this.rank = rank;
		this.color = color;
	}
	
	public char getFile() {
		return file;
	}
	
	public int getFileIndex() {
		return fileIndex;
	}
	
	public int getRank() {
		return rank;
	}
	
	public ChessColor getColor() {
		return color;
	}
	
	public String toString() {
		return file + "" + rank;
	}
	
}
