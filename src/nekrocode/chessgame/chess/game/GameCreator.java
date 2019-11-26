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
 * - Remove code duplication (same as FenPositionParser).
 * 
 * @author ~
 *
 */
public class GameCreator {
	
	private HashMap<byte[], ChessPiece> lightPieces;
	private HashMap<byte[], ChessPiece> darkPieces;
	
	public GameCreator() {
		lightPieces = new HashMap<byte[], ChessPiece>();
		darkPieces = new HashMap<byte[], ChessPiece>();
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
	
	// TODO Too messy in my opinion. Want to change when there's more time
	public char[][] createBoard(char[][] boardPosition) {
		int rowSize = 12;
		int columnSize = rowSize;
		int start = 2;
		int end = 10;
		int index = 0;
		char[][] chessboard = new char[rowSize][columnSize];
		for (int i = 0; i < rowSize; i++) {
			if (i >= start && i < end) {
				StringBuilder builder = new StringBuilder();
				builder.append("--");
				builder.append(boardPosition[index]);
				if (index > 7) {
					index = 0;
				}
				index++;
				builder.append("--");
				chessboard[i] = buildRank(builder.toString());
			} else {
				chessboard[i] = buildRank("------------");
			}
		}
		return chessboard;
	}
	
	private char[] getEmptyRowAsArray() {
		return buildRank("xxxxxxxx");
	}
	
	// TODO Duplication
	private char[] buildRank(String rankPosition) {
		int length = rankPosition.length();
		char[] position = new char[length];
		for (int i = 0; i < length; i++) {
			position[i] = rankPosition.substring(i,i+1).charAt(0);
		}
		return position;
	}
	
	private void insertChessPiece(ChessPiece chessPiece, byte rank, byte file) {
		byte[] position = new byte[]{rank, file};
		ChessColor color = chessPiece.getColor();
		if (color == ChessColor.LIGHT) {
			lightPieces.put(position, chessPiece);
		} else {
			darkPieces.put(position, chessPiece);
		}
	}
	
	public HashMap<byte[], ChessPiece> getLightPieces() {
		return lightPieces;
	}
	
	public HashMap<byte[], ChessPiece> getDarkPieces() {
		return darkPieces;
	}
}
