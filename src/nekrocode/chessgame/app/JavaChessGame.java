package nekrocode.chessgame.app;

import javax.swing.SwingUtilities;

import nekrocode.chessgame.userinterface.util.GuiBuilder;

/**
 * TODO General improvements:
 * - For loop logic in GameCreator.java and ChessboardView.java are nearly identical. Find ways to negate this duplication.
 * 
 * @author ~
 *
 */
public class JavaChessGame {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(() -> drawGui());
	}
	
	private static void drawGui() {
		new GuiBuilder();
	}

}