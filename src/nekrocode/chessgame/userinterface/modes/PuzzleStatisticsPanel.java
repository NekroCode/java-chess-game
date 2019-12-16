package nekrocode.chessgame.userinterface.modes;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nekrocode.chessgame.userinterface.util.GridBagAppender;

/**
 * This class acts as a visual representation for the puzzle statistic data
 * 
 * TODO: Duplicate code, I know. Will fix it later.
 * 
 * @author ~
 *
 */
public class PuzzleStatisticsPanel extends JPanel {

	private static final long serialVersionUID = -2559609381708757837L;
	
	public PuzzleStatisticsPanel() {
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setLayout(new GridLayout(3, 1));
		add(buildInfoPanel());
		add(new JLabel(""));
		add(buildTimePanel());
	}
	
	private JPanel buildInfoPanel() {
		JPanel panel = new JPanel();
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		GridBagAppender appender = new GridBagAppender(gridBag, c, panel);
		panel.setLayout(gridBag);
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		JLabel label = new JLabel("Session information");
		appender.appendComponent(label, 1, 1, 5, 1);
		appender.appendComponent(new JLabel("Total played:"), 1, 2, 1, 1);
		appender.appendComponent(new JLabel("      "), 2, 2, 1, 1);
		appender.appendComponent(new JLabel("Total success:"), 3, 2, 1, 1);
		appender.appendComponent(new JLabel("      "), 4, 2, 1, 1);
		appender.appendComponent(new JLabel("Sucess rate:"), 5, 2, 1, 1);
		return panel;
	}
	
	private JPanel buildTimePanel() {
		JPanel panel = new JPanel();
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		GridBagAppender appender = new GridBagAppender(gridBag, c, panel);
		panel.setLayout(gridBag);
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		JLabel label = new JLabel("Time");
		appender.appendComponent(label, 1, 1, 5, 1);
		appender.appendComponent(new JLabel("Spent time:"), 1, 2, 1, 1);
		appender.appendComponent(new JLabel("      "), 2, 2, 1, 1);
		appender.appendComponent(new JLabel("Average time per puzzle:"), 3, 2, 1, 1);
		return panel;
	}
	
}
