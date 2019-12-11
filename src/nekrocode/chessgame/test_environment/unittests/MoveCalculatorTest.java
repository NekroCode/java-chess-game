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
		Map<String, ChessPiece> pieces = chessGame.getBoardRepresentation().getLightPieces();
//		for (Map.Entry<String, ChessPiece> map : pieces.entrySet()) {
//			System.out.println(map.getKey());
//		}
		String position = "7/7";
		ChessPiece piece = pieces.get(position);
		byte[][] moveSets = piece.getMoveSets();
		
		int x = Integer.parseInt(position.substring(0, 1));
		int y = Integer.parseInt(position.substring(2, 3));
//		file += moveSets[2][0];
//		rank += moveSets[2][1];
		
		//System.out.println(board[rank+BoardRepresentation.BOARD_START][file+BoardRepresentation.BOARD_START]);
		int boardStart = BoardRepresentation.BOARD_START;
		List<byte[]> legalMoves = new ArrayList<byte[]>();
		for (byte[] moveSet : moveSets) {
			int newFile = moveSet[0]+x;
			int newRank = moveSet[1]+y;
			Character c = board[newRank+boardStart][newFile+boardStart];
			if (!c.equals('-')) {
				legalMoves.add(new byte[] {(byte)newFile, (byte)newRank});
			}
			//System.out.println(newFile + ":" + newRank);
		}
		for (byte[] list : legalMoves) {
			System.out.println(list[0] + ":" + list[1]);
		}
	}

}
