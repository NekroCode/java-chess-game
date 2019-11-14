package nekrocode.chessgame.test_environment;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import nekrocode.chessgame.chess.ChessColors;
import nekrocode.chessgame.chess.chessboard.Chessboard;
import nekrocode.chessgame.chess.chessboard.ChessboardBuilder;
import nekrocode.chessgame.chess.chessboard.IllegalSquareException;
import nekrocode.chessgame.chess.chessboard.Square;
import nekrocode.chessgame.chess.chesspieces.Chesspiece;
import nekrocode.chessgame.chess.chessutil.FenNotationParser;
import nekrocode.chessgame.chess.chessutil.SquareSearcher;
import nekrocode.chessgame.chess.visualrepresentations.ChessboardPanel;
import nekrocode.chessgame.chess.visualrepresentations.SquarePanel;
import nekrocode.chessgame.chess.visualrepresentations.util.ChesspieceAppender;

public class TestPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// TODO Demo code to demonstrate the working functionality so far.
	//
	// TODO Finding #01: It takes some time to loop through the HashMap
	// perhaps run it as a Runnable(Thread)?
	public TestPanel() {
		ChessboardBuilder builder = new ChessboardBuilder();
		Chessboard board = builder.buildBoard(ChessColors.LIGHT);
		//Chessboard board = builder.buildBoard(ChessColors.DARK);
		board.initVisualComponents();
		ChessboardPanel boardPanel = board.getChessboardPanel();
		add(boardPanel);
		
		// TODO This logic will do its thing elsewhere at a later point.
		// Currently it's just here to demo the functionality
		FenNotationParser parser = new FenNotationParser();
		String position = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
		HashMap<Chesspiece, String> boardPosition = parser.parsePosition(position);
		ChesspieceAppender appender = new ChesspieceAppender();
		SquareSearcher searcher = new SquareSearcher(board.getSquares());
		int rankIndex = 0;
		int fileIndex = 0;
		for (Map.Entry<Chesspiece, String> entry : boardPosition.entrySet()) {
			entry.getKey().initVisualComponent();
			fileIndex = searcher.getFileIndex(entry.getValue().charAt(0));
			rankIndex = searcher.getRankIndex(Integer.parseInt(entry.getValue().substring(1, 2)));
			Square square = null;
			SquarePanel squarePanel = null;
			try {
				square = searcher.getSquare(entry.getValue());
				squarePanel = boardPanel.getSquarePanels().get(rankIndex).get(fileIndex);
			} catch (IllegalSquareException e) {}
			appender.appendPiece(entry.getKey(), squarePanel);
		}
	}
	
}
