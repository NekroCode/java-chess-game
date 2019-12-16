package nekrocode.chessgame.chess.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 * This class is responsible for parsing FEN notations in algebraic notation form.
 * It currently requires the notation to be three lines long in the following order:
 * - Game information
 * - Board information
 * - Moves to be made
 * 
 * The Map<String, String> keys are as follows:
 * boardPosition
 * toMove
 * moves
 * castling
 * enPassant
 * halfMoveClock
 * gameInfo
 * 
 * WARNING: This class currently does not throw any error when something goes wrong so it's open for bugs.
 * - Example: Reading out the moves requires a whitespace between the move number and actual move to pass the regex.
 *   (1. e4 instead of 1.e4). In case of the latter the puzzle might break due to an incorrect move set.
 *   Output should be tested thoroughly to see if any legal move is caught out.
 * 
 * TODO
 * - Better code implementation.
 * 
 * @author ~
 *
 */
public class FenNotationParser {
	
	/**
	 * Sends the first line out as a game info string meaning it holds the board position, player to move, 
	 * castling availability, En-Passant moves and half move clock. 
	 * Second lines contains the moves per player.
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 */
	public List<Map<String, String>> parseNotation(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		List<String> games = new ArrayList<String>();
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			if (!line.isBlank()) {
				games.add(line);
			}
		}
		scanner.close();
		return processLines(games);
	}
	
	private List<Map<String, String>> processLines(List<String> games) {
		int size = games.size();
		final int increment = 3;
		List<Map<String, String>> chessPuzzles = new ArrayList<Map<String, String>>();
		for (int i = 0; i < size; i+=increment) {
			Map<String, String> map = processElements(games.get(i), games.get(i+1), games.get(i+2));
			if (map.get("boardPosition") != null) {
				chessPuzzles.add(processElements(games.get(i), games.get(i+1), games.get(i+2)));
			}
		}
		return chessPuzzles;
	}
	
	private Map<String, String> processElements(String gameInfo, String boardInfo, String moves) {
		Map<String, String> chessPuzzle = new HashMap<String, String>();
		processBoardInfo(boardInfo, chessPuzzle);
		chessPuzzle.put("gameInfo", gameInfo);
		processMoves(moves, chessPuzzle);
		return chessPuzzle;
	}
	
	// I don't like splitting based on an empty whitespace.
	// Or could I at least declare it in a more semantic way?
	private void processBoardInfo(String boardInfo, Map<String, String> chessPuzzle) {
		String[] elements = boardInfo.split(" ");
		String position = elements[0];
		if (!FenPositionParser.positionIsValid(elements[0])) { return; }
		chessPuzzle.put("boardPosition", position);
		chessPuzzle.put("toMove", elements[1]);
		chessPuzzle.put("castling", elements[2]);
		chessPuzzle.put("enPassant", elements[3]);
		chessPuzzle.put("halfMoveClock", elements[4] + " " + elements[5]);
	}
	
	private void processMoves(String moves, Map<String, String> chessPuzzle) {
		String[] elements = moves.split(" ");
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < patterns.length; i++) {
			builder.append(patterns[i] + "|");
		}
		StringBuilder moveSet = new StringBuilder();
		for (String object : elements) {
			if (Pattern.matches(builder.toString(), object)) {
				moveSet.append(object + "/");
			}
		}
		chessPuzzle.put("moves", moveSet.toString());
	}
	
	// Very ugly but will do for now. Very possible that it's still missing some necessary entries
	// or that some of the existing entries contain errors.
	private String[] patterns = new String[] {
			
			"[a-h][1-8]", // Regular pawn move 
			"[a-h]x[a-h][1-8]", // Pawn capture 
			"[a-h][1-8]\\+", // Pawn check
			"[a-h]x[a-h][1-8]\\+", // Pawn capture + check
			"[a-h][1-8]#", // Pawn checkmate
			"[a-h]x[a-h][1-8]#", // Pawn capture + checkmate
			"[a-h][1-8]=[RBNQ]#",// Pawn promotion
			"[a-h][1-8]=[RBNQ]",// Pawn promotion + capture
			"[a-h][1-8]=[RBNQ]\\+",// Pawn promotion + check
			"[a-h][1-8]=[RBNQ]#",// Pawn promotion + checkmate
			"[a-h]x[a-h][1-8]=[RBNQ]\\+",// Pawn promotion + capture + check
			"[a-h]x[a-h][1-8]=[RBNQ]#",// Pawn promotion + capture + checkmate
			
			"[BRQNK][a-h][1-8]", // Regular piece move 
			"[BRQNK]x[a-h][1-8]", // Piece capture
			"[BRQNK][a-h][1-8]\\+", // Piece check
			"[BRQNK]x[a-h][1-8]\\+", // Piece capture + check
			"[BRQNK][a-h][1-8]#", // Piece checkmate
			"[BRQNK]x[a-h][1-8]#", // Piece capture + checkmate
			
			"[BRQNK][a-h][a-h][1-8]", // Piece file move
			"[BRQNK][a-h]x[a-h][1-8]", // Piece file capture
			"[BRQNK][a-h][a-h][1-8]\\+", // Piece file check
			"[BRQNK][a-h][a-h][1-8]#", // Piece file checkmate
			"[BRQNK][a-h]x[a-h][1-8]#", // Piece file capture + checkmate
			"[BRQNK][a-h]x[a-h][1-8]\\+", // Piece file capture + check
			
			"[BRQNK][1-8][a-h][1-8]", // Piece rank move
			"[BRQNK][1-8]x[a-h][1-8]", // Piece rank capture
			"[BRQNK][1-8][a-h][1-8]\\+", // Piece rank check
			"[BRQNK][1-8][a-h][1-8]#", // Piece rank checkmate
			"[BRQNK][1-8]x[a-h][1-8]#", // Piece rank capture + checkmate
			"[BRQNK][1-8]x[a-h][1-8]\\+", // Piece rank capture + check	
	};
	
}
