package nekrocode.chessgame.modes.puzzles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import nekrocode.chessgame.chess.game.ChessGame;
import nekrocode.chessgame.chess.game.ChessGameBuilder;
import nekrocode.chessgame.chess.game.enums.ChessColor;
import nekrocode.chessgame.chess.pieces.ChessPiece;
import nekrocode.chessgame.chess.pieces.MoveCalculator;
import nekrocode.chessgame.chess.players.Player;
import nekrocode.chessgame.chess.util.FenNotationException;
import nekrocode.chessgame.chess.util.FenParsingManager;
import nekrocode.chessgame.chess.util.FenPositionParser;
import nekrocode.chessgame.userinterface.chessboard.util.ChessPieceAppender;
import nekrocode.chessgame.userinterface.chesspieces.PieceManager;
import nekrocode.chessgame.userinterface.modes.PuzzleModeView;

/**
 * This class manages the course of a chess puzzle session. Many improvements are to be made but for now, I just need to get something working.
 * 
 * TODO Improvements:
 * - The FEN board position notation is being validated twice currently. Once during FenPositionParser work and another time
 * during the actual parsing of the position in FenPositionParser. Reduce it to once in the future.
 * 
 * @author ~
 *
 */
public class PuzzleManager {
	
	private PuzzleModeView puzzleModeView;
	private JButton startBtn, nextBtn;
	private List<List<Map<String, String>>> puzzleCollection;
	
	public PuzzleManager(PuzzleModeView puzzleModeView) {
		this.puzzleModeView = puzzleModeView;
		startBtn = puzzleModeView.getPuzzleControlPanel().getStartButton();
		nextBtn = puzzleModeView.getPuzzleControlPanel().getNextButton();
		parsePuzzles();
		startBtn.setEnabled(true);
		
		// temp
		skip();
	}
	
	/**
	 * Method skipping the user input for faster testing
	 */
	private void skip() {
		startSession();
	}
	
	public void startSession() {
		startBtn.setEnabled(false);
		createPuzzle();
	}
	
	/**
	 * 
	 * CURRENTLY IN TESTING STAGE
	 * 
	 * TODO
	 * - Clean this method and divide abstraction between functionality
	 * - Handle catch clause
	 */
	private void createPuzzle() {
		Map<String, String> puzzle = puzzleCollection.get(0).get(0);
		ChessColor toMove;
		if (puzzle.get("toMove").equals("w")) {
			toMove = ChessColor.LIGHT; } 
			else { toMove = ChessColor.DARK; }
		
		String FenPosition = puzzle.get("boardPosition");
		char[][] boardPosition = null;
		try {
			boardPosition = new FenPositionParser().parsePosition(FenPosition);
		} catch (FenNotationException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		String[] moveSet = puzzle.get("moveSet").split("/");
		
		ChessGame chessGame = new ChessGameBuilder().createGame(boardPosition, toMove);
		
		// Temp testing
		ChessPieceAppender pieceAppender = new ChessPieceAppender(puzzleModeView.getChessboardView());
		pieceAppender.appendPosition(chessGame.getBoardRepresentation().getLightPieces());
		pieceAppender.appendPosition(chessGame.getBoardRepresentation().getDarkPieces());
		
		char[][] board = chessGame.getBoardRepresentation().getBoardPosition();
		MoveCalculator calc = new MoveCalculator();
		Map<String, ChessPiece> pieces = chessGame.getBoardRepresentation().getLightPieces();
		for (Map.Entry<String, ChessPiece> entry : pieces.entrySet()) {
			ChessPiece piece = entry.getValue();
			String position = entry.getKey();
			byte file = (byte)Integer.parseInt(position.substring(0, 1));
			byte rank = (byte)Integer.parseInt(position.substring(2, 3));
			System.out.println(file + ":" + rank);
			//piece.setLegalMoves(calc.calculateLegalMoves(new byte[] {file, rank}, piece.getMoveSets(), piece.getMoveIncrement(), board));
			//System.out.println(calc.calculateLegalMoves(new byte[] {file, rank}, piece.getMoveSets(), piece.getMoveIncrement(), board));
		}
		
		Player player = new Player(ChessColor.LIGHT, null);
		puzzleModeView.getChessboardView().setPieceManager(new PieceManager(player, puzzleModeView.getChessboardView()));
	}
	
	private void endPuzzle() {
		nextBtn.setEnabled(true);
	}
	
	public void nextPuzzle() {
		nextBtn.setEnabled(false);
	}
	
	// TODO Needs proper validation.
	private void parsePuzzles() {
		puzzleCollection = new ArrayList<List<Map<String, String>>>();
		FenParsingManager parsingManager = new FenParsingManager();
		puzzleCollection.add(parsingManager.parseNotation("puzzles/wtharveycomm8n2.txt"));
		puzzleCollection.add(parsingManager.parseNotation("puzzles/wtharveycomm8n3.txt"));
		puzzleCollection.add(parsingManager.parseNotation("puzzles/wtharveycomm8n4.txt"));
	}
	
}
