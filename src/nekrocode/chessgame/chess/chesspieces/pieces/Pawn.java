package nekrocode.chessgame.chess.chesspieces.pieces;

import nekrocode.chessgame.chess.ChessColor;
import nekrocode.chessgame.chess.chesspieces.Chesspiece;
import nekrocode.chessgame.chess.chesspieces.ChesspieceLetter;

public class Pawn extends Chesspiece {

	public Pawn(ChessColor color) {
		super("Pawn", ChesspieceLetter.P, color);
	}

}
