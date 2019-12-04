package nekrocode.chessgame.chess.pieces.types;

import nekrocode.chessgame.chess.game.enums.ChessColor;
import nekrocode.chessgame.chess.pieces.ChessPiece;

public class Pawn extends ChessPiece {

	public Pawn(ChessColor color) {
		super("Pawn", 'P', color, 1, new byte[][] {{0, 1}});
	}

}
