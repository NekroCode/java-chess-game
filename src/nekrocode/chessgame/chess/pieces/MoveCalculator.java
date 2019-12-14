package nekrocode.chessgame.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import nekrocode.chessgame.chess.game.BoardRepresentation;

public class MoveCalculator {
	
	public List<byte[]> calculateLegalMoves(byte[] position, byte[][] moveSets, int increment, char[][] board) {
		List<byte[]> legalMoves = new ArrayList<byte[]>();
		for (byte[] moveSet : moveSets) {
			processMoveSet(position, moveSet, increment, legalMoves, board);
		}
		return legalMoves;
	}
	
	private void processMoveSet(byte[] position, byte[] moveSet, int increment, List<byte[]> legalMoves, char[][] board) {
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
