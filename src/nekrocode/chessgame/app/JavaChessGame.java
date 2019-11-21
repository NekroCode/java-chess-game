package nekrocode.chessgame.app;

import javax.swing.SwingUtilities;

import nekrocode.chessgame.userinterface.util.GuiBuilder;

public class JavaChessGame {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(() -> drawGui());
	}
	
	private static void drawGui() {
		new GuiBuilder();
	}

}