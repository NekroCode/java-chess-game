package nekrocode.chessgame.userinterface.modes;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nekrocode.chessgame.chess.game.enums.ChessColor;
import nekrocode.chessgame.userinterface.util.GridBagAppender;

/**
 * This class acts as a visual representation conveying chess puzzle information to the player
 * @author ~
 *
 */
public class PuzzleInfoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel toMove;
	
	public PuzzleInfoPanel() {
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		toMove = new JLabel();
		add(buildInfoPanel());
	}
	
	private JPanel buildInfoPanel() {
		JPanel panel = new JPanel();
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		GridBagAppender appender = new GridBagAppender(gridBag, c, panel);
		panel.setLayout(gridBag);
		appender.appendComponent(new JLabel("To move:"), 1, 1, 1, 1);
		appender.appendComponent(toMove, 1, 2, 1, 1);
		return panel;
	}
	
	public void displayToMove(ChessColor color) {
		if (color == ChessColor.LIGHT) {
			toMove.setText("White");
		} else if (color == ChessColor.DARK) {
			toMove.setText("Black");
		}
	}
	
	public void clearToMove() {
		toMove.setText("");
	}
	
}
