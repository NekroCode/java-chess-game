package nekrocode.chessgame.test_environment.tests;

import javax.swing.JPanel;

import nekrocode.chessgame.chess.board.Chessboard;
import nekrocode.chessgame.chess.game.BoardRepresentation;
import nekrocode.chessgame.chess.game.ChessGame;
import nekrocode.chessgame.chess.game.ChessGameBuilder;
import nekrocode.chessgame.chess.game.ChessGameController;
import nekrocode.chessgame.chess.game.enums.ChessColor;
import nekrocode.chessgame.chess.game.enums.StartingPosition;
import nekrocode.chessgame.chess.players.Player;
import nekrocode.chessgame.chess.util.FenNotationException;
import nekrocode.chessgame.chess.util.FenPositionParser;
import nekrocode.chessgame.modes.PuzzleOpponent;
import nekrocode.chessgame.userinterface.chessboard.ChessboardView;
import nekrocode.chessgame.userinterface.chessboard.util.ChessPieceAppender;

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
//			for (char[] list : boardPosition) {
//				for (char s : list) {
//					System.out.print(s);
//				}
//				System.out.println("");
//			}
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
	}
	
}
