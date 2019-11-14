package nekrocode.chessgame.userinterface;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;
	
	public MyMenuBar() {
		JMenu helpMenu = new JMenu("Help");
		JMenuItem about = new JMenuItem("about");
		helpMenu.add(about);
		add(helpMenu);
	}
	
	// Credits to:
	//
	// Bill Harvey for the chess puzzles: http://wtharvey.com
}
