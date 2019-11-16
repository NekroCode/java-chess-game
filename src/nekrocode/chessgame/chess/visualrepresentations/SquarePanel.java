package nekrocode.chessgame.chess.visualrepresentations;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import nekrocode.chessgame.chess.ChessColor;
import nekrocode.chessgame.chess.chessboard.Square;
import nekrocode.chessgame.chess.visualrepresentations.util.ChessboardConfig;

public class SquarePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// TODO Do I really need this?
	// Printing toString() is nice for testing but I need to see
	// if it's still relevant after testing.
	private Square square;
	
	public SquarePanel(Square square) {
		setLayout(new GridLayout(1,1));
		setBackground(getColor(square));
		//add(new JLabel(square.toString()));
		// TODO Needs a better way of setting its dimension
		setPreferredSize(new Dimension(50, 50));
		this.square = square;
	}
	
	private Color getColor(Square square) {
		ChessColor color = square.getColor();
		if (color == ChessColor.LIGHT) {
			return ChessboardConfig.getLightColor();
		} else { 
			return ChessboardConfig.getDarkColor();
		}
	}
	
	public String toString() {
		return square.toString();
	}
	
}
