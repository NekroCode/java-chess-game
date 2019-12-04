package nekrocode.chessgame.chess.game;

import nekrocode.chessgame.chess.players.Competitor;

public class ChessGameController {
	 
	private Competitor lightPieces;
	private Competitor darkPieces;
	
	public ChessGameController(Competitor lightPieces, Competitor darkPieces) {
		this.lightPieces = lightPieces;
		this.darkPieces = darkPieces;
	}
	
}
