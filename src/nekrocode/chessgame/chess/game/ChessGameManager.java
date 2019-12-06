package nekrocode.chessgame.chess.game;

import nekrocode.chessgame.chess.game.enums.ChessColor;
import nekrocode.chessgame.chess.players.Competitor;
import nekrocode.chessgame.chess.players.Player;

public class ChessGameManager {
	 
	private Competitor lightPieces, darkPieces, playerToMove;
	private ChessGame chessGame;
	
	public ChessGameManager(ChessGame chessGame, Competitor competitor1, Competitor competitor2) {
		this.chessGame = chessGame;
		assignCompetitors(competitor1, competitor2);
	}
	
	// TODO I don't like this implementation but doing it because of the lack of time
	// Duplicate code also
	private void assignCompetitors(Competitor competitor1, Competitor competitor2) {
		ChessColor color = ((Player)competitor1).getColor();
		if (color == ChessColor.LIGHT) {
			lightPieces = competitor1;
			darkPieces = competitor2;
		} else if (color == ChessColor.DARK) {
			lightPieces = competitor2;
			darkPieces = competitor1;
		}
	}
	
	public void startGame() {
		assignPlayerToMove();
		startTurn();
	}
	
	private void assignPlayerToMove() {
		ChessColor toMove = chessGame.getBoardRepresentation().getToMove();
		if (toMove == ChessColor.LIGHT) {
			playerToMove = lightPieces;
		} else if (toMove == ChessColor.DARK) {
			playerToMove = darkPieces;
		}
	}
	
	private void startTurn() {
		startAction(playerToMove);
	}
	
	private void calculateLegalMoves() {
		System.out.println("hello");
	}
	
	private void startAction(Competitor competitor) {
		//competitor.action();
	}
	
	private void handleTurn() {
		
	}
	
	private void updateGame() {
		updatePlayerToMove();
	}
	
	private void updatePlayerToMove() {
		if (playerToMove == lightPieces) {
			playerToMove = darkPieces;
		} else if (playerToMove == darkPieces) {
			playerToMove = lightPieces;
		}
	}
}
