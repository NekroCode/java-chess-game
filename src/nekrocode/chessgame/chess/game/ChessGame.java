package nekrocode.chessgame.chess.game;

import nekrocode.chessgame.chess.game.enums.StartingPosition;
import nekrocode.chessgame.chess.board.Chessboard;


public class ChessGame {
	
	private BoardRepresentation boardRepresentation;
	private Chessboard chessboard;
	
	/**
	 * Construct a chess game based on a given board representation
	 * @param boardRepresentation
	 */
	public ChessGame(BoardRepresentation boardRepresentation) {
		this.boardRepresentation = boardRepresentation;
		chessboard = new Chessboard(boardRepresentation.getBoardPosition(), boardRepresentation.getToMove());
	}
	
	/**
	 * TODO 
	 * Construct a chess game based on the given FEN position
	 */
	public ChessGame(StartingPosition startingPosition) {
		
	}
	
	public BoardRepresentation getBoardRepresentation() {
		return boardRepresentation;
	}
	
	public Chessboard getChessboard() {
		return chessboard;
	}
	
}
