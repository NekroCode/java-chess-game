package nekrocode.chessgame.chess.visualrepresentations;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class ChessboardContainer extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public ChessboardContainer() {
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setLayout(gridBag);
	}
	
}
