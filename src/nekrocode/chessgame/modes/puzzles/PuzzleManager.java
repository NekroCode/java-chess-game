package nekrocode.chessgame.modes.puzzles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import nekrocode.chessgame.chess.game.BoardRepresentation;
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
 * - Not every FEN value is implemented
 * 
 * WARNING!: There's currently a bug where when, during FEN parsing, entries with invalid positions are still being added,
 * only with the position entry. Fix this at a later point in time.
 * 
 * @author ~
 *
 */
public class PuzzleManager {
	
	private PuzzleModeView puzzleModeView;
	private JButton startBtn, nextBtn;
	private List<Map<String, String>> puzzleCollection;
	private int puzzleNumber;
	private Player player;
	private ChessPieceAppender pieceAppender;
	
	public PuzzleManager(PuzzleModeView puzzleModeView) {
		this.puzzleModeView = puzzleModeView;
		startBtn = puzzleModeView.getPuzzleControlPanel().getStartButton();
		nextBtn = puzzleModeView.getPuzzleControlPanel().getNextButton();
		parsePuzzles();
		startBtn.setEnabled(true);
		player = new Player();
		pieceAppender = new ChessPieceAppender(puzzleModeView.getChessboardView());
		// temp
		skip();
	}
	
	/**
	 * Method for skipping the user input for faster testing
	 */
	private void skip() {
		startSession();
	}
	
	public void startSession() {
		startBtn.setEnabled(false);
		nextPuzzle();
	}
	
	private void startPuzzle(ChessPuzzle chessPuzzle) {
		BoardRepresentation boardRepresentation = chessPuzzle.getChessGame().getBoardRepresentation();
		updatePlayer(boardRepresentation);
		drawChessPieces(boardRepresentation);
		calculateLegalMoves(player.getChessPieces(), boardRepresentation.getBoardPosition());
		//endPuzzle();
	}
	
	private void updatePlayer(BoardRepresentation boardRepresentation) {
		ChessColor toMove = boardRepresentation.getToMove();
		player.setColor(toMove);
		if (toMove == ChessColor.LIGHT) {
			player.setChessPieces(boardRepresentation.getLightPieces());
		} else {
			player.setChessPieces(boardRepresentation.getDarkPieces());
		}
		// Check if I really have to instantiate a new piecemanager everytime. Could possibily do without.
		puzzleModeView.getChessboardView().setPieceManager(new PieceManager(player, puzzleModeView.getChessboardView()));
	}
	
	// TODO Everything in between // * * // should be divided into separate methods
	private ChessPuzzle createPuzzle(Map<String, String> puzzle) {
		// *
		ChessColor toMove;
		if (puzzle.get("toMove").equals("w")) {
			toMove = ChessColor.LIGHT; } 
			else { toMove = ChessColor.DARK; }
		String FenPosition = puzzle.get("boardPosition");
		char[][] boardPosition = null;
		try {
			boardPosition = new FenPositionParser().parsePosition(FenPosition);
		} catch (FenNotationException e) {
			nextPuzzle();
		}
		// *
		ChessGame chessGame = new ChessGameBuilder().createGame(boardPosition, toMove);
		String[] moves = puzzle.get("moves").split("/");
		return new ChessPuzzle(chessGame, moves);
	}
	
	private Map<String, String> getNextPuzzle(int puzzleNumber) {
		return puzzleCollection.get(puzzleNumber);
	}
	
	private void endPuzzle() {
		nextBtn.setEnabled(true);
	}
	
	public void nextPuzzle() {
		nextBtn.setEnabled(false);
		try {
			puzzleCollection.get(puzzleNumber);
		} catch (Exception e) {
			System.out.println("Out of puzzles");
		}
		startPuzzle(createPuzzle(getNextPuzzle(puzzleNumber)));
		puzzleNumber++;
	}
	
	// TODO Needs proper validation and exception handling
	private void parsePuzzles() {
		puzzleCollection = new ArrayList<Map<String, String>>();
		FenParsingManager parsingManager = new FenParsingManager();
		addPuzzleToCollection(parsingManager.parseNotation("puzzles/wtharveycomm8n2.txt"));
		addPuzzleToCollection(parsingManager.parseNotation("puzzles/wtharveycomm8n4.txt"));
		addPuzzleToCollection(parsingManager.parseNotation("puzzles/wtharveycomm8n3.txt"));
		//Collections.shuffle(puzzleCollection);
	}
	
	private void addPuzzleToCollection(List<Map<String, String>> puzzles) {
		for (Map<String, String> puzzle : puzzles) {
			puzzleCollection.add(puzzle);
		}
	}
	
	// I don't the following two methods belong in this class.
	// Find a better place in the future
	private void drawChessPieces(BoardRepresentation board) {
		pieceAppender.appendPosition(board.getLightPieces());
		pieceAppender.appendPosition(board.getDarkPieces());
	}
	
	// ^
	private void calculateLegalMoves(Map<String, ChessPiece> pieces, char[][] board) {
		MoveCalculator calc = new MoveCalculator();
		for (Map.Entry<String, ChessPiece> entry : pieces.entrySet()) {
			ChessPiece piece = entry.getValue();
			String position = entry.getKey();
			byte file = (byte)Integer.parseInt(position.substring(0, 1));
			byte rank = (byte)Integer.parseInt(position.substring(2, 3));
			piece.setLegalMoves(calc.calculateLegalMoves(new byte[] {file, rank}, piece.getMoveSets(), piece.getMoveIncrement(), board));
		}
	}
	
}

///**
//* 
//* CURRENTLY IN TESTING STAGE. CODE IS MESSY
//* 
//* TODO
//* - Clean this method and divide abstraction between functionality
//* - Handle catch clause
//*/
//private void createPuzzle() {
//	Map<String, String> puzzle = puzzleCollection.get(0).get(0);
//	ChessColor toMove;
//	if (puzzle.get("toMove").equals("w")) {
//		toMove = ChessColor.LIGHT; } 
//		else { toMove = ChessColor.DARK; }
//	
//	String FenPosition = puzzle.get("boardPosition");
//	char[][] boardPosition = null;
//	try {
//		boardPosition = new FenPositionParser().parsePosition(FenPosition);
//	} catch (FenNotationException e) {
//		System.out.println(e.getMessage());
//		return;
//	}
//	
//	String[] moveSet = puzzle.get("moveSet").split("/");
//	
//	ChessGame chessGame = new ChessGameBuilder().createGame(boardPosition, toMove);
//	
//	// Temp testing
//	ChessPieceAppender pieceAppender = new ChessPieceAppender(puzzleModeView.getChessboardView());
//	pieceAppender.appendPosition(chessGame.getBoardRepresentation().getLightPieces());
//	pieceAppender.appendPosition(chessGame.getBoardRepresentation().getDarkPieces());
//	
//	char[][] board = chessGame.getBoardRepresentation().getBoardPosition();
//	MoveCalculator calc = new MoveCalculator();
//	Map<String, ChessPiece> pieces = chessGame.getBoardRepresentation().getLightPieces();
//	for (Map.Entry<String, ChessPiece> entry : pieces.entrySet()) {
//		ChessPiece piece = entry.getValue();
//		String position = entry.getKey();
//		byte file = (byte)Integer.parseInt(position.substring(0, 1));
//		byte rank = (byte)Integer.parseInt(position.substring(2, 3));
//		piece.setLegalMoves(calc.calculateLegalMoves(new byte[] {file, rank}, piece.getMoveSets(), piece.getMoveIncrement(), board));
//	}
//	
//	Player player = new Player(ChessColor.LIGHT, null);
//	puzzleModeView.getChessboardView().setPieceManager(new PieceManager(player, puzzleModeView.getChessboardView()));
//}
