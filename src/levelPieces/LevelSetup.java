package levelPieces;
import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.Moveable;
import gameEngine.GameEngine;

public class LevelSetup {
	private Drawable[] levelGameBoard;
	private ArrayList<Moveable> levelMovingPieces;
	private ArrayList<GamePiece> levelInteractingPieces;
	private ArrayList<String> levelPieceDescriptions;
	
	public LevelSetup() {
		levelGameBoard = null;
		levelMovingPieces = null;
		levelInteractingPieces = null;
		levelPieceDescriptions = null;
		
	}
	
	private void createPiece(Drawable piece) {
		assert levelGameBoard != null : "levelGameBoard must be assigned before calling this function!";
		assert levelInteractingPieces != null : "levelInteractingPieces must be assigned before calling this function!";
		assert levelMovingPieces != null : "levelMovingPieces must be assigned before calling this function!";
		assert levelPieceDescriptions != null : "levelPieceDescriptions must be assigned before calling this function!";
		assert piece instanceof GamePiece || piece instanceof Rock : "Piece is not valid";
		int idx;
		if(piece instanceof Rock) {
			idx = ((Rock)piece).getLocation();
		} else { // we know piece is a GamePiece
			GamePiece gp = (GamePiece) piece;
			idx = gp.getLocation();
			levelInteractingPieces.add(gp);
			if(gp instanceof Moveable) levelMovingPieces.add((Moveable)gp);
		}
		
		
		assert levelGameBoard[idx] == null : "Location " + idx + " already has a piece";
		levelGameBoard[idx] = piece;
		if(!levelPieceDescriptions.contains(piece.toString())) levelPieceDescriptions.add(piece.toString());
	}
	
	public void createLevel(int levelnum) {
		levelPieceDescriptions = new ArrayList<String>();
		levelPieceDescriptions.add("P - Player (you)");
		switch(levelnum) {
		case 1:
			levelGameBoard = new Drawable[GameEngine.BOARD_SIZE];
			levelInteractingPieces = new ArrayList<GamePiece>();
			levelMovingPieces = new ArrayList<Moveable>();
			
//			levelGameBoard[3] = new Rock(3);
//			levelGameBoard[4] = new LightningBolt(4);
//			levelInteractingPieces.add((GamePiece)levelGameBoard[4]);
//			levelMovingPieces.add((Moveable)levelGameBoard[4]);
			
			// example to do the above:
			createPiece(new Rock(3));
			createPiece(new Trophy(10));
			createPiece(new Hunter(9));
			createPiece(new Apple(2));
			createPiece(new Apple(13));
			createPiece(new Spikes(4));
			
			break;
		case 2:
			levelGameBoard = new Drawable[GameEngine.BOARD_SIZE];
			levelInteractingPieces = new ArrayList<GamePiece>();
			levelMovingPieces = new ArrayList<Moveable>();
			createPiece(new Apple(4));
			createPiece(new Apple(18));
			createPiece(new Spikes(8));
			createPiece(new LightningBolt(7));
			createPiece(new Hole(10));
			createPiece(new Hunter(0));
			
			break;
		default:
			System.out.println("Invalid level number " + levelnum + ".");
			levelGameBoard = null;
			levelMovingPieces = null;
			levelInteractingPieces = null;
		}
		
		System.out.println("Level " + levelnum + " Legend:");
		for(String s : levelPieceDescriptions) {
			System.out.println(" " + s);
		}
	}

	public Drawable[] getBoard() { return levelGameBoard; }
	public ArrayList<Moveable> getMovingPieces() { return levelMovingPieces; }
	public ArrayList<GamePiece> getInteractingPieces() { return levelInteractingPieces; }
	public int getPlayerStartLoc() { return 5; }

}
