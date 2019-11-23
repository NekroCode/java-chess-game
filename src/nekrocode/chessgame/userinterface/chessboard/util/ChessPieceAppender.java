package nekrocode.chessgame.userinterface.chessboard.util;

import java.util.HashMap;
import java.util.Map;

import nekrocode.chessgame.chess.pieces.ChessPiece;
import nekrocode.chessgame.userinterface.chessboard.ChessboardView;
import nekrocode.chessgame.userinterface.chessboard.SquarePanel;
import nekrocode.chessgame.userinterface.chesspieces.ChessPiecePanel;

/**
 * This class is used to append a visual chess piece on to a visual chessboard
 * 
 * TODO
 * - Improve code and make it better/ cleaner
 * - Error handling when trying to append to a square which is already taken by another piece
 * 
 * @author ~
 *
 */
public class ChessPieceAppender {
	
	private ChessboardView view;
	
	public ChessPieceAppender(ChessboardView view) {
		this.view = view;
	}
	
	public void appendPosition(HashMap<ChessPiece, byte[]> pieces) {
		for (Map.Entry<ChessPiece, byte[]> entry : pieces.entrySet()) {
			int rank = entry.getValue()[0];
			int file = entry.getValue()[1];
			ChessPiece chessPiece = entry.getKey();
			ChessPiecePanel chessPiecePanel = new ChessPiecePanel(chessPiece);
			appendPiece(chessPiecePanel, view.getSquarePanels().get(rank).get(file));
		}
	}
	
	public void appendPiece(ChessPiecePanel chessPiecePanel, SquarePanel squarePanel) {
		squarePanel.add(chessPiecePanel);
	}
	
}
