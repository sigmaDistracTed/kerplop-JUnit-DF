package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Hole extends GamePiece {
	public Hole(int location) {
		super('O', "Kills you when you stand on it", location);
	}
	
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == getLocation()) {
			return InteractionResult.KILL;
		}
		else {
			return InteractionResult.NONE; 
		}
	}

}
