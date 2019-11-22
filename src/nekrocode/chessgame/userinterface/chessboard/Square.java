package nekrocode.chessgame.userinterface.chessboard;

import nekrocode.chessgame.chess.game.ChessColor;

/**
 * A model representing a chessboard square
 * 
 * @author ~
 *
 */
public final class Square {
	
	private final int rank;
	private final char file;
	private final int fileIndex;
	private final ChessColor color;
	
	public Square(char file, int rank, int fileIndex, ChessColor color) {
		this.file = file;
		this.rank = rank;
		this.fileIndex = fileIndex;
		this.color = color;
	}
	
	public int getRank() {
		return rank;
	}
	
	public char getFile() {
		return file;
	}
	
	public int getFileIndex() {
		return fileIndex;
	}
	
	public ChessColor getColor() {
		return color;
	}
	
	public String toString() {
		return file + "" + rank;
	}
	
}
