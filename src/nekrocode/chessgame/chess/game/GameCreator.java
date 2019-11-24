package nekrocode.chessgame.chess.game;

import java.util.HashMap;

import nekrocode.chessgame.chess.pieces.ChessPiece;
import nekrocode.chessgame.chess.pieces.ChessPieceException;
import nekrocode.chessgame.chess.pieces.PieceCreator;

/**
 * This class creates and prepares a playable chess game in the following ways:
 * - Prepares a board position ???
 * - Returns a hash map per chess color with chess pieces as keys and their respective array position as value
 * 
 * TODO
 * - Requires validation before processing. Would want to make it less dependent in the future
 * 
 * @author ~
 *
 */
public class GameCreator {
	
	private HashMap<ChessPiece, byte[]> lightPieces;
	private HashMap<ChessPiece, byte[]> darkPieces;
	
	public GameCreator() {
		lightPieces = new HashMap<ChessPiece, byte[]>();
		darkPieces = new HashMap<ChessPiece, byte[]>();
	}
	
	// TODO Handle catch clause
	public void preparePieces(char[][] boardPosition) {
		int length = boardPosition.length;
		int rank = 0, file = 0;
		PieceCreator creator = new PieceCreator();
		for (int i = 0; i < length; i++) {
			for (int b = 0; b < length; b++) {
				Character letter = boardPosition[rank][b];
				if (!letter.equals('x')) {
					try {
						insertChessPiece(creator.getChessPiece(letter), (byte)rank, (byte)file);
					} catch (ChessPieceException e) {
						System.out.println(e.getMessage());
					}
				}
				file++;
			}
			rank++;
			file = 0;
		}
	}
	
	public void createBoard(char[][] boardPosition) {
		
	}
	
	private void insertChessPiece(ChessPiece chessPiece, byte rank, byte file) {
		byte[] position = new byte[]{rank, file};
		ChessColor color = chessPiece.getColor();
		if (color == ChessColor.LIGHT) {
			lightPieces.put(chessPiece, position);
		} else {
			darkPieces.put(chessPiece, position);
		}
	}
	
	public HashMap<ChessPiece, byte[]> getLightPieces() {
		return lightPieces;
	}
	
	public HashMap<ChessPiece, byte[]> getDarkPieces() {
		return darkPieces;
	}
}
