package nekrocode.chessgame.chess.chesspieces.pieces;

import nekrocode.chessgame.chess.ChessColor;
import nekrocode.chessgame.chess.chesspieces.Chesspiece;
import nekrocode.chessgame.chess.chesspieces.ChesspieceLetter;

public class Bishop extends Chesspiece {
	
	public Bishop(ChessColor color) {
		super("Bishop", ChesspieceLetter.B, color);
	}
	
}
