package nekrocode.chessgame.test_environment.unittests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import nekrocode.chessgame.chess.board.SquareTranslator;

/**
 * Testing the class SquareTranslator
 * @author ~
 *
 */
class SquareTranslatorTest {

	@Test
	void test() {
		SquareTranslator t = new SquareTranslator();
		squareToIndices(t);
		//indexToSquare(t);
	}
	
	private void squareToIndices(SquareTranslator t) {
		String output = t.getSquareName(0, 7);
		assertEquals("a1", output);
	}
	
	private void indexToSquare(SquareTranslator t) {
		
	}
	
}
