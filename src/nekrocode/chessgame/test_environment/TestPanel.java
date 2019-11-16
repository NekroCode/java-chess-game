package nekrocode.chessgame.test_environment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import nekrocode.chessgame.chess.ChessColor;
import nekrocode.chessgame.chess.chessboard.Chessboard;
import nekrocode.chessgame.chess.chessboard.ChessboardBuilder;
import nekrocode.chessgame.chess.chessboard.Square;
import nekrocode.chessgame.chess.chesspieces.Chesspiece;
import nekrocode.chessgame.chess.chesspieces.ChesspieceLetter;
import nekrocode.chessgame.chess.chessutil.FenNotationParser;
import nekrocode.chessgame.chess.chessutil.SquareSearcher;
import nekrocode.chessgame.chess.chessutil.exceptions.FENFormatException;
import nekrocode.chessgame.chess.chessutil.exceptions.IllegalSquareException;
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
		Chessboard board = builder.buildBoard(ChessColor.LIGHT);
		//Chessboard board = builder.buildBoard(ChessColors.DARK);
		board.initVisualComponent();
		ChessboardPanel boardPanel = board.getChessboardPanel();
		add(boardPanel);
		
		// TODO This logic will do its thing elsewhere at a later point.
		// Currently it's just here to demo the functionality
		FenNotationParser parser = new FenNotationParser();
		String position = "rnbqkbnr/ppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
		//String position = "5r2/pq4k1/1pp1Qn2/2bp1PB1/3R1R2/2P3P1/P6P/6K1";
		
		HashMap<Chesspiece, String> boardPosition = null;
		try {
			boardPosition = parser.parsePosition(position);
		} catch (FENFormatException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		// TODO Better HashMap iterating?
		// Get the first entry that the iterator returns
		//Map.Entry<String, String> entry = map.entrySet().iterator().next();
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
