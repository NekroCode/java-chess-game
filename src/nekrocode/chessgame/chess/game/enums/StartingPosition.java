package nekrocode.chessgame.chess.game.enums;

public enum StartingPosition {
	
	STANDARD("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR"),
	EMPTY("8/8/8/8/8/8/8/8");
	
	String startPosition;
	
	StartingPosition(String startPosition) {
		this.startPosition = startPosition;
	}
	
	public String getStartingPosition() {
		return startPosition;
	}
}
