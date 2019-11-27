package nekrocode.chessgame.chess.pieces.types;

import nekrocode.chessgame.chess.game.ChessColor;
import nekrocode.chessgame.chess.pieces.ChessPiece;

public class Bishop extends ChessPiece {

	public Bishop(ChessColor color) {
		super("Bishop", 'B', color, 8, new byte[][] {{-1, 1}, {1, 1},
			{-1, -1}, {1, -1}} );
	}

}
