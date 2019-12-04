package nekrocode.chessgame.chess.players;

import nekrocode.chessgame.chess.game.enums.ChessColor;

public class Player implements Competitor {
	
	private ChessColor color;
	
	public Player(ChessColor color) {
		this.color = color;
	}
	
	@Override
	public void action() {
		
	}
	
	public ChessColor getColor() {
		return color;
	}

}
