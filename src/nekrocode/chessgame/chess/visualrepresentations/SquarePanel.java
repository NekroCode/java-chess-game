package nekrocode.chessgame.chess.visualrepresentations;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import nekrocode.chessgame.chess.ChessColors;
import nekrocode.chessgame.chess.chessboard.Square;

public class SquarePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public SquarePanel(Square square) {
		setLayout(new GridLayout(1,1));
		setBackground(getColor(square));
		add(new JLabel(square.toString()));
		setPreferredSize(new Dimension(50, 50));
	}
	
	private Color getColor(Square square) {
		ChessColors color = square.getColor();
		if (color == ChessColors.LIGHT)
			return ChessboardConfig.getLightColor();
		else 
			return ChessboardConfig.getDarkColor();
	}

}
