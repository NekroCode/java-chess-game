package nekrocode.chessgame.userinterface.graphicalutil;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class GridBagAppender {
	
	private JPanel panel;
	private GridBagLayout gridBag;
	private GridBagConstraints gbc;
	
	public GridBagAppender(GridBagLayout gridBag, GridBagConstraints gbc, JPanel panel) {
		this.gridBag = gridBag;
		this.gbc = gbc;
		this.panel = panel;
	}
	
	public void appendComponent(JComponent component, 
								int gridx, int gridy, 
								int gridwidth, int gridheight) {
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gridBag.setConstraints(component, gbc);
		panel.add(component);
	}
	
}
