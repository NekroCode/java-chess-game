package nekrocode.chessgame.chess.visualrepresentations;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

/**
 * This acts as a temporal class to save the colors of chessboard squares
 * until the user gets to customize his own color.
 * @author ~
 *
 */
public class ChessboardConfig {
	
	public static Color getLightColor() {
		return new Color(236, 236, 215);
	}
	
	public static Color getDarkColor() {
		return new Color(115, 137, 182);
	}
	
	// TODO Remove later on if this method is not needed
	public static List<Color> getBoardColors() {
		return Arrays.asList(new Color(236, 236, 215), new Color(115, 137, 182));
	}
}
