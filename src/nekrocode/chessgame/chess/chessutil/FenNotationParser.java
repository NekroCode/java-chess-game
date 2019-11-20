package nekrocode.chessgame.chess.chessutil;

import java.util.HashMap;

import nekrocode.chessgame.chess.ChessColor;
import nekrocode.chessgame.chess.chessboard.Chessboard;
import nekrocode.chessgame.chess.chesspieces.Chesspiece;
import nekrocode.chessgame.chess.chesspieces.pieces.Bishop;
import nekrocode.chessgame.chess.chesspieces.pieces.King;
import nekrocode.chessgame.chess.chesspieces.pieces.Knight;
import nekrocode.chessgame.chess.chesspieces.pieces.Pawn;
import nekrocode.chessgame.chess.chesspieces.pieces.Queen;
import nekrocode.chessgame.chess.chesspieces.pieces.Rook;
import nekrocode.chessgame.chess.chessutil.exceptions.FENFormatException;
import nekrocode.chessgame.chess.chessutil.exceptions.ChesspieceException;
import nekrocode.chessgame.util.Utility;

// TODO Want to refactor this code to something more composition based rather
// than the current 'pipeline' setup.
//
// TODO Include the remaining notation elements.
//
// TODO Do I want to return a square as String or as Square object?
// Square for less converting one in different classes.
// String for less dependency
public class FenNotationParser {
	
	public HashMap<Chesspiece, String> parsePosition(String position) throws FENFormatException {
		try { 
			validateFENFormat(position);
			String[] positions = splitPosition(position);
			return getPositionAsHashMap(positions);
		} catch (FENFormatException e) {throw e;}	
	}
	
	private void validateFENFormat(String position) throws FENFormatException {
		if (!position.matches("([rnbqkpRNBQKP1-8]{1,8}/){7}([rnbqkpRNBQKP1-8]{1,8})")) {
			throw new FENFormatException("Incorrect FEN format.");
		}
	}
	
	private HashMap<Chesspiece, String> getPositionAsHashMap(String[] positions) throws FENFormatException {
		int ranks = positions.length;
		HashMap<Chesspiece, String> boardPosition = new HashMap<Chesspiece, String>();
		for (int i = 0; i < ranks; i++) {
			String position = positions[i];
			if (!rowIsEmpty(position.substring(0, 1))) {
				processRank(position, ranks-i, boardPosition);
			}
		}
		return boardPosition;
	}
	
	private void processRank(String position, int rank, HashMap<Chesspiece, String> boardPosition) throws FENFormatException {
		int length = position.length();
		int file = 0;
		for (int i = 0; i < length; i++) {
			String object = position.substring(i, i+1);
			// TODO Integer.parseInt is invoked twice. Want to change this
			if (Utility.isInteger(object)) {
				file += Integer.parseInt(object);
			} else {
				file++;
				if (file > Chessboard.TOTAL_RANKS) {
					throw new FENFormatException("Exceeded total amounts of files.");
				}
				try {
					HashMap.Entry<Chesspiece, String> entry = getPositionAsMapEntry(object, rank, file);
					boardPosition.put(entry.getKey(), entry.getValue());
				} catch (FENFormatException e) {
					throw new FENFormatException(e.getMessage());
				}
			}
		}
	}
	
	private HashMap.Entry<Chesspiece, String> getPositionAsMapEntry(String letter, int rank, int file) throws FENFormatException {
		ChessColor color = getColor(letter.charAt(0));
		Chesspiece chesspiece = null;
		try {
			chesspiece = getChesspiece(letter, color);
		} catch (ChesspieceException e) {
			throw new FENFormatException(e.getMessage());
		}
		String square = Chessboard.getFileLetters().get(file-1).toString() + rank;
		return new java.util.AbstractMap.SimpleEntry<Chesspiece, String>(chesspiece, square);
	}
	
	// TODO I may want to refactor this method to something global if it turns
	// out I need to re-use it for something else
	private String[] splitPosition(String notation) {
		String[] positions = notation.split("/");
		return positions;
	}
	
	private ChessColor getColor(char letter) {
		if (Character.isUpperCase(letter)) {
			return ChessColor.LIGHT;
		} else {
			return ChessColor.DARK;
		}
	}
	
	private boolean rowIsEmpty(String numberToSkip) {
		if (numberToSkip.equals("8")) {
			return true;
		} else {
			return false;
		}
	}
	
	// TODO Change data type to Enum for extra safety?
	private Chesspiece getChesspiece(String letter, ChessColor color) throws ChesspieceException {
		letter = letter.toLowerCase();
		Chesspiece chesspiece = null;
		switch (letter) {
			case "p" :
				chesspiece = new Pawn(color);
				break;
			case "n" :
				chesspiece = new Knight(color);
				break;
			case "b" :
				chesspiece = new Bishop(color);
				break;
			case "r" :
				chesspiece = new Rook(color);
				break;
			case "q" :
				chesspiece = new Queen(color);
				break;
			case "k" : 
				chesspiece = new King(color);
				break;
		}
		if (chesspiece == null) {
			throw new ChesspieceException("Unknown chesspiece in notation. " + letter);
		}
		return chesspiece;
//		Java 12's Case Label preview feature
//		case "p" -> creator.createPawn(color);
//		case "n" -> creator.createKnight(color);
//		case "b" -> creator.createBishop(color);
//		case "r" -> creator.createRook(color);
//		case "q" -> creator.createQueen(color);
//		case "k" -> creator.createKing(color);
	}
	
}
