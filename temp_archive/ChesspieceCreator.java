package nekrocode.chessgame.temparchive;

import nekrocode.chessgame.chess.ChessColors;
import nekrocode.chessgame.chess.chesspieces.pieces.Bishop;
import nekrocode.chessgame.chess.chesspieces.pieces.King;
import nekrocode.chessgame.chess.chesspieces.pieces.Knight;
import nekrocode.chessgame.chess.chesspieces.pieces.Pawn;
import nekrocode.chessgame.chess.chesspieces.pieces.Queen;
import nekrocode.chessgame.chess.chesspieces.pieces.Rook;

public class ChesspieceCreator {
	
	public Pawn createPawn(ChessColors color) {
		return new Pawn(color);
	}
	
	public Knight createKnight(ChessColors color) {
		return new Knight(color);
	}
	
	public Bishop createBishop(ChessColors color) {
		return new Bishop(color);
	}
	
	public Rook createRook(ChessColors color) {
		return new Rook(color);
	}
	
	public Queen createQueen(ChessColors color) {
		return new Queen(color);
	}
	
	public King createKing(ChessColors color) {
		return new King(color);
	}

	
}
