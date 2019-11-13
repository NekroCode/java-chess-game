package nekrocode.chessgame.chess.chessboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nekrocode.chessgame.chess.ChessColors;

public class ChessboardBuilder {
	
	private List<List<Square>> squares;
	
	public ChessboardBuilder() {
		int totalRanks = Chessboard.getTotalRanks();
		int rankNumber = totalRanks;
		List<Character> letters = Chessboard.getFileLetters();
		squares = new ArrayList<List<Square>>();
		List<ChessColors> colors = getBoardColors();
		for (int i = 0; i < totalRanks; i++) {
			squares.add(createBoardRow(letters,rankNumber, colors));
			Collections.reverse(colors);
			rankNumber--;
		}
	}
	
	public Chessboard buildBoard(ChessColors orientation) {
		return new Chessboard(getSquares(), orientation);
	}
	
	private List<Square> createBoardRow(List<Character> letters, int rankNumber, List<ChessColors> colors) {
		List<Square> row = new ArrayList<Square>();
		int totalFiles = letters.size();
		int colorIndex = 0;
		
		for (int i = 0; i < totalFiles; i++) {
			row.add(new Square(letters.get(i), rankNumber, colors.get(colorIndex)));
			colorIndex++;
			if (colorIndex > 1)
				colorIndex = 0;
		}
		
		return row;
	}
	
	private List<ChessColors> getBoardColors() {
		List<ChessColors> colors = new ArrayList<ChessColors>();
		for (ChessColors color : ChessColors.values())
			colors.add(color);
		return colors;
	}
	
	public List<List<Square>> getSquares() {
		return squares;
	}
	
}
