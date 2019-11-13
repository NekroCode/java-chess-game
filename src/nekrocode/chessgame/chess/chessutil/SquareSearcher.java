package nekrocode.chessgame.chess.chessutil;

import java.util.List;

import nekrocode.chessgame.chess.chessboard.IllegalSquareException;
import nekrocode.chessgame.chess.chessboard.Square;

public class SquareSearcher {
	
	private final List<List<Square>> squares;
	
	public SquareSearcher(List<List<Square>> squares) {
		this.squares = squares;
	}
	
	// TODO Add logic if needed
	public Square getSquare(String name) throws IllegalSquareException {
		return null;
	}
	
	public Square getSquare(int rank, int file) throws IllegalSquareException {
		Square s = squares.get(rank).get(file);
		System.out.println(s.toString());
		return null;
	}
	
}
