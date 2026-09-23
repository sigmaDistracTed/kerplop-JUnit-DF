package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Spikes extends GamePiece{
	public Spikes(int location) {
		super('*', "Spikes (Hurts you when you stand on it)", location);
	}
	
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == getLocation()) {
			return InteractionResult.HIT;
		}
		else {
			return InteractionResult.NONE; 
		}
	}

}
