package nekrocode.chessgame.userinterface.chesspieces;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import nekrocode.chessgame.chess.game.ChessColor;
import nekrocode.chessgame.chess.pieces.ChessPiece;

public class ChessPiecePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image image;
	
	public ChessPiecePanel(ChessPiece chessPiece) {
		setLayout(new GridLayout(1, 1));
		setBackground(null);
		// TODO Needs a better way of setting its dimension
		setPreferredSize(new Dimension(50, 50));
		// TODO Handle catch clause
		try {
			ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource(getImageURLAsString(chessPiece)));
			image = imageIcon.getImage();
		} catch (Exception e) { System.out.println("Error: Image not found: " + chessPiece.toString() + ": " + chessPiece.getColor()); }
	}
	
	private String getImageURLAsString(ChessPiece chessPiece) {
		String url = "imgs/" + chessPiece.toString().toLowerCase();;
		String color;
		if (chessPiece.getColor() == ChessColor.LIGHT) {
			color = "white";
		} else { 
			color = "black";
		}
		return url = url.concat("_" + color + ".png");
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}
}
