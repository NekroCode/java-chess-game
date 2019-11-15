package nekrocode.chessgame.chess.visualrepresentations;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import nekrocode.chessgame.chess.ChessColors;
import nekrocode.chessgame.chess.chesspieces.Chesspiece;

public class ChesspiecePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Image image;
	
	public ChesspiecePanel(Chesspiece chesspiece) {
		setLayout(new GridLayout(1, 1));
		setBackground(null);
		// TODO Needs a better way of setting its dimension
		setPreferredSize(new Dimension(50, 50));
		// TODO Better exception handling
		try {
			ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource(getImageURLAsString(chesspiece)));
			image = imageIcon.getImage();
		} catch (Exception e) { System.out.println("Image not found"); }
	}
	
	private String getImageURLAsString(Chesspiece chesspiece) {
		String url = "imgs/" + chesspiece.toString().toLowerCase();;
		String color;
		if (chesspiece.getColor() == ChessColors.LIGHT)
			color = "white";
		else 
			color = "black";
		return url = url.concat("_" + color + ".png");
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}

}
