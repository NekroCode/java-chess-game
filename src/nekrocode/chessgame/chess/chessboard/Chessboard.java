package nekrocode.chessgame.chess.chessboard;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import nekrocode.chessgame.chess.ChessColors;
import nekrocode.chessgame.chess.visualrepresentations.ChessboardPanel;

// TODO Need a better system to initialize its graphical components.
public class Chessboard {
	
	private static final int totalRanks = 8;
	private static final int totalFiles = totalRanks;
	private final List<List<Square>> squares;
	private ChessColors orientation;
	private ChessboardPanel chessboardPanel;
	
	public Chessboard(List<List<Square>> squares, ChessColors orientation) {
		this.squares = squares;
		this.orientation = orientation;
	}
	
	public ChessColors getOrientation() {
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
	
	public static int getTotalRanks() {
		return totalRanks;
	}
	
	public static int getTotalFiles() {
		return totalFiles;
	}
	
	public void initVisualComponents() {
		chessboardPanel = new ChessboardPanel(this);
	}
	
	public ChessboardPanel getChessboardPanel() {
		return chessboardPanel;
	}
	
}
