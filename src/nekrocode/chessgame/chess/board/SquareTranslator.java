package nekrocode.chessgame.chess.board;

/**
 * This class has the capability to translate array indices to a String representing a square
 * 
 * TODO return indices based on given String
 * @author ~
 *
 */
public class SquareTranslator {
	
	public String getSquareName(int fileIndex, int rank) {
		rank = Chessboard.TOTAL_RANKS - rank;
		char file = Chessboard.getFileLetters().get(fileIndex);
		return file + "" + rank ;
	}
	
	// TODO build implementation
	public int[] getSquareIndices(String square) {
		int fileIndex = 0;
		int rank = 0;
		return new int[] {fileIndex, rank};
	}
	
}
