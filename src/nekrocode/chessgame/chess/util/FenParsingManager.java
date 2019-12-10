package nekrocode.chessgame.chess.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

/**
 * This class manages the parsing of FEN notations
 * 
 * @author ~
 *
 */
public class FenParsingManager {
	
	public FenParsingManager() {
		File file;
		try {
			file = getFileFromSource("puzzles/wtharveycomm8n4.txt");
			FenNotationParser parser = new FenNotationParser();
			parser.parseNotation(file);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private File getFileFromSource(String fileName) throws FileNotFoundException {
		ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource(fileName);
		
		if (resource != null) {
			return new File(resource.getFile());
		} else {
			throw new FileNotFoundException("File " + fileName + " not found");
		}
	}
	
}
