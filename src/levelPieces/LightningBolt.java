package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class LightningBolt extends GamePiece implements Moveable{
	public LightningBolt(int location)  {
		super('!', "Kills you if it lands nearby.", location);
		
		
	}
	
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (Math.abs(playerLocation - getLocation()) <= 1) {
			return InteractionResult.KILL;
		}
		else {
			return InteractionResult.NONE;
		}

	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int cellTile = (int)(Math.random()*gameBoard.length);
		if (gameBoard[cellTile] == null) {
			gameBoard[getLocation()] = null;
			setLocation(cellTile);
			gameBoard[getLocation()] = this;
			
		}
		
	}


}
