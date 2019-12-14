package nekrocode.chessgame.chess.board;

/**
 * This class is responsible for translating array indices to a String respesenting a square name
 * 
 * TODO
 * - Add exception handling 
 * - Return indices based on given String
 * @author ~
 *
 */
public class SquareTranslator {
	
	public String getSquareName(int file, int rank) {
		rank = Chessboard.TOTAL_RANKS - rank;
		char fileLetter = Chessboard.getFileLetters().get(file);
		return fileLetter + "" + rank ;
	}
	
	// TODO build implementation
	public int[] getSquareIndices(String square) {
		int fileIndex = 0;
		int rank = 0;
		return new int[] {fileIndex, rank};
	}
	
}
