package nekrocode.chessgame.test_environment.tests;

import java.util.HashMap;

import javax.swing.JPanel;

import nekrocode.chessgame.chess.board.Chessboard;
import nekrocode.chessgame.chess.game.BoardRepresentation;
import nekrocode.chessgame.chess.game.ChessGame;
import nekrocode.chessgame.chess.game.ChessGameBuilder;
import nekrocode.chessgame.chess.game.ChessGameManager;
import nekrocode.chessgame.chess.game.enums.ChessColor;
import nekrocode.chessgame.chess.game.enums.StartingPosition;
import nekrocode.chessgame.chess.pieces.ChessPiece;
import nekrocode.chessgame.chess.players.Player;
import nekrocode.chessgame.chess.util.FenNotationException;
import nekrocode.chessgame.chess.util.FenPositionParser;
import nekrocode.chessgame.modes.PuzzleOpponent;
import nekrocode.chessgame.userinterface.chessboard.ChessboardView;
import nekrocode.chessgame.userinterface.chessboard.SquareHighlighter;
import nekrocode.chessgame.userinterface.chessboard.util.ChessPieceAppender;
import nekrocode.chessgame.userinterface.chesspieces.PieceManager;

/**
 * Used solely for testing
 * 
 * @author ~
 *
 */
public class TestPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public TestPanel() {			
		String position = StartingPosition.STANDARD.getStartingPosition();
		//String position = "r1b3kr/ppp1Bp1p/1b6/n2P4/2p3q1/2Q2N2/P4PPP/RN2R1K1";
		char[][] boardPosition = null;
		try {
			FenPositionParser parser = new FenPositionParser();
			boardPosition = parser.parsePosition(position);
		} catch (FenNotationException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		ChessGame g = new ChessGameBuilder().createGame(boardPosition, ChessColor.LIGHT);
		ChessboardView view = new ChessboardView(g.getChessboard());
		ChessPieceAppender pieceAppender = new ChessPieceAppender(view);
		pieceAppender.appendPosition(g.getBoardRepresentation().getLightPieces());
		pieceAppender.appendPosition(g.getBoardRepresentation().getDarkPieces());
		
		add(view);
		
		HashMap<byte[], ChessPiece> playerPieces = g.getBoardRepresentation().getLightPieces();
		Player player = new Player(ChessColor.LIGHT, playerPieces);
		
		ChessGameManager m = new ChessGameManager(g, player, new PuzzleOpponent());
		PieceManager p = new PieceManager(player, view);
		view.setPieceManager(p);
		m.startGame();
	}
	
}
