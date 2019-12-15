package nekrocode.chessgame.chess.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * This class manages the parsing of FEN notations and returns a Map object with all the necessary information
 * needed to simulate the puzzle.
 * 
 * @author ~
 *
 */
public class FenParsingManager {
	
	private FenNotationParser parser;
	
	public FenParsingManager() {
		parser = new FenNotationParser();
	}
	
	/**
	 * Handle catch clause in a better way
	 * 
	 * @param url
	 * @return
	 */
	public List<Map<String, String>> parseNotation(String url) {
		File file;
		try {
			file = getFileFromSource(url);
			return parser.parseNotation(file);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return null;
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
