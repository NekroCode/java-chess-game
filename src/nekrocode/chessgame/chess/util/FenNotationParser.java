package nekrocode.chessgame.chess.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import com.sun.tools.javac.Main;

public class FenNotationParser {
	
	String notation = "r2qkb1r/pp2nppp/3p4/2pNN1B1/2BnP3/3P4/PPP2PPP/R2bK2R w KQkq - 1 0\r\n" + 
			"1. Nf6+ gxf6 2. Bxf7#\n" + 
			"\n" +
			"1rb4r/pkPp3p/1b1P3n/1Q6/N3Pp2/8/P1P3PP/7K w - - 1 0\r\n" + 
			"1. Qd5+ Ka6 2. cxb8=N#";
	
	public FenNotationParser() {
		Scanner scanner = new Scanner(notation);
		while (scanner.hasNext()) {
			processLine(scanner.nextLine());
		}
		scanner.close();
	}
	
	private void processLine(String line) {
		if (line.equals("")) {
			System.out.println("--- nothing here ---");
		} else {
			System.out.println(line);
		}
	}
	
	/**
	 * Testing
	 */
	private void testFindingFile() {
		try {
			findFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	private void findFile() throws FileNotFoundException {
		InputStream i = Main.class.getResourceAsStream("/puzzles/edits/wtharveycomm8n2_edit.txt");
		System.out.println(i);
//		File file = new File("/puzzles/edits/wtharveycomm8n2_edit.txt");
	}
	
}
