package nekrocode.chessgame.chess.chesspieces.pieces;

import nekrocode.chessgame.chess.ChessColors;
import nekrocode.chessgame.chess.chesspieces.Chesspiece;
import nekrocode.chessgame.chess.chesspieces.ChesspieceLetters;

public class King extends Chesspiece {

	public King(ChessColors color) {
		super("King", ChesspieceLetters.K, color);
	}

}
