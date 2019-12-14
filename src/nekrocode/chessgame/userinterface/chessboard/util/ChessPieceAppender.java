package nekrocode.chessgame.userinterface.chessboard.util;

import java.util.Map;

import nekrocode.chessgame.chess.pieces.ChessPiece;
import nekrocode.chessgame.userinterface.chessboard.ChessboardView;
import nekrocode.chessgame.userinterface.chesspieces.ChessPiecePanel;

/**
 * This class is used to append a visual chess piece on to a visual chessboard
 * 
 * TODO
 * - Improve code and make it better/cleaner
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
	
	public void appendPosition(Map<String, ChessPiece> pieces) {
		for (Map.Entry<String, ChessPiece> entry : pieces.entrySet()) {
			String position = entry.getKey();
			int file = Integer.parseInt(position.substring(0, 1));
			int rank = Integer.parseInt(position.substring(2, 3));
			ChessPiece chessPiece = entry.getValue();
			ChessPiecePanel chessPiecePanel = new ChessPiecePanel(chessPiece);
			view.getSquarePanels().get(rank).get(file).addChessPiece(chessPiecePanel);
		}
		view.revalidate();
		view.repaint();
	}
	
}
