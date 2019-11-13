package nekrocode.chessgame.chess.chessutil;

import java.util.HashMap;

import nekrocode.chessgame.chess.ChessColors;
import nekrocode.chessgame.chess.chessboard.Square;
import nekrocode.chessgame.chess.chesspieces.Chesspiece;
import nekrocode.chessgame.chess.chesspieces.ChesspieceCreator;
import nekrocode.chessgame.util.Utility;

public class FenNotationParser {
	
	public FenNotationParser() {
		//String notation = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
		String notation = "rn2kbnr/pp6/8/8/8/8/6PP/RNBQKBNR";
		parseNotation(notation);
	}

	public HashMap<Chesspiece, Square> parseNotation(String notation) {
		String[] list = splitNotation(notation);
		int rankIndex = list.length-1;
		for (int i = rankIndex; i >= 0; i--) {
			int indexFromStart = i-i;
			String object = list[i].substring(indexFromStart, (indexFromStart)+1);
			if (!rowIsEmpty(object))
				processRank(list[i], i+1);
		}
		return null;
	}
	
	// TODO Pickup after fixing git. Need to implement a square searcher before I can continue
	private void processRank(String position, int rank) {
		int length = position.length();
		int columnIndex = 0;
		
		for (int i = 0; i < length; i++) {
			String object = position.substring(i, i+1);
			if (Utility.isInteger(object))
				columnIndex += Integer.parseInt(object)-1;
			else {
				ChessColors color = getColor(object.charAt(0));
				Chesspiece chesspiece = getChesspiece(object.toLowerCase(), color);
				Square square;
				//System.out.println(chesspiece);
			}
				
			//System.out.println(columnIndex);
			columnIndex++;
		}
		System.out.println("----------");
		//System.out.println(position + ":" + rank);
	}
	
	// TODO I may want to refactor this method to something global if it turns
	// out I need to re-use it for something else
	private String[] splitNotation(String notation) {
		String[] positions = notation.split("/");
		return positions;
	}
	
	private ChessColors getColor(char letter) {
		if (Character.isLowerCase(letter))
			return ChessColors.LIGHT;
		else
			return ChessColors.DARK;
	}
	
	private boolean rowIsEmpty(String numberToSkip) {
		if (numberToSkip.equals("8"))
			return true;
		else
			return false;
	}
	
	// TODO Change data type to Enum for extra safety?
	private Chesspiece getChesspiece(String letter, ChessColors color) {
		ChesspieceCreator creator = new ChesspieceCreator();
		switch (letter) {
			case "p" :
				return creator.createPawn(color);
			case "n" :
				return creator.createKnight(color);
			case "b" :
				return creator.createBishop(color);
			case "r" :
				return creator.createRook(color);
			case "q" :
				return creator.createQueen(color);
			case "k" : 
				return creator.createKing(color);

//			Java 12's Case Label preview feature
//			case "p" -> creator.createPawn(color);
//			case "n" -> creator.createKnight(color);
//			case "b" -> creator.createBishop(color);
//			case "r" -> creator.createRook(color);
//			case "q" -> creator.createQueen(color);
//			case "k" -> creator.createKing(color);
		}
		return null;
	}
	
}
