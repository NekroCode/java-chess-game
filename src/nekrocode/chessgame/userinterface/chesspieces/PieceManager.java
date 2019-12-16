package nekrocode.chessgame.userinterface.chesspieces;

import nekrocode.chessgame.chess.pieces.ChessPiece;
import nekrocode.chessgame.chess.players.Player;
import nekrocode.chessgame.userinterface.chessboard.ChessboardView;
import nekrocode.chessgame.userinterface.chessboard.SquarePanel;
import nekrocode.chessgame.userinterface.chessboard.util.SquareManager;

public class PieceManager {
	
	private Player player;
	private ChessboardView chessboardView;
	private SquareManager squareManager;
	private ChessPiece selectedPiece;
	
	public PieceManager(Player player, ChessboardView chessboardView) {
		this.player = player;
		this.chessboardView = chessboardView;
		squareManager = new SquareManager(this);
	}
	
	
	public void cleanBoard() {
		if (squareManager.getMarkedPanels().size() > 0) {
			squareManager.removeSelection();
		}
	}
	
	public void handleInput(SquarePanel squarePanel) {
		ChessPiecePanel piecePanel = squarePanel.getChessPiecePanel();
		if (piecePanel == null || piecePanel.getChessPiece().getColor() != player.getColor()) { return; }
		selectedPiece = piecePanel.getChessPiece();
		squareManager.manageSelection(selectedPiece, squarePanel);
	}
	
	public ChessboardView getChessboardView() {
		return chessboardView;
	}
	
	public ChessPiece getSelectedPiece() {
		return selectedPiece;
	}
	
}
