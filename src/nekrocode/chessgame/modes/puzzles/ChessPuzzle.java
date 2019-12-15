package nekrocode.chessgame.modes.puzzles;

import nekrocode.chessgame.chess.game.ChessGame;

public class ChessPuzzle {
	
	private int turn;
	private ChessGame chessGame;
	private String[] moves;
	
	public ChessPuzzle(ChessGame chessGame, String[] moves) {
		this.chessGame = chessGame;
		this.moves = moves;
	}
	
	public void nextTurn() {
		turn++;
	}
	
	public ChessGame getChessGame() {
		return chessGame;
	}
	
}
