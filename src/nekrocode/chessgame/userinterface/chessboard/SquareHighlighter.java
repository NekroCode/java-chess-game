package nekrocode.chessgame.userinterface.chessboard;

import java.awt.Color;

import javax.swing.BorderFactory;

public class SquareHighlighter {
	
	public void addSelectionBorder(SquarePanel squarePanel) {
		squarePanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
	}
	
	public void removeSelectionBorder(SquarePanel squarePanel) {
		squarePanel.setBorder(null);
	}
	
}