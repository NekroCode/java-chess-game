package nekrocode.chessgame.userinterface.chessboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import nekrocode.chessgame.chess.game.enums.ChessColor;
import nekrocode.chessgame.userinterface.chesspieces.ChessPiecePanel;

/**
 * Visual representation of a chessboard square
 * 
 * @author ~
 *
 */
public class SquarePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ChessboardView chessboardView;
	private ChessPiecePanel chessPiecePanel;
	private final Color color;
	public final static Border BORDER = BorderFactory.createLineBorder(Color.GRAY, 1);
	
	public SquarePanel(ChessboardView chessboardView, Square square) {
		this.chessboardView = chessboardView;
		setLayout(new GridLayout(1,1));
		color = assignColor(square);
		setBorder(BORDER);
		setBackground(color);
		// TODO Needs a better way of setting its dimension
		setPreferredSize(new Dimension(50, 50));
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				handleInput(e);
			}
		});
	}
	
	public void handleInput(MouseEvent e) {
		chessboardView.manageInput(this, e);
	}
	
	public void addChessPiece(ChessPiecePanel chessPiecePanel) {
		this.chessPiecePanel = chessPiecePanel;
		add(chessPiecePanel);
	}
	
	private Color assignColor(Square square) {
		ChessColor color = square.getColor();
		if (color == ChessColor.LIGHT) {
			return ChessboardConfig.getLightColor();
		} else { 
			return ChessboardConfig.getDarkColor();
		}
	}
	
	public void emptySquare() {
		if (getComponentCount() > 0) {
			chessPiecePanel = null;
			removeAll();
			revalidate();
			repaint();
		}
	}
	
	public ChessPiecePanel getChessPiecePanel() {
		return chessPiecePanel;
	}
	
	public Color getColor() {
		return color;
	}
	
}
