package nekrocode.chessgame.chess.chessboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nekrocode.chessgame.chess.ChessColor;

public class ChessboardBuilder {
	
	private List<List<Square>> squares;
	
	public ChessboardBuilder() {
		int totalRanks = Chessboard.TOTAL_RANKS;
		int rankNumber = totalRanks;
		List<Character> letters = Chessboard.getFileLetters();
		squares = new ArrayList<List<Square>>();
		List<ChessColor> colors = getColors();
		for (int i = 0; i < totalRanks; i++) {
			squares.add(createRow(letters, rankNumber, colors));
			Collections.reverse(colors);
			rankNumber--;
		}
	}
	
	public Chessboard buildBoard(ChessColor orientation) {
		return new Chessboard(getSquares(), orientation);
	}
	
	private List<Square> createRow(List<Character> letters, int rankNumber, List<ChessColor> colors) {
		List<Square> row = new ArrayList<Square>();
		int totalFiles = letters.size();
		int colorIndex = 0;
		
		for (int i = 0; i < totalFiles; i++) {
			row.add(new Square(letters.get(i), rankNumber, i, colors.get(colorIndex)));
			colorIndex++;
			if (colorIndex > 1) { 
				colorIndex = 0;
			}
		}
		
		return row;
	}
	
	private List<ChessColor> getColors() {
		List<ChessColor> colors = new ArrayList<ChessColor>();
		for (ChessColor color : ChessColor.values()) {
			colors.add(color);
		}
		return colors;
	}
	
	public List<List<Square>> getSquares() {
		return squares;
	}
	
}
