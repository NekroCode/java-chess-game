package nekrocode.chessgame.userinterface.chessboard.util;

import java.util.ArrayList;
import java.util.List;

import nekrocode.chessgame.chess.pieces.ChessPiece;
import nekrocode.chessgame.userinterface.chessboard.ChessboardView;
import nekrocode.chessgame.userinterface.chessboard.SquarePanel;
import nekrocode.chessgame.userinterface.chesspieces.PieceManager;

public class SquareManager {
	
	private PieceManager pieceManager;
	private SquareHighlighter highlighter;
	private SquarePanel selectedSquare;
	private List<SquarePanel> markedPanels;
	
	public SquareManager(PieceManager pieceManager) {
		this.pieceManager = pieceManager;
		highlighter = new SquareHighlighter();
		markedPanels = new ArrayList<SquarePanel>();
	}
	
	public void manageSelection(ChessPiece chessPiece, SquarePanel squarePanel) {
		handleSelectedSquare(squarePanel);
		handleSquareMarkers(chessPiece);
	}
	
	private void handleSelectedSquare(SquarePanel squarePanel) {
		if (selectedSquare != null) {
			removeSelection();
		}
		selectedSquare = squarePanel;
		highlighter.addSelectionBorder(selectedSquare);
	}
	
	private void handleSquareMarkers(ChessPiece chessPiece) {
		List<byte[]> legalMoves = chessPiece.getLegalMoves();
		if (legalMoves.size() > 0) {
			for (byte[] position : legalMoves) {
				ChessboardView view = pieceManager.getChessboardView();
				SquarePanel panel = view.getSquarePanels().get(position[1]).get(position[0]);
				markedPanels.add(panel);
				highlighter.addSelectionBackground(panel);
			}
		}
	}
	
	public void removeSelection() {
		highlighter.removeSelectionBorder(selectedSquare);
		for (SquarePanel panel : markedPanels) {
			highlighter.removeSelectionBackground(panel);
		}
		markedPanels.clear();
	}
	
	public List<SquarePanel> getMarkedPanels() {
		return markedPanels;
	}
	
}
