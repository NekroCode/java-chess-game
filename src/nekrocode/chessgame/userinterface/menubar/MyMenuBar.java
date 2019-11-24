package nekrocode.chessgame.userinterface.menubar;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;

// TODO Improve this class and its code only when there's time left for less important things
public class MyMenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;
	
	public MyMenuBar(JFrame frame) {
		JMenu helpMenu = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");
		about.addActionListener(o -> drawDialogBox(frame));
		helpMenu.add(about);
		add(helpMenu);
	}
	
	// TODO Replace the resource heavy JTextPane for the less resource limiting JTextArea
	// TODO Better placement of JDialog
	private void drawDialogBox(JFrame frame) {
		JDialog dialog = new JDialog(frame, "About", true);
		dialog.setResizable(false);
		JTextPane p = new JTextPane();
		p.setEditable(false);
		p.setText("My first attempt at building a chess application. \n"
				+ "Version 0.1 \n\n"
				+ "A thank you to: \n"
				+ "- Bill Harvey for the chess puzzles (http://wtharvey.com). \n"
				+ "- Everyone involved for taking the time to help me improve! \n\n"
				+ "Images used: \n"
				+ "- https://commons.wikimedia.org/wiki/Category:SVG_chess_pieces \n\n"
				+ "Improvement notes for version 0.2: \n"
				+ "- Better abstraction between the backend, backend conversion and the graphical user interface where possible. \n"
				+ "- Improve existing code by making use of interfaces where posssible. \n"
				+ "- Finding new techniques to improve memory usage and performance. \n"
				+ "- Improve by eliminating code logic duplication.");
		dialog.add(p);
		dialog.pack();
		dialog.setLocation(frame.getLocation());
		dialog.setVisible(true);
	}

}
