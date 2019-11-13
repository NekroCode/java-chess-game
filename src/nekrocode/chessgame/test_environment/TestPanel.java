package nekrocode.chessgame.test_environment;

import javax.swing.JPanel;

import nekrocode.chessgame.chess.ChessColors;
import nekrocode.chessgame.chess.chessboard.Chessboard;
import nekrocode.chessgame.chess.chessboard.ChessboardBuilder;
import nekrocode.chessgame.chess.chessutil.FenNotationParser;
import nekrocode.chessgame.chess.visualrepresentations.ChessboardPanel;

public class TestPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public TestPanel() {
//		ChessboardBuilder builder = new ChessboardBuilder();
//		Chessboard board = builder.buildBoard(ChessColors.LIGHT);
//		//Chessboard board = builder.buildBoard(ChessColors.DARK);
//		add(new ChessboardPanel(board));
		FenNotationParser p = new FenNotationParser();
	}
	
}
