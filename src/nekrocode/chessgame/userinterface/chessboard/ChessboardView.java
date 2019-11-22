package nekrocode.chessgame.userinterface.chessboard;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

import nekrocode.chessgame.chess.board.Chessboard;
import nekrocode.chessgame.chess.game.ChessColor;

/**
 * Visual representation of a chessboard
 * 
 * @author ~
 *
 */
public class ChessboardView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private List<List<SquarePanel>> squarePanels;
	
	public ChessboardView(Chessboard chessboard) {
		setLayout(new GridLayout(Chessboard.TOTAL_RANKS, Chessboard.TOTAL_FILES));
		ChessColor orientation = chessboard.getOrientation();
		if (orientation == ChessColor.LIGHT) {
			drawLightOrientation();
		} else if (orientation == ChessColor.DARK) {
			drawDarkOrientation();
		}
	}
	
	private void drawLightOrientation() {
		for (List<SquarePanel> list : squarePanels) {
			for (SquarePanel squarePanel : list) {
				add(squarePanel);
			}
		}
	}
	
	private void drawDarkOrientation() {
		int listIndex = squarePanels.size() - 1;
		int columnIndex = squarePanels.get(0).size() - 1;
		for (int i = listIndex; i >= 0; i--) {
			for (int c = columnIndex; c >= 0; c--) {
				add(squarePanels.get(i).get(c));
			}
		}
	}
	
	public List<List<SquarePanel>> getSquarePanels() {
		return squarePanels;
	}
	
}
