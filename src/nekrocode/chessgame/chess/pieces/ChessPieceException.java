package nekrocode.chessgame.chess.pieces;

public class ChessPieceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ChessPieceException(String message) {
		super("ChessPieceException: " + message);
	}
	
}
