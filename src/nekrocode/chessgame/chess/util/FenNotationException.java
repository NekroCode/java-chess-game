package nekrocode.chessgame.chess.util;

public class FenNotationException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public FenNotationException(String message) {
		super("FenNotationException: " + message);
	}
}
