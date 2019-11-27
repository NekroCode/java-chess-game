package nekrocode.chessgame.chess.pieces.types;

import nekrocode.chessgame.chess.game.ChessColor;
import nekrocode.chessgame.chess.pieces.ChessPiece;

public class Queen extends ChessPiece {

	public Queen(ChessColor color) {
		super("Queen", 'Q', color, 8, new byte[][] {{-1, 1}, {0, 1},
			{1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}});
	}

}
