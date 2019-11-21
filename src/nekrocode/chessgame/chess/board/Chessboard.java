package nekrocode.chessgame.chess.board;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Chessboard {
	
	public static final int TOTAL_RANKS = 8;
	public static final int TOTAL_FILES = TOTAL_RANKS;
	private List<List<Square>> squares; // TODO make it final
	
	public Chessboard() {
		
	}
	
	// TODO Find a better way of keeping an array immutable
	public static List<Character> getFileLetters() {
		return Collections.unmodifiableList(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'));
	}
	
	public List<List<Square>> getSquares() {
		return Collections.unmodifiableList(squares);
	}

}
