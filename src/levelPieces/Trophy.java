package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Trophy extends GamePiece {
	public Trophy(int location) {
		super('T', "Trophy (Advances you to the next level!)", location);
	}
	
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == getLocation()) {
			gameBoard[getLocation()] = null; 
			return InteractionResult.ADVANCE;
		}
		else {
			return InteractionResult.NONE;
		}

	}

}
