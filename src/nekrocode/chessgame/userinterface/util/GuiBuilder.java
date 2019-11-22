package nekrocode.chessgame.userinterface.util;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

import nekrocode.chessgame.test_environment.TestPanel;
import nekrocode.chessgame.userinterface.menubar.MyMenuBar;

/**
 * A separate class for drawing the graphical user interface is made so the non-static method
 * getClass() can be used to retrieve the application's image icon.
 * @author ~
 *
 */
public class GuiBuilder {
	
	public GuiBuilder() {
		try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel" );} 
			catch(Exception e) {}
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Nekro's Chess Application");
		// TODO Look into better ways of loading the image?
		// Don't forget to also change the image and its dimension
		//try { frame.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("imgs/icons/app_icon.png")).getImage()); } 
			//catch (NullPointerException e) {}
		frame.setJMenuBar(new MyMenuBar(frame));
		//frame.setContentPane(new MainMenuPanel());
		frame.setContentPane(new TestPanel());
		//frame.pack();
		//frame.setVisible(true);
		System.exit(0);
	}
	
}
