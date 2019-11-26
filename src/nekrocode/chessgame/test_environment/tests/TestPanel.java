package nekrocode.chessgame.test_environment.tests;

import javax.swing.JPanel;

import nekrocode.chessgame.chess.board.Chessboard;
import nekrocode.chessgame.chess.game.BoardRepresentation;
import nekrocode.chessgame.chess.game.ChessColor;
import nekrocode.chessgame.chess.game.GameCreator;
import nekrocode.chessgame.chess.util.FenNotationException;
import nekrocode.chessgame.chess.util.FenPositionParser;
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
		String position = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
		//String position = "r1b3kr/ppp1Bp1p/1b6/n2P4/2p3q1/2Q2N2/P4PPP/RN2R1K1";
		
		FenPositionParser parser = new FenPositionParser();
		char[][] boardPosition = null;
		try {
			boardPosition = parser.parsePosition(position);
		} catch (FenNotationException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		GameCreator gc = new GameCreator();
		char[][] chessboardArray = gc.createBoard(boardPosition);
		gc.preparePieces(boardPosition);
		
		BoardRepresentation board = new BoardRepresentation(chessboardArray);
		Chessboard chessboard = new Chessboard(boardPosition, ChessColor.LIGHT);
		ChessboardView view = new ChessboardView(chessboard);
		
		ChessPieceAppender pieceAppender = new ChessPieceAppender(view);
		pieceAppender.appendPosition(gc.getLightPieces());
		pieceAppender.appendPosition(gc.getDarkPieces());
		
		add(view);
	}
	
}
