package nekrocode.chessgame.chess.chessutil;

import java.util.HashMap;

import nekrocode.chessgame.chess.ChessColors;
import nekrocode.chessgame.chess.chessboard.Chessboard;
import nekrocode.chessgame.chess.chesspieces.Chesspiece;
import nekrocode.chessgame.chess.chesspieces.pieces.Bishop;
import nekrocode.chessgame.chess.chesspieces.pieces.King;
import nekrocode.chessgame.chess.chesspieces.pieces.Knight;
import nekrocode.chessgame.chess.chesspieces.pieces.Pawn;
import nekrocode.chessgame.chess.chesspieces.pieces.Queen;
import nekrocode.chessgame.chess.chesspieces.pieces.Rook;
import nekrocode.chessgame.util.Utility;

// TODO Want to refactor this code to something more composition based rather
// than the current 'pipeline' setup.
//
// TODO Include the remaining notation elements.
//
// TODO Include Exception Handling to protect against incorrect formats
//
// TODO Do I want to return a square as String or as Square object?
// I think as String.
public class FenNotationParser {
	
	public FenNotationParser() {
		
	}
	
	public HashMap<Chesspiece, String> parsePosition(String position) {
		String[] list = splitNotation(position);
		HashMap<Chesspiece, String> hashMap = new HashMap<Chesspiece, String>();
		int ranks = list.length;
		for (int i = 0; i < ranks; i++) {
			String object = list[i].substring(0, 1);
			if (!rowIsEmpty(object))
				processRank(list[i], ranks-i, hashMap);
		}
		return hashMap;
	}
	
	private HashMap<Chesspiece, String> processRank(String position, int rank, HashMap<Chesspiece, String> hashMap) {
		int length = position.length();
		int columnIndex = 0;
		ChessColors color;
		
		for (int i = 0; i < length; i++) {
			String object = position.substring(i, i+1);
			if (Utility.isInteger(object))
				columnIndex += Integer.parseInt(object);
			else {
				color = getColor(object.charAt(0));
				String square = Chessboard.getFileLetters().get(columnIndex) + "" + rank;
				hashMap.put(getChesspiece(object.toLowerCase(), color), square);
				columnIndex++;
			}
		}
		return hashMap;
	}
	
	// TODO I may want to refactor this method to something global if it turns
	// out I need to re-use it for something else
	private String[] splitNotation(String notation) {
		String[] positions = notation.split("/");
		return positions;
	}
	
	private ChessColors getColor(char letter) {
		if (Character.isUpperCase(letter))
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
		switch (letter) {
			case "p" :
				return new Pawn(color);
			case "n" :
				return new Knight(color);
			case "b" :
				return new Bishop(color);
			case "r" :
				return new Rook(color);
			case "q" :
				return new Queen(color);
			case "k" : 
				return new King(color);

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
