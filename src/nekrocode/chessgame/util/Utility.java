package nekrocode.chessgame.util;

/**
 * Using this class until I can come up with a better structure
 * @author ~
 *
 */
public class Utility {
	
	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
