package nekrocode.chessgame.userinterface.chessboard;

import java.util.ArrayList;
import java.util.List;

import nekrocode.chessgame.chess.pieces.ChessPiece;
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
//		List<List<Byte>> legalMoves = chessPiece.getLegalMoves();
//		for (List<Byte> position : legalMoves) {
//			ChessboardView view = pieceManager.getChessboardView();
//			SquarePanel panel = view.getSquarePanels().get(position.get(0)).get(position.get(1));
//			markedPanels.add(panel);
//			highlighter.addSelectionBackground(panel);
//		}
	}
	
	public void removeSelection() {
		highlighter.removeSelectionBorder(selectedSquare);
		for (SquarePanel panel : markedPanels) {
			highlighter.removeSelectionBackground(panel);
		}
		markedPanels.clear();
	}
	
}
