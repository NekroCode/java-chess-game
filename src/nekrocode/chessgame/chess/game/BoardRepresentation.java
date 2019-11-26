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
	
	private ChessColor toMove;
	// Temporal variable to hold a chessboard (and its off bound sentinel value) with the usual starting position
	// for visual purpose
	private char[][] chessboard = {
			{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
			{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
			{'-', '-', 'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r', '-', '-',},
			{'-', '-', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', '-', '-',},
			{'-', '-', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', '-', '-',},
			{'-', '-', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', '-', '-',},
			{'-', '-', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', '-', '-',},
			{'-', '-', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', '-', '-',},
			{'-', '-', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '-', '-',},
			{'-', '-', 'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R', '-', '-',},
			{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
			{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',}
	};
	
	public BoardRepresentation() {
		
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
