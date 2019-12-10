package nekrocode.chessgame.modes.puzzles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import nekrocode.chessgame.chess.game.ChessGame;
import nekrocode.chessgame.chess.util.FenNotationParser;
import nekrocode.chessgame.chess.util.FenParsingManager;
import nekrocode.chessgame.userinterface.modes.PuzzleModeView;

/**
 * This class manages the course of a chess puzzle session
 * 
 * TODO Improvements:
 * - The FEN board position notation is being validated twice currently. Once during FenPositionParser work and another time
 * during the actual parsing of the position in FenPositionParser. Reduce it to once in the future.
 * 
 * @author ~
 *
 */
public class PuzzleManager {
	
	private PuzzleModeView view;
	private JButton startBtn, nextBtn;
	private List<List<Map<String, String>>> puzzleCollection;
	
	public PuzzleManager(PuzzleModeView view) {
		this.view = view;
		startBtn = view.getPuzzleControlPanel().getStartButton();
		nextBtn = view.getPuzzleControlPanel().getNextButton();
		parsePuzzles();
		startBtn.setEnabled(true);
	}
	
	public void startSession() {
		startBtn.setEnabled(false);
		createPuzzle();
	}
	
	private void createPuzzle() {
		
	}
	
	private void endPuzzle() {
		nextBtn.setEnabled(true);
	}
	
	public void nextPuzzle() {
		nextBtn.setEnabled(false);
	}
	
	private void parsePuzzles() {
		puzzleCollection = new ArrayList<List<Map<String, String>>>();
		FenParsingManager parsingManager = new FenParsingManager();
		puzzleCollection.add(parsingManager.parseNotation("puzzles/wtharveycomm8n2.txt"));
		puzzleCollection.add(parsingManager.parseNotation("puzzles/wtharveycomm8n3.txt"));
		puzzleCollection.add(parsingManager.parseNotation("puzzles/wtharveycomm8n4.txt"));
	}
	
}
