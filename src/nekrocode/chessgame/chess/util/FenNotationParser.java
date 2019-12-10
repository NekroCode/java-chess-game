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
 * This class is responsible for parsing FEN notations/
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
		System.out.println(chessPuzzle.get("boardPosition"));
		System.out.println(chessPuzzle.get("toMove"));
		System.out.println(chessPuzzle.get("castling"));
		System.out.println(chessPuzzle.get("enPassant"));
		System.out.println(chessPuzzle.get("halfMoveClock"));
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
	
	private void processMoves() {
		
	}
	
}
