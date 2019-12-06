package nekrocode.chessgame.chess.players;

import java.util.HashMap;

import nekrocode.chessgame.chess.game.enums.ChessColor;
import nekrocode.chessgame.chess.pieces.ChessPiece;

public class Player implements Competitor {
	
	private ChessColor color;
	private HashMap<byte[], ChessPiece> chessPieces;
	
	public Player(ChessColor color, HashMap<byte[], ChessPiece> chessPieces) {
		this.color = color;
		this.chessPieces = chessPieces;
	}
	
	@Override
	public void action() {
		
	}
	
	public ChessColor getColor() {
		return color;
	}
	
	public HashMap<byte[], ChessPiece> chessPieces() {
		return chessPieces();
	}
	
}
