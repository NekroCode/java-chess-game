package nekrocode.chessgame.chess.pieces;

public class MoveCalculator {
	
	public byte[] calculateMove(byte file, byte rank) {	
		byte x = 0;
		byte y = 0;
		
		byte newFile = x += file;
		byte newRank = y += rank;
		
		return new byte[] {newFile, newRank};
	}
	
}
