package nekrocode.chessgame.chess.game;

import java.util.HashMap;

import nekrocode.chessgame.chess.board.Chessboard;
import nekrocode.chessgame.chess.game.enums.ChessColor;
import nekrocode.chessgame.chess.pieces.ChessPiece;
import nekrocode.chessgame.chess.pieces.ChessPieceException;
import nekrocode.chessgame.chess.pieces.PieceCreator;

public class ChessGameBuilder {
	
	private HashMap<String, ChessPiece> lightPieces;
	private HashMap<String, ChessPiece> darkPieces;
	
	public ChessGame createGame(char[][] boardPosition, ChessColor toMove) {
		lightPieces = new HashMap<String, ChessPiece>();
		darkPieces = new HashMap<String, ChessPiece>();
		preparePieces(boardPosition);
		BoardRepresentation boardRepresentation = new BoardRepresentation(boardPosition, lightPieces, darkPieces, toMove);
		return new ChessGame(boardRepresentation);
	}
	
	// TODO Handle catch clause
	public void preparePieces(char[][] boardPosition) {
		int length = Chessboard.TOTAL_RANKS;
		int start = BoardRepresentation.BOARD_START;
		int end = BoardRepresentation.BOARD_END;
		int rank = 0, file = 0;
		PieceCreator creator = new PieceCreator();
		for (int i = 0; i < length; i++) {
			for (int b = 0; b < length; b++) {
				Character letter = boardPosition[i+start][b+start];
				if (!letter.equals('x')) {
					try {
						insertChessPiece(creator.getChessPiece(letter), (byte)rank, (byte)file);
					} catch (ChessPieceException e) {
						System.out.println(e.getMessage());
					}
				}
				file++;
			}
			rank++; file = 0;
		}
	}
	
	private void insertChessPiece(ChessPiece chessPiece, byte file, byte rank) {
		//byte[] position = new byte[]{rank, file};
		String position = file + "/" + rank;
		ChessColor color = chessPiece.getColor();
		if (color == ChessColor.LIGHT) {
			lightPieces.put(position, chessPiece);
		} else {
			darkPieces.put(position, chessPiece);
		}
	}
	
}
