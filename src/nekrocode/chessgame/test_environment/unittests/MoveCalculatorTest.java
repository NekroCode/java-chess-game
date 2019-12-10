package nekrocode.chessgame.test_environment.unittests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

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
		MoveCalculator c = new MoveCalculator();
		ChessGame chessGame = new ChessGameBuilder().createGame(board, null);
		Map<byte[], ChessPiece> pieces = chessGame.getBoardRepresentation().getLightPieces();
//		for (Map.Entry<byte[], ChessPiece> map : pieces.entrySet()) {
//			System.out.println(map.getKey()[0] + ":" + map.getKey()[1]);
//		}
		//ChessPiece piece = pieces.get(new byte[]{7, 7});
		//System.out.println(new byte[]{7, 7} == new byte[]{7, 7});
		
	}

}
