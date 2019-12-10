package nekrocode.chessgame.chess.board;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import nekrocode.chessgame.chess.game.BoardRepresentation;
import nekrocode.chessgame.chess.game.enums.ChessColor;

/**
 * This class represents a chessboard and is used to convey data from the BoardPresentation class
 * TODO:
 * - getBoardPosition() needs a change in the future unless it turns out I actually need a copy of the array.
 * 
 * @author ~
 *
 */
public class Chessboard {
	
	// TODO Remove total ranks + files to user interface environment?
	public static final int TOTAL_RANKS = 8;
	public static final int TOTAL_FILES = TOTAL_RANKS;
	private BoardRepresentation boardRepresentation;
	//private char[][] boardPosition;
	private ChessColor orientation;
	
	public Chessboard(BoardRepresentation boardRepresentation, ChessColor orientation) {
		this.boardRepresentation = boardRepresentation;
		this.orientation = orientation;
	}
	
	public ChessColor getOrientation() {
		return orientation;
	}
	
	// TODO Remove hard coded values
	public char[][] getBoardPosition() {
		int size = 8; 
		char[][] boardPosition = new char[size][size];
		char[] rank = new char[size];
		int start = 2;
		int end = 10;
		int index = start;
		for (int i = 0; i < size; i++) {
			rank = Arrays.copyOfRange(boardRepresentation.getBoardPosition()[index], start, end);
			boardPosition[i] = rank;
			index++;
		}
		return boardPosition;
	}
	
	// TODO Find a better way of keeping an array immutable
	public static List<Character> getFileLetters() {
		return Collections.unmodifiableList(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'));
	}

}
