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
	
	public void appendPosition(Map<byte[], ChessPiece> pieces) {
		for (Map.Entry<byte[], ChessPiece> entry : pieces.entrySet()) {
			byte rank = entry.getKey()[0];
			byte file = entry.getKey()[1];
			ChessPiece chessPiece = entry.getValue();
			ChessPiecePanel chessPiecePanel = new ChessPiecePanel(chessPiece, rank, file);
			view.getSquarePanels().get(rank).get(file).addChessPiece(chessPiecePanel);
			view.revalidate();
			view.repaint();
		}
	}
	
}
