package nekrocode.chessgame.userinterface.chessboard;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

import nekrocode.chessgame.chess.board.Chessboard;
import nekrocode.chessgame.chess.game.ChessColor;
import nekrocode.chessgame.userinterface.chesspieces.ChessPiecePanel;

/**
 * Visual representation of a chessboard
 * 
 * TODO 
 * - Eliminate the dependency between this class and Chessboard
 * - Put createSquarePanels() logic elsewhere?
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
		squarePanels = createSquarePanels();
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
			for (int b = columnIndex; b >= 0; b--) {
				add(squarePanels.get(i).get(b));
			}
		}
	}
	
	private List<List<SquarePanel>> createSquarePanels() {
		List<List<SquarePanel>> squarePanels = new ArrayList<List<SquarePanel>>();
		List<SquarePanel> row = new ArrayList<SquarePanel>();
		List<ChessColor> colors = Arrays.asList(ChessColor.LIGHT, ChessColor.DARK);
		int rank = Chessboard.TOTAL_RANKS;
		int totalSquares = rank * Chessboard.TOTAL_RANKS;
		int totalFiles = Chessboard.TOTAL_FILES;
		int start = 1, file = start, colorIndex = 0;
		
		for (int i = 0; i <= totalSquares; i++) {
			if (file > totalFiles) {
				file = start;
				rank--;
				squarePanels.add(row);
				row = new ArrayList<SquarePanel>();
				Collections.reverse(colors);
			}
			if (colorIndex > 1) { 
				colorIndex = 0;
			}
			char fileLetter = Chessboard.getFileLetters().get(file-1);
			Square square = new Square(fileLetter, file-1, rank, colors.get(colorIndex));
			SquarePanel squarePanel = new SquarePanel(square);
			row.add(squarePanel);
			colorIndex++;
			file++;			
		}
		
		return squarePanels;
	}
	
	public List<List<SquarePanel>> getSquarePanels() {
		return squarePanels;
	}
	
}