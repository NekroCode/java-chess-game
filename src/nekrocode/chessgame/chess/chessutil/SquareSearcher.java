package nekrocode.chessgame.chess.chessutil;

import java.util.List;

import nekrocode.chessgame.chess.chessboard.Chessboard;
import nekrocode.chessgame.chess.chessboard.Square;
import nekrocode.chessgame.chess.chessutil.exceptions.IllegalSquareException;
import nekrocode.chessgame.util.Utility;

public class SquareSearcher {
	
	private final List<List<Square>> squares;
	
	public SquareSearcher(List<List<Square>> squares) {
		this.squares = squares;
	}
	
	// TODO Separate logic into different methods?
	//
	// TODO Refactor a little bit after Square change (fileIndex variabel)
	public Square getSquare(String name) throws IllegalSquareException {
		//int fileIndex = findFileIndex(name.charAt(0), Chessboard.getFileLetters());
		int fileIndex = getFileIndex(name.charAt(0));
		if (fileIndex == -1) {
			throw new IllegalSquareException("Illegal file");
		}
		
		String rank = name.substring(1, 2);
		int rankIndex = 0;
		if (!Utility.isInteger(rank)) {
			throw new IllegalSquareException("Illegal Rank");
		} else {
			rankIndex = Integer.parseInt(rank);
		}
		if (!validateRank(rankIndex)) {
			throw new IllegalSquareException("Illegal Rank");
		}
		
		return squares.get(getRankIndex(rankIndex)).get(fileIndex);
	}
	
	// TODO Add logic if needed
	public Square getSquare(int rank, int file) throws IllegalSquareException {
		return null;
	}
	
	public int getFileIndex(Character file) {
		return findFileIndex(file, Chessboard.getFileLetters());
	}
	
	public int getRankIndex(int rank) {
		return Chessboard.TOTAL_RANKS - rank;
	}
	
	// TODO Maybe refactor this method to something more global?
	// The functionality could be used in other cases too.
	private int findFileIndex(Character file, List<Character> files) {
		int size = files.size();
		for (int i = 0; i < size; i++) {
			if (file.equals(files.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	// TODO Find a different place for this method
	// Class for calculating new moves may also need to use this method
	private boolean validateRank(int rank) {
		if (rank > 0 && rank <= Chessboard.TOTAL_RANKS) {
			return true;
		} else {
			return false;
		}
	}
	
}
