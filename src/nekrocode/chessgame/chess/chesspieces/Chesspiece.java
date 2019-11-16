package nekrocode.chessgame.chess.chesspieces;

import java.util.ArrayList;

import nekrocode.chessgame.chess.ChessColor;
import nekrocode.chessgame.chess.chessboard.Square;
import nekrocode.chessgame.chess.visualrepresentations.ChesspiecePanel;

public abstract class Chesspiece {
	
	protected final String NAME;
	protected final ChesspieceLetter LETTER;
	protected final ChessColor COLOR;
	protected boolean isPinned, isAttacked;
	protected Square position;
	protected ArrayList<Square> legalSquares;
	protected ChesspiecePanel chesspiecePanel;
	
	public Chesspiece(String name, ChesspieceLetter letter, ChessColor color) {
		NAME = name;
		LETTER = letter;
		COLOR = color;
	}
	
	public char getLetter() {
		return LETTER.getLetter();
	}
	
	public ChessColor getColor() {
		return COLOR;
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
		return NAME;
	}
	
	public void initVisualComponent() {
		chesspiecePanel = new ChesspiecePanel(this);
	}
	
	public ChesspiecePanel getChesspiecePanel() {
		return chesspiecePanel;
	}
}
