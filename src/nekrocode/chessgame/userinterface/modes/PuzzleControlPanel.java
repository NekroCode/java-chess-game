package nekrocode.chessgame.userinterface.modes;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PuzzleControlPanel extends JPanel {

	private static final long serialVersionUID = 2570781811224817749L;
	
	private JButton startBtn, nextBtn;
	
	public PuzzleControlPanel(PuzzleModeView view) {
		startBtn = new JButton("Start");
		nextBtn = new JButton("Next");
		startBtn.addActionListener(o -> view.startSession());
		nextBtn.addActionListener(o -> view.nextPuzzle());
		startBtn.setEnabled(false);
		nextBtn.setEnabled(false);
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
