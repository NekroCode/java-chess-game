package nekrocode.chessgame.chess.chessboard;

import nekrocode.chessgame.chess.ChessColor;

// TODO May want to change the name to ChessboardSquare?
public class Square {
	
	private final char file;
	private final int rank;
	private final int fileIndex;
	private final ChessColor color;
	
	public Square(char file, int rank, int fileIndex, ChessColor color) {
		this.file = file;
		this.rank = rank;
		this.fileIndex = fileIndex;
		this.color = color;
	}
	
	public String toString() {
		return file + "" + rank;
	}
	
	public int getFileIndex() {
		return fileIndex;
	}
	
	public ChessColor getColor() {
		return color;
	}
	
}
