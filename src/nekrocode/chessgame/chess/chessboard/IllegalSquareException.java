package nekrocode.chessgame.chess.chessboard;

public class IllegalSquareException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public IllegalSquareException(String message) {
		super(message);
	}
	
}
