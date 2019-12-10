package nekrocode.chessgame.userinterface.util;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import nekrocode.chessgame.test_environment.tests.TestPanel;
import nekrocode.chessgame.userinterface.mainmenu.MainMenuView;
import nekrocode.chessgame.userinterface.menubar.MyMenuBar;
import nekrocode.chessgame.userinterface.modes.PuzzleModeView;

/**
 * A separate class for drawing the graphical user interface is made so the non-static method
 * getClass() can be used to retrieve the application's image icon
 * 
 * @author ~
 *
 */
public class GuiBuilder {
	
	private JFrame frame;
	
	public GuiBuilder() {
		try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel" );} 
			catch(Exception e) {}
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Nekro's Chess Application");
		// TODO Look into better ways of loading the image?
		// Don't forget to also change the image and its dimension
		//try { frame.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("imgs/icons/app_icon.png")).getImage()); } 
			//catch (NullPointerException e) {}
		frame.setJMenuBar(new MyMenuBar(frame));
		//changeContentPane(new MainMenuView());
		//changeContentPane(new TestPanel());
		changeContentPane(new PuzzleModeView());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		//System.exit(0);
	}
	
	private void changeContentPane(JPanel panel) {
		frame.setContentPane(panel);
		frame.validate();
	}
	
}
