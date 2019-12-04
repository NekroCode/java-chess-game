package nekrocode.chessgame.userinterface.chessboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.instrument.Instrumentation;

import javax.swing.JPanel;

import nekrocode.chessgame.chess.game.enums.ChessColor;

/**
 * Visual representation of a chessboard square
 * 
 * @author ~
 *
 */
public class SquarePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public SquarePanel(Square square) {
		setLayout(new GridLayout(1,1));
		setBackground(getColor(square));
		// TODO Needs a better way of setting its dimension
		setPreferredSize(new Dimension(50, 50));
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Testing
				System.out.println(e.getSource().toString());
			}
		});
	}
	
	private Color getColor(Square square) {
		ChessColor color = square.getColor();
		if (color == ChessColor.LIGHT) {
			return ChessboardConfig.getLightColor();
		} else { 
			return ChessboardConfig.getDarkColor();
		}
	}
	
	public void emptySquare() {
		removeAll();
		revalidate();
		repaint();
	}
	
}
