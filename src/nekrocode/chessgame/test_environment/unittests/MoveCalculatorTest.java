package nekrocode.chessgame.test_environment.unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import nekrocode.chessgame.chess.board.SquareTranslator;
import nekrocode.chessgame.chess.pieces.MoveCalculator;

class MoveCalculatorTest {

	@Test
	void test() {
		MoveCalculator c = new MoveCalculator();
		byte x = 0;
		byte y = 7;
		byte[] newPosition = c.calculateMove(x, y);
		
		SquareTranslator s = new SquareTranslator();
		String square = s.getSquareName(newPosition[0], newPosition[1]);
		
		System.out.println(square + " " + newPosition[0] + ": " + newPosition[1]);
		assertEquals("a1", square);
	}

}
