package levelPieces;
import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.Moveable;
import gameEngine.GameEngine;

public class LevelSetup {
	private Drawable[] levelGameBoard;
	private ArrayList<Moveable> levelMovingPieces;
	private ArrayList<GamePiece> levelInteractingPieces;
	
	public LevelSetup() {
		levelGameBoard = null;
		levelMovingPieces = null;
		levelInteractingPieces = null;
	}
	
	public void createLevel(int levelnum) {
		switch(levelnum) {
		case 1:
			levelGameBoard = new Drawable[GameEngine.BOARD_SIZE];
			levelInteractingPieces = new ArrayList<GamePiece>();
			levelMovingPieces = new ArrayList<Moveable>();
			levelGameBoard[3] = new Rock(3);
			levelGameBoard[4] = new LightningBolt(4);
			levelInteractingPieces.add((GamePiece)levelGameBoard[4]);
			levelMovingPieces.add((Moveable)levelGameBoard[4]);
			break;
		case 2:
			break;
		default:
			System.out.println("Invalid level number " + levelnum + ".");
			levelGameBoard = null;
			levelMovingPieces = null;
			levelInteractingPieces = null;
		}
	}

	public Drawable[] getBoard() { return levelGameBoard; }
	public ArrayList<Moveable> getMovingPieces() { return levelMovingPieces; }
	public ArrayList<GamePiece> getInteractingPieces() { return levelInteractingPieces; }
	public int getPlayerStartLoc() { return 5; }

}
