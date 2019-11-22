package nekrocode.chessgame.chess.game;

import java.util.Arrays;

/**
 * This class is used to represent a chessboard in the following ways (for now):
 * - Color to move
 * - Chess piece positions on the board
 * - (Extendible)
 * @author ~
 *
 */
public class BoardRepresentation {
	
	private ChessColor toMove;
	// Temporal variabel to hold a chessboard (and its off bound sentinel value) with the usual starting position
	private char[][] boardPosition = {
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
		char[] test = Arrays.copyOfRange(boardPosition[2], 2, 10);
		for (char c : test)
			System.out.println(c);
	}
	
	public char[][] getBoardPosition() {
		return boardPosition;
	}
}
