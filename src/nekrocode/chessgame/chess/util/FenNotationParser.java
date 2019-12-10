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
 * TODO
 * - Better code implementation. Currently in testing stage
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
	public void parseNotation(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		List<String> games = new ArrayList<String>();
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			if (!line.isBlank()) {
				games.add(line);
			}
		}
		scanner.close();
		processLines(games);
		//List<Map<String, String>> chessPuzzles = new ArrayList<Map<String, String>>();
	}
	
	// Return Map<String, String> object
	private void processLines(List<String> games) {
		int size = games.size();
		final int increment = 3;
		List<Map<String, String>> chessPuzzles = new ArrayList<Map<String, String>>();
		for (int i = 0; i < size; i+=increment) {
			processElements(games.get(i), games.get(i+1), games.get(i+2));
		}
	}
	
	private void processElements(String gameInfo, String boardInfo, String moves) {
		Map<String, String> chessPuzzle = new HashMap<String, String>();
		chessPuzzle.put("gameInfo", gameInfo);
		processBoardInfo(boardInfo, chessPuzzle);
		processMoves(moves, chessPuzzle);
//		System.out.println(chessPuzzle.get("boardPosition"));
//		System.out.println(chessPuzzle.get("toMove"));
//		System.out.println(chessPuzzle.get("castling"));
//		System.out.println(chessPuzzle.get("enPassant"));
//		System.out.println(chessPuzzle.get("halfMoveClock"));
//		System.out.println(gameInfo);
//		System.out.println(boardInfo);
//		System.out.println(moves);
		System.out.println("------");
		
	}
	
	// I don't like splitting based on an empty whitespace
	// Or could I at least declare it in a more semantic way?
	private void processBoardInfo(String boardInfo, Map<String, String> chessPuzzle) {
		String[] elements = boardInfo.split(" ");
		chessPuzzle.put("boardPosition", elements[0]);
		chessPuzzle.put("toMove", elements[1]);
		chessPuzzle.put("castling", elements[2]);
		chessPuzzle.put("enPassant", elements[3]);
		chessPuzzle.put("halfMoveClock", elements[4] + " " + elements[5]);
	}
	
	// A better way of checking valid values is with regex. Implement at a later time.
	private void processMoves(String moves, Map<String, String> chessPuzzle) {
		String[] elements = moves.split(" ");
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < patterns.length; i++) {
			builder.append(patterns[i] + "|");
		}
		
		for (String s : elements) {
			System.out.println(Pattern.matches(builder.toString(), s) + " : " + s);
		}
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
			"[BRQNK][1-8][a-h][1-8]#", // Piece rank checmkate
			"[BRQNK][1-8]x[a-h][1-8]#", // Piece rank capture + checkmate
			"[BRQNK][1-8]x[a-h][1-8]\\+", // Piece rank capture + check	
	};
	
}
