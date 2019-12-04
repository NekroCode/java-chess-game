package nekrocode.chessgame.chess.util;

/**
 * This class is used to parse a FEN based chessboard position and returns a 2D character array to represent the board
 * Current functionality:
 * - Validates the format using a regular expression
 * 
 * TODO 
 * - Remove code duplication (same as GameCreator).
 * - Validate for illegal positions (two kings for one color for example)
 * - Validates the amount of files per rank
 * - Replace the following methods
 * 	 - getUnusedSquare()
 *   - getSize()
 *   
 * !!! IMPORTANT !!!
 * - Due to time limitations and change in design I had to copy and paste some other code over.
 * It's really redundant in it's current stage so I definitely want to change it when there's more time.
 * Currently it's looping twice the create the final result, one should be enough.
 * Also, regardless of the statement above, I don't like the 12x12 array implementation
 * so it's a temporal fix until I get time to redesign code to be way more efficient.
 * 
 * @author ~
 *
 */
public class FenPositionParser {
	
	public char[][] parsePosition(String position) throws FenNotationException {
		try { 
			validateFENFormat(position);
			String[] positions = splitPosition(position);
			char[][] boardPosition = getBoardAsArray(positions);
			return createBoardAsArrayTemp(boardPosition);
			//return getBoardAsArray(positions);
		} catch (FenNotationException e) {throw e;}
	}
	
	private void validateFENFormat(String position) throws FenNotationException {
		if (!position.matches("([rnbqkpRNBQKP1-8]{1,8}/){7}([rnbqkpRNBQKP1-8]{1,8})")) {
			throw new FenNotationException("Incorrect FEN format.");
		}
	}
	
	private char[][] getBoardAsArray(String[] positions) throws FenNotationException {
		int size = getSize();
		char[][] boardPosition = new char[size][size];
		for(int i = 0; i < size; i++) {
			try { boardPosition[i] = getRankAsArray(positions[i]); } 
				catch (FenNotationException e) {throw e;}
		}
		return boardPosition;
	}
	
	private char[] getRankAsArray(String rankPosition) throws FenNotationException {
		int length = rankPosition.length();
		char unusedSquare = getUnusedSquare();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			String object = rankPosition.substring(i, i+1);
			if (object.equals("8")) { return getEmptyRowAsArray(); }
			try {
				int increment = Integer.parseInt(object);
				for (int b = 0; b < increment; b++) {
					builder.append(unusedSquare);
				}
			} catch (Exception e ) {
				builder.append(object);
			}
		}
		return buildRank(builder.toString());
	}
	
	private char[] getEmptyRowAsArray() {
		return buildRank("xxxxxxxx");
	}
	
	// TODO Duplication
	private char[] buildRank(String rankPosition) {
		int size = getSize();
		char[] position = new char[size];
		for (int i = 0; i < size; i++) {
			position[i] = rankPosition.substring(i,i+1).charAt(0);
		}
		return position;
	}
	
	private char getUnusedSquare() {
		return 'x';
	}
	
	private int getSize() {
		return 8;
	}
	
	// TODO I may want to refactor this method to something global if it turns
	// out I need to re-use it for something else
	private String[] splitPosition(String notation) {
		String[] positions = notation.split("/");
		return positions;
	}
	
	// TODO Too messy in my opinion. Want to change when there's more time
	public char[][] createBoardAsArrayTemp(char[][] boardPosition) {
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
				builder.append("--");
				if (index > 7) {
					index = 0;
				}
				index++;
				chessboard[i] = buildRankTemp(builder.toString());
			} else {
				chessboard[i] = buildRankTemp("------------");
			}
		}
		return chessboard;
	}
	
	// TODO Duplication
	private char[] buildRankTemp(String rankPosition) {
		int length = rankPosition.length();
		char[] position = new char[length];
		for (int i = 0; i < length; i++) {
			position[i] = rankPosition.substring(i,i+1).charAt(0);
		}
		return position;
	}
}
