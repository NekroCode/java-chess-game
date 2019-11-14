package nekrocode.chessgame.chess.chessutil;

import java.util.List;

import nekrocode.chessgame.chess.chessboard.Chessboard;
import nekrocode.chessgame.chess.chessboard.IllegalSquareException;
import nekrocode.chessgame.chess.chessboard.Square;
import nekrocode.chessgame.util.Utility;

public class SquareSearcher {
	
	private final List<List<Square>> squares;
	
	public SquareSearcher(List<List<Square>> squares) {
		this.squares = squares;
	}
	
	// TODO Separate logic into different methods?
	public Square getSquare(String name) throws IllegalSquareException {
		Character file = name.charAt(0);
		int fileIndex = findFileIndex(file, Chessboard.getFileLetters());
		if (fileIndex == -1)
			throw new IllegalSquareException("Illegal file");
		
		String rank = name.substring(1, 2);
		int rankIndex = 0;
		if (!Utility.isInteger(rank))
			throw new IllegalSquareException("Illegal Rank");
		else
			rankIndex = Integer.parseInt(rank);
		if (!validateRank(rankIndex))
			throw new IllegalSquareException("Illegal Rank");
		
		int totalRanks = Chessboard.getTotalRanks();
		return squares.get(totalRanks-rankIndex).get(fileIndex);
	}
	
	// TODO Add logic if needed
	public Square getSquare(int rank, int file) throws IllegalSquareException {
		return null;
	}
	
	// TODO Maybe refactor this method to something more global?
	// The functionality could be used in other cases too.
	private int findFileIndex(Character file, List<Character> files) {
		int size = files.size();
		for (int i = 0; i < size; i++)
			if (file.equals(files.get(i)))
				return i;
		return -1;
	}
	
	private boolean validateRank(int rank) {
		if (rank > 0 && rank <= Chessboard.getTotalRanks())
			return true;
		else
			return false;
	}
	
}
