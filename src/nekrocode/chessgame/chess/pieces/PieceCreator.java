package nekrocode.chessgame.chess.pieces;

import nekrocode.chessgame.chess.game.enums.ChessColor;
import nekrocode.chessgame.chess.pieces.types.Bishop;
import nekrocode.chessgame.chess.pieces.types.King;
import nekrocode.chessgame.chess.pieces.types.Knight;
import nekrocode.chessgame.chess.pieces.types.Pawn;
import nekrocode.chessgame.chess.pieces.types.Queen;
import nekrocode.chessgame.chess.pieces.types.Rook;

/**
 * This class returns a chess piece based on the given input taking the FEN notation into account.
 * 
 * @author ~
 *
 */
public class PieceCreator {
	
	public ChessPiece getChessPiece(Character letter) throws ChessPieceException {
		ChessColor color = getColor(letter);
		letter = Character.toLowerCase(letter);
		ChessPiece chessPiece = null;
		switch (letter) {
			case 'p' :
				chessPiece = new Pawn(color, assignPawnMoveSet(color));
				break;
			case 'n' :
				chessPiece = new Knight(color);
				break;
			case 'b' :
				chessPiece = new Bishop(color);
				break;
			case 'r' :
				chessPiece = new Rook(color);
				break;
			case 'q' :
				chessPiece = new Queen(color);
				break;
			case 'k' : 
				chessPiece = new King(color);
				break;
		}
		if (chessPiece == null) {
			throw new ChessPieceException("Unregognized chess piece.");
		}
		return chessPiece;
	}
	
	private ChessColor getColor(char letter) {
		if (Character.isUpperCase(letter)) {
			return ChessColor.LIGHT;
		} else {
			return ChessColor.DARK;
		}
	}
	
	private byte[][] assignPawnMoveSet(ChessColor color) {
		if (color == ChessColor.LIGHT) {
			return new byte[][] {{0, -1}};
		} else {
			return new byte[][] {{0, 1}};
		}
	}
	
}
//Java 12's Case Label preview feature
//case "p" -> chessPiece = new Pawn('P', color);
//case "n" -> chessPiece = new Knight('N', color);
//case "b" -> chessPiece = new Bishop('B', color);
//case "r" -> chessPiece = new Rook('R', color);
//case "q" -> chessPiece = new Queen('Q', color);
//case "k" -> chessPiece = new King('K', color);
