package nekrocode.chessgame.chess.board;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import nekrocode.chessgame.chess.game.ChessColor;

/**
 * This class represents a chessboard and is used to convey data from the BoardPresentation class
 * 
 * @author ~
 *
 */
public class Chessboard {
	
	// TODO Remove total ranks + files to user interface environment?
	public static final int TOTAL_RANKS = 8;
	public static final int TOTAL_FILES = TOTAL_RANKS;
	private char[][] boardPosition;
	private ChessColor orientation;
	
	public Chessboard(char[][] boardPosition, ChessColor orientation) {
		this.boardPosition = boardPosition;
		this.orientation = orientation;
		
		// Test code
//		int rank = 8;
//		int file = 1;
//		for (char[] list : boardPosition) {
//			rank--;
//			for (int b = 0; b < list.length; b++) {
//				Character c = boardPosition[rank][b];
//				if (c.equals('x')) {
//					char f = getFileLetters().get(b);
//					System.out.print(f + "" + rank);
//				} else {
//					System.out.print(c + " ");
//				}
//			}
//			System.out.println("");
//		}
	}
	
	public char[][] getBoardPosition() {
		return boardPosition;
	}
	
	public ChessColor getOrientation() {
		return orientation;
	}
	
	// TODO Find a better way of keeping an array immutable
	public static List<Character> getFileLetters() {
		return Collections.unmodifiableList(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'));
	}

}
