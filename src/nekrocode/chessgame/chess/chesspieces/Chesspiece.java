package nekrocode.chessgame.chess.chesspieces;

import java.util.ArrayList;

import nekrocode.chessgame.chess.ChessColors;
import nekrocode.chessgame.chess.chessboard.Square;
import nekrocode.chessgame.chess.visualrepresentations.ChesspiecePanel;

public abstract class Chesspiece {
	
	protected final String name;
	protected final char letter;
	protected final ChessColors color;
	protected boolean isPinned, isAttacked;
	protected Square position;
	protected ArrayList<Square> legalSquares;
	protected ChesspiecePanel chesspiecePanel;
	
	public Chesspiece(String name, char letter, ChessColors color) {
		this.name = name;
		this.letter = letter;
		this.color = color;
	}
	
	public char getLetter() {
		return letter;
	}
	
	public ChessColors getColor() {
		return color;
	}
	
	public boolean isPinned() {
		return isPinned;
	}
	
	public boolean isAttacked() {
		return isAttacked;
	}
	
	public Square getPosition() {
		return position;
	}
	
	public ArrayList<Square> getLegalSquares() {
		return legalSquares;
	}
	
	public String toString() {
		return name;
	}
	
	public void initVisualComponent() {
		chesspiecePanel = new ChesspiecePanel(this);
	}
	
	public ChesspiecePanel getChesspiecePanel() {
		return chesspiecePanel;
	}
}
