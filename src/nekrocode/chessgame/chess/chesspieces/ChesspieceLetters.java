package nekrocode.chessgame.chess.chesspieces;

public enum ChesspieceLetters {
	P('p'),
	N('n'),
	B('b'),
	R('r'),
	K('k'),
	Q('q');
	
	private char letter;
	
	private ChesspieceLetters(char letter) {
		this.letter = letter;
	}
	
	public char getLetter() {
		return letter;
	}
}
