package nekrocode.chessgame.chess.visualrepresentations.util;

import nekrocode.chessgame.chess.chesspieces.Chesspiece;
import nekrocode.chessgame.chess.visualrepresentations.SquarePanel;

public class ChesspieceAppender {
	
	public ChesspieceAppender() {}
	
	public void appendPiece(Chesspiece chesspiece, SquarePanel squarePanel) {
		squarePanel.add(chesspiece.getChesspiecePanel());
	}
	
}
