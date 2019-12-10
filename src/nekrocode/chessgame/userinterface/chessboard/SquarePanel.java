package nekrocode.chessgame.userinterface.chessboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

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
	
	public SquarePanel(ChessboardView chessboardView, Square square) {
		this.chessboardView = chessboardView;
		setLayout(new GridLayout(1,1));
		setBackground(getColor(square));
		// TODO Needs a better way of setting its dimension
		setPreferredSize(new Dimension(50, 50));
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				handleInput();
			}
		});
	}
	
	public void handleInput() {
		chessboardView.manageInput(this);
	}
	
	public void addChessPiece(ChessPiecePanel chessPiecePanel) {
		this.chessPiecePanel = chessPiecePanel;
		add(chessPiecePanel);
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
	
	public ChessPiecePanel getChessPiecePanel() {
		return chessPiecePanel;
	}
	
}
