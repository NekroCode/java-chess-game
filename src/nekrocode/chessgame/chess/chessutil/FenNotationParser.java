package nekrocode.chessgame.chess.chessutil;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
// I think as String.
public class FenNotationParser {
	
	// TODO Localise the (object-1)-x thing?
	
	public HashMap<Chesspiece, String> parsePosition(String position) throws FENFormatException {
		try { 
			validateFENFormat(position, true);
			String[] positions = splitPosition(position);
			return getPositionAsHashMap(positions);
		} catch (FENFormatException e) {throw e;}	
	}
	
	// TODO Add regex
	// Added boolean temp to simulate the functionality the regex should achieve
	private void validateFENFormat(String position, boolean temp) throws FENFormatException {
		if (temp == false) {
			throw new FENFormatException("Incorrect FEN format.");
		}
			//throw new FENFormatException("Incorrect FEN Format. Missing slash separator between the ranks.");
	}
	
	private HashMap<Chesspiece, String> getPositionAsHashMap(String[] positions) throws FENFormatException {
		int ranks = positions.length;
		HashMap<Chesspiece, String> boardPosition = new HashMap<Chesspiece, String>();
		ChessColor color;
		
		for (int i = 0; i < ranks; i++) {
			if (!rowIsEmpty(positions[i].substring(0, 1))) {
				int length = positions[i].length();
				int file = 0;
				for (int x = 0; x < length; x++) {
					String object = positions[i].substring(x, x+1);
					if (Utility.isInteger(object)) {
						file += Integer.parseInt(object);
					} else {
						color = getColor(object.charAt(0));
						try {
							Chesspiece chesspiece = getChesspiece(object, color);
							String square = Chessboard.getFileLetters().get(file).toString() + (ranks-i);
							System.out.println(square);
							boardPosition.put(chesspiece, square);
							file++;
						} catch (ChesspieceException e) {
							throw new FENFormatException(e.getMessage());
						}
					}
				}
			}
		}
		return boardPosition;
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
			throw new ChesspieceException("Unknown chesspiece in notation.");
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
