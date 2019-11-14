package nekrocode.chessgame.app;

import javax.swing.SwingUtilities;

import nekrocode.chessgame.userinterface.graphicalutil.GuiBuilder;

public class JavaChessGame {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(() -> drawGui());
		//System.exit(0);
	}
	
	private static void drawGui() {
		new GuiBuilder();
	}

}