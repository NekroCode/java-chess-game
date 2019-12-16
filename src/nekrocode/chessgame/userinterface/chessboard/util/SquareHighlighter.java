package nekrocode.chessgame.userinterface.chessboard.util;

import java.awt.Color;

import javax.swing.BorderFactory;

import nekrocode.chessgame.userinterface.chessboard.SquarePanel;

public class SquareHighlighter {
	
	public void addSelectionBorder(SquarePanel squarePanel) {
		squarePanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
	}
	
	public void removeSelectionBorder(SquarePanel squarePanel) {
		squarePanel.setBorder(SquarePanel.BORDER);
	}
	
	public void addSelectionBackground(SquarePanel squarePanel) {
		squarePanel.setBackground(Color.GREEN);
	}
	
	public void removeSelectionBackground(SquarePanel squarePanel) {
		squarePanel.setBackground(squarePanel.getColor());
	}
	
}
