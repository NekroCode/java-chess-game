package nekrocode.chessgame.chess.chesspieces;

//TODO Wondering of this ENUM is really needed
//It's safer, sure...(compared to directly passing a char in a chesspiece its constructor) but is it still really needed?
public enum ChesspieceLetter {
	P('p'),
	N('n'),
	B('b'),
	R('r'),
	K('k'),
	Q('q');
	
	private char letter;
	
	private ChesspieceLetter(char letter) {
		this.letter = letter;
	}
	
	public char getLetter() {
		return letter;
	}
}
