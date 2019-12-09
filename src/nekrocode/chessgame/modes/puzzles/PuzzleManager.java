package nekrocode.chessgame.modes.puzzles;

import javax.swing.JButton;

import nekrocode.chessgame.chess.game.ChessGame;
import nekrocode.chessgame.chess.util.FenNotationParser;
import nekrocode.chessgame.chess.util.FenParserManager;
import nekrocode.chessgame.userinterface.modes.PuzzleModeView;

public class PuzzleManager {
	
	private PuzzleModeView view;
	private JButton startBtn, nextBtn;
	
	public PuzzleManager(PuzzleModeView view) {
		this.view = view;
		startBtn = view.getPuzzleControlPanel().getStartButton();
		nextBtn = view.getPuzzleControlPanel().getNextButton();
		startBtn.setEnabled(false);
		nextBtn.setEnabled(false);
		loadPuzzles();
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
	
	private void loadPuzzles() {
		
	}
	
}
