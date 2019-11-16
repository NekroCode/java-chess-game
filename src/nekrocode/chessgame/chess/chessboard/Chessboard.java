package nekrocode.chessgame.chess.chessboard;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import nekrocode.chessgame.chess.ChessColor;
import nekrocode.chessgame.chess.visualrepresentations.ChessboardPanel;

// TODO Need a better system to initialize its graphical components.
public class Chessboard {
	
	public static final int TOTAL_RANKS = 8;
	public static final int TOTAL_FILES = TOTAL_RANKS;
	private final List<List<Square>> squares;
	private ChessColor orientation;
	private ChessboardPanel chessboardPanel;
	
	public Chessboard(List<List<Square>> squares, ChessColor orientation) {
		this.squares = squares;
		this.orientation = orientation;
	}
	
	public ChessColor getOrientation() {
		return orientation;
	}
	
	// TODO immutable array
	public List<List<Square>> getSquares() {
		return Collections.unmodifiableList(squares);
	}
	
	// TODO immutable array
	public static List<Character> getFileLetters() {
		return Collections.unmodifiableList(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'));
	}
	
	public void initVisualComponent() {
		chessboardPanel = new ChessboardPanel(this);
	}
	
	public ChessboardPanel getChessboardPanel() {
		return chessboardPanel;
	}
	
}
