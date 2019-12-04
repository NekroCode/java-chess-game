package nekrocode.chessgame.chess.util;

import nekrocode.chessgame.chess.game.BoardRepresentation;

/**
 * This class is used to parse a FEN based chessboard position and returns a 2D character array to represent the board
 * Current functionality:
 * - Validates the format using a regular expression
 * 
 * TODO 
 * - Remove code duplication (same as GameCreator).
 * - Validate for illegal positions (two kings for one color for example)
 * - Validates the amount of files per rank
 *   
 * !!! IMPORTANT !!!
 * - Due to the 12x12 array data structure representing the board
 * I had to include the dependency of this classing knowing about the class
 * BoardRepresentation so it can make use of its static data members.
 * This should be changed in future versions.
 * 
 * @author ~
 *
 */
public class FenPositionParser {
	
	public char[][] parsePosition(String position) throws FenNotationException {
		try { 
			validateFENFormat(position);
			String[] positions = splitPosition(position);
			return getBoardAsArray(positions);
		} catch (FenNotationException e) {throw e;}
	}
	
	private char[][] getBoardAsArray(String[] positions) throws FenNotationException {
		int size = BoardRepresentation.SIZE;
		int start = BoardRepresentation.BOARD_START;
		int end = BoardRepresentation.BOARD_END;
		char[][] boardPosition = new char[size][size];
		int index = 0;
		
		for (int i = 0; i < size; i++) {
			StringBuilder builder = new StringBuilder();
			if (i >= start && i < end) {
				builder.append("--");
				builder.append(translateRank(positions[i-start]));
				builder.append("--");
				if (index > 7) { index = 0;}
				index++;
			} else {
				for (int b = 0; b < size; b++) {
					builder.append("-");
				}
			}
			boardPosition[i] = getRankAsArray(builder.toString());
		}
		return boardPosition;
	}
	
	private String translateRank(String position) throws FenNotationException {
		StringBuilder builder = new StringBuilder();
		int length = position.length();
		for (int i = 0; i < length; i++) {
			String object = position.substring(i, i+1);
			if (object.equals("8")) { 
				return("xxxxxxxx");
			}
			try {
				int increment = Integer.parseInt(object);
				for (int b = 0; b < increment; b++) {
					builder.append("x");
				}
			} catch (Exception e) {
				builder.append(object);
			}
		}
		return builder.toString();
	}
	
	private char[] getRankAsArray(String positionOnRank) {
		int length = positionOnRank.length();
		char[] position = new char[length];
		for (int i = 0; i < length; i++) {
			position[i] = positionOnRank.substring(i,i+1).charAt(0);
		}
		return position;
	}
	
	private void validateFENFormat(String position) throws FenNotationException {
		if (!position.matches("([rnbqkpRNBQKP1-8]{1,8}/){7}([rnbqkpRNBQKP1-8]{1,8})")) {
			throw new FenNotationException("Incorrect FEN format.");
		}
	}
	
	// TODO I may want to refactor this method to something global if it turns
	// out I need to re-use it for something else
	private String[] splitPosition(String notation) {
		String[] positions = notation.split("/");
		return positions;
	}
}
