package nekrocode.chessgame.chess.game;

import java.util.Arrays;

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
 * TODO 
 * - Define the board as an array of bytes for better memory usage
 * 
 * @author ~
 *
 */
public class BoardRepresentation {
	
	private char[][] chessboard;
	private ChessColor toMove;
	
	public BoardRepresentation(char[][] chessboard) {
		this.chessboard = chessboard;
//		for (char[] list : chessboard) {
//			for (char c : list) {
//				System.out.print(c);
//			}
//			System.out.println("");
//		}
	}
	
	public char[][] getChessboardAsArray() {
		return chessboard;
	}
	
	public char[][] getBoardPosition() {
		int size = 8; 
		char[][] boardPosition = new char[size][size];
		char[] rank = new char[size];
		int start = 2;
		int end = 10;
		int index = start;
		for (int i = 0; i < size; i++) {
			rank = Arrays.copyOfRange(chessboard[index], start, end);
			boardPosition[i] = rank;
			index++;
		}
		return boardPosition;
	}
}
