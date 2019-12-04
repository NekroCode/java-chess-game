package nekrocode.chessgame.chess.game;

import nekrocode.chessgame.chess.board.Chessboard;
import nekrocode.chessgame.chess.game.enums.StartingPosition;

public class ChessGame {
	
	private BoardRepresentation boardRepresentation;
	private Chessboard chessboard;
	
	public ChessGame(BoardRepresentation boardRepresentation) {
		this.boardRepresentation = boardRepresentation;
		chessboard = new Chessboard(boardRepresentation.getBoardPosition(), boardRepresentation.getToMove());
	}
	
	// TODO Implement feature
	public ChessGame(StartingPosition startingPosition) {
		
	}
	
	public BoardRepresentation getBoardRepresentation() {
		return boardRepresentation;
	}
	
	public Chessboard getChessboard() {
		return chessboard;
	}
}
