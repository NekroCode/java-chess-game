package nekrocode.chessgame.chess.game;

import nekrocode.chessgame.chess.game.enums.StartingPosition;
import nekrocode.chessgame.chess.board.Chessboard;


public class ChessGame {
	
	private BoardRepresentation boardRepresentation;
	
	/**
	 * Construct a chess game based on a given board representation
	 * @param boardRepresentation
	 */
	public ChessGame(BoardRepresentation boardRepresentation) {
		this.boardRepresentation = boardRepresentation;
	}
	
	/**
	 * Construct a chess game based on the given FEN position
	 * TODO implement feature when the project needs it
	 */
	public ChessGame(StartingPosition startingPosition) {
		
	}
	
	public BoardRepresentation getBoardRepresentation() {
		return boardRepresentation;
	}
	
	public Chessboard getChessboard() {
		return new Chessboard(boardRepresentation, boardRepresentation.getToMove());
	}
	
}
