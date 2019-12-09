package nekrocode.chessgame.userinterface.modes;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PuzzleControlPanel extends JPanel {

	private static final long serialVersionUID = 2570781811224817749L;
	
	private PuzzleModeView view;
	private JButton startBtn, nextBtn;
	
	public PuzzleControlPanel(PuzzleModeView view) {
		this.view = view;
		startBtn = new JButton("Start");
		nextBtn = new JButton("Next");
		startBtn.addActionListener(o -> view.startSession());
		nextBtn.addActionListener(o -> view.nextPuzzle());
		add(startBtn);
		add(nextBtn);
	}
	
	public JButton getStartButton() {
		return startBtn;
	}
	
	public JButton getNextButton() {
		return nextBtn;
	}
	
}
