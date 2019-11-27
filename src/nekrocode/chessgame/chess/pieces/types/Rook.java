package nekrocode.chessgame.chess.pieces.types;

import nekrocode.chessgame.chess.game.ChessColor;
import nekrocode.chessgame.chess.pieces.ChessPiece;

public class Rook extends ChessPiece {

	public Rook(ChessColor color) {
		super("Rook", 'R', color, 8, new byte[][] {{0, 1}, {1, 0},
			{0, -1}, {-1, 0}});
	}

}
