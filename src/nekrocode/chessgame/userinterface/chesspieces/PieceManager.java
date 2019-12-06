package nekrocode.chessgame.userinterface.chesspieces;

import nekrocode.chessgame.chess.pieces.ChessPiece;
import nekrocode.chessgame.chess.players.Player;
import nekrocode.chessgame.userinterface.chessboard.ChessboardView;
import nekrocode.chessgame.userinterface.chessboard.SquareManager;
import nekrocode.chessgame.userinterface.chessboard.SquarePanel;

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
	
	public void handleInput(ChessPiece chessPiece, SquarePanel squarePanel) {
		if (player.getColor() != chessPiece.getColor()) {
			squareManager.removeSelection();
			return;
		}
		selectedPiece = chessPiece;
		squareManager.manageSelection(chessPiece, squarePanel);
	}
	
	public ChessboardView getChessboardView() {
		return chessboardView;
	}
	
	public ChessPiece getSelectedPiece() {
		return selectedPiece;
	}
	
}
