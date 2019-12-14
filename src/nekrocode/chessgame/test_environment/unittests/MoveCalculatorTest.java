package nekrocode.chessgame.test_environment.unittests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nekrocode.chessgame.chess.game.BoardRepresentation;
import nekrocode.chessgame.chess.game.ChessGame;
import nekrocode.chessgame.chess.game.ChessGameBuilder;
import nekrocode.chessgame.chess.pieces.ChessPiece;
import nekrocode.chessgame.chess.pieces.MoveCalculator;
import nekrocode.chessgame.chess.board.SquareTranslator;

/**
 * The move calculato is going to change. New tests later
 * @author ~
 *
 */
class MoveCalculatorTest {
	
	char[][] board = new char[][] {
		{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, 
		{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
		{'-', '-', 'r', 'x', 'x', 'q', 'k', 'b', 'x', 'r', '-', '-'},
		{'-', '-', 'p', 'p', 'x', 'x', 'n', 'p', 'p', 'p', '-', '-'},
		{'-', '-', 'x', 'x', 'x', 'p', 'x', 'x', 'x', 'x', '-', '-'},
		{'-', '-', 'x', 'x', 'p', 'N', 'N', 'x', 'B', 'x', '-', '-'},
		{'-', '-', 'x', 'x', 'B', 'n', 'P', 'x', 'x', 'x', '-', '-'},
		{'-', '-', 'x', 'x', 'x', 'P', 'x', 'x', 'x', 'x', '-', '-'},
		{'-', '-', 'P', 'P', 'P', 'x', 'x', 'P', 'P', 'P', '-', '-'},
		{'-', '-', 'R', 'x', 'x', 'b', 'K', 'x', 'x', 'R', '-', '-'},
		{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
		{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}
	};
	
	@Test
	void test() {
		MoveCalculator calculator = new MoveCalculator();
		ChessGame chessGame = new ChessGameBuilder().createGame(board, null);
		simulate();
	}
	
	private void simulate() {
		//byte[][] moveSets = new byte[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		//byte[][] moveSets = new byte[][] {{1, 0}};
//		String position = "0/7";
//		int increment = 8;
//		int file = Integer.parseInt(position.substring(0, 1));
//		int rank = Integer.parseInt(position.substring(2, 3));
//		calculateLegalMoves(new byte[] {(byte)file, (byte)rank}, moveSets, increment);
		
		int start = BoardRepresentation.BOARD_START;
		byte[][] moveSets = new byte[][] {{-1, 2}};
		byte file = 4;
		byte rank = 3;
		calculateLegalMoves(new byte[] {(byte)file, (byte)rank}, moveSets, 1);
	}
	
	private void calculateLegalMoves(byte[] position, byte[][] moveSets, int increment) {
		List<byte[]> legalMoves = new ArrayList<byte[]>();
		for (byte[] moveSet : moveSets) {
			processMoveSet(position, moveSet, increment, legalMoves);
		}
		
		SquareTranslator t = new SquareTranslator();
		for (byte[] legalMove : legalMoves) {
			System.out.println(t.getSquareName(legalMove[0], legalMove[1]));
		}
	}
	
	private void processMoveSet(byte[] position, byte[] moveSet, int increment, List<byte[]> legalMoves) {
		int start = BoardRepresentation.BOARD_START;
		for (int i = 0; i < increment; i++) {
			byte[] newPosition = calculateMove(position[0], position[1], moveSet);
			position = newPosition;
			char c = board[newPosition[1]+start][newPosition[0]+start];
			if (!isValid(c)) { break; }
				else { legalMoves.add(newPosition); }
		}
	}
	
	private byte[] calculateMove(byte file, byte rank, byte[] moveSet) {
		file += moveSet[0];
		rank += moveSet[1];
		return new byte[] {file, rank};
	}
	
	private boolean isValid(Character c) {
		if (c.equals('-')) {
			return false;
		}
		return true;
	}

}
