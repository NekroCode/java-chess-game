package nekrocode.chessgame.chess.pieces.types;

import nekrocode.chessgame.chess.game.enums.ChessColor;
import nekrocode.chessgame.chess.pieces.ChessPiece;

public class Knight extends ChessPiece {

	public Knight(ChessColor color) {
		super("Knight", 'N', color, 1, new byte[][] {{-1, 2}, {1, 2},
			{2, 1}, {-2, 1}, {1, -2}, {-1, -2}, {-2, -1}, {2, -1}});
	}

}
