package nekrocode.chessgame.chess.game;

import java.util.HashMap;
import java.util.Map;

import nekrocode.chessgame.chess.game.enums.ChessColor;
import nekrocode.chessgame.chess.pieces.ChessPiece;

/**
 * This class is used to represent a chessboard in the following ways (for now):
 * - Color to move
 * - Chess piece positions on the board
 * - (Extendible)
 * 
 * Encoding protocol:
 * - 'x' represents an unused square
 * - '-' out of boundary sentinel value
 * - Upper case letters represent white pieces
 * - Lower case letters represent black pieces
 * 
 * Map<String, ChessPiece> usage:
 * - Key: String value containing the file and rank index separated by a dash /. Example: 7/7 would represent square a1. 0/0 represents a8.
 * IMPORTANT: The first digit represents the file and the second the rank. 
 * 
 * TODO 
 * - Define the board as an array of bytes for better memory usage
 * - Are the HashMaps really needed? If so, could I change the data structure for better memory usage?
 * - I don't like the 12x12 array implementation.
 * 	 - Placed a few constants so other classes no where to start when leaving out the boundary sentinel value
 * 
 * @author ~
 *
 */
public class BoardRepresentation {
	
	// Represents the amount of squares including the boundary sentinel
	// value per rank and per file
	public static int SIZE = 12;
	// Represents where in the array the actual chessboard starts and ends
	public static int BOARD_START = 2;
	public static int BOARD_END = 10;
	
	private char[][] boardPosition;
	private Map<String, ChessPiece> lightPieces;
	private Map<String, ChessPiece> darkPieces;
	private ChessColor toMove;
	
	public BoardRepresentation(char[][] boardPosition,
			HashMap<String, ChessPiece> lightPieces,
			HashMap<String, ChessPiece> darkPieces,
			ChessColor toMove) {
		this.boardPosition = boardPosition;
		this.lightPieces = lightPieces;
		this.darkPieces = darkPieces;
		this.toMove = toMove;
	}
	
	public char[][] getBoardPosition() {
		return boardPosition;
	}
	
	public void setToMove(ChessColor toMove) {
		this.toMove = toMove;
	}
	
	public ChessColor getToMove() {
		return toMove;
	}
	
	public Map<String, ChessPiece> getLightPieces() {
		return lightPieces;
	}
	
	public Map<String, ChessPiece> getDarkPieces() {
		return darkPieces;
	}
}
