package nekrocode.chessgame.chess.chesspieces.pieces;

import nekrocode.chessgame.chess.ChessColors;
import nekrocode.chessgame.chess.chesspieces.Chesspiece;
import nekrocode.chessgame.chess.chesspieces.ChesspieceLetters;

public class Pawn extends Chesspiece {

	public Pawn(ChessColors color) {
		super("Pawn", ChesspieceLetters.P, color);
	}

}
