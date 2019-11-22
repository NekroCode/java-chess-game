package nekrocode.chessgame.chess.board;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class represents a chessboard and is used to convey data from the BoardPresentation class
 * @author ~
 *
 */
public class Chessboard {
	
	// TODO Remove total ranks + files to user interface environment?
	public static final int TOTAL_RANKS = 8;
	public static final int TOTAL_FILES = TOTAL_RANKS;
	private char[][] boardPosition;
	
	public Chessboard(char[][] boardPosition) {
		this.boardPosition = boardPosition;
	}
	
	// TODO Find a better way of keeping an array immutable
	public static List<Character> getFileLetters() {
		return Collections.unmodifiableList(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'));
	}

}
