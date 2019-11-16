package nekrocode.chessgame.chess.chesspieces.pieces;

import nekrocode.chessgame.chess.ChessColor;
import nekrocode.chessgame.chess.chesspieces.Chesspiece;
import nekrocode.chessgame.chess.chesspieces.ChesspieceLetter;

public class Queen extends Chesspiece {

	public Queen(ChessColor color) {
		super("Queen", ChesspieceLetter.Q, color);
	}

}
