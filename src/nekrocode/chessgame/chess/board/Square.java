package nekrocode.chessgame.chess.board;

import nekrocode.chessgame.chess.ChessColor;

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
