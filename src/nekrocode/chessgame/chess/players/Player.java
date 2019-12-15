package nekrocode.chessgame.chess.players;

import java.util.HashMap;
import java.util.Map;

import nekrocode.chessgame.chess.game.enums.ChessColor;
import nekrocode.chessgame.chess.pieces.ChessPiece;

public class Player {
	
	private ChessColor color;
	private HashMap<String, ChessPiece> chessPieces;
	
	public Player(ChessColor color, HashMap<String, ChessPiece> chessPieces) {
		this.color = color;
		this.chessPieces = chessPieces;
	}
	
	public Player() {
		
	}
	
	public void setColor(ChessColor color) {
		this.color = color;
	}
	
	public ChessColor getColor() {
		return color;
	}
	
	public void setChessPieces(Map<String, ChessPiece> chessPieces) {
		this.chessPieces = (HashMap<String, ChessPiece>)chessPieces;
	}
	
	public HashMap<String, ChessPiece> getChessPieces() {
		return chessPieces;
	}
	
}
