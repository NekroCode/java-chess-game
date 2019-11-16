package nekrocode.chessgame.chess.chesspieces.pieces;

import nekrocode.chessgame.chess.ChessColor;
import nekrocode.chessgame.chess.chesspieces.Chesspiece;
import nekrocode.chessgame.chess.chesspieces.ChesspieceLetter;

public class Knight extends Chesspiece {

	public Knight(ChessColor color) {
		super("Knight", ChesspieceLetter.N, color);
	}

}
