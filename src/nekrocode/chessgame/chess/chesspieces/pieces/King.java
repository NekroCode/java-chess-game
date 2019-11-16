package nekrocode.chessgame.chess.chesspieces.pieces;

import nekrocode.chessgame.chess.ChessColor;
import nekrocode.chessgame.chess.chesspieces.Chesspiece;
import nekrocode.chessgame.chess.chesspieces.ChesspieceLetter;

public class King extends Chesspiece {

	public King(ChessColor color) {
		super("King", ChesspieceLetter.K, color);
	}

}
