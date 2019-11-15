package nekrocode.chessgame.chess.visualrepresentations;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import nekrocode.chessgame.chess.ChessColors;
import nekrocode.chessgame.chess.chessboard.Chessboard;
import nekrocode.chessgame.chess.chessboard.Square;

public class ChessboardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private List<List<SquarePanel>> squarePanels;
	
	public ChessboardPanel(Chessboard chessboard) {
		setLayout(new GridLayout(Chessboard.TOTAL_RANKS, Chessboard.TOTAL_FILES));
		ChessColors orientation = chessboard.getOrientation();
		squarePanels = createSquarePanels(chessboard.getSquares());
		if (orientation == ChessColors.LIGHT)
			drawLightOrientation();
		else if (orientation == ChessColors.DARK)
			drawDarkOrientation();

	}
	
	private void drawLightOrientation() {
		for (List<SquarePanel> list : squarePanels)
			for (SquarePanel squarePanel : list)
				add(squarePanel);
	}
	
	private void drawDarkOrientation() {
		int listIndex = squarePanels.size() - 1;
		int columnIndex = squarePanels.get(0).size() - 1;
		
		for (int i = listIndex; i >= 0; i--) {
			for (int c = columnIndex; c >= 0; c--) 
				add(squarePanels.get(i).get(c));
		}
	}
	
	// TODO immutable array
	private List<List<SquarePanel>> createSquarePanels(List<List<Square>> squares) {
		List<List<SquarePanel>> squarePanels = new ArrayList<List<SquarePanel>>();
		List<SquarePanel> row; 
		
		for (List<Square> list : squares) {
			row = new ArrayList<SquarePanel>();
			for (Square square : list) 
				row.add(new SquarePanel(square));
			squarePanels.add(row);
		}
		
		return squarePanels;
	}
	
	public List<List<SquarePanel>> getSquarePanels() {
		return squarePanels;
	}
	
}
