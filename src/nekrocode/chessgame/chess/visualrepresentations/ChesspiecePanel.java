package nekrocode.chessgame.chess.visualrepresentations;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.JPanel;

import nekrocode.chessgame.chess.chesspieces.Chesspiece;

public class ChesspiecePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Image image;
	
	public ChesspiecePanel(Chesspiece chesspiece) {
		setLayout(new GridLayout(1, 1));
		setBackground(null);
		URL imageUrl;
		// TODO initialize ImageIcon and pass its image to Image
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}

}
