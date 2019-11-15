package nekrocode.chessgame.chess.chessutil;

// TODO Add extra text to the message for clarity.
// But I would need to get the final message constructed before calling the parent constructor.
public class IllegalSquareException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public IllegalSquareException(String message) {
		super(message);
	}
	
}
