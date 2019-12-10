package nekrocode.chessgame.userinterface.chessboard;

import java.awt.GridLayout;
import java.awt.ItemSelectable;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

import nekrocode.chessgame.chess.board.Chessboard;
import nekrocode.chessgame.chess.game.enums.ChessColor;
import nekrocode.chessgame.chess.pieces.ChessPiece;
import nekrocode.chessgame.userinterface.chesspieces.PieceManager;

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
	private Chessboard chessboard;
	private PieceManager pieceManager;
	
	public ChessboardView(Chessboard chessboard) {
		setLayout(new GridLayout(Chessboard.TOTAL_RANKS, Chessboard.TOTAL_FILES));
		ChessColor orientation;
		if (chessboard != null) { 
			setChessboard(chessboard);
			orientation = chessboard.getOrientation(); 
		} else { orientation = ChessColor.LIGHT; }
		squarePanels = createSquarePanels();
		if (orientation == ChessColor.DARK) {
			drawDarkOrientation(); } 
		else { drawLightOrientation(); }
	}
	
	public void manageInput(ChessPiece chessPiece, SquarePanel squarePanel) {
		if (pieceManager != null) {
			pieceManager.handleInput(chessPiece, squarePanel);
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
			SquarePanel squarePanel = new SquarePanel(this, square);
			row.add(squarePanel);
			colorIndex++;
			file++;			
		}
		
		return squarePanels;
	}
	
	public List<List<SquarePanel>> getSquarePanels() {
		return squarePanels;
	}
	
	public void setChessboard(Chessboard chessboard) {
		this.chessboard = chessboard;
	}
	
	public void setPieceManager(PieceManager pieceManager) {
		this.pieceManager = pieceManager;
	}
	
}
