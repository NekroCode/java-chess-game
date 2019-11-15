package nekrocode.chessgame.chess.chesspieces.pieces;

import nekrocode.chessgame.chess.ChessColors;
import nekrocode.chessgame.chess.chesspieces.Chesspiece;
import nekrocode.chessgame.chess.chesspieces.ChesspieceLetters;

public class Queen extends Chesspiece {

	public Queen(ChessColors color) {
		super("Queen", ChesspieceLetters.Q, color);
	}

}
