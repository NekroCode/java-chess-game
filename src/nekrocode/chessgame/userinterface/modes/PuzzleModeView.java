package nekrocode.chessgame.userinterface.modes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import nekrocode.chessgame.modes.puzzles.PuzzleManager;
import nekrocode.chessgame.userinterface.chessboard.ChessboardView;
import nekrocode.chessgame.userinterface.util.GridBagAppender;

public class PuzzleModeView extends JPanel {

	private static final long serialVersionUID = 7252106225111030284L;
	private PuzzleManager puzzleManager;
	private PuzzleControlPanel puzzleControlPanel;
	private ChessboardView chessboardView;
	
	public PuzzleModeView() {
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setLayout(gridBag);
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		GridBagAppender appender = new GridBagAppender(gridBag, c, this);
		
		puzzleControlPanel = new PuzzleControlPanel(this);
		chessboardView = new ChessboardView(null);
		appender.appendComponent(chessboardView, 1, 1, 1, 5);
		appender.appendComponent(new PuzzleStatisticsPanel(), 2, 1, 1, 1);
		appender.appendComponent(puzzleControlPanel, 1, 6, 1, 1);
		
		
		puzzleManager = new PuzzleManager(this);
	}
	
	public PuzzleControlPanel getPuzzleControlPanel() {
		return puzzleControlPanel;
	}
	
	public void startSession() {
		puzzleManager.startSession();
	}
	
	public void nextPuzzle() {
		puzzleManager.nextPuzzle();
	}
	
	public ChessboardView getChessboardView() {
		return chessboardView;
	}
	
}
