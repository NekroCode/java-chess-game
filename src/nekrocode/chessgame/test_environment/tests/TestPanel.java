package nekrocode.chessgame.test_environment.tests;

import javax.swing.JPanel;

import nekrocode.chessgame.chess.util.FenNotationException;
import nekrocode.chessgame.chess.util.FenPositionParser;

public class TestPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public TestPanel() {
		char[][] test = null;
		String position = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
		//String position = "rn/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
		//String position = "r1b3kr/ppp1Bp1p/1b6/n2P4/2p3q1/2Q2N2/P4PPP/RN2R1K1";
		FenPositionParser p = new FenPositionParser();
		try {
			test = p.parsePosition(position);
			for (char[] list : test) {
				System.out.println(list);
			}
		} catch (FenNotationException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
