package nekrocode.chessgame.userinterface.chessboard;

import nekrocode.chessgame.chess.pieces.ChessPiece;
import nekrocode.chessgame.userinterface.chesspieces.PieceManager;

public class SquareManager {
	
	private PieceManager pieceManager;
	private SquareHighlighter highlighter;
	private SquarePanel selectedSquare;
	
	public SquareManager(PieceManager pieceManager) {
		this.pieceManager = pieceManager;
		highlighter = new SquareHighlighter();
	}
	
	public void manageInput(ChessPiece chessPiece, SquarePanel squarePanel) {
//		byte[][] legalMoves = chessPiece.getLegalMoves();
//		if (selectedSquare != null) {
//			highlighter.removeSelectionBorder(selectedSquare);
//			legalMoves = null;
//		}
//		selectedSquare = squarePanel;
//		highlighter.addSelectionBorder(squarePanel);
//		
//		for (byte[] position : legalMoves) {
//			ChessboardView view = pieceManager.getChessboardView();
//			SquarePanel panel = view.getSquarePanels().get(position[0]).get(position[1]);
//			highlighter.addSelectionBackground(panel);
//		}
	}
	
}
